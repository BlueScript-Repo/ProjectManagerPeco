package com.projectmanager.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.projectmanager.dao.*;
import com.projectmanager.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectmanager.entity.AccessoryDetails;
import com.projectmanager.entity.BOQDetails;
import com.projectmanager.entity.BOQHeader;
import com.projectmanager.entity.BOQLineData;
import com.projectmanager.entity.BillDetails;
import com.projectmanager.entity.ChallanDetails;
import com.projectmanager.entity.Inventory;
import com.projectmanager.entity.InventorySpec;
import com.projectmanager.entity.Mappings;
import com.projectmanager.entity.Project;
import com.projectmanager.entity.ProjectDetails;
import com.projectmanager.entity.TaxInvoiceDetails;
import com.projectmanager.entity.TaxInvoiceGenerator;
import com.projectmanager.excel.ExcelWriter;
import com.projectmanager.util.InventoryUtils;
import com.projectmanager.util.NumberWordConverter;

@Controller
@EnableWebMvc
public class InventoryController {

	@Autowired
	private InventoryDao inventoryDao;

	@Autowired
	private ChallanDao challanDao;

	@Autowired
	ProjectDao projectDao;

	@Autowired
	BillDetailsDao billDao;

	@Autowired
	TaxInvoiceDetailsDao taxInvoiceDetailsDao;

	@Autowired
	AccessoryDetailsDao accessoryDetailsDao;

	@Autowired
	ReceivedInventoryDao receivedInventoryDao;

	@Autowired
	ProjectDetailsDao projectDetailsDao;

	@Autowired
	UserDetailsDao userDetailsDao;

	@Autowired
	private InventoryUtils inventoryUtils;

	@Autowired
	TaxInvoiceGenerator taxInvoiceGenerator;

	@Autowired
	NumberWordConverter numberWordConverter;

	@Autowired
	MappingsDao mappingsDao;

	@Autowired
	ValvesDao valvesDao;

	@Autowired
	BOQDetailsDao boqDetailsDao;

	@Autowired
	BOQHeaderDao boqHeaderDao;

	@Autowired
	ExcelWriter writer;

	@Autowired
	BOQController boqController;

	@Autowired
	TaxesDao taxesDao;

	private static final String updateViewName = "updateInvPO";


	@RequestMapping(value = "/updateInventoryForm", method = RequestMethod.GET)
	protected ModelAndView updateInventoryForm() {
		ModelAndView view = new ModelAndView(updateViewName);

		ArrayList<Project> projectList = projectDao.getProject("projectName", "");
		StringBuffer projectNames = new StringBuffer();

		for (Project project : projectList) {
			projectNames.append(project.getProjectName() + ",");
		}

		view.addObject("projectNames", projectNames.toString());

		return view;
	}

