import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class P102_BinaryTreeLevelOrderTraversal {
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list =new ArrayList<List<Integer>>();
    	
    	if(root == null) return list;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	
    	TreeNode treeNode =null;
    	int qSize =0;
    	List<Integer> subList =null;
    	while(q.size()!=0){
    		qSize =q.size();
    		subList =new ArrayList<Integer>();
    		for(int i=0;i<qSize;i++){
        		treeNode = q.poll();
        		subList.add(treeNode.val);
        		
        		if(treeNode.left!=null){
        			q.add(treeNode.left);
        		}
        		if(treeNode.right!=null){
        			q.add(treeNode.right);
        		}   
    		}
    		list.add(subList);
    	}
    	
    	return list;
    }
    
    
    private class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) {
    	    	 val = x;
    	    }
   }

}
