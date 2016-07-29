import java.util.Stack;

public class P230_KthSmallestElementInaBST {
//	Question:
//		Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//	Note: 
//		You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//	Follow up:
//		What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
//		How would you optimize the kthSmallest routine?

	
//  Method 1: Binary Search (dfs): most preferable
    public int kthSmallest_1(TreeNode root, int k) {
    	//Be aware that root is (count+1)-th node
    	int count = getCount(root.left);

    	if( k<=count )
    		return kthSmallest_1(root.left,k);
    	else if( k > count+1)
    		return kthSmallest_1(root.right, k-(count+1));
    	// k>count && k<=count+1  ---> k == count+1
    	return root.val;
    }
    public int getCount(TreeNode root){
    	int count = 0;
    	if(root==null) return  0;
    	
    	//root!=null 
    	count = 1;
    	count += getCount(root.left);
    	count += getCount(root.right);
    	return count;
    }
	
//	Method 2: DFS in-order recursive:
    private static int number = 0;
    private static int count = 0;
    public int kthSmallest_2(TreeNode root, int k) {
    	count = k;
    	search (root);
    	return number;
    }
    
    public void search(TreeNode root){
    	if(root.left!=null)
    		search(root.left);
    	
    	count--;
    	if(count == 0){
    		number = root.val;
    		return;
    	}
    	
    	if(root.right!=null)
    		search(root.right);
    }
    
    
    
//  Method 3: DFS in-order iterative:
    public int kthSmallest_3(TreeNode root, int k) {
    	Stack<TreeNode> stack =new Stack<TreeNode>();
    	while(root!=null){
    		stack.push(root);
    		root = root.left;
    	}
    	
    	while(k!=0){
    		TreeNode n = stack.pop();
    		k--;
    		if(k==0)
    			return n.val;
    		TreeNode right = n.right;
    		while(right!=null){
    			stack.push(right);
    			right =right.left;
    		}
    	}
    	return -10086;
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
