import java.util.ArrayList;
import java.util.List;

public class P23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
    	return mergeKListsHelper(lists, 0, lists.length-1);//start, end are indexes
    }
    
    public ListNode mergeKListsHelper(ListNode[] lists,int start,int end) {
    	if(end == start){
    		return lists[start];
    	}
    	if(end ==start +1){
	    	ListNode list1 = lists[start];
	    	ListNode list2 = lists[end];
	    	return   mergeTwoLists(list1, list2);
    	}
    	else if(end >start+1){
	    	ListNode list1 = mergeKListsHelper(lists, start, (start+end)/2);
	    	ListNode list2 = mergeKListsHelper(lists, (start+end)/2+1, end);
	    	return   mergeTwoLists(list1, list2);
    	}
    	else{
    		return null;
    	}
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
    	if(list1 ==null) return list2;
    	if(list2 ==null) return list1;
    	ListNode former = new ListNode(-10086);
    	ListNode head 	= null;
    	while(list1!=null && list2!=null){
    		if(list1.val<list2.val){
    		   former.next = list1; 
    		   list1  = list1.next;
    		   
    		}
    		else{
    		   former.next = list2; 
    		   list2  = list2.next;
    		}
    		//if former == null, then the following steps, head will not be affected by former's operation
    		//so before former = former.next, we should make former.next == list1 or list2
    		former=former.next;   
    		if(head==null) head=former;
    	}
    	
    	if(list1==null)
    		former.next = list2;
    	if(list2==null)
    		former.next = list1;
    	
    	return head;
    }
    
    public ListNode mergeKLists_TimeLimitExceeded(ListNode[] lists) {
    	ListNode pre_head =  new ListNode(0);
    	ListNode preHead =pre_head;
    	
    	List<ListNode> nodeLists = new ArrayList<ListNode>();
    	for(int i =0 ;i<lists.length;i++){
    		if(lists[i]!=null){
    		   nodeLists.add(lists[i]);
    		}
    	}
    	
    	//O(k*n) 
    	while(nodeLists.size()>=1){
    		int index_min=-1;
        	int min = Integer.MAX_VALUE;
        	
        	//Time Complexity here is O(k),k is the length of "ListNode[] lists"
        	for(int i =0;i<nodeLists.size();i++){
        			if(nodeLists.get(i)!=null && min>nodeLists.get(i).val){
        				min=nodeLists.get(i).val;
        				index_min=i;
        			}
        	}
        	if(index_min!=-1){
        		pre_head.next = new ListNode(nodeLists.get(index_min).val);
        	//Time Complexity here is O(n),n is the length of "per single list"
        		pre_head = pre_head.next;
        		if(nodeLists.get(index_min).next!=null) nodeLists.add(nodeLists.get(index_min).next);
        		nodeLists.remove(index_min) ;
        	}
    	}
    	
    	return preHead.next;
    }
   
//    public boolean ifHasNext(ListNode[] lists){
//    	for(int i=0;i<lists.length;i++){
//    		if(lists[i]!=null){
//    			return true;
//    		}
//    	}
//    	return false;
//    }

    
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] lists = { new P23_MergeKSortedLists().new ListNode(1), new P23_MergeKSortedLists().new ListNode(0)};
		ListNode n = new P23_MergeKSortedLists().mergeKLists(lists);
		while( n!=null){
			System.out.println(n.val);
			n=n.next;
		}
	}

}
