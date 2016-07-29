import java.util.ArrayList;
import java.util.List;

public class P144_BinaryTreePreorderTraversal {
	

    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> list_horizontal_level =new ArrayList<Integer>();
    	if(root != null){
    		list_horizontal_level.add(root.val);
    		if(root.left!=null){
    			List<Integer> list  = preorderTraversal2(root.left);
    			for(int i=0;i<list.size();i++)
    				list_horizontal_level.add(list.get(i));
    		}
    		if(root.right!=null){
    			List<Integer> list = preorderTraversal2(root.right);
    			for(int i=0;i<list.size();i++)
    				list_horizontal_level.add(list.get(i));
    		}
    	}
    	return list_horizontal_level;
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
