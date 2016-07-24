
public class P160_IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA==null || headB==null) return null;
    	
    	int lenA= getLength(headA);
    	int lenB= getLength(headB);
    	
    	if(lenA>=lenB)
    		headA = moveNsteps(headA,lenA-lenB);
    	else
    		headB = moveNsteps(headB,lenB-lenA);
    	
    	while(headA!=null&&headB!=null){
    		if(headA==headB)
    			return headA;
    		headA=headA.next;
    		headB=headB.next;
    	}
    	return null;
    }
	
    
    public int getLength(ListNode head){
    	int len =0;
    	while(head!=null){
    		len++;
    		head=head.next;
    	}
    	return len;
    }
    
    public ListNode moveNsteps(ListNode node ,int n){
    	while(n>0){
    		node =node.next;
    		n--;
    	}
    	return node;
    }
    
    public class ListNode {
    	      int val;
    	     ListNode next;
    	     ListNode(int x) {
    	         val = x;
    	         next = null;
    	     }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
