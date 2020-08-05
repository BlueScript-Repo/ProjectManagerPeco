package com.projectmanager.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import com.projectmanager.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.projectmanager.dao.InventoryDao;
import com.projectmanager.dao.PODetailsDao;
import org.springframework.util.ResourceUtils;

@ManagedBean
public class InventoryUtils {

	@Autowired
	InventoryDao inventoryDao;

	@Autowired
	PODetailsDao poDetailsDao;

	public String createDescriptionLine(String material, String type, String inventory, String classOrgrade,
			String manifMethod, String ends, String size) {
		//String templateDesc = "material type inventory of Grade(OR Class) as classOrgrade with Ends as endsVal Manifacturing Method as manifMethod of size sizeVal";

		String templateDesc = "inventory~ material~ classOrgrade~ type~ endsVal~ manifMethod~ sizeVal";
		
		String description = templateDesc;

		description = description.replace("material", material);
		
		description = description.replace("type", type);

		description = description.replace("inventory", inventory);
		description = description.replace("classOrgrade", classOrgrade);

		description = description.replace("endsVal", ends);
		description = description.replace("sizeVal", size);
		description = description.replace("manifMethod", manifMethod);

		return description;
	}

	public List<InventorySpec> createInventorySpecList(String[] inventoryName, String[] material, String[] type,
			String[] manifMethod, String[] gradeOrClass, String[] ends, String[] size, String[] project,
			String[] status) {
		ArrayList<InventorySpec> inventorySpecList = new ArrayList<InventorySpec>();
		String projectname = project[0];

		for (int i = 0; i < inventoryName.length; i++) {
			inventorySpecList.add(new InventorySpec(inventoryName[i], material[i], type[i], manifMethod[i],
					gradeOrClass[i], ends[i], size[i], projectname, status[i]));
		}

		return inventorySpecList;
	}

	public String createInventoryRowTable(Inventory inv, boolean isConsumed) {
		return createInventoryRowTable(inv, false, null, isConsumed);
	}

	public String createInventoryRowTable(Inventory inv, boolean needProjectList, String index, boolean isConsumed) {

		String inventoryId = "inventoryNo";

		if (null != index) {
			inventoryId = inventoryId + index;
		}

		String template = "<tr id=\"" + inventoryId + "\"><form><td></td>"
				+ "<td>InventoryVal</td>    <td>MaterialVal</td>    <td>TypeVal</td>"
				+ "<td>ManifMethodVal</td><td>gradeOrClassVal</td>    <td>endsVal</td>" + "<td>sizeVal</td>" + "<td>"
				+ (isConsumed ? "availableQuantity</td>"
						: "<input type=\"text\" style=\"width:45px;\" name=\"quantity\" value=\"availableQuantity\" > </td>")
				+ "<td>purchaseRateVal</td>"
				+ (needProjectList
						? "<td><select class='form-control currentProjectList' name='project' name='projectName' ><option></option></td>"
						: "<td>projectVal</td>")
				+ "<td>locationVal</td>"

				+ (isConsumed ? ""
						: "<td><input type=\"button\" class=\"btn btn-default statusTo \" value=\"release\"></td>")
				+ "<input type=\"hidden\" name=\"inventoryStr\" value=\"InventoryVal\" >"
				+ "<input type=\"hidden\" name=\"materialStr\" value=\"MaterialVal\" >"
				+ "<input type=\"hidden\" name=\"typeStr\" value=\"TypeVal\" >"
				+ "<input type=\"hidden\" name=\"manifMethodStr\" value=\"ManifMethodVal\" >"
				+ "<input type=\"hidden\" name=\"gradeOrClassStr\" value=\"gradeOrClassVal\" >"
				+ "<input type=\"hidden\" name=\"endsStr\" value=\"endsVal\" >"
				+ "<input type=\"hidden\" name=\"sizeStr\" value=\"sizeVal\" >"
				+ "<input type=\"hidden\" name=\"purchaseRateStr\" value=\"purchaseRateVal\" >"
				+ "<input type=\"hidden\" name=\"projectStr\" value=\"projectVal\" >"
				+ "<input type=\"hidden\" name=\"locationStr\" value=\"locationVal\" > "
				+ "<input type=\"hidden\" name=\"status\" value=\"assigned\"> " + "</tr>";

		String rowToReturn = template;
		rowToReturn = rowToReturn.replace("InventoryVal", inv.getInventorySpec().getInventoryName());
		rowToReturn = rowToReturn.replace("MaterialVal", inv.getInventorySpec().getMaterial());
		rowToReturn = rowToReturn.replace("TypeVal", inv.getInventorySpec().getType());
		rowToReturn = rowToReturn.replace("ManifMethodVal", inv.getInventorySpec().getManifMethod());
		rowToReturn = rowToReturn.replace("gradeOrClassVal", inv.getInventorySpec().getGradeOrClass());
		rowToReturn = rowToReturn.replace("endsVal", inv.getInventorySpec().getEnds());
		rowToReturn = rowToReturn.replace("sizeVal", inv.getInventorySpec().getSize());

		// check assigned quantity
		int availableQuantity = inventoryDao.getQuantityByStatus(inv, inv.getInventorySpec().getStatus(), !isConsumed);

		rowToReturn = rowToReturn.replace("availableQuantity", Integer.toString(availableQuantity));

		// Purchse Rate
		rowToReturn = rowToReturn.replace("purchaseRateVal",
				String.valueOf(inventoryDao.getPurchaseRate(inv, !isConsumed)));
		rowToReturn = rowToReturn.replace("projectVal", inv.getInventorySpec().getAssignedProject());
		rowToReturn = rowToReturn.replace("locationVal", inv.getLocation());
		return rowToReturn;
	}

