import java.util.Stack;

public class P255_VerifyPreorderSequenceInBinarySearchTree {
//	前序遍历：根节点->左子树->右子树
//	中序遍历：左子树->根节点->右子树
//	后序遍历：左子树->右子树->根节点
	
//	Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//	You may assume each number in the sequence is unique.
	
//  Preorder Definition: root, left, right
//  The key to this problem is the "last_pop"
	public boolean verifyPreorder(int[] preorder) {
		if(preorder.length==0) return true;
		int last_pop = Integer.MIN_VALUE;
		boolean result =true;
		Stack<Integer> stack =new Stack<Integer>();
		for(int i=0;i<preorder.length;i++){
			if(stack.isEmpty()){
				stack.push(preorder[i]);
			}
			else if(!stack.isEmpty() && preorder[i] < stack.peek()){
				if(preorder[i] < last_pop){
					result = false;
				}
				stack.push(preorder[i]);
			}
			else if(!stack.isEmpty() && preorder[i] > stack.peek()){
				while(!stack.isEmpty() && stack.peek()<preorder[i]){
					last_pop = stack.pop();
				}
				stack.push(preorder[i]);
			}
		}
		return result;
	}
	
	
	
	
	//This thinking is wrong
	//because a[0] == root, but a[1],a[2] are not left and right, they might be all in left subtree
    public boolean verifyPreorder_wrong(int[] preorder) {
    	//root(i), left(2*i+1), right(2*i+2)
    	boolean flag = true;
    	int i =0; 
    	while(2*i+1<preorder.length){//if node(i) has a left child
    		if(2*i+1==preorder.length-1){
    			if( !(preorder[i]>preorder[2*i+1]) ){
    				flag =false;
    			}
    			break;
    		}
    		if(!(preorder[i]>preorder[2*i+1] && preorder[i]<preorder[2*i+2])){
    			flag =false;
    			break;
    		}
    		i++;
    	}
        return flag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
