
public class P109_ConvertSortedListtoBinarySearchTree {

//	Given a singly linked list where elements are sorted in ascending order, 
//	convert it to a height balanced BST.
	
	
	
	//My O(nlgn) solution
    public TreeNode sortedListToBST(ListNode head) {
    	if(head==null)      return null;
    	//only 1 ListNode
    	if(head.next==null) {
    	   TreeNode res =new TreeNode(head.val);
    	   return res;
    	}
    	ListNode pre_slower=head;
    	ListNode slower=head;
    	ListNode faster=head;
    	// 2 ListNode nodes,3 ListNode nodes?
    	while(faster !=null && faster.next!=null){
    		faster = faster.next.next;
    		pre_slower = slower;
    		slower = slower.next;
    	}
    	TreeNode res = new TreeNode(slower.val);
    	
    	pre_slower.next=null;//cut the List form the middle into 2 subLists
    	res.left  = sortedListToBST(head);
    	res.right = sortedListToBST(slower.next);
    	return res;
    }
	
	
    //O(n) solution
    private ListNode node;

    public TreeNode sortedListToBST_On(ListNode head) {
        if(head == null){
            return null;
        }
        int size = 0;
        ListNode runner = head;
        node = head;

        while(runner != null){
            runner = runner.next;
            size ++;
        }
        return inorderHelper(0, size - 1);
    }
    //Inorder
    public TreeNode inorderHelper(int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode treenode = new TreeNode(node.val);// Inorder
        
        treenode.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;

        return treenode;
    }
    
    
    
	 //Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	
	 //Definition for a binary tree node.
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
