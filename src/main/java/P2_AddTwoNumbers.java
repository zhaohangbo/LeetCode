
public class P2_AddTwoNumbers {
	
	//most voted answer
    public ListNode addTwoNumbers_(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
	
	//Mine
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1==null&&l2==null) return null;
    	if(l1==null) return l2;
    	if(l2==null) return l1;
    	
    	ListNode head =l1;

    	int carry =0;
    	int sum   =0;
    	ListNode prel1 =l1;
    	
    	while(l1!=null && l2!=null){
    		sum	  = carry + l1.val+l2.val;
    		l1.val= sum%10;
    		carry = sum/10;
    		
    		prel1=l1;  	 
    		l1=l1.next; 
    		l2=l2.next;
    	}
    	if(l1==null && l2==null && carry==1){
    		prel1.next = new ListNode(carry);
    		return head;
    	}
    	
    	if(l1==null && l2!=null){
    		l1 = prel1;//one step back
    		while(l2!=null){
    			sum	  = carry +l2.val;
    			l2.val= sum%10;
    			carry = sum/10;
    			
    			l1.next=l2;
    			l1=l1.next;
    			
    			prel1  =l2;//Should follow the tail, so it should follow l2 not l1 any more 
    			l2=l2.next;
    		}
    	}
    	else{
    		//because I use 'head' to record l1, so don't need prel2;
    		//l2 = prel2; //no need to one step back;
    		while(l1!=null){
    			sum  = carry + l1.val;
    			l1.val= sum%10;
    			carry = sum/10;
    			//l2.next=l1;//because I use 'head' to record l1
    			//l2=l2.next;//because I use 'head' to record l1
    			
    			prel1 = l1;
    			l1=l1.next;    
    		}
    	}
    	if(carry==1){
    		prel1.next = new ListNode(carry);
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
		P2_AddTwoNumbers instance  =new P2_AddTwoNumbers();
		ListNode l1 =instance.new ListNode(1);
		ListNode l2	=instance.new ListNode(9);l2.next=instance.new ListNode(9);
		instance.addTwoNumbers(l1, l2);
	}

}
