import java.util.*;

public class DuplicateVendor{

	public  String[] findMostDuplicates(String[] strs){
		if(strs == null || strs.length == 0){
			return new  String[0];
		}
		//Using a hashset to check for duplicate vendors first
		HashSet<String> items = new HashSet<String>();
		//Store the duplicate items
		HashSet<String> duplicateItems = new HashSet<String>();
		for(String str:strs){
			String[] curCombination = str.split(",");
			String curVendor = curCombination[0];
			String curItem = curCombination[1];
			if(!items.add(curItem)){
				duplicateItems.add(curItem);
			}
		}
		//Right now we have all the duplicate items
		//Using a hashmap to store how many duplicate items a vendor sell
		HashMap<String,Integer> vendorDuplicateMap = new HashMap<String,Integer>();
		for(String str:strs){
			String[] curCombination = str.split(",");
			String curVendor = curCombination[0];
			String curItem = curCombination[1];
			if(duplicateItems.contains(curItem)){
				if(!vendorDuplicateMap.containsKey(curVendor)){
					vendorDuplicateMap.put(curVendor,0);
				}
				vendorDuplicateMap.put(curVendor,vendorDuplicateMap.get(curVendor)+1);
			}
		}
		//Then we need to find the vendors sells most duplicates 

		
		String [] res = new String[0];
		//There is at lest one vendor sells duplicates item
		if(vendorDuplicateMap.size() != 0){
			
			//the maxDuplicate item a vendor sells
			int maxDuplicateItem = -1;
			
			//Using array list to store the vendors sell maxNumber of duplicates Item
			List<String> mostDuplicateVendors = new ArrayList<String>();
			for(Map.Entry<String,Integer> entry: vendorDuplicateMap.entrySet()){
				//if we got a new max, 
				if(entry.getValue() > maxDuplicateItem){
					maxDuplicateItem = entry.getValue();
					mostDuplicateVendors = new ArrayList<String>();
					mostDuplicateVendors.add(entry.getKey());

				}else if(entry.getValue() == maxDuplicateItem){
					mostDuplicateVendors.add(entry.getKey());
				}
			}
			res = new String[mostDuplicateVendors.size()];
			for(int i = 0;i<mostDuplicateVendors.size();i++){
				res[i] = mostDuplicateVendors.get(i);
			}
		}
		return res;
	}

	
}