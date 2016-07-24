import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P78_Subsets {

	//If nums = [1,2,3], a solution is:
	//000  
	//001
	//010
	//011
	//100
	//101
	//110
	//111
	//Amazing solution, it directly captures the intrinsic connection between power set and binary numbers.
	//When forming a subset, for each element, only 2 possiblities, either it is in the subset or not in the subset, hence we have total number of possible subsets = 2^n.
	//thinking each element as a bit, it's either on or off when forming the ith subset, and that's the solution!
	
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res =new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	
    	int numOfBits 	 =  nums.length;
    	int numOfSubsets = (int)Math.pow(2, numOfBits);
    	for(int i=0 ;i< numOfSubsets;i++){
    		List<Integer> subSet =new ArrayList<Integer>();
    		//be careful on the order, should from the most left to most right
    		//for(int j=numOfBits-1;j>=0;j--){
    		//	int k = i>>j;
    		//	if((k&1) ==1){
    		//		subSet.add(nums[numOfBits-1-j]);
    		//	}
    		//}
    		for(int j =0;j<numOfBits;j++){
    			if((i& (1<<j)) !=0){
    				subSet.add(nums[j]);
    			}
    		}
    		res.add(subSet);
    	}
    	return  res;  
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
