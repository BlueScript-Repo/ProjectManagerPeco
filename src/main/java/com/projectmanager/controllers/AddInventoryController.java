package com.projectmanager.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectmanager.dao.MappingsDao;
import com.projectmanager.dao.TaxesDao;
import com.projectmanager.dao.ValvesDao;
import com.projectmanager.entity.Mappings;
import com.projectmanager.entity.TaxesEntity;
import com.projectmanager.entity.Valves;
import com.projectmanager.model.InventoryMappingModel;
import com.projectmanager.model.InventoryValveModel;

@Controller
@EnableWebMvc
public class AddInventoryController {
	
	@Autowired
	MappingsDao mappingsDao;
	
	@Autowired
	ValvesDao valvesDao;
	
	@Autowired
	TaxesDao taxesDao;

	@RequestMapping(value = "/inventoryDetails", method = RequestMethod.GET)
	private ModelAndView inventoryDetails(){
		ModelAndView modelAndView = new ModelAndView();


		StringBuffer mappingDetails = new StringBuffer();


		ArrayList<Mappings> mappingsList = mappingsDao.getAllMappinsData();

		ArrayList<ArrayList<String>> inventoryMaterial = new ArrayList<ArrayList<String>>();

		ArrayList<String> doneInventory = new ArrayList<String>();

		//Populate inventoryMaterial
		for(Mappings mapping : mappingsList)
		{
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.add(mapping.getInventoryName());
			tempList.add(mapping.getMaterial());

			inventoryMaterial.add(tempList);
		}

		ArrayList<String> type = new ArrayList<>();
		ArrayList<String> classOrGrade = new ArrayList<>();
		ArrayList<String> category = new ArrayList<>();

		for(ArrayList<String> invMet : inventoryMaterial)
		{
			String inventory = invMet.get(0);
			String material = invMet.get(1);

			String typeStr = "";
			String classOrGradeStr = "";
			String categoryStr = "";

			for(Mappings mapping : mappingsList)
			{
				if(inventory.equals(mapping.getInventoryName()) && material.equals(mapping.getMaterial()))
				{
					typeStr = typeStr  + mapping.getType() + ",";
					classOrGradeStr = classOrGradeStr  + mapping.getClassOrGrade() + ",";
					categoryStr = categoryStr  + mapping.getCatogory()+ ",";
				}

			}

			type.add(typeStr);
			classOrGrade.add(classOrGradeStr);
			category.add(categoryStr);
		}

		int index = 0;
		int indexToDisplay = 0;
		ArrayList<String> done = new ArrayList<>();

		for(ArrayList<String> invMet : inventoryMaterial)
		{
			if(!(done.contains(invMet.get(0)+invMet.get(1))))
			{
				done.add(invMet.get(0)+invMet.get(1));
				mappingDetails.append("<tr class='lazy' >");
				mappingDetails.append("<td><input type='hidden' class='form-control' value='" + indexToDisplay + "' name='ItemId'  >" + indexToDisplay + "</td>");
				mappingDetails.append("<td><input type='checkbox' class='chkView' ></td>");
				mappingDetails.append("<td><input type='text'  class='form-control' value='" + invMet.get(0) + "' name='inventoryName'  ></td>");
				mappingDetails.append("<td><input type='text'  class='form-control' value='" + invMet.get(1) + "' name='material' ></td>");
				mappingDetails.append("<td><input type='text'  class='form-control' value='" + type.get(index) + "' name='type' disabled ></td>");
				mappingDetails.append("<td><input type='text'  class='form-control' value='" + classOrGrade.get(index) + "' name='classOrGrade' disabled ></td>");
				mappingDetails.append("<td><input type='text'  class='form-control' value='" + category.get(index) + "' name='catogory' disabled ></td>");
				mappingDetails.append("</tr>");

				indexToDisplay++;
			}
			index++;
		}
	
		ArrayList<Valves> valvesData = valvesDao.getValveDetails();
		
		StringBuffer valvesDetails = new StringBuffer();
		int index2 = 1;
		for(Valves valves : valvesData){
			valvesDetails.append("<tr class='lazy'>");
			valvesDetails.append("<td><input type='hidden' class='form-control' value='" + index2 + "' name='ItemId'  >"+ index2 +"</td>");
			valvesDetails.append("<td><input type='checkbox' class='chkView' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getModel() + "' name='model' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getMaterial() + "' name='material' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getEnd() + "' name='end' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getType() + "' name='type' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getPressureRatings() + "' name='pressureRatings' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getMaxInletPressure() + "' name='maxInletPressure' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getOperation() + "' name='operation' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getSeatAndSeals() + "' name='seatAndSeals' ></td>");
			valvesDetails.append("<td><input type='text'  class='form-control' value='" + valves.getSizeRange() + "' name='sizeRange' ></td>");
			valvesDetails.append("</tr>");
			index2++;
		}

		ArrayList<TaxesEntity> taxesData = taxesDao.getTaxesDetails();
		
		StringBuffer taxesDetails = new StringBuffer();
		
		for (TaxesEntity taxes : taxesData){
			taxesDetails.append("<label style='font-weight: bold; padding-right: 20px;'>CGST :</label> <input type='text' id='cGst' name='cGst' value='" + taxes.getcGst()+ "' style='text-align:center; height: 40px;width: 70px;'><br><br>");
			taxesDetails.append("<label style='font-weight: bold; padding-right: 20px;'>SGST :</label> <input type='text' id='sGst' name='sGst' value='" + taxes.getsGst()+ "' style='text-align:center; height: 40px;width: 70px;'><br><br>");
			taxesDetails.append("<label style='font-weight: bold; padding-right: 25px;'>IGST :</label> <input type='text' id='iGst' name='iGst' value='" + taxes.getiGst()+ "' style='text-align:center; height: 40px;width: 70px;'><br><br>");
			
		}
		
		modelAndView.setViewName("InventoryDetails");
		modelAndView.addObject("mappingDetails", mappingDetails.toString());
		modelAndView.addObject("valvesDetails", valvesDetails.toString());
		modelAndView.addObject("taxesDetails", taxesDetails.toString());
		return modelAndView;
	}
	
	public static String[] concatTwoStringArrays(String[] s1, String[] s2){
	    String[] result = new String[s1.length+s2.length];
	    int i;
	    for (i=0; i<s1.length; i++)
	        result[i] = s1[i];
	    int tempIndex =s1.length; 
	    for (i=0; i<s2.length; i++)
	        result[tempIndex+i] = s2[i];
	    return result;
	}//concatTwoStringArrays().
	

	public ArrayList<String> GetUniqueData(boolean IsModified,List<String> ArraryfromDb, List<String> ArrayfromInput)
	{
		ArrayList<String> ResultArray = new ArrayList<String>();
		
		
		
		if(IsModified)
		{
			int LengthOfArraryfromDb = ArraryfromDb.size();
			int LenghtOfArrayfromInput = ArrayfromInput.size();
			
			if(LenghtOfArrayfromInput >LengthOfArraryfromDb || LenghtOfArrayfromInput==LengthOfArraryfromDb)
			{
				
				for(int i=0; i<LenghtOfArrayfromInput;i++)
				{
					String val = ArrayfromInput.get(i);
					for(int j=0; j<LengthOfArraryfromDb;j++)
					{
						if(ArraryfromDb.contains(ArrayfromInput.get(i))|| val.equals("[")||val.equals("]"))
						{
							continue;
						}
						else
						{
							if(!ResultArray.contains(val.trim()))
							{
							
								//String SeprateValue = val.trim()+",";
								ResultArray.add(val.trim());
							}
							
						}
					}
					
				}
			}
			
			else if(LenghtOfArrayfromInput < LengthOfArraryfromDb)
			{
				for(int i=0; i< LengthOfArraryfromDb;i++)
				{
					
					for(int j=0; j<LenghtOfArrayfromInput;j++)
					{
						//String Val1 = ArraryfromDb.get(j);
						String val = ArrayfromInput.get(j);
						if(ArraryfromDb.contains(val)|| val.equals("[")||val.equals("]"))
						{
							continue;
						}
						else
						{
							if(!ResultArray.contains(val.trim()))
							{
							
								//String SeprateValue = val.trim()+",";
								ResultArray.add(val.trim());
							}
							
						}
					}
					
				}
			}
			
		}
		return ResultArray;
	}
	
	
	private ArrayList<String> CheckValid(String PsUserInput, String PsDatabaseValue)
	{
		 
		  List<String> DataFromInput = Arrays.asList(PsUserInput.trim().split(","));
		  List<String> DataFromDb = Arrays.asList(PsDatabaseValue.trim().split(","));
	      boolean LbIsModified= !DataFromInput.equals(DataFromDb);
	      ArrayList<String> NewlyAddedValue = GetUniqueData(LbIsModified,DataFromDb,DataFromInput);	      	     
	      
	      return NewlyAddedValue;
	      
	}
	
	
	//public InventoryMappingModel ModifiedMapping() 
	
	@PostMapping("/updateMappingDetails")
	public @ResponseBody String updateMappingDetails(@RequestBody String dataArrayToSend) throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException{
		
		
		String decodedJson = java.net.URLDecoder.decode(dataArrayToSend, "UTF-8");
	      ObjectMapper jacksonObjectMapper = new ObjectMapper(); // This is Jackson
	      List<InventoryMappingModel> userRolesGUIBeans =  jacksonObjectMapper.readValue(decodedJson, new TypeReference<List<InventoryMappingModel>>(){});
		
	      
	      for(InventoryMappingModel InventoryModel:userRolesGUIBeans)
	      {
	    	  ArrayList<String> ArrayOfType = new ArrayList<String>() ;
	    	  ArrayList<String> ArrayOfClassGrade = new ArrayList<String>();
	    	  ArrayList<String> ArrayOfCatogory = new ArrayList<String>();
	    	  
	    	  String InventoryName = InventoryModel.getInventoryName();
	    	  String Material = InventoryModel.getMaterial();
	    	  String Type = InventoryModel.getType();
	    	  String ClassOrGrade = InventoryModel.getClassOrGrade();
	    	  String Catogory = InventoryModel.getCatogory();
	    	  
	  
	    	  ArrayList<Mappings> ListOfAllMappingDetails = mappingsDao.getMappingDetails(InventoryName,Material);
	    	  
	    	  
	    	  for(Mappings MappData:ListOfAllMappingDetails)
	    	  
	    	  {
	    		  ArrayOfType.add(MappData.getType());
	    		  ArrayOfClassGrade.add(MappData.getClassOrGrade());
	    		  ArrayOfCatogory.add(MappData.getCatogory());
	    	  }
	    	  
	    	  
	    	  ArrayList<String> LbTypeNewValue = CheckValid(Type,ArrayOfType.toString().replace("[","").replace("]", ""));
	    	  ArrayList<String> LbClassOrGrade = CheckValid(ClassOrGrade,ArrayOfClassGrade.toString().replace("[","").replace("]", ""));
	    	  ArrayList<String> LbCatogory = CheckValid(Catogory,ArrayOfCatogory.toString().replace("[","").replace("]", ""));
	    	  
	    	  if(LbTypeNewValue.size()==0 && LbClassOrGrade.size()==0 && LbCatogory.size()==0)
		    	 {
		    		    Mappings mapp = null;			    	    
		    					    		   
		    			 int val = mappingsDao.getMaxId();  	
		    			    	mapp = new Mappings(val+1,InventoryName, Material, "Null","Null", "Null");
		    			    	mappingsDao.updateMapping(mapp);
		    			    				    	  
		    	 }
	    	  else if(LbTypeNewValue.size()>0 && LbClassOrGrade.size()==0 && LbCatogory.size()==0)
	    	 {
	    		    Mappings mapp = null;			    	    
	    			for(String NewValue : LbTypeNewValue){
	    			 int val = mappingsDao.getMaxId();  	
	    			    	mapp = new Mappings(val+1,InventoryName, Material, NewValue,"Null", "Null");
	    			    	mappingsDao.updateMapping(mapp);
	    			}
	    				    	  
	    	 }
	    	 
	    	 else if(LbTypeNewValue.size()==0 && LbClassOrGrade.size()>0 && LbCatogory.size()==0)
	    	 {
	    		    Mappings mapp = null;			    	    
	    			for(String NewValue : LbClassOrGrade){
	    			 int val = mappingsDao.getMaxId();  	
	    			    	mapp = new Mappings(val+1,InventoryName, Material, "Null",NewValue, "Null");
	    			    	mappingsDao.updateMapping(mapp);
	    			}
	    				    	  
	    	 }
	    	  
	    	 else if(LbTypeNewValue.size()==0 && LbClassOrGrade.size()==0 && LbCatogory.size()>0)
	    	 {
	    		    Mappings mapp = null;			    	    
	    			for(String NewValue : LbCatogory){
	    			 int val = mappingsDao.getMaxId();  	
	    			    	mapp = new Mappings(val+1,InventoryName, Material, "Null","Null", NewValue);
	    			    	mappingsDao.updateMapping(mapp);
	    			}
	    				    	  
	    	 }
	    	  
	    	 
	    	 else if(LbTypeNewValue.size()>0 && LbClassOrGrade.size()>0 && LbCatogory.size()==0)
	    	 {
	    		  	    		    
	    			if(LbTypeNewValue.size()>LbClassOrGrade.size() ||LbTypeNewValue.size()==LbClassOrGrade.size())
	    		    {
	    		    	for(String NewType : LbTypeNewValue){
	    		    		Mappings objTempMapping = new Mappings();
	    		    		for(String NewClass : LbClassOrGrade)
	    		    		{	    		    			    		    		
	    		    		objTempMapping.setId(mappingsDao.getMaxId()+1);
	    		    		objTempMapping.setInventoryName(InventoryName);
	    		    		objTempMapping.setMaterial(Material);
	    		    		objTempMapping.setType(NewType);
	    		    		objTempMapping.setClassOrGrade(NewClass);
	    		    		objTempMapping.setCatogory("Null");
	    		    		mappingsDao.updateMapping(objTempMapping);
	    		    	    objTempMapping = new Mappings();
	    		    		}
	    		    		
	    		    	}
	    		    }
	    		    else if(LbClassOrGrade.size()>LbTypeNewValue.size())
	    		    {
	    		    	for(String NewClass  : LbClassOrGrade ){
	    		    		Mappings objTempMapping = new Mappings();
	    		    		for(String NewType  : LbTypeNewValue)
	    		    		{	    		    			    		    		
	    		    		objTempMapping.setId(mappingsDao.getMaxId()+1);
	    		    		objTempMapping.setInventoryName(InventoryName);
	    		    		objTempMapping.setMaterial(Material);
	    		    		objTempMapping.setType(NewType);
	    		    		objTempMapping.setClassOrGrade(NewClass);
	    		    		objTempMapping.setCatogory("Null");
	    		    		mappingsDao.updateMapping(objTempMapping);
	    		    	    objTempMapping = new Mappings();
	    		    		}
	    		    		
	    		    	}
	    		    }	    	  
	    	 }
	    	 
	    	 else if(LbTypeNewValue.size()==0 && LbClassOrGrade.size()>0 && LbCatogory.size()>0)
	    	 {
	    		 
	    		    if(LbClassOrGrade.size()>LbCatogory.size() ||LbClassOrGrade.size()==LbCatogory.size())
	    		    {
	    		    	for(String NewClass : LbClassOrGrade){
	    		    		Mappings objTempMapping = new Mappings();
	    		    		for(String NewCatogory : LbCatogory)
	    		    		{	    		    			    		    		
	    		    		objTempMapping.setId(mappingsDao.getMaxId()+1);
	    		    		objTempMapping.setInventoryName(InventoryName);
	    		    		objTempMapping.setMaterial(Material);
	    		    		objTempMapping.setType("Null");
	    		    		objTempMapping.setClassOrGrade(NewClass);
	    		    		objTempMapping.setCatogory(NewCatogory);
	    		    		mappingsDao.updateMapping(objTempMapping);
	    		    	    objTempMapping = new Mappings();
	    		    		}
	    		    		
	    		    	}
	    		    }
	    		    else if(LbCatogory.size()>LbClassOrGrade.size())
	    		    {
	    		    	for(String NewCatogory  : LbCatogory ){
	    		    		Mappings objTempMapping = new Mappings();
	    		    		for(String NewClass  : LbClassOrGrade)
	    		    		{	    		    			    		    		
	    		    		objTempMapping.setId(mappingsDao.getMaxId()+1);
	    		    		objTempMapping.setInventoryName(InventoryName);
	    		    		objTempMapping.setMaterial(Material);
	    		    		objTempMapping.setType("Null");
	    		    		objTempMapping.setClassOrGrade(NewClass);
	    		    		objTempMapping.setCatogory(NewCatogory);
	    		    		mappingsDao.updateMapping(objTempMapping);
	    		    	    objTempMapping = new Mappings();
	    		    		}
	    		    		
	    		    	}
	    		    }	    	  
	    	 }
	    	 
	    	 else if(LbTypeNewValue.size()>0 && LbClassOrGrade.size()==0 && LbCatogory.size()>0)
	    	 {
	    		  
	    		    if(LbTypeNewValue.size()>LbCatogory.size() ||LbTypeNewValue.size()==LbCatogory.size())
	    		    {
	    		    	for(String NewType : LbTypeNewValue){
	    		    		Mappings objTempMapping = new Mappings();
	    		    		for(String NewCatogory : LbCatogory)
	    		    		{	    		    			    		    		
	    		    		objTempMapping.setId(mappingsDao.getMaxId()+1);
	    		    		objTempMapping.setInventoryName(InventoryName);
	    		    		objTempMapping.setMaterial(Material);
	    		    		objTempMapping.setType(NewType);
	    		    		objTempMapping.setClassOrGrade("Null");
	    		    		objTempMapping.setCatogory(NewCatogory);
	    		    		mappingsDao.updateMapping(objTempMapping);
	    		    	    objTempMapping = new Mappings();
	    		    		}
	    		    		
	    		    	}
	    		    }
	    		    else if(LbCatogory.size()>LbTypeNewValue.size())
	    		    {
	    		    	for(String NewCatogory  : LbCatogory ){
	    		    		Mappings objTempMapping = new Mappings();
	    		    		for(String NewType  : LbTypeNewValue)
	    		    		{	    		    			    		    		
	    		    		objTempMapping.setId(mappingsDao.getMaxId()+1);
	    		    		objTempMapping.setInventoryName(InventoryName);
	    		    		objTempMapping.setMaterial(Material);
	    		    		objTempMapping.setType(NewType);
	    		    		objTempMapping.setClassOrGrade("Null");
	    		    		objTempMapping.setCatogory(NewCatogory);
	    		    		mappingsDao.updateMapping(objTempMapping);
	    		    	    objTempMapping = new Mappings();
	    		    		}
	    		    		
	    		    	}
	    		    }	    	  
	    	 }
	    	 
	    	else if(LbTypeNewValue.size()>0 && LbClassOrGrade.size()>0 && LbCatogory.size()>0)
	    	 {
	    		
	    		for(String NewValue : LbTypeNewValue){
	    			 int val = mappingsDao.getMaxId();  	
	    			    	mappingsDao.updateMapping(new Mappings(val+1,InventoryName, Material, NewValue,"Null", "Null"));
	    			}
	    		for(String NewValue : LbClassOrGrade){
	    			 int val = mappingsDao.getMaxId();  	
	    			    	mappingsDao.updateMapping(new Mappings(val+1,InventoryName, Material, "Null",NewValue, "Null"));
	    			}
	    		for(String NewValue : LbCatogory){
	    			 int val = mappingsDao.getMaxId();  	
	    			    	mappingsDao.updateMapping(new Mappings(val+1,InventoryName, Material, "Null","Null", NewValue));
	    			}
	    		
	    	 }
	    	
	      }
		return decodedJson; 
	  	
	}
	
	
/*	private ArrayList<String> CompareHigherSizeOfList(int PiSize, ArrayList<String> ListOfType,ArrayList<String> ListOfClass, ArrayList<String> ListOfCatogory)
	{
		ArrayList<String> HigherList = new ArrayList<String>();
		
		if(PiSize == 0)
		{
		int LiListSize = ListOfType.size(); 
		int LiClassSize = ListOfClass.size();
		int LiCatogorySize = ListOfCatogory.size();
		
		int max = Math.max(Math.max(LiListSize,LiClassSize),LiCatogorySize);
		
		if(ListOfType.size() == max)
			HigherList=ListOfType;
		else if(ListOfClass.size() == max)
			HigherList=ListOfClass;
		else
			HigherList=ListOfCatogory;		
		}
		
		else
		{
			int LiListSize = ListOfType.size();
			int LiClassSize = ListOfClass.size();
			int LiCatogorySize = ListOfCatogory.size();
			
			if(LiListSize == PiSize)
				LiListSize =0;
			else if(LiClassSize == PiSize)
				LiClassSize= 0;
			else if(LiCatogorySize == PiSize)
				LiCatogorySize= 0;
			
			
			int max = Math.max(Math.max(LiListSize,LiClassSize),LiCatogorySize);
			
			if(ListOfType.size() == max)
				HigherList=ListOfType;
			else if(ListOfClass.size() == max)
				HigherList=ListOfClass;
			else
				HigherList=ListOfCatogory;		
			
		}
		
		return HigherList;
	}
	
*/	
	@RequestMapping(value = "updateValvesDetails", method = RequestMethod.POST)
	public @ResponseBody String updateValvesDetails(@RequestBody String dataArrayToSendContoller) throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException{
		
		
		String decodedJson = java.net.URLDecoder.decode(dataArrayToSendContoller, "UTF-8");
	      ObjectMapper jacksonObjectMapper = new ObjectMapper(); // This is Jackson
	      List<InventoryValveModel> userRolesGUIBeans =  jacksonObjectMapper.readValue(decodedJson, new TypeReference<List<InventoryValveModel>>(){});
	      
	      for(InventoryValveModel inventoryValve :userRolesGUIBeans){
	    	 String itemid =  inventoryValve.getItemId();
	    	 String Model = inventoryValve.getModel();
	    	 String Material = inventoryValve.getMaterial();
	    	 String End = inventoryValve.getEnd();
	    	 String Type = inventoryValve.getType();
	    	 String PressureRatings = inventoryValve.getPressureRatings();
	    	 String SizeRange = inventoryValve.getSizeRange();
	    	 String MaxInletPressure = inventoryValve.getMaxInletPressure();
	    	 String Operation = inventoryValve.getOperation();
	    	 String SeatAndSeals = inventoryValve.getSeatAndSeals();
	    	 int itemInt = Integer.parseInt(itemid);
	    	 Valves valves = new Valves(itemInt, Model, Material, End, Type, PressureRatings, SizeRange, MaxInletPressure, Operation, SeatAndSeals);
				valvesDao.updateValves(valves);
	      }

		System.out.println(userRolesGUIBeans);
		
		return "true";
	}
	

	@RequestMapping(value = "updateTaxesDetails", method = RequestMethod.POST)
	public @ResponseBody String updateTaxesDetails(int cGst, int sGst, int iGst){
	
			//TaxesEntity taxes = new TaxesEntity();
		
			taxesDao.updateTaxes(cGst, sGst, iGst);

		
		return "true";
	}
	
}
