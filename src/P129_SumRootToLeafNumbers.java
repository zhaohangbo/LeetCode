import java.util.ArrayList;

public class P129_SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
		 return sum(root,0);
	}
	
	public int sum(TreeNode n,int s){
		if(n==null) return 0;
		if(n.left==null && n.right==null) return s*10 + n.val;
		return  sum(n.left, s*10+n.val) + sum(n.right, s*10+n.val);
	}
	
	
	//Mine 
	ArrayList<String> list =new ArrayList<String>();
    public int sumNumbers2(TreeNode root) {
    	if(root==null) return 0;
    	throughPath(root, "");
    	int sum = 0;
    	for(String s : list){
    		sum+=Integer.valueOf(s);
    	}
    	return sum;
    }
	
    public void throughPath(TreeNode root, String s){
    	s = s+ root.val;
    	if(root.left!=null)
    		throughPath(root.left,s);
    	if(root.right!=null)
    		throughPath(root.right,s);
    	if(root.left==null && root.right==null){
    		list.add(s);
    	}
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
