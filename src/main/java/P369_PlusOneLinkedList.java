
public class P369_PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
    	head= dfs(head);
    	if(carry==1){
    		ListNode newHead = new ListNode(1);
    		newHead.next=head;
    		return newHead;
    	}
    	else
    		return head;
    }
    int carry=0;
    public ListNode dfs(ListNode head) {
        if(head==null) return null;
    	if(head.next==null){
    		int val = head.val+1;
    		head.val =(val+carry)%10;
    		carry = (val+carry)/10;
    	}
    	else{
    		dfs(head.next);
    		int val = head.val;
    		head.val =(val+carry)%10;
    		carry = (val+carry)/10;
    	}
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
