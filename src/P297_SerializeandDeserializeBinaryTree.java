import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P297_SerializeandDeserializeBinaryTree {
	 //Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	 public class Codec {

	     // Encodes a tree to a single string.
	     public String serialize(TreeNode root) {
	    	 StringBuilder sb = new StringBuilder();
	    	 buildString(root,sb);
	    	 return sb.toString();
	     }

	     public void buildString(TreeNode node, StringBuilder sb){
	    	 if(node==null){
	    		 sb.append("null").append(",");
	    	 }
	    	 else{
	    		 sb.append(node.val).append(",");
	    		 buildString(node.left,sb);
	    		 buildString(node.right,sb);
	    	 }
	     }
	     
	     // Decodes your encoded data to tree.
	     public TreeNode deserialize(String data) {
	    	 String[] str_arr= data.split(",");
	    	 Deque<String> nodes = new LinkedList<>();
	    	 nodes.addAll(Arrays.asList(str_arr));
	    	 return buildSubTree(nodes);
	     }
	     
	     public TreeNode buildSubTree(Deque<String> nodes){
	    	 String val = nodes.remove();
	    	 if(val.equals("null")){
	    		 return null;
	    	 }
	    	 else{
	    		 TreeNode node =new TreeNode(Integer.valueOf(val));
	    		 node.left= buildSubTree(nodes);
	    		 node.right= buildSubTree(nodes);
	    		 return node;
	    	 }
	     }
	 } 

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	
	 public static void main(String[] args){
		 Queue<TreeNode> q = new LinkedList<TreeNode>();
		 q.add(null);
		 System.out.println(q.size());
	 }
}
