import java.util.HashMap;
import java.util.HashSet;

public class P219_ContainsDuplicateII {
	
	//HashSet
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(nums.length==0 || nums.length==1) return false;
    	HashSet<Integer > set =new HashSet<Integer>();
    	//Ides is :
    	//in range i~~i+k, if there're duplicate numbers, return true;
    	for(int i=0;i<nums.length;i++){
    		if(i>k)
    			set.remove(nums[i-1 -k]);
    		if(!set.add(nums[i])) 
    			return true;
    	}
    	return false;
    }
    
    
    //HashMap
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
