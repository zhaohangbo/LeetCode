import java.util.ArrayList;
import java.util.List;

public class P94_BinaryTreeInorderTraversal {

	 public List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> list_result =new ArrayList<Integer>();
		 //First Left Child
		 if(root!=null && root.left!=null){
			 List<Integer> list = inorderTraversal(root.left);
			 for(int i=0;i<list.size();i++){
				 list_result.add(list.get(i));
			 }
		 }
		 //Second parent node
		 if(root!=null){
			 list_result.add(root.val);
		 }
		 //Third Right Child
		 if(root!=null && root.right!=null){
			 List<Integer> list = inorderTraversal(root.right);
			 for(int i=0;i<list.size();i++){
				 list_result.add(list.get(i));
			 }			 
		 }
		 return list_result;
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
