import java.util.*;

public class P95_UniqueBinarySearchTreesII_cool {

    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }

    
    public List<TreeNode> genTrees(int start , int end) {
        List<TreeNode> rootList =new ArrayList<TreeNode>();
        
        if(start>end){
        	rootList.add(null);
        	return rootList;
        }
        if(start == end){
        	rootList.add(new TreeNode(start));
        	return rootList;
        }
        
        TreeNode root;
        List<TreeNode> leftChildList;
        List<TreeNode> rightChildList;
        
        for(int i=start; i<=end;i++){
        	
        	
        	//It is Dynamic Programing, because 
        	//genTrees(start,end) = i from start to end
           leftChildList  =genTrees(start, i-1);
           rightChildList =genTrees(i+1, end);
            
            for(TreeNode leftChild : leftChildList){
            	for(TreeNode rightChild :rightChildList){
            		root =new TreeNode(i);
            		root.left  =leftChild;
            		root.right =rightChild;
            		rootList.add(root);
            	}
            }
            
        }
        
        
        return rootList;
    }
    
    
    
    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
