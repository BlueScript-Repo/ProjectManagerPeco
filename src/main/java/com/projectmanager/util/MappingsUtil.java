package com.projectmanager.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectmanager.dao.MappingsDao;
import com.projectmanager.entity.Mappings;

@ManagedBean
public class MappingsUtil {
	@Autowired
	MappingsDao mappingsDao;

	private HashMap<Integer, ArrayList<ArrayList<String>>> indexSetMap = new HashMap<>();
	private HashMap<String, Integer> invNameIndexMap = new HashMap<>();

	private ArrayList<String> flangeClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> flangeMaterialList = new ArrayList<String>();
	private ArrayList<String> flangeTypeList = new ArrayList<String>();
	private ArrayList<String> flangeCategoryList = new ArrayList<String>();

	private ArrayList<String> elbowClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> elbowMaterialList = new ArrayList<String>();
	private ArrayList<String> elbowTypeList = new ArrayList<String>();
	private ArrayList<String> elbowCategoryList = new ArrayList<String>();

	private ArrayList<String> barrelNippleClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> barrelNippleMaterialList = new ArrayList<String>();
	private ArrayList<String> barrelNippleTypeList = new ArrayList<String>();
	private ArrayList<String> barrelNippleCategoryList = new ArrayList<String>();

	private ArrayList<String> socketClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> socketMaterialList = new ArrayList<String>();
	private ArrayList<String> socketTypeList = new ArrayList<String>();
	private ArrayList<String> socketCategoryList = new ArrayList<String>();

	private ArrayList<String> reducerClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> reducerMaterialList = new ArrayList<String>();
	private ArrayList<String> reducerTypeList = new ArrayList<String>();
	private ArrayList<String> reducerCategoryList = new ArrayList<String>();

	private ArrayList<String> couplingClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> couplingMaterialList = new ArrayList<String>();
	private ArrayList<String> couplingTypeList = new ArrayList<String>();
	private ArrayList<String> couplingCategoryList = new ArrayList<String>();

	private ArrayList<String> teeClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> teeMaterialList = new ArrayList<String>();
	private ArrayList<String> teeTypeList = new ArrayList<String>();
	private ArrayList<String> teeCategoryList = new ArrayList<String>();

	private ArrayList<String> gasketsClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> gasketsMaterialList = new ArrayList<String>();
	private ArrayList<String> gasketsTypeList = new ArrayList<String>();
	private ArrayList<String> gasketsCategoryList = new ArrayList<String>();

	private ArrayList<String> boltClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> boltMaterialList = new ArrayList<String>();
	private ArrayList<String> boltTypeList = new ArrayList<String>();
	private ArrayList<String> boltCategoryList = new ArrayList<String>();

	private ArrayList<String> washerClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> washerMaterialList = new ArrayList<String>();
	private ArrayList<String> washerTypeList = new ArrayList<String>();
	private ArrayList<String> washerCategoryList = new ArrayList<String>();

	private ArrayList<String> supportClassOrGradeList = new ArrayList<String>();
	private ArrayList<String> supportMaterialList = new ArrayList<String>();
	private ArrayList<String> supportTypeList = new ArrayList<String>();
	private ArrayList<String> supportCategoryList = new ArrayList<String>();

	private ArrayList<ArrayList<String>> flangeDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> elbowDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> barrelNippleDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> socketDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> reducerDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> couplingDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> teeDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> gasketsDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> boltDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> washerDetails = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> supportDetails = new ArrayList<ArrayList<String>>();

	public ArrayList<String> getInventoryNames() {
		ArrayList<String> invNameList = null;

		if (invNameIndexMap.size() == 0) {
			// update the map to fetch details from DB
			fetchAndPopulateMaps();
		}

		invNameList = (ArrayList<String>) invNameIndexMap.keySet();

		return invNameList;
	}