	public String createAccessoryRowTable(AccessoryDetails accessoryDetails, boolean isConsumed) {
		String template = "<tr><form action=\"release\" method=\"POST\" ><td></td>" + "<td>desc1Val</td>"
				+ "<td>desc2Val</td>" + "<td>desc3Val</td>" + "<td>desc4Val</td>" + "<td>desc5Val</td>"
				+ "<td>accessoryNameVal</td>" + "<td></td>" + "<td>availableQuantity</td>"
				/*
				 * + (isConsumed?
				 * "availableQuantity":"<input type=\"text\" class=\"form-control\" name=\"quantity\" value=\"availableQuantity\" ></td>"
				 * )
				 */
				+ "<td>-</td>" + "<td>projectVal</td>" + "<td>locationVal</td>"
				/*
				 * + "<td>" + (isConsumed?
				 * "":"<select class=\"form-control accessoryStatusTo\" name=\"accessoryStatusTo\" >"
				 * + "<option></option>" +
				 * "<option value=\"release\">Release</option>" +
				 * "<option value=\"consumed\">Consumed</option>" + "</select>")
				 * + "</td>"
				 */
				+ "<input type=\"hidden\" name=\"desc1\" value=\"desc1Val\" >"
				+ "<input type=\"hidden\" name=\"desc2\" value=\"desc2Val\" >"
				+ "<input type=\"hidden\" name=\"desc3\" value=\"desc3Val\" >"
				+ "<input type=\"hidden\" name=\"desc4\" value=\"desc4Val\" >"
				+ "<input type=\"hidden\" name=\"desc5\" value=\"desc5Val\" >"
				+ "<input type=\"hidden\" name=\"accessoryName\" value=\"accessoryNameVal\" >"
				+ "<input type=\"hidden\" name=\"project\" value=\"projectVal\" >"
				+ "<input type=\"hidden\" name=\"location\" value=\"locationVal\" >";

		String rowToReturn = template;

		rowToReturn = rowToReturn.replace("desc1Val", accessoryDetails.getDesc1());
		rowToReturn = rowToReturn.replace("desc2Val", accessoryDetails.getDesc2());
		rowToReturn = rowToReturn.replace("desc3Val", accessoryDetails.getDesc3());
		rowToReturn = rowToReturn.replace("desc4Val", accessoryDetails.getDesc4());
		rowToReturn = rowToReturn.replace("desc5Val", accessoryDetails.getDesc5());
		rowToReturn = rowToReturn.replace("accessoryNameVal", accessoryDetails.getAccessoryName());
		rowToReturn = rowToReturn.replace("availableQuantity", accessoryDetails.getQuantity());
		rowToReturn = rowToReturn.replace("projectVal", accessoryDetails.getAssignedProject());
		rowToReturn = rowToReturn.replace("locationVal", accessoryDetails.getLocation());

		return rowToReturn;

	}

	public InventorySpec copyInventorySpec(InventorySpec toCopy) {
		InventorySpec toReturn = new InventorySpec();

		toReturn.setAssignedProject(toCopy.getAssignedProject());
		toReturn.setEnds(toCopy.getEnds());
		toReturn.setGradeOrClass(toCopy.getGradeOrClass());
		toReturn.setInventoryName(toCopy.getInventoryName());
		toReturn.setManifMethod(toCopy.getManifMethod());
		toReturn.setMaterial(toCopy.getMaterial());
		toReturn.setSize(toCopy.getSize());
		toReturn.setStatus(toCopy.getStatus());
		toReturn.setType(toCopy.getType());

		return toReturn;
	}

	public String blankIfNull(String[] input, int index) {
		try {
			return input[index];
		} catch (Exception ex) {
			return "";
		}
	}

