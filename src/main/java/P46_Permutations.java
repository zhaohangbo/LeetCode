import java.util.ArrayList;
import java.util.List;

public class P46_Permutations {
	
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	//Arrays.sort(nums);
    	backTracking(res, new ArrayList<>(), nums);
    	return res;
    }
	
    public void backTracking(List<List<Integer>> res,List<Integer> tempList,int[] nums){
    	if(tempList.size() == nums.length){
    		res.add(new ArrayList<>(tempList));
    	}
    	else{//tempList.size() != nums.length-1
        	for(int i=0;i<nums.length;i++){
        		if(tempList.contains(nums[i]))
        			continue;
	        	tempList.add(nums[i]);
	        	backTracking(res, tempList, nums);
	        	tempList.remove(tempList.size()-1);
        	}	
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
