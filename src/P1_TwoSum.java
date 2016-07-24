import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

	//O(n)
	//Idea: use HashMap to store the left parts
	
	public int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    //go through the array once
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i ;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i );
	    }
	    return result;
	}
	
	//O(n^n)
    public int[] twoSum_mine(int[] nums, int target) {
    	int[] res = new int[2];
    	for(int i=0;i<nums.length;i++){
    			for(int j =i+1 ;j<nums.length;j++){
    				if(nums[i]+nums[j]==target){
    					res[0] = i;
    					res[1] = j;
    				}
    			}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,4,3,0}	;
	}

}
