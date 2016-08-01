import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P47_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res =new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	int[] visited= new int[nums.length];
    	backTracking(res, new ArrayList<>(), nums, visited);
    	return res;
    }
    
    public void backTracking(List<List<Integer>> res,List<Integer> tempList,int[] nums, int[] visited){
    	if(tempList.size()==nums.length){
    		res.add(new ArrayList<>(tempList));
    	}
    	else{
	    	for(int i=0;i<nums.length;i++){
	    		//avoid duplicates in same level
	    		//visited[i-1]==0 ensures that
	    		//current duplicate will be added only if previous duplicates are all added
	    		if(i>0 && nums[i]==nums[i-1] && visited[i-1]==0) continue;
	    		if(visited[i]==1) continue;
	    		
	    		//avoid duplicates same to the parent level, don't need to use here.
	    		//if(tempList.contains(nums[i])) continue;
	    		visited[i]=1;
	    		tempList.add(nums[i]);
	    		backTracking(res, tempList, nums, visited);
	    		tempList.remove(tempList.size()-1);
	    		visited[i]=0;
	    	}
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
