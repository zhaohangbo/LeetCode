import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class P272_ClosestBinarySearchTreeValueII {

	 public List<Integer> closestKValues(TreeNode root, double target, int k) {
	    	List<Integer> res  = new ArrayList<Integer>();
	    	if(root==null) return res;
	    	
	    	Stack<Integer> stack_pred = new Stack<Integer>();
	    	Stack<Integer> stack_succ = new Stack<Integer>();
	    	inorder(root,target,false,stack_pred);//stack : first in last out, not reverse_traversal
	    	inorder(root,target,true ,stack_succ);//stack : first in last out,  do reverse_traversal
	    	
	    	while(k>0){
	    		if (stack_pred.isEmpty() && stack_succ.isEmpty())
	    			break;
	    		else if(stack_pred.isEmpty() && !stack_succ.isEmpty())
	    			res.add(stack_succ.pop());
	    		else if(stack_succ.isEmpty() && !stack_pred.isEmpty())
	    			res.add(stack_pred.pop());
	    		else {
	    			if (Math.abs(stack_pred.peek()-target)< Math.abs(stack_succ.peek()-target))
	    				res.add(stack_pred.pop());
	    			else
	    				res.add(stack_succ.pop());
	    		}
	    		k--;
	    	}
	    	return res;
	 }
	
	public void inorder(TreeNode root, double target, boolean reverse_traversal, Stack<Integer> stack) {
		if(root==null) return;
		if(!reverse_traversal){
			inorder(root.left, target, reverse_traversal, stack);
			if(root.val <= target)//predecessor, push the smaller nodes, be aware that we need put "=" here to include the closest node
				stack.push(root.val);
			inorder(root.right, target, reverse_traversal, stack);
		}
		else{
			inorder(root.right, target, reverse_traversal, stack);
			if(root.val > target)//successor, push the larger nodes, , be aware that no "=" here, already included
				stack.push(root.val);
			inorder(root.left, target, reverse_traversal, stack);
		}
	}
	
	//Given a non-empty binary search tree and a target value
	//Find k values in the BST that are closest to the target.
	//My solution
	//Idea: get closestNode, use getPredecessor() and get getSuccessor()
    public List<Integer> closestKValues_hangbo(TreeNode root, double target, int k) {
    	List<Integer> res  = new ArrayList<Integer>();
    	if(root==null) return res;
    	
    	TreeNode closestNode = closestNode(root, target);
    	TreeNode p =null;
    	TreeNode s =null;
    	while(k>0){
    		if(res.size()==0){
    			res.add(closestNode.val);
    			p = getPredecessor(root,closestNode);
    			s = getSuccessor  (root,closestNode);
    		}
    		else{
    			if(p==null && s==null){
    				break;
    			}
    			else if(p==null && s!=null){
    				res.add(s.val);
    				s=getSuccessor(root, s);
    			}
    			else if(p!=null && s==null){
    				res.add(p.val);
    				p=getPredecessor(root, p);
    			}
    			else{
	    			if(Math.abs(p.val-target) < Math.abs(s.val-target)){//p is closer
	    				res.add(p.val);
	    				p =getPredecessor(root, p);
	    			}
	    			else{
	    				res.add(s.val);
	    				s =getSuccessor(root, s);
	    			}
    			}
    		}
    		k--;
    	}
    	return res;
    }
    
    public TreeNode closestNode(TreeNode root, double target) {
    	if(root==null) return null;
    	TreeNode child = root.val<target?root.right:root.left;
    	if(child==null) return root;
    	
    	TreeNode closestNodeOfSubTree = closestNode(child,target);
    	return Math.abs(closestNodeOfSubTree.val-target)>Math.abs(root.val-target)?root:closestNodeOfSubTree;
    }
    
	//returns the next smaller node to N.
    public TreeNode getPredecessor(TreeNode root, TreeNode N){
    	if(root==null || N==null) return null;
    	TreeNode predecessor = null;
    	if(N.left!=null){//get Maximum of leftSubTree
    		predecessor = N.left;
    		while(predecessor.right!=null){
    			predecessor = predecessor.right;
    		}
    	}
    	else{//N.left==null, predecessor = [first right parent] or [null for the last node]
    		while(root!=null){
    			if(root.val<N.val){
    				predecessor = root;
    				root = root.right;
    			}
    			else{
    				root = root.left;
    			}
    		}
    	}
    	return predecessor;
    }
    //returns the next larger node to N.
    public TreeNode getSuccessor(TreeNode root, TreeNode N){
    	if(root==null || N==null) return null;
    	TreeNode successor = null;
    	if(N.right!=null){//get Minimum of rightSubTree
    		successor = N.right;
    		while(successor.left!=null){
    			successor = successor.left;
    		}
    	}
    	else{//N.right==null, successor = [first right parent] or [null for last node]
    		while(root!=null){
    			if(root.val>N.val){
    				successor = root;
    				root = root.left;
    			}
    			else{
    				root = root.right;
    			}
    		}
    	}
    	return successor;
    }
    
    //keep track of the path from the root to the current node using a stack.
    class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P272_ClosestBinarySearchTreeValueII ins = new P272_ClosestBinarySearchTreeValueII();
//		[3,2,4,1]
//		2.000000
//		3
		TreeNode root = ins.new TreeNode(3);
		root.left  = ins.new TreeNode(2);
		root.left.left =ins.new TreeNode(1);
		root.right =ins.new TreeNode(4);
		ins.closestKValues(root, 2.000000, 3);
	}

}
