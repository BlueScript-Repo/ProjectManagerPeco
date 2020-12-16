package com.projectmanager.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.projectmanager.dao.*;
import com.projectmanager.util.HTMLElements;
import com.projectmanager.util.NotificationUtil;
import com.projectmanager.util.PurchaseOrderPDFView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.amazonaws.util.StringUtils;
import com.projectmanager.entity.Inventory;
import com.projectmanager.entity.InventorySpec;
import com.projectmanager.entity.PODetails;
import com.projectmanager.entity.Project;
import com.projectmanager.entity.ProjectDetails;
import com.projectmanager.entity.TaxInvoiceDetails;
import com.projectmanager.util.InventoryUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@EnableWebMvc
public class OrderController {

	@Autowired
	InventoryUtils inventoryUtils;

	@Autowired
	TaxInvoiceDetailsDao invoiceDao;

	@Autowired
	PODetailsDao poDetailsDao;

	@Autowired
	ProjectDao projectDao;

	@Autowired
	ProjectDetailsDao projectDetailsDao;

	@Autowired
	InventoryDao inventoryDao;

	@Autowired
	NotificationUtil notificationUtil;

	@Autowired
	PurchaseOrderPDFView purchaseOrderPDFView;

	@RequestMapping(value = "/generateOrderForm", method = RequestMethod.POST)
	public ModelAndView generateOfferFrom(String[] product, String[] moc, String[] manufactureType, String[] classOrGrade,
			String[] materialSpecs, String[] standardType, String[] ends, String[] size, String[] quantity, String[] supplyRate,
			String projectId) {
		StringBuffer lineItemData = new StringBuffer();

		StringBuffer lineItemDataSiple = new StringBuffer();

		ModelAndView mav = new ModelAndView("purchaseOrderForm");

		int length = product.length;

		System.out.println("inventoryName.length is : " + length);
		for (int i = 0; i < length; i++) {

			String description = inventoryUtils.createDescriptionLine(moc[i], product[i],
					classOrGrade[i], manufactureType[i], materialSpecs[i], standardType[i], ends[i], size[i]);
			String index = String.valueOf(i + 1);
			String lineItem = getInventoryDetailsRow(index, description, quantity[i], supplyRate[i]);
			lineItemData.append(lineItem);

			String line = index + "," + description + "," + quantity[i] + "," + supplyRate[i] + ";";

			System.out.println("Simple line : " + line);
			lineItemDataSiple.append(line);
		}
		System.out.println(lineItemDataSiple.length());
     System.out.println(lineItemDataSiple.toString());

		mav.addObject("lineItemData", lineItemData.toString());
		mav.addObject("lineItemDataSimple", lineItemDataSiple.toString());
		mav.addObject("projectId", projectId);
		return mav;
	}

