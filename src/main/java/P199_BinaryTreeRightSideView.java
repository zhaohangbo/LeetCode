import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> list =new ArrayList<Integer>();
    	if(root==null) return list;
    	
    	Queue<Object[]> q =new LinkedList<Object[]>();
    	q.add(new Object[]{root,1});
    	while(!q.isEmpty()){
    		Object[] objs = q.poll();
    		TreeNode node = (TreeNode) objs[0];
    		int depth = (int)objs[1];
    		if(node.left!=null)
    			q.add(new Object[]{node.left ,depth+1});
    		if(node.right!=null)
    			q.add(new Object[]{node.right,depth+1});
    		
    		Object[] objs_next = q.peek();
    		if(objs_next!=null){
    			int depth_next = (int)objs_next[1];
    			if(depth!=depth_next){
    				list.add(node.val);
    			}
    		}
    		if(objs_next==null){ //no next, the current node is the last node
    		   list.add(node.val);
    		}
    	}
    	return list;
    }
	
    //巧妙在于,先right,再left
    public List<Integer> rightSideView_others(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        //巧妙之处,先right,再left
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
    
    
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
