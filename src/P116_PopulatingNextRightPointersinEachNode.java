import java.util.LinkedList;
import java.util.Queue;

public class P116_PopulatingNextRightPointersinEachNode {

    public void connect(TreeLinkNode root) {
    	if(root == null)
    		return;
    	
    	root.next=null;
    	
    	Queue<TreeLinkNode> queue =new LinkedList<TreeLinkNode>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()){
    		TreeLinkNode node = queue.poll();
    		
    		if(node.left!=null){
    			node.left.next = node.right;
    			queue.add(node.left);
    		}
    		if(node.right!=null ){ 
    			if(node.next!=null){
    				node.right.next = node.next.left;
    			}
    			queue.add(node.right);
    		}
    	}
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
