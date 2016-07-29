
public class P108_ConvertSortedArraytoBinarySearchTree {
	
	//Leetcode 108. Convert Sorted Array to Binary Search Tree
	//Given an array where elements are sorted in "ascending" order
	//Convert it to a height balanced BST.
	
	//Idea to Solve The Problem
	//To ensure it's height balanced BST
	//We can choose the mid as root every time,
	//0~mid as left subtree and mid~length as right subtree
	//Obviously the length of left subtree and right subtree are equal

    public TreeNode sortedArrayToBST(int[] nums) {
    	return getTree(nums, 0 , nums.length-1);
    }
	
	public TreeNode getTree(int[] nums, int low, int high){
		if(low>high) return null;
		int mid = (low + high)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = getTree( nums,low, mid -1);
		root.right= getTree(nums, mid+1, high);
		return root;
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
