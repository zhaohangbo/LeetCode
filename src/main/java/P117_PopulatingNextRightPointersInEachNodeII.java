import java.util.LinkedList;
import java.util.Queue;

public class P117_PopulatingNextRightPointersInEachNodeII {

	public void connect(TreeLinkNode root) {
		TreeLinkNode head =null;
		TreeLinkNode prev =null;
		TreeLinkNode cur =root;
		while(cur!=null){
			while(cur!=null){
				if(cur.left!=null){
					if(prev==null)
						head=cur.left;
					else
						prev.next=cur.left;
					prev=cur.left;//instead of prev = prev.next;
				}
				if(cur.right!=null){
					if(prev==null)
						head=cur.right;
					else
						prev.next=cur.right;
					prev =cur.right;//instead of prev = prev.next;
				}
				cur=cur.next;
			}
			cur=head;
			head=null;
			prev=null;
		}
	}
	
	
	public void connect1(TreeLinkNode root) {
        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null)
                        prev.next = cur.left;
                    else 
                        head = cur.left;
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev  != null) 
                        prev.next = cur.right;
                    else 
                        head = cur.right;
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
    }
	
    public void connect2(TreeLinkNode root) {
    	if(root == null ) return;
    	LinkedList<Object[]> l = new LinkedList<Object[]>();
    	Queue<Object[]> q = new LinkedList<Object[]>();
    	Object[] root_arr = new Object[2];
    	root_arr[0]= root; root_arr[1]= 0;
    	q.add(root_arr);
    	l.add(root_arr);
    	while(!q.isEmpty()){
    		root_arr = q.poll();
    		TreeLinkNode node = (TreeLinkNode) root_arr[0];
    		if(node.left!=null){
    			Object[] node_arr  = new Object[2];
    			node_arr[0] = ((TreeLinkNode)root_arr[0]).left;
    			node_arr[1] = (int)root_arr[1]+1;
    			q.add(node_arr);
    			l.add(node_arr);
    		}
    		if(node.right!=null){
    			Object[] node_arr  = new Object[2];
    			node_arr[0] = ((TreeLinkNode)root_arr[0]).right;
    			node_arr[1] = (int)root_arr[1]+1;
    			q.add(node_arr);
    			l.add(node_arr);
    		}
    	}
    	
    	for(int i=0;i<l.size()-1;i++){
    		Object[] node1  = l.get(i);
    		Object[] node2  = l.get(i+1);
    		if((int)node1[1]==(int)node2[1]){
    			((TreeLinkNode)node1[0]).next=((TreeLinkNode)node2[0]);
    		}
    		else{
    			((TreeLinkNode)node1[0]).next =null;
    		}
    	}
    	Object[] node  = l.get(l.size()-1);
    	((TreeLinkNode)node[0]).next =null;
    }
    
    
    public class TreeLinkNode {
    	     int val;
    	     TreeLinkNode left, right, next;
    	     TreeLinkNode(int x) { val = x; }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