	@RequestMapping(value = "/updateInventory", method = RequestMethod.POST)
	protected ModelAndView updateInventory(ChallanDetails challanDetails, String[] inventoryName, String[] material,
			String[] type, String[] manifMethod, String[] gradeOrClass, String[] ends, String[] size, int[] quantity,
			String[] purchaseRate, /* String[] rate, */ String[] project, String[] location, String[] status,
			String invoiceType, TaxInvoiceDetails taxInvoiceDetails, BillDetails billDetails,
			AccessoryDetails accessoryDetails, String generateChallan, String generateInvoice, String addAccessory,
			String addBillDetails, HttpSession session) {

		System.out.println("generateChallan is " + generateChallan);
		System.out.println("generateInvoice is " + generateInvoice);
		System.out.println("addAccessory is " + addAccessory);
		System.out.println("addBillDetails is " + addBillDetails);

		ModelAndView view = null;

		if (!(generateChallan.equals("1"))) {
			view = new ModelAndView("redirect:/" + updateViewName);
		} else {
			view = new ModelAndView("challan");
		}

		int projectId = projectDao.getProjectId(project[0]);

		taxInvoiceDetails.setProjectName(project[0]);

		StringBuffer lineItemData = new StringBuffer();

		List<InventorySpec> inventorySpec = inventoryUtils.createInventorySpecList(inventoryName, material, type,
				manifMethod, gradeOrClass, ends, size, project, status);

		ArrayList<Inventory> receivedInventoryList = new ArrayList<Inventory>();

		String clientShortName = "";

		//Calclate number of sub-challan need to be reated

        int noOfChallan = Math.round(inventorySpec.size()/14) + 1;

        ArrayList<StringBuffer> lineItemDataList = new ArrayList<>();

        for(int k=0;k<=noOfChallan-2;k++)
        {
            lineItemDataList.add(new StringBuffer());
        }

		for (int i = 0; i < inventorySpec.size(); i++) {
			Inventory inventory = new Inventory();
			inventory.setInventorySpec(inventorySpec.get(i));
			inventory.setPurchaseRate(String.valueOf(Double.parseDouble(purchaseRate[i])));
			inventory.setQuantity(quantity[i]);
			inventory.setLocation(location[i]);

			int inventoryRowId = inventoryDao.isEntityPresent(inventory, status[i]);

			System.out.println("inventoryRowId is : " + inventoryRowId);

			if (inventoryRowId != 0) {

				inventory.setInventoryRowId(inventoryRowId);

				int availableQuantity = inventoryDao.getAvailableQuantity(inventory);

				if (project[0] != null && project[0] != "") {

					int assignedQty = inventoryDao.getQuantityByStatus(inventory, status[i], true);

					System.out.println("assignedQty is : " + assignedQty);

					switch (status[i]) {
					case "assigned":
						inventory.setQuantity(assignedQty + Integer.valueOf(quantity[i]));
						break;
					case "available":
						// Reduce the assigned quantity
						inventory.setQuantity(assignedQty - Integer.valueOf(quantity[i]));

						// Add new entry for update existing one without project
						Inventory availableInventory = inventory.copyObject(inventory);

						InventorySpec invSpec = inventoryUtils.copyInventorySpec(inventory.getInventorySpec());
						invSpec.setAssignedProject("");
						invSpec.setStatus("available");

						availableInventory.setInventorySpec(invSpec);

						int availableInventoryRowId = inventoryDao.isEntityPresent(availableInventory);

						if (availableInventoryRowId == 0) {
							// Inventory is not available. Add a new entry to DB
							availableInventory.setQuantity(quantity[i]);
							availableInventory.setInventoryRowId(inventoryDao.getLatestInventoryEntryNo() + 1);

						} else {
							// Inventory is available. Just increase the
							// quantity
							availableInventory.setQuantity(availableQuantity + quantity[i]);
						}

						try {
							inventoryDao.saveInventory(availableInventory);
						} catch (Exception ex) {
							System.out.println("calling update");
							inventoryDao.updateWhenSaveFailed(availableInventory);
						}

						break;
					case "delivered":
						// Reduce the assigned quantity
						inventory.setQuantity(assignedQty - Integer.valueOf(quantity[i]));

						// Add new entry for update existing one without project
						Inventory deliveredInventory = inventory.copyObject(inventory);

						InventorySpec invSpec2 = inventoryUtils.copyInventorySpec(inventory.getInventorySpec());

						invSpec2.setAssignedProject(inventory.getInventorySpec().getAssignedProject());
						invSpec2.setStatus("delivered");

						deliveredInventory.setInventorySpec(invSpec2);

						int deliveredInventoryRowId = inventoryDao.isEntityPresent(deliveredInventory);

						if (deliveredInventoryRowId == 0) {
							// Inventory is not available. Add a new entry to DB
							deliveredInventory.setQuantity(quantity[i]);
							deliveredInventory.setInventoryRowId(inventoryDao.getLatestInventoryEntryNo() + 1);

						} else {
							// Inventory is available. Just increase the
							// quantity
							deliveredInventory.setQuantity(availableQuantity + quantity[i]);
						}

						try {
							inventoryDao.saveInventory(deliveredInventory);
						} catch (Exception ex) {
							System.out.println("calling update");
							inventoryDao.updateWhenSaveFailed(deliveredInventory);
						}

						break;
					}

				} else {
					inventory.setQuantity(quantity[i]);
				}

			} else {
				inventoryRowId = inventoryDao.getLatestInventoryEntryNo() + 1;
				inventory.setInventoryRowId(inventoryRowId);
			}

			try {
				inventoryDao.saveInventory(inventory);
			} catch (Exception ex) {
				System.out.println("calling update");
				inventoryDao.updateWhenSaveFailed(inventory);
			}

			String projectName = project[0];
			String temp = projectName;

			if (projectName.contains(" ") && projectName.length() >= 7) {
				clientShortName = projectName.substring(0, 3) + new String(temp.getBytes(), temp.indexOf(" "), 3);
			} else {
				clientShortName = projectName.substring(0, 3);
			}

			if (generateChallan.equals("1")) {
				// get projectId before saving challan details.

				taxInvoiceDetails.setProjectId(projectId);
				challanDetails.setProjectId(String.valueOf(projectId));
				ArrayList<String> lrList = (ArrayList<String>) challanDao.getLrNo(String.valueOf(projectId));
				Collections.sort(lrList);

				String lastLrNo = "0";
				if (lrList.size() > 0) {
					lastLrNo = lrList.get(lrList.size() - 1);
					lastLrNo = lastLrNo.substring(lastLrNo.length() - 1);
				}
				int lrNoInt = Integer.parseInt(lastLrNo) + 1;
				String lrNumber = "HI/" + clientShortName + "/" + String.valueOf(lrNoInt);
				challanDetails.setInventoryRowId(inventoryRowId);
				challanDetails.setLrNumberDate(lrNumber);
				challanDao.saveChallan(challanDetails);

			}
			if ("1".equals(addBillDetails) && billDetails.getBillNumber() != null
					&& billDetails.getBillNumber() != "") {
				billDao.saveBill(billDetails);
			}

			String description = inventoryUtils.createDescriptionLine(material[i], type[i], inventoryName[i],
					gradeOrClass[i], manifMethod[i], ends[i], size[i]);
			String lineItem = getInventoryDetailsRow(String.valueOf(i + 1), size[i], description,
					String.valueOf(quantity[i]), "NB");
			if(i<14)
            {
                lineItemData.append(lineItem);
            }
            else
            {
                int challanToGoTo = Math.round(i/14);

                StringBuffer stringBufferItem = lineItemDataList.get(challanToGoTo-1);
				stringBufferItem.append(lineItem);

				lineItemDataList.add(challanToGoTo, stringBufferItem);

				if(lineItemDataList.size()>challanToGoTo+1)
				{
					lineItemDataList.remove(challanToGoTo+1);
				}


            }


			inventory.setInventoryRowId(inventoryRowId);
			receivedInventoryList.add(inventory);
		}

		String invoiceNo = null;
		String invoiceDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		if (generateInvoice.equals("1")) {

			ProjectDetails projectDetails = projectDetailsDao.getProjectDetails(projectId);

			String lasttaxInvoiceNo = taxInvoiceDetailsDao.getLastTaxIvoiceNo();

			int lastNo = 0;
			if (lasttaxInvoiceNo.length() > 0) {
				lastNo = Integer.parseInt(lasttaxInvoiceNo.substring(lasttaxInvoiceNo.lastIndexOf("/") + 1));
			}

			invoiceNo = "Invoice/" + clientShortName.replaceAll(" ","_") + "/" + String.valueOf(lastNo + 1);
			taxInvoiceDetails.setInvoiceNo(invoiceNo);
			taxInvoiceDetails.setTaxInvoiceNo(invoiceNo);

			taxInvoiceDetails.setOrderNo(projectDetails.getPoNumber());

			taxInvoiceDetails.setTaxInvoiceDate(invoiceDate);

			String totalAmount = getTotalAmount(purchaseRate, quantity);

			// Add if any miscellaneous charges are included
			String miscCharges = taxInvoiceDetails.getMiscCharges();

			String userName = (String) session.getAttribute("userName");

			String totalInvoiceAmount = createAnnexture(String.valueOf(projectId), material, type, ends, gradeOrClass, inventoryName, manifMethod,
					size, quantity, invoiceNo, taxInvoiceDetails.getInvoiceType(), userName);

			double totalAmountInt = Double.parseDouble(totalInvoiceAmount);
			if (miscCharges != null && !("".equals(miscCharges))) {
				totalAmountInt = totalAmountInt + Double.parseDouble(miscCharges);
			}

			TaxesEntity taxes = taxesDao.getTaxesDetails().get(0);

			double cGST = totalAmountInt * taxes.getcGst() / 100;
			double sGST = totalAmountInt * taxes.getsGst() / 100;

			taxInvoiceDetails.setcGst(String.valueOf(cGST));

			Double doubleVal = totalAmountInt + cGST + sGST;

			String amountsToWord = numberWordConverter.convert((int) Math.round(doubleVal));

			if (amountsToWord.length() > 40) {
				taxInvoiceDetails.setAmtInwrd1((String) amountsToWord.substring(0, 39));
				taxInvoiceDetails.setAmtInwrd2((String) amountsToWord.substring(40));
			} else {
				taxInvoiceDetails.setAmtInwrd1(amountsToWord);
				taxInvoiceDetails.setAmtInwrd2("");
			}
			taxInvoiceDetails.setRate(totalInvoiceAmount);
			taxInvoiceDetails.setTotal(totalInvoiceAmount);

			String sender = userDetailsDao.getEmailAddress(userName);

			taxInvoiceGenerator.generateAndSendTaxInvoice(taxInvoiceDetails, sender, userName);

			try {
				for (int i = 0; i < receivedInventoryList.size(); i++) {

					Inventory inventory = receivedInventoryList.get(i);
					inventory.setInvoiceNo(invoiceNo);
					inventory.setReceivedDate(invoiceDate);

					try {
						inventoryDao.updateWhenSaveFailed(inventory);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String userName = (String)session.getAttribute("userName");
		UserDetails userDetails = userDetailsDao.getuSerDetails(userName);

		String subChallanHTML = inventoryUtils.getChallanHTML(noOfChallan-1, challanDetails, lineItemDataList, userDetails);

		view.addObject("moreChallanPages", subChallanHTML);

		view.addObject("itemList", lineItemData.toString().replaceAll("~",""));
		view.addObject("challanNo", challanDetails.getInventoryRowId()+" - "+"1/"+noOfChallan);

		for(int l =1;l<noOfChallan;l++)
        {
            view.addObject("itemList"+l, lineItemDataList.get(l-1).toString().replaceAll("~",""));
            view.addObject("challanNo"+l, challanDetails.getInventoryRowId()+" - "+l+1+"/"+noOfChallan);
        }



		view.addObject("date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
		view.addObject("consignee1", challanDetails.getConsignee());
		view.addObject("consignee2", "");
		view.addObject("consignee3", "");
		view.addObject("from1", userDetails.getFirstName() + " " + userDetails.getLastName());
		view.addObject("from2", challanDetails.getReceivedFrom());
		view.addObject("from3", "");
		view.addObject("gstNo", challanDetails.getGstNo());
		view.addObject("lrNo", challanDetails.getLrNumberDate());
		view.addObject("poDate", challanDetails.getPoDate());
		view.addObject("poNo", challanDetails.getPoNo());
		view.addObject("transportMode", challanDetails.getTransportMode());
		view.addObject("vheicleNumber", challanDetails.getVheicleNumber());

		ArrayList<Project> projectList = projectDao.getProject("projectName", "");
		StringBuffer projectNames = new StringBuffer();

		for (Project project1 : projectList) {
			projectNames.append(project1.getProjectName() + ",");
		}
		view.addObject("projectNames", projectNames.toString());

		// Generate the Invoice if this is not a return i.e. taxInvoiceNo is
		// null.

		return view;
	}

	@RequestMapping(value = "/generateInvoice", method = RequestMethod.POST)
	public @ResponseBody String generateInvoice(int projectId, String[] inventoryName, String[] material, String[] type,
			String[] manifMetod, String[] classOrGrade, String[] ends, String[] size, String[] purchaseRate,
			int[] receivedQuantity, String[] location, String[] receivedDate, TaxInvoiceDetails taxInvoiceDetails,
			HttpSession session) {
		taxInvoiceDetails.setProjectId(projectId);

		String lasttaxInvoiceNo = taxInvoiceDetailsDao.getLastTaxIvoiceNo();
		String clientShortName = "";
		Project project = projectDao.getProject(projectId);

		String projectName = project.getProjectName();

		int lastNo = 0;
		if (lasttaxInvoiceNo.length() > 0) {
			lastNo = Integer.parseInt(lasttaxInvoiceNo.substring(lasttaxInvoiceNo.lastIndexOf("/") + 1));
		}

		String temp = projectName;

		if (projectName.contains(" ") && projectName.length() >= 7) {
			clientShortName = projectName.substring(0, 3) + new String(temp.getBytes(), temp.indexOf(" "), 3);
		} else {
			clientShortName = projectName.substring(0, 3);
		}

		ProjectDetails projectDetails = projectDetailsDao.getProjectDetails(projectId);

		String invoiceNo = "Invoice/" + clientShortName.replaceAll(" ","_") + "/" + String.valueOf(lastNo + 1);
		taxInvoiceDetails.setInvoiceNo(invoiceNo);
		taxInvoiceDetails.setTaxInvoiceNo(invoiceNo);
		taxInvoiceDetails.setOrderNo(projectDetails.getPoNumber());
		taxInvoiceDetails.setGstNo(projectDetails.getGstNumber());

		taxInvoiceDetails.setProjectName(projectName);

		String invoiceDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		taxInvoiceDetails.setTaxInvoiceDate(invoiceDate);

		String totalAmount = getTotalAmount(purchaseRate, receivedQuantity);

		// Add if any miscellaneous charges are included

		String miscCharges = taxInvoiceDetails.getMiscCharges();

		double totalAmountInt = Double.parseDouble(totalAmount);
		if (miscCharges != null && !("".equals(miscCharges))) {
			totalAmountInt = totalAmountInt + Double.parseDouble(miscCharges);
		}

		taxInvoiceDetails.setRate(totalAmount);

		String userName = (String) session.getAttribute("userName");
		String sender = userDetailsDao.getEmailAddress(userName);

		String totalInvoiceAmount = createAnnexture(String.valueOf(projectId), material, type, ends, classOrGrade,
				inventoryName, manifMetod, size, receivedQuantity, invoiceNo, taxInvoiceDetails.getInvoiceType(), userName);

		taxInvoiceDetails.setRate(totalInvoiceAmount);
		taxInvoiceDetails.setTotal(totalInvoiceAmount);

		TaxesEntity taxes = taxesDao.getTaxesDetails().get(0);

		double cGST = Double.parseDouble(totalInvoiceAmount) * taxes.getcGst() / 100;
		double sGST = Double.parseDouble(totalInvoiceAmount) * taxes.getsGst() / 100;

		Double doubleVal = Double.parseDouble(totalInvoiceAmount) + cGST + sGST;

		String amountsToWord = numberWordConverter.convert((int) Math.round(doubleVal));
		if (amountsToWord.length() > 40) {
			taxInvoiceDetails.setAmtInwrd1((String) amountsToWord.substring(0, 39));
			taxInvoiceDetails.setAmtInwrd2((String) amountsToWord.substring(40));
		} else {
			taxInvoiceDetails.setAmtInwrd1(amountsToWord);
			taxInvoiceDetails.setAmtInwrd2("");
		}

		taxInvoiceDetails.setcGst(String.valueOf(cGST));
		taxInvoiceGenerator.generateAndSendTaxInvoice(taxInvoiceDetails, sender, userName);

		try {

			for (int i = 0; i < inventoryName.length; i++) {

				Inventory inventory = new Inventory(
						new InventorySpec(inventoryName[i], material[i], type[i], manifMetod[i], classOrGrade[i],
								ends[i], size[i], projectName, "consumed"),
						purchaseRate[i], receivedQuantity[i], location[i], "", "");

				try {
					// Check if exists get the inventoryRow Id

					int rowId = inventoryDao.isEntityPresent(inventory);

					if (rowId == 0) {
						rowId = inventoryDao.getLatestInventoryEntryNo() + 1;
					}
					inventory.setInventoryRowId(rowId);

					inventory.setInvoiceNo(invoiceNo);

					inventoryDao.updateWhenSaveFailed(inventory);
				} catch (Exception ex) {
					ex.printStackTrace();

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILURE";
		}

		return "SUCCESS";
	}

	@RequestMapping(value = "/release", method = RequestMethod.POST)
	private ModelAndView releaseInventory(String inventoryStr, String materialStr, String typeStr,
			String manifMethodStr, String gradeOrClassStr, String endsStr, String sizeStr, String purchaseRateStr,
			String projectStr, String locationStr, String quantity, String projectId, String projectName,
			String projectDesc, String statusTo, RedirectAttributes redirectAttributes) {
		Inventory inventory = new Inventory(new InventorySpec(inventoryStr, materialStr, typeStr, manifMethodStr,
				gradeOrClassStr, endsStr, sizeStr, projectStr, "assigned"), purchaseRateStr, 0, locationStr, null, null);

		int assignedQty = inventoryDao.getQuantityByStatus(inventory, "assigned", true);

		int qty = 0;

		if (statusTo.equals("assigned")) {
			qty = Integer.valueOf(assignedQty) + Integer.valueOf(quantity);
		} else {
			qty = Integer.valueOf(assignedQty) - Integer.valueOf(quantity);
		}

		inventory.setInventoryRowId(inventoryDao.isEntityPresent(inventory));

		// Reduce the assigned quantity
		inventory.setQuantity(qty);

		// Add new entry for update existing one without project
		Inventory releasedInventory = inventory.copyObject(inventory);

		int releasedInventoryRowId = 0;
		boolean isToBeAssigned = false;

		if (statusTo.equals("release")) {
			statusTo = "available";
			InventorySpec invSpec = inventoryUtils.copyInventorySpec(inventory.getInventorySpec());
			invSpec.setAssignedProject("");
			invSpec.setStatus("available");
			releasedInventory.setInventorySpec(invSpec);
			releasedInventoryRowId = inventoryDao.isEntityPresent(releasedInventory);
		} else if (statusTo.equals("consumed")) {
			InventorySpec invSpec = inventoryUtils.copyInventorySpec(inventory.getInventorySpec());
			invSpec.setAssignedProject(inventory.getInventorySpec().getAssignedProject());
			invSpec.setStatus("consumed");
			releasedInventory.setInventorySpec(invSpec);
			releasedInventoryRowId = inventoryDao.isEntityPresent(releasedInventory, statusTo);
		} else if (statusTo.equals("assigned")) {
			isToBeAssigned = true;
			statusTo = "available";

			InventorySpec invSpec = inventoryUtils.copyInventorySpec(inventory.getInventorySpec());
			invSpec.setAssignedProject("");
			invSpec.setStatus("available");

			releasedInventory.setInventorySpec(invSpec);

			releasedInventoryRowId = inventoryDao.isEntityPresent(releasedInventory, statusTo);
		}

		if (releasedInventoryRowId == 0) {
			// Inventory is not available. Add a new entry to DB
			releasedInventory.setQuantity(Integer.valueOf(quantity));
			releasedInventory.setInventoryRowId(inventoryDao.getLatestInventoryEntryNo() + 1);

		} else {
			// Inventory is available. Just increase the
			// quantity
			int quantityToGo = inventoryDao.getQuantityByStatus(releasedInventory, statusTo, false);

			int quantityToUpdate = 0;

			if (isToBeAssigned) {
				quantityToUpdate = quantityToGo - Integer.valueOf(quantity);
			} else {
				quantityToUpdate = quantityToGo + Integer.valueOf(quantity);
			}

			releasedInventory.setQuantity(quantityToUpdate);
			releasedInventory.setInventoryRowId(releasedInventoryRowId);
		}

		try {
			inventoryDao.saveInventory(inventory);
		} catch (Exception ex) {
			System.out.println("calling update");
			inventoryDao.updateWhenSaveFailed(inventory);
		}

		try {
			inventoryDao.saveInventory(releasedInventory);
		} catch (Exception ex) {
			System.out.println("calling update");
			inventoryDao.updateWhenSaveFailed(releasedInventory);
		}

		if (isToBeAssigned) {
			return new ModelAndView("redirect:/updateInventoryForm");
		}

		redirectAttributes.addAttribute("projectId", projectId);
		redirectAttributes.addAttribute("projectName", projectName);
		redirectAttributes.addAttribute("projectDesc", projectDesc);

		return new ModelAndView("redirect:/projectDetails");
	}

	@RequestMapping(value = "/updateInvPO", method = RequestMethod.GET)
	private ModelAndView updateInvPO() {
		ArrayList<Project> projectList = projectDao.getProject("projectName", "");
		StringBuffer projectNames = new StringBuffer();

		for (Project project : projectList) {
			projectNames.append(project.getProjectName() + ",");
		}
		return new ModelAndView("inventoryUpdate").addObject("projectNames", projectNames.toString());
	}


	@RequestMapping(value = "/getExistingMappings", method = RequestMethod.GET)
	private @ResponseBody String getExistingMappings() {
		StringBuilder mappingsHTML = new StringBuilder();
		ArrayList<Mappings> mappingsList = mappingsDao.getAllMappinsData();

		return mappingsHTML.toString();
	}

	private String getInventoryDetailsRow(String sr_no, String size, String description, String quantity, String unit) {
		String template = "<tr><td style=\"text-align:center;\" >&emsp;sr_no&emsp;&emsp;&emsp;size</td>"
				+ "<td style=\"text-align:center;\">Description</td>" + "<td style=\"text-align:center;\">quantity</td>"
				+ "<td style=\"text-align:center;\">unit</td>" + "</tr>";
		String stringToReturn = template.replace("sr_no", sr_no).replace("size", size)
				.replace("Description", description).replace("quantity", quantity).replace("unit", unit);

		return stringToReturn;
	}

	private String getTotalAmount(String[] purchaseRate, int[] quantity) {
		double total = 0;

		for (int i = 0; i < purchaseRate.length; i++) {
			total = total + (Double.parseDouble(purchaseRate[i]) * quantity[i]);
		}

		return String.valueOf(total);
	}

	protected String createAnnexture(String projectId, String[] materialIn, String[] typeIn, String[] endsIn,
			String[] classOrGradeIn, String[] inventoryNameIn, String[] manifMetodIn, String[] sizeIn, int billedQty[],
			String invoiceNo, String invoiceType, String userName) {

		invoiceNo = invoiceNo.replace("/", "_");
		String destination = System.getProperty("java.io.tmpdir") + "/" + userName +"/" + invoiceNo + "_Annexture.xls";

		String docNameToDownload = boqDetailsDao.getLatestAssociatedBOQProject(projectId);

		byte[] excelByts = null;

		ArrayList<BOQLineData> boqlineData = new ArrayList<BOQLineData>();

		ArrayList<BOQDetails> itemDetails = boqDetailsDao.getBOQFromName(docNameToDownload, projectId);

		Double supplyAmountTotal = 0.0;
		Double erectionAmountTotal = 0.0;

		int length = itemDetails.size();

		String[] material = new String[length];
		String[] type = new String[length];
		String[] ends = new String[length];
		String[] classOrGrade = new String[length];
		String[] inventoryName = new String[length];
		String[] manifMetod = new String[length];
		String[] size = new String[length];
		String[] quantity = new String[length];
		String[] supplyRate = new String[length];
		String[] erectionRate = new String[length];
		String[] supplyAmount = new String[length];
		String[] erectionAmount = new String[length];

		for (int i = 0; i < length; i++) {
			material[i] = itemDetails.get(i).getMaterial();
			type[i] = itemDetails.get(i).getType();
			ends[i] = itemDetails.get(i).getEnds();
			classOrGrade[i] = itemDetails.get(i).getClassOrGrade();
			inventoryName[i] = itemDetails.get(i).getInventoryName();
			manifMetod[i] = itemDetails.get(i).getManifacturingMethod();
			size[i] = itemDetails.get(i).getSize();
			quantity[i] = "0";
			supplyRate[i] = itemDetails.get(i).getSupplyRate();
			erectionRate[i] = itemDetails.get(i).getErectionRate();
			supplyAmount[i] = "0";
			erectionAmount[i] = "0";

		}

		for (int k = 0; k < inventoryNameIn.length; k++) {
			for (int i = 0; i < length; i++) {
				if (materialIn[k].equalsIgnoreCase(itemDetails.get(i).getMaterial())
						&& typeIn[k].equalsIgnoreCase(itemDetails.get(i).getType())
						&& endsIn[k].equalsIgnoreCase(itemDetails.get(i).getEnds())
						&& classOrGradeIn[k].equalsIgnoreCase(itemDetails.get(i).getClassOrGrade())
						&& inventoryNameIn[k].equalsIgnoreCase(itemDetails.get(i).getInventoryName())
						&& manifMetodIn[k].equalsIgnoreCase(itemDetails.get(i).getManifacturingMethod())
						&& sizeIn[k].equalsIgnoreCase(itemDetails.get(i).getSize())) {
					quantity[i] = String.valueOf(billedQty[k]);
					supplyAmount[i] = String
							.valueOf(billedQty[k] * Double.parseDouble(itemDetails.get(i).getSupplyRate()));
					erectionAmount[i] = String
							.valueOf(billedQty[k] * Double.parseDouble(itemDetails.get(i).getErectionRate()));

					supplyAmountTotal += billedQty[k] * Double.parseDouble(itemDetails.get(i).getSupplyRate());
					erectionAmountTotal += billedQty[k] * Double.parseDouble(itemDetails.get(i).getErectionRate());
				}
			}
		}

		BOQHeader header = boqHeaderDao.getBOQHeaderFromName(docNameToDownload, projectId);

		boqlineData = boqController.getBOQLineDataList(material, type, ends, classOrGrade, inventoryName, manifMetod);
		try {
			excelByts = writer.writeExcel(boqlineData, size, quantity, supplyRate, erectionRate, supplyAmount,
					erectionAmount, "", header, false, true);

			File fileToSave = new File(destination);
			fileToSave.getParentFile().mkdirs();

			FileOutputStream fOut = new FileOutputStream(fileToSave);

			fOut.write(excelByts);

			fOut.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if("Supply".equalsIgnoreCase(invoiceType))
		{
			return String.valueOf(supplyAmountTotal);
		}
		else if("Labour".equalsIgnoreCase(invoiceType))
		{
			return String.valueOf(erectionAmountTotal);
		}
		else if("Supply&Labour".equalsIgnoreCase(invoiceType))
		{
			return String.valueOf(erectionAmountTotal + supplyAmountTotal);
		}

		return "";

	}
}