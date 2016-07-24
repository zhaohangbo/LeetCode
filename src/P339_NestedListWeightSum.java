import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P339_NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
    	int sum = 0;
    	for(NestedInteger nestedI :nestedList){
    		sum+=getV(nestedI,1);
    	}
    	return  sum;
    }
	
    public int getV(NestedInteger nestedI,int depth){
    	if (nestedI.isInteger()){
    		return nestedI.getInteger()*depth;
    	}
    	else{
    		int sum =0;
    		for(NestedInteger ni: nestedI.getList()){
    			sum += getV(ni,depth+1);
    		}
    		return sum;
    	}
    }
    
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
