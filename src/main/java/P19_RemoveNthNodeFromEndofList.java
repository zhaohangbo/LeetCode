
public class P19_RemoveNthNodeFromEndofList {

	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode pre_p=head;
    	
    	ListNode fast=head;
    	
    	for(int i=0;i<n;i++)
    		fast=fast.next;
    	
    	if(fast==null)
    		return head.next;
    	
    	while(fast.next!=null){
    		pre_p=pre_p.next;
    		fast=fast.next;
    	}
    	pre_p.next=pre_p.next.next;
    	return head;
    }
	
    public class ListNode {
    	     int val;
    	     ListNode next;
    	     ListNode(int x) { val = x; }
    	 }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
