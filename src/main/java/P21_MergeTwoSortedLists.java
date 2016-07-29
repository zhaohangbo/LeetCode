
public class P21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
    	if(l1==null) return l2;
        if(l2==null) return l1;
    	ListNode root = new ListNode(0);
    	ListNode prev = root;
    	
    	while(l1!=null && l2 !=null){
    		if(l1.val<=l2.val){
    			prev.next=l1;
    			l1=l1.next;
    		}
    		else{
    			prev.next=l2;
    			l2=l2.next;
    		}
    		prev=prev.next;//prev is always previous of l1 or l2, so it would not change l1 l2 nodes before used.
    	}
    	
    	while(l1!=null){
    		prev.next=l1;
    		l1=l1.next;
    		prev=prev.next;
    	}
    	while(l2!=null){
    		prev.next=l2;
    		l2=l2.next;
    		prev=prev.next;
    	}
    	return root.next;
    }
    
    public ListNode mergeTwoLists_recur(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
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
