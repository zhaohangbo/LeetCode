
public class P147_InsertionSortList {

	//Key 1 : know how insertion sort works
	//Key 2 : realize the difference between arrray and list.
    public static ListNode insertionSortList(ListNode head) {
        if(head==null)
        	return null;

    	ListNode unSorted_p =head;
    	ListNode sorted_p   =head;
    	while(unSorted_p!=null){
    		
    		
    		sorted_p =head;
    		while(sorted_p!=unSorted_p){
    			if(unSorted_p.val<sorted_p.val){
    				int temp = unSorted_p.val;
    				unSorted_p.val =sorted_p.val;
    				sorted_p.val  =temp;
    			}
    			sorted_p =sorted_p.next;
    		}
    		
    		
    		unSorted_p=unSorted_p.next;
    	}
    	
    	return head;
    }
	
    
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
    
    public static void print(ListNode node){
    	while(node!=null){
    		System.out.println(node.val);
    		node =node.next;
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 =new ListNode(3);
		ListNode n2 =new ListNode(4);
		ListNode n3 =new ListNode(1);
		n1.next=n2;n2.next=n3;
		
		
		insertionSortList(n1);
		print(n1);

	}

}
