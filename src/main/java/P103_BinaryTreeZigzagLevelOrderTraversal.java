import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P103_BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res =new LinkedList<List<Integer>>();
		if(root == null ) return res;
		int depth = 0;
		
		Queue<Object[]> queue = new LinkedList<Object[]>();
		Object[] root_depth = {root,depth};
		queue.add(root_depth);

		List<Integer> oneLayer =new LinkedList<Integer>();
		while(!queue.isEmpty()){
			Object[] node_depth = queue.poll();
			TreeNode cur = (TreeNode) node_depth[0];
			int curDepth = (int) node_depth[1];
			
			if(curDepth==depth+1){
				res.add(oneLayer);
				oneLayer = new LinkedList<Integer>();
				depth++;
			}
			
			if(curDepth%2==0)// even level, from left to right
				oneLayer.add(cur.val);
			else             //  odd level, from right to left 
				oneLayer.add(0,cur.val);
			
			if(cur.left!=null){
				Object[] left_depth = {cur.left, curDepth+1};
				queue.add(left_depth);
			}
			if(cur.right!=null){
				Object[] right_depth = {cur.right, curDepth+1};
				queue.add(right_depth);
			}
			
		}
		if(oneLayer.size()>0) 
			res.add(oneLayer);
    	return res;
    }
	
	  //BFS method
	  public List<List<Integer>> zigzagLevelOrder_bfs(TreeNode root) {
	    List<List<Integer>> res = new LinkedList<>();
	    if(root == null)
	        return res;
	    
	    Queue<TreeNode> q = new LinkedList<>();
	    q.offer(root);
	    int level = 1;
	    while(!q.isEmpty()){
	        LinkedList<Integer> path = new LinkedList<>();
	        int levelNums = q.size();
	        
	        for(int i = 0; i < levelNums; i++){
	            root = q.poll();
	            if(level % 2 != 0){
	                path.add(root.val);
	            }else{
	                path.addFirst(root.val);
	            }
	            
	            if(root.left != null)
	                q.offer(root.left);
	            if(root.right != null)
	                q.offer(root.right);
	        }
	        res.add(path);
	        level++;
	    }
	    
	    return res;
	}
	  //DFS method
	  //O(n) solution by using LinkedList along with ArrayList. 
	  //So insertion in the inner list and outer list are both O(1),
	  //Using DFS and creating new lists when needed.
	  public List<List<Integer>> zigzagLevelOrder_dfs(TreeNode root){
	        List<List<Integer>> sol = new LinkedList<>();
	        travel(root, sol, 0);
	        return sol;
	  }
	    
	  private void travel(TreeNode curr, List<List<Integer>> sol, int level){
	        if(curr == null) return;
	        
	        if(sol.size() <= level)
	        {
	            List<Integer> newLevel = new LinkedList<>();
	            sol.add(newLevel);
	        }
	        
	        List<Integer> collection  = sol.get(level);
	        if(level % 2 == 0) collection.add(curr.val);
	        else collection.add(0, curr.val);//LinkedList,so insertion is O(1)
	        
	        travel(curr.left , sol, level + 1);
	        travel(curr.right, sol, level + 1);
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
