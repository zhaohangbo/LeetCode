import java.util.HashMap;

public class P217_ContainsDuplicate {

    public boolean containsDuplicate (int[] nums) {
    	if(nums.length==0) return false;
    	HashMap<Integer,Integer> map_distinct =new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(map_distinct.containsKey(nums[i])){
    		    return true;
    		}
    		map_distinct.put(nums[i],1);
    	}
    	return false;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