	@RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
	public ModelAndView generateOffer(RedirectAttributes redirectAttrs, PODetails poDetails, String lineItemSimple, Model model,
									  HttpSession session, HttpServletResponse response, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("purchaseOrder");

		StringBuffer terms = new StringBuffer();

		for (String termLine : poDetails.getTerm()) {
			terms.append(getTermHtml(termLine));
		}

		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
		String poDate = date.format(formatter);

		ArrayList<String> poNumberList = (ArrayList<String>) poDetailsDao.getPoNumber(poDetails.getProjectId());
		ArrayList<String> vendorSpecificPoList = new ArrayList<String>();

		Collections.sort(poNumberList);

		System.out.println("Sorted LR list is : ");

		for (String poNo : poNumberList) {
			System.out.println(poNo);
			if (poNo.contains(poDetails.getVendorName())) {
				vendorSpecificPoList.add(poNo);
			}
		}

		String lastPoNo = "0";

		Collections.sort(vendorSpecificPoList);

		if (vendorSpecificPoList.size() > 0) {
			lastPoNo = vendorSpecificPoList.get(vendorSpecificPoList.size() - 1);
			lastPoNo = lastPoNo.substring(lastPoNo.lastIndexOf("/") + 1);
		}

		int poNoInt = Integer.parseInt(lastPoNo) + 1;

		String poNumber = "HI/" + poDetails.getVendorName() + "/" + poDetails.getProjectId() + "/"
				+ String.valueOf(poNoInt);

		mav.addObject("PONumber", poNumber);
		mav.addObject("PODate", poDate);
		mav.addObject("companyName", poDetails.getVendorName());
		mav.addObject("location", poDetails.getLocation());
		mav.addObject("contactName", poDetails.getContactName());
		mav.addObject("contactNumber", poDetails.getContactNumber());
		mav.addObject("contactEmail", poDetails.getContactEmail());
		mav.addObject("terms", terms.toString());

		System.out.println(poDetails.getLineItem());

		poDetails.setPoNumber(poNumber);
		poDetails.setPoDate(poDate);

		poDetails.setLineItemNoHtml(lineItemSimple);


		System.out.println(poDetails.getLineItem());
		System.out.println(poDetails.getLineItem().length());

		poDetailsDao.savePO(poDetails);

		String lineItemSimpleStr = poDetails.getLineItemNoHtml();
		String[] lineItemSimpleStrArray = lineItemSimpleStr.split(";");

		System.out.println("showPO : " + lineItemSimpleStr);

		model.addAttribute("poDetails", poDetails);

		model.addAttribute("poLineDetails", lineItemSimpleStr);


		String userName = (String)session.getAttribute("userName");

		model.addAttribute("userName", userName);

		//save entry to notification table

		String poName = poNumber.replace("/", "_");
		notificationUtil.pushNotification(userName,poDetails.getContactEmail(),
				"Purchase Order :" + poDetails.getVendorName(),
				"Enter body Text here",
				poName+".pdf",
				"INBOX",new Date());

		//return "purchaseOrderView";


		Map<String, Object> modelObject = new HashMap<>();
		modelObject.put("poDetails", poDetails);
		for(String s1:lineItemSimpleStrArray)
		modelObject.put("poLineDetails", lineItemSimpleStr);
		modelObject.put("userName", userName);

		try
		{
			purchaseOrderPDFView.renderMergedOutputModel(modelObject, request, response);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		Project project = projectDao.getProject(Integer.parseInt(poDetails.getProjectId()));

		ModelAndView projectDetails = new ModelAndView("redirect:/projectDetails");


		redirectAttrs.addAttribute("projectId", String.valueOf(poDetails.getProjectId()));
		redirectAttrs.addAttribute("projectName", project.getProjectName());
		redirectAttrs.addAttribute("projectDesc", project.getProjectDesc());

		return projectDetails;
	}

	@RequestMapping(value = "/showInvoice", method = { RequestMethod.POST, RequestMethod.GET })
	private String shiwInvoice(Model model, String invoiceName) {
		ArrayList<TaxInvoiceDetails> invoiceDetails = invoiceDao.getTaxIvoiceData("taxInvoiceNo", invoiceName);

		model.addAttribute("taxInvoiceDetails", invoiceDetails.get(0));

		return "taxInvoiceView";
	}

	@RequestMapping(value = "/showPO", method = { RequestMethod.POST, RequestMethod.GET })
	private String showPO(Model model, String poName)
	{
		ArrayList<PODetails> invoiceDetails = poDetailsDao.getPOData("poNumber", poName);

		System.out.println("showPO : " + poName);

		ArrayList<PODetails> detailsList = poDetailsDao.getPOData("poNumber", poName);

		String lineItemSimple = ((PODetails) detailsList.get(0)).getLineItemNoHtml();

		System.out.println("showPO : " + lineItemSimple);

		model.addAttribute("poDetails", invoiceDetails.get(0));

		model.addAttribute("poLineDetails", lineItemSimple);

		return "purchaseOrderView";
	}

	@RequestMapping(value = "/getPoList", method = { RequestMethod.POST, RequestMethod.GET })
	private @ResponseBody String getPoList(String projectName) {
		int projectID = projectDao.getProjectId(projectName);

		ProjectDetails projectDetails = projectDetailsDao.getProjectDetails(projectID);

		String poNames = inventoryUtils.getPONames(String.valueOf(projectID));

		return poNames + "::" + projectDetails.toString();
	}

	@RequestMapping(value = "/getPoDetails", method = { RequestMethod.POST, RequestMethod.GET })
	private @ResponseBody String getPoDetails(String poNumber) {
		ArrayList<PODetails> poDetailsList = poDetailsDao.getPOData("poNumber", poNumber);

		String rowToReturn = "";

		for (PODetails pODetails : poDetailsList) {
			Project project = projectDao.getProject(Integer.parseInt(pODetails.getProjectId()));

			String[] lineItems = pODetails.getLineItemNoHtml().split(";");

			for (String line : lineItems) {
				String itemsStr = HTMLElements.PO_DETAILS_ROW;

				String words[] = line.split(",");

				String[] details = words[1].split("~");

				String productVal = details[0].trim();
				String mocVal = details[1].trim();
				String manufactureType = details[2].trim();
				String gradeOrClassVal = details[3].trim();
				String materialSpecsVal = details[4].trim();
				String standardTypeVal = details[5].trim();
				String endsVal = details[6].trim();
				String sizeVal = details[7].trim();


				String purchaseRate = words[3];
				String poQuantity = words[2];
				String projectNameVal = project.getProjectName();

				itemsStr = itemsStr.replace("productVal", productVal);
				itemsStr = itemsStr.replace("mocVal", mocVal);
				itemsStr = itemsStr.replace("manufactureTypeVal", manufactureType);
				itemsStr = itemsStr.replace("materialSpecsVal", materialSpecsVal);
				itemsStr = itemsStr.replace("standardTypeVal", standardTypeVal);
				itemsStr = itemsStr.replace("gradeOrClassVal", gradeOrClassVal);
				itemsStr = itemsStr.replace("endsVal", endsVal);
				itemsStr = itemsStr.replace("sizeVal", sizeVal);
				itemsStr = itemsStr.replace("poQuantity", poQuantity);
				itemsStr = itemsStr.replace("projectNameVal", projectNameVal);
				itemsStr = itemsStr.replace("purchaseRateVal", purchaseRate);

				rowToReturn = rowToReturn + itemsStr;
			}
		}

		return rowToReturn + "::" + ((PODetails) poDetailsList.get(0)).toString();
	}

	@RequestMapping(value = "/getNoInvoiceInventory", method = RequestMethod.POST)
	public @ResponseBody String getNoInvoiceInventory(int projectId) throws Exception {
		String rowToReturn = "";

		Project project = projectDao.getProject(projectId);
		ArrayList<Inventory> receivedInvListNoInvoice = inventoryDao.getNoInvoiceInventory(project.getProjectName());

		if(receivedInvListNoInvoice.size()>0) {
			for (Inventory receivedInventory : receivedInvListNoInvoice) {

				InventorySpec invSpec = receivedInventory.getInventorySpec();
				String itemsStr = HTMLElements.NO_INVOICE_INVENTORY_ROW;
				itemsStr = itemsStr.replace("productVal", invSpec.getInventoryName());
				itemsStr = itemsStr.replace("mocVal", invSpec.getMaterial());
				itemsStr = itemsStr.replace("manufactureTypeVal", invSpec.getManifMethod());
				itemsStr = itemsStr.replace("gradeOrClassVal", invSpec.getGradeOrClass());
				itemsStr = itemsStr.replace("standardTypeVal", invSpec.getStandardType());
				itemsStr = itemsStr.replace("materialSpecsVal", invSpec.getMaterialSpecs());
				itemsStr = itemsStr.replace("endsVal", invSpec.getEnds());
				itemsStr = itemsStr.replace("sizeVal", invSpec.getSize());
				itemsStr = itemsStr.replace("receivedQuantityVal", String.valueOf(receivedInventory.getQuantity()));
				itemsStr = itemsStr.replace("projectNameVal", invSpec.getAssignedProject());
				itemsStr = itemsStr.replace("purchaseRateVal", receivedInventory.getPurchaseRate());
				itemsStr = itemsStr.replace("locationVal", receivedInventory.getLocation());
				itemsStr = itemsStr.replace("receivedDateVal",
						(StringUtils.isNullOrEmpty(receivedInventory.getReceivedDate()) ? ""
								: receivedInventory.getReceivedDate().substring(0, 10)));

				rowToReturn = rowToReturn + itemsStr;
			}
		}
		else
		{
			rowToReturn = "<tr><td colspan=\"13\" class=\"text-center\">No inventory to BILL..!!<t d=\"\"></t></td></tr>";
		}

		return rowToReturn;
	}

	// Function to find the index of an element in a primitive array in Java
	public static int findIndex(String[] a, String target) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(target))
				return i;
		}
		return -1;
	}

	private String getInventoryDetailsRow(String sr_no, String description, String quantity, String supplyRate) {
		String template = "<TR>" + "	<TD class=\"tr8 td38\"><P class=\"p16 ft8\">sr_no</P></TD>               "
				+ "	<TD class=\"tr8 td27\"><P class=\"p0 ft0\"></P></TD>               "
				+ "	<TD class=\"tr8 td53\"><P class=\"p0 ft0\"></P></TD>               "
				+ "	<TD colspan=2 class=\"tr8 td54\"><P class=\"p4 ft8\">Description</P></TD>"
				+ "	<TD class=\"tr8 td41\"><P class=\"p0 ft0\"></P></TD>               "
				+ "	<TD class=\"tr8 td42\"><P class=\"p17 ft8\">quantity</P></TD>            "
				+ "	<TD class=\"tr8 td43\"><P class=\"p8 ft8\">NB</P></TD>                 "
				+ "	<TD class=\"tr8 td44\"><P class=\"p18 ft8\">supplyRate</P></TD>"
				+ "	<TD class=\"tr8 td55\"><P class=\"p5 ft9 gstCentral\" value=\"cgst\">cgst</P></TD>                 "
				+ "	<TD class=\"tr8 td55\"><P class=\"p5 ft9 gstState\" value=\"sgst\">sgst</P></TD>                 "
				+ "	<TD class=\"tr8 td17\"><P class=\"p5 ft9 lineAmt\" value=\"amount\">amount</P></TD>              "
				+ "</TR>                                                                       ";

		float amount = Float.parseFloat(quantity) * Float.parseFloat(supplyRate);

		//Updated below code to use TAX values from DB

		float sgst = amount * 9 / 100;
		float cgst = amount * 9 / 100;

		String stringToReturn = template.replace("sr_no", sr_no).replace("Description", description)
				.replace("quantity", quantity)
				.replace("supplyRate",
						supplyRate.contains(".") ? supplyRate.substring(0, supplyRate.indexOf(".")) : supplyRate)
				.replace("cgst", get2DecimalVal(cgst)).replace("sgst", get2DecimalVal(sgst))
				.replace("amount", get2DecimalVal(amount));

		return stringToReturn;
	}

	public String get2DecimalVal(float val) {
		String twoDecimalVal = String.valueOf(val);

		// twoDecimalVal = twoDecimalVal.substring(0, twoDecimalVal.indexOf(".")
		// + 3);

		return twoDecimalVal;
	}

	private String getTermHtml(String termLine) {
		String template = "<TR>                                                                     "
				+ "	<TD colspan=7 class=\"tr8 td58\"><P class=\"p23 ft3\">1 TERM_TEXT.</P></TD>"
				+ "	<TD class=\"tr8 td30\"><P class=\"p0 ft0\"></P></TD>                "
				+ "	<TD class=\"tr8 td31\"><P class=\"p0 ft0\"></P></TD>                "
				+ "	<TD class=\"tr8 td16\"><P class=\"p0 ft0\"></P></TD>                "
				+ "	<TD class=\"tr8 td16\"><P class=\"p0 ft0\"></P></TD>                "
				+ "	<TD class=\"tr8 td17\"><P class=\"p0 ft0\"></P></TD>                "
				+ "</TR>                                                                    ";

		String stringToReturn = template.replace("TERM_TEXT", termLine);

		return stringToReturn;
	}


