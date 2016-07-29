import java.util.LinkedList;
import java.util.List;

public class P235_LowestCommonAncestorOfBinarySearchTree {
	
	//Be aware it's in a BST
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val==root.val)
			return p;
		if(q.val==root.val)
			return q;
		if(p.val<root.val && q.val<root.val){
			return lowestCommonAncestor(root.left, p, q);
		}
		else if(p.val>root.val && q.val>root.val){
			return lowestCommonAncestor(root.right, p, q);
		}
		else{
			return root;
		}
	}
	
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    	List<TreeNode> toP =new LinkedList<TreeNode>();
    	List<TreeNode> toQ =new LinkedList<TreeNode>();
    	
    	toP = findPath (root,p);
    	toQ = findPath (root,q);

    	TreeNode LCA =null;
    	if(toP.size() > toQ.size()){
    		if(toQ.size() == 1)
    			return toQ.get(0);
    		for(int i=0;i<toQ.size()-1;i++){
    			if( nodeEqual(toP.get(i),toQ.get(i)) && !nodeEqual(toP.get(i+1),toQ.get(i+1)) )
    					LCA = toP.get(i);
    		}
    	}
    	else{
    		if(toP.size() == 1)
    			return toP.get(0);
    		for(int i=0;i<toP.size()-1;i++){
    			if( nodeEqual(toP.get(i),toQ.get(i)) && !nodeEqual(toP.get(i+1),toQ.get(i+1)) )
    					LCA = toP.get(i);
    		}
    	}
     return LCA;   
    }
    
    public LinkedList<TreeNode> findPath (TreeNode root, TreeNode target){
    	LinkedList<TreeNode> pathList = new LinkedList<TreeNode>(); 
    	if(nodeEqual(root, target)){
    	   pathList.add(target);
    	}
    	else {
    		if(root.left!=null){
	    		LinkedList<TreeNode> list = findPath(root.left,target);
	    		if(!list.isEmpty()){
	    			pathList.addAll(list);
	    		}
	    		return pathList;
    		}
    		
    		if(root.right!=null){
	    		LinkedList<TreeNode> list = findPath(root.right,target);
	    		if(!list.isEmpty()){
	    			pathList.addAll(list);
	    		}
	    		return pathList;
    		}
    	}
    	return pathList;
    }
    
    public boolean nodeEqual(TreeNode a, TreeNode b){
    	if(a!=null && b !=null && a.val == b.val){
    		if(a.left!=null && b.left!=null && a.right!=null && b.right!=null)
    			return nodeEqual(a.left, b.left) && nodeEqual(a.right, b.right);
    		else if((a.left!=null && b.left==null))
    			return false;
    		else if(a.right!=null && b.right==null)
    			return false;
    		else
    			return true;
    	}
    	return false;
    }
    
    public class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; }
    	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
