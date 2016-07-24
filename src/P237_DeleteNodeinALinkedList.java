
public class P237_DeleteNodeinALinkedList {
    public void deleteNode(ListNode node) {
    	if (node == null) return ;
    	node.val=node.next.val;
    	node.next=node.next.next;
    }
	
    
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
