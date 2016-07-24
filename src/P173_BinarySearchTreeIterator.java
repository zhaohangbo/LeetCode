import java.util.Stack;

public class P173_BinarySearchTreeIterator {
	
	public class BSTIterator {
		//Use Stack
		private Stack<TreeNode> stack = new Stack<TreeNode>();
		public BSTIterator(TreeNode root) {
			putAll(root);
		}
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		public int next() {
			TreeNode node =stack.pop();
			if(node.right!=null)
				putAll(node.right);
			return node.val;
		}
		public void putAll(TreeNode node){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
		}
	}
	
//	public class BSTIterator {
//	    private Stack<TreeNode> stack = new Stack<TreeNode>();
//
//	    public BSTIterator(TreeNode root) {
//	        pushAll(root);
//	    }
//
//	    /** @return whether we have a next smallest number */
//	    public boolean hasNext() {
//	        return !stack.isEmpty();
//	    }
//
//	    /** @return the next smallest number */
//	    public int next() {
//	        TreeNode tmpNode = stack.pop();
//	        pushAll(tmpNode.right);
//	        return tmpNode.val;
//	    }
//
//	    private void pushAll(TreeNode node) {
//	        for (; node != null; stack.push(node), node = node.left);
//	    }
//	}
	public class BSTIterator_mine {
		TreeNode root;
		TreeNode cur;
		TreeNode last;
	    public BSTIterator_mine(TreeNode root) {
	        this.root =root;
	        this.cur  =getFirst(this.root);
	        this.last =getLast(this.root);
	    }
	
	    //next() and hasNext() should run in average O(1) time and uses O(h) memory, 
	    //where h is the height of the tree.
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return this.cur == this.last; //O(1) time
	    }
	    public TreeNode getFirst(TreeNode root){
	    	if(root==null) return null;
	    	while(root.left!=null)
	    		root=root.left;
	    	return root;
	    }
	    public TreeNode getLast(TreeNode root){
	    	if(root==null) return null;
	    	while(root.right!=null)
	    		root=root.right;
	    	return root;
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	    	this.cur = inorderSuccessor(this.root,this.cur);
	    	return cur.val;
	    }
	    
	    public TreeNode inorderSuccessor(TreeNode _root, TreeNode p) {
	    	if(_root==null) return null;
	    	TreeNode successor =null;
	    	if(p.right!=null){
	    		successor = p.right;
	    		while(successor.left!=null){
	    			successor = successor.left;
	    		}
	    	}
	    	else{//   p.right==null, two situations
	    		 //1. last node, successor = null
	    		 //2. successor = closest right parent
	    		while(_root!=null){
	    			if(_root.val > p.val){
	    				successor = _root; // successor = closest right parent
	    				_root = _root.left;
	    			}
	    			else{
	    				_root = _root.right;
	    			}
	    		}
	    	}
	    	return successor;
	    }
	}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

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