	public ArrayList<BOQDetails> getBOQDetailsList(String projectId, String boqName, String[] inventoryName,
			String[] material, String[] type, String[] manifMetod, String[] classOrGrade, String[] ends, String[] size,
			String[] quantity, String[] supplyRate, String[] erectionRate, String[] supplyAmount,
			String[] erectionAmount, String[] baseErectionRate, String[] baseSupplyRate, String sheetDetails) {
		int noOfEntries = inventoryName.length;
		ArrayList<BOQDetails> boqInventoryDetails = new ArrayList<>();

		String[] sheetDetailsArray = sheetDetails.split(",");
		ArrayList<String> sheetNames = new ArrayList<String>();
		ArrayList<Integer> sheetInventoryCount = new ArrayList<Integer>();

		int total = 0;

		for (int i = 0; i < sheetDetailsArray.length; i++) {
			if (i % 2 == 0) {
				sheetNames.add(sheetDetailsArray[i]);
			} else {
				total = total + Integer.valueOf(sheetDetailsArray[i]);

				sheetInventoryCount.add(total);
			}

		}
		String sheetName = "";
		for (int i = 0; i < noOfEntries; i++) {

			for (int j = 0; j < sheetInventoryCount.size(); j++) {
				if (i < sheetInventoryCount.get(j)) {
					sheetName = sheetNames.get(j);
					break;
				}
			}

			boqInventoryDetails.add(new BOQDetails(projectId, boqName, inventoryName[i], material[i], type[i],
					manifMetod != null ? (manifMetod.length > i ? manifMetod[i] : "-") : "-", classOrGrade[i], ends[i],
					size[i], quantity[i], supplyRate.length > 0 ? supplyRate[i] : "",
					erectionRate.length > 0 ? erectionRate[i] : "", supplyAmount.length > 0 ? supplyAmount[i] : "",
					erectionAmount.length > 0 ? erectionAmount[i] : "",
					baseErectionRate.length > 0 ? baseErectionRate[i] : "",
					baseSupplyRate.length > 0 ? baseSupplyRate[i] : "", sheetName));
			System.out.println(boqInventoryDetails.get(i).toString());
		}

		return boqInventoryDetails;
	}

	public String getPONames(String projectId) {
		ArrayList<String> poNames = poDetailsDao.getAssociatedPONames(projectId);

		StringBuffer invoiceNamesString = new StringBuffer();
		for (String poName : poNames) {
			if (!(poName.isEmpty())) {
				invoiceNamesString.append(poName + ",");
			}
		}

		return invoiceNamesString.toString();
	}

	public String getChallanHTML(int noOfChallan, ChallanDetails challanDetails, ArrayList<StringBuffer> lineItemDataList, UserDetails userDetails)
	{
		String challanHTML = "";
		StringBuffer challanHTMLBuffer = new StringBuffer();

		try
		{
			FileInputStream inputStream = new FileInputStream(ResourceUtils.getFile("classpath:extendedChallan"));
			String str = "";
			StringBuffer buf = new StringBuffer();

			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			if (inputStream != null) {
				while ((str = reader.readLine()) != null) {
					buf.append(str + "\n" );
				}
			}

			challanHTML = buf.toString();

			for(int i=1;i<=noOfChallan;i++)
			{
				String stringToadd = challanHTML;

				stringToadd = stringToadd.replace("challanNo",challanDetails.getInventoryRowId()+" - "+(i+1)+"/"+(noOfChallan+1));
				stringToadd = stringToadd.replace("itemList",lineItemDataList.get(i-1).toString().replaceAll("~",""));

				stringToadd = stringToadd.replace("poNo",challanDetails.getPoNo());
				stringToadd = stringToadd.replace("date",LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
				stringToadd = stringToadd.replace("poDate",challanDetails.getPoDate());
				stringToadd = stringToadd.replace("from1",userDetails.getFirstName() + " " + userDetails.getLastName());
				stringToadd = stringToadd.replace("consignee1",challanDetails.getConsignee());
				stringToadd = stringToadd.replace("from2",challanDetails.getReceivedFrom());
				stringToadd = stringToadd.replace("consignee2","");
				stringToadd = stringToadd.replace("from3","");
				stringToadd = stringToadd.replace("consignee3","");
				stringToadd = stringToadd.replace("transportMode",challanDetails.getTransportMode());
				stringToadd = stringToadd.replace("lrNo",challanDetails.getLrNumberDate());
				stringToadd = stringToadd.replace("vheicleNumber",challanDetails.getVheicleNumber());
				stringToadd = stringToadd.replace("gstNo",challanDetails.getGstNo());





				challanHTMLBuffer.append(stringToadd);
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return challanHTMLBuffer.toString();
	}
}
