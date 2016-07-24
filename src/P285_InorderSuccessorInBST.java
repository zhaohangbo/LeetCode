
public class P285_InorderSuccessorInBST {
	
	//In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree. 
	//Inorder Successor is NULL for the last node in Inoorder traversal.
	
	//In Binary Search Tree, 
	//Inorder Successor of an input node 
	//can also be defined as the node with the smallest key greater than the key of input node. 
	//So, it is sometimes important to find next node in sorted order.
    
	//Iterative
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	if(root==null) return null;
    	TreeNode successor =null;
    	if(p.right!=null){//p.right!=null, successor = minOfRihtSubTree
    		successor = p.right;
    		while(successor.left!=null){
    			successor = successor.left;
    		}
    	}
    	else{//p.right==null, successor = [first right parent] or [null for last node]
    		while(root!=null){
    			if(root.val > p.val){
    				successor = root;
    				root = root.left;
    			}
    			else{
    				root=root.right;
    			}
    		}
    	}
    	return successor;
    }
    
	//Recursive, LeetCode most voted answer
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null)
          return null;
      
        if (root.val <= p.val) {
          return inorderSuccessor2(root.right, p);
        } 
        else {
          TreeNode left = inorderSuccessor2(root.left, p);
          //if p is the largest in the leftSubTree, then left == null
          //return root, which is the first right parent node of p
          return (left != null) ? left : root;
        }
     }
    
    
    //
    
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
