import java.util.ArrayList;
import java.util.List;

public class P39_CombinationSum {

	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	//Arrays.sort(candidates); //don't need sort here
    	backTracking(res,new ArrayList<Integer>(),candidates, target ,0);
    	return res;
    }
    public void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int curLeft, int startPos){
    	if(curLeft < 0){
    		return;
    	}
    	else if(curLeft==0) {
    		res.add(new ArrayList<Integer>(tempList));
    	}
    	else{//curLeft > 0
    		for(int i=startPos; i<candidates.length;i++){
    			tempList.add(candidates[i]);
    			backTracking(res,tempList,candidates,curLeft - candidates[i], i); // not i + 1 because we can reuse same elements
    			tempList.remove(tempList.size()-1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