//	private static final String poDetailsRow = "	   <tr>"
//			+ "    <td> <input type='button' value='X' onClick='removeRow($(this));'></td>"
//			+ "    <td> <input type='hidden' name='product' value='productVal'></input> productVal </td>"
//			+ "    <td> <input type='hidden' name='moc' value='mocVal'></input>mocVal</td>"
//			+ "    <td> <input type='hidden' name='manufactureType' value='manufactureTypeVal'></input>manufactureTypeVal</td>"
//			+ "    <td> <input type='hidden' name='gradeOrClass' value='gradeOrClassVal'></input>gradeOrClassVal</td>"
//			+ "    <td> <input type='hidden' name='materialSpecs' value='materialSpecsVal'></input>materialSpecsVal</td>"
//			+ "    <td> <input type='hidden' name='standardType' value='standardTypeVal'></input>standardTypeVal</td>"
//			+ "    <td> <input type='hidden' name='ends' value='endsVal'></input>endsVal</td>"
//			+ "    <td> <input type='hidden' name='size' value='sizeVal'></input>sizeVal</td>"
//			+ "	   <td> <input type='hidden' name='purchaseRate' value='purchaseRateVal'></input> purchaseRateVal </td>"
//			+ "	   <td> poQuantity </td>"
//			+ "	   <td><input type='text' class='form-control' id='receivedQuantity' name='quantity' onChange='exceedInventory($(this));' value=''></input><input type='hidden' name='projectName' id='projectNm' value='projectNameVal'></td>"
//			+ "	   <td><input type='text' class='form-control' name='location' value=''></input></td>"
//			+ "	   <td><input type='text' class='form-control' name='comment' value=''></input></td>"			
//			+ "	   <input type='hidden' name='status' value='assigned'>" + "    </tr>";
//


}
