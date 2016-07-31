import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	//sort first to skip duplicates in solution-space-tree easily.
    	Arrays.sort(candidates); 
    	backTracking(res, new ArrayList<Integer>(), candidates, target, 0);
    	return res;
    }
    
    public void backTracking(List<List<Integer>> res, List<Integer> tempList,int[] candidates,int curLeft, int startPos){
    	if(curLeft < 0){
    		return;
    	}
    	else if(curLeft==0){
    		res.add(new ArrayList<Integer>(tempList));
    	}
    	else{
    		for(int i =startPos; i<candidates.length;i++){
    			//避免在搜索解空间树中的同一层，出现重复的状态。
    			if(i > startPos && candidates[i] == candidates[i-1]) continue; // skip duplicates in search-solution-space tree
    			
    			tempList.add(candidates[i]);
    			backTracking(res, tempList, candidates, curLeft-candidates[i] , i+1);//i+1 because each number in C can only be used once
    			tempList.remove(tempList.size()-1);
    		}
    	}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
