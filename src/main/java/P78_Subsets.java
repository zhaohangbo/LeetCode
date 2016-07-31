import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P78_Subsets {

	//Example nums = [1,2,3], a solution is:
	//000  
	//001
	//010
	//011
	//100
	//101
	//110
	//111
	//Amazing solution, it directly captures the intrinsic connection between power set and binary numbers.
	//When forming a subset, for each element, only 2 possiblities, either it is in the subset or not in the subset, 
	//hence we have total number of possible subsets = 2^n.
	//thinking each element as a bit, it's either on or off when forming the ith subset, and that's the solution!
	
	//Given a set of distinct integers, nums, return all possible subsets.
	//Use bit manipulation
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res =new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	
    	int numOfBits 	 =  nums.length;
    	int numOfSubsets = (int)Math.pow(2, numOfBits);
    	for(int i=0 ;i< numOfSubsets;i++){
    		List<Integer> subSet =new ArrayList<Integer>();
    		for(int j =0;j<numOfBits;j++){
    			//i is the numOfSubsets like 101, 
    			//1<<j is to set the j-th bit to 1,
    			//i & (1<<j) is to judge if the j-th of i is 1 or not.
    			if((i& (1<<j)) !=0){
    				subSet.add(nums[j]);
    			}
    		}
    		res.add(subSet);
    	}
    	return  res;  
    }
    
    //Given a set of distinct integers, nums, return all possible subsets.
	//Use back tracking
    public List<List<Integer>> subsets_backtracking(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	//Arrays.sort(nums);
    	backTracking(res,new ArrayList<>(),nums,0);
    	return res;
    }
    
    public void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] nums, int startPos){
    	res.add(new ArrayList<>(tempList));
    	for(int i=startPos;i<nums.length;i++){
    		tempList.add(nums[i]);
    		backTracking(res, tempList, nums, i+1);
    		tempList.remove(tempList.size()-1);
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
