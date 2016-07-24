
public class P148_SortList {
//	Sort a linked list in O(n log n) time using constant space complexity.
    public ListNode sortList(ListNode head) {
    	
    	if(head == null || head.next==null) 
    		return head;
    	
    	// step 1. cut the list to two halves
    	ListNode prev =null;
    	ListNode slow =head;
    	ListNode fast =head;
    	
    	while(fast !=null && fast.next!=null){
    		prev=slow;
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	
    	//Cut
    	if(prev!=null)
    		prev.next=null;
    	
    	// step 2. sort each half
    	ListNode l1 = sortList(head);
    	ListNode l2 = sortList(slow);
    	
    	// step 3. merge l1 and l2
        return merge(l1,l2);
    }
    
    public ListNode merge(ListNode l1 ,ListNode l2){
    	ListNode super_head = new ListNode(-999);
    	ListNode p =super_head;
    	
//    	while(l1.next!=null && l2.next!=null){//Be careful,it's not || but && here~
//    	while(l1.next!=null && l2.next!=null){//Be careful,it's not l1.next ,l2.next
    	while(l1!=null && l2!=null){
    		if(l1.val<l2.val){
    			p.next=l1;
    			l1 = l1.next;
    			p  = p.next;
    		}
    		else{
    			p.next=l2;
    			l2=l2.next;
    			p =p.next;
    		}
    	}
    	
    	if(l2!=null)
    		p.next=l2;
    	if(l1!=null)
    		p.next=l1;

    	return super_head.next;
    }
    
    public class ListNode {
    	     int val;
    	     ListNode next;
    	     ListNode(int x) {
    	    	 val = x; 
    	    }
    	 }
}
