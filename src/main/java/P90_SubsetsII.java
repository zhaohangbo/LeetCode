import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90_SubsetsII {
	
	//Given a collection of integers that might contain duplicates, nums, 
	//return all possible subsets.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res =new ArrayList<List<Integer>>();
    	Arrays.sort(nums);// must sort so that we can avoid duplicates easily
    	backTracking(res, new ArrayList<>(), nums, 0);
    	return res;
    }
    
    public void backTracking(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums, int startPos){
    	res.add(new ArrayList<>(tempList));
    	
    	for(int i=startPos;i <nums.length;i++){
    		// avoid duplicates in the same level of solution-space-tree
    		if(i>startPos && nums[i]==nums[i-1]) continue;// avoid duplicates
    		
    		tempList.add(nums[i]);
    		backTracking(res, tempList, nums, i+1);
    		tempList.remove(tempList.size()-1);
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
