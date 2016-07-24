import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class P229_MajorityElementII {
	
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list =new ArrayList<Integer>();
        
        HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
        	if(map.containsKey(nums[i])){
        		map.put(nums[i], map.get(nums[i])+1);
        	}
        	else{
        		map.put(nums[i], 1);
        	}
        }
        
        Iterator<Integer> keys = map.keySet().iterator();
        while(keys.hasNext()){
        	Integer key = keys.next();
        	if(map.get(key)>nums.length/3){
        		list.add(key);
        	}
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