	public ArrayList<String> getDetails(String inventoryName, String detailsRequired) {
		
		if (invNameIndexMap.size() == 0) {
			// update the map to fetch details from DB
			fetchAndPopulateMaps();
		}
		
		ArrayList<ArrayList<String>> details = indexSetMap.get(invNameIndexMap.get(inventoryName));

		if (detailsRequired.equals("category")) {
			return removeDuplicates(details.get(0));
		} else if (detailsRequired.equals("classOrGrade")) {
			return removeDuplicates(details.get(1));
		} else if (detailsRequired.equals("material")) {
			return removeDuplicates(details.get(2));
		} else if (detailsRequired.equals("type")) {
			return removeDuplicates(details.get(3));
		} else {
			return null;
		}
	}

	public static ArrayList<String> removeDuplicates(ArrayList<String> list) 
    { 
  
        // Create a new ArrayList 
        ArrayList<String> newList = new ArrayList<String>(); 
  
        // Traverse through the first list 
        for (String element : list) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!(element.isEmpty())&&!newList.contains(element)) { 
  
                newList.add(element); 
            } 
        } 
  
        // return the new list 
        return newList; 
    } 
	
	private void fetchAndPopulateMaps() {
		ArrayList<Mappings> listOfMappings = new ArrayList<Mappings>();

		listOfMappings = mappingsDao.getAllMappinsData();

		for (int i = 0; i < listOfMappings.size(); i++) {
			if (!(invNameIndexMap.containsKey(listOfMappings.get(i).getInventoryName()))) {
				invNameIndexMap.put(listOfMappings.get(i).getInventoryName(), i + 1);
			}

			if (listOfMappings.get(i).getInventoryName().contains("Flange")) {
				flangeCategoryList.add(listOfMappings.get(i).getCatogory());
				flangeClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				flangeMaterialList.add(listOfMappings.get(i).getMaterial());
				flangeTypeList.add(listOfMappings.get(i).getType());
				flangeDetails.add(flangeCategoryList);
				flangeDetails.add(flangeClassOrGradeList);
				flangeDetails.add(flangeMaterialList);
				flangeDetails.add(flangeTypeList);
			} else if (listOfMappings.get(i).getInventoryName().contains("Elbow")) {
				elbowCategoryList.add(listOfMappings.get(i).getCatogory());
				elbowClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				elbowMaterialList.add(listOfMappings.get(i).getMaterial());
				elbowTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Barrel Nipple")) {
				barrelNippleCategoryList.add(listOfMappings.get(i).getCatogory());
				barrelNippleClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				barrelNippleMaterialList.add(listOfMappings.get(i).getMaterial());
				barrelNippleTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Socket")) {
				socketCategoryList.add(listOfMappings.get(i).getCatogory());
				socketClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				socketMaterialList.add(listOfMappings.get(i).getMaterial());
				socketTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Reducer")) {
				reducerCategoryList.add(listOfMappings.get(i).getCatogory());
				reducerClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				reducerMaterialList.add(listOfMappings.get(i).getMaterial());
				reducerTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Coupling")) {
				couplingCategoryList.add(listOfMappings.get(i).getCatogory());
				couplingClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				couplingMaterialList.add(listOfMappings.get(i).getMaterial());
				couplingTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Tee")) {
				teeCategoryList.add(listOfMappings.get(i).getCatogory());
				teeClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				teeMaterialList.add(listOfMappings.get(i).getMaterial());
				teeTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Gaskets")) {
				gasketsCategoryList.add(listOfMappings.get(i).getCatogory());
				gasketsClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				gasketsMaterialList.add(listOfMappings.get(i).getMaterial());
				gasketsTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Bolt")) {
				boltCategoryList.add(listOfMappings.get(i).getCatogory());
				boltClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				boltMaterialList.add(listOfMappings.get(i).getMaterial());
				boltTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Washer")) {
				washerCategoryList.add(listOfMappings.get(i).getCatogory());
				washerClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				washerMaterialList.add(listOfMappings.get(i).getMaterial());
				washerTypeList.add(listOfMappings.get(i).getType());
			} else if (listOfMappings.get(i).getInventoryName().contains("Support")) {
				supportCategoryList.add(listOfMappings.get(i).getCatogory());
				supportClassOrGradeList.add(listOfMappings.get(i).getClassOrGrade());
				supportMaterialList.add(listOfMappings.get(i).getMaterial());
				supportTypeList.add(listOfMappings.get(i).getType());
			}
		}

		Iterator iterator = invNameIndexMap.keySet().iterator();

		while (iterator.hasNext()) {

			String key = (String) iterator.next();
			if (key.contains("Flange")) {
				flangeDetails.add(flangeCategoryList);
				flangeDetails.add(flangeClassOrGradeList);
				flangeDetails.add(flangeMaterialList);
				flangeDetails.add(flangeTypeList);

				indexSetMap.put(invNameIndexMap.get(key), flangeDetails);
			} else if (key.contains("Elbow")) {
				elbowDetails.add(elbowCategoryList);
				elbowDetails.add(elbowClassOrGradeList);
				elbowDetails.add(elbowMaterialList);
				elbowDetails.add(elbowTypeList);
				indexSetMap.put(invNameIndexMap.get(key), elbowDetails);
			} else if (key.contains("Barrel Nipple")) {
				barrelNippleDetails.add(barrelNippleCategoryList);
				barrelNippleDetails.add(barrelNippleClassOrGradeList);
				barrelNippleDetails.add(barrelNippleMaterialList);
				barrelNippleDetails.add(barrelNippleTypeList);
				indexSetMap.put(invNameIndexMap.get(key), barrelNippleDetails);
			} else if (key.contains("Socket")) {
				socketDetails.add(socketCategoryList);
				socketDetails.add(socketClassOrGradeList);
				socketDetails.add(socketMaterialList);
				socketDetails.add(socketTypeList);
				indexSetMap.put(invNameIndexMap.get(key), socketDetails);
			} else if (key.contains("Reducer")) {
				reducerDetails.add(reducerCategoryList);
				reducerDetails.add(reducerClassOrGradeList);
				reducerDetails.add(reducerMaterialList);
				reducerDetails.add(reducerTypeList);
				indexSetMap.put(invNameIndexMap.get(key), reducerDetails);
			} else if (key.contains("Coupling")) {
				couplingDetails.add(couplingCategoryList);
				couplingDetails.add(couplingClassOrGradeList);
				couplingDetails.add(couplingMaterialList);
				couplingDetails.add(couplingTypeList);
				indexSetMap.put(invNameIndexMap.get(key), couplingDetails);
			} else if (key.contains("Tee")) {
				teeDetails.add(teeCategoryList);
				teeDetails.add(teeClassOrGradeList);
				teeDetails.add(teeMaterialList);
				teeDetails.add(teeTypeList);
				indexSetMap.put(invNameIndexMap.get(key), teeDetails);
			} else if (key.contains("Gaskets")) {
				gasketsDetails.add(gasketsCategoryList);
				gasketsDetails.add(gasketsClassOrGradeList);
				gasketsDetails.add(gasketsMaterialList);
				gasketsDetails.add(gasketsTypeList);
				indexSetMap.put(invNameIndexMap.get(key), gasketsDetails);
			} else if (key.contains("Bolt")) {
				boltDetails.add(boltCategoryList);
				boltDetails.add(boltClassOrGradeList);
				boltDetails.add(boltMaterialList);
				boltDetails.add(boltTypeList);
				indexSetMap.put(invNameIndexMap.get(key), boltDetails);
			} else if (key.contains("Washer")) {
				washerDetails.add(washerCategoryList);
				washerDetails.add(washerClassOrGradeList);
				washerDetails.add(washerMaterialList);
				washerDetails.add(washerTypeList);
				indexSetMap.put(invNameIndexMap.get(key), washerDetails);
			} else if (key.contains("Support")) {
				supportDetails.add(supportCategoryList);
				supportDetails.add(supportClassOrGradeList);
				supportDetails.add(supportMaterialList);
				supportDetails.add(supportTypeList);
				indexSetMap.put(invNameIndexMap.get(key), supportDetails);
			}
		}
	}
}
