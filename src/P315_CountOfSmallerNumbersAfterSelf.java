import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P315_CountOfSmallerNumbersAfterSelf {
	
	private int [] count;
	//Merge Sort
    public List<Integer> countSmaller(int[] nums) {
    	count = new int[nums.length];
    	int[] indexes =new int[nums.length];
    	for(int i=0;i<nums.length;i++)
    		indexes[i] = i;
    	mergeSort(0,nums.length-1,nums,indexes);
    	
    	List<Integer> list_count = new ArrayList<Integer>();
    	for(int i= 0; i< count.length;i++){
    		list_count.add(count[i]);
    	}
    	return list_count;
    }
    
    public void mergeSort(int start , int end ,int[] nums, int[] indexes){
    	if(start<end){
    		int mid = (start+end)/2;
    		mergeSort(start,mid,nums,indexes);
    		mergeSort(mid+1,end,nums,indexes);
    		merge(start,mid,end,nums,indexes);
    	}
    }
    
	public void merge(int start,int mid, int end, int[] nums, int[] indexes ){
	    int left_index = start, right_index = mid+1;
	    int right_smaller_count = 0 , sort_index = 0;    
	    int[] new_indexes = new int[end - start + 1];
	    
	    while(left_index<=mid && right_index<=end){
		    //left > right, so we'll put the right in to new_indexes
	    	//we compare the value of nums[], but we move and sort the index of it
		    if(nums[indexes[left_index]]>nums[indexes[right_index]]){
		    	new_indexes[sort_index] = indexes[right_index];
		    	right_smaller_count++;
		    	right_index++;
		    }
		    else{
		    	//Both the left sub array and  the right sub array are already sorted, so conut[mid+1 ~ end] must all be Zero. 
		    	//It's impossible that the index in count[index] will be greater(>) than mid, 
		    	//in another word, index in count[index] is limited to the left half.
		    	new_indexes[sort_index] = indexes[left_index];
		    	count[indexes[left_index]]+=right_smaller_count;
		    	left_index++;
		    }
		    sort_index++;
	    }
	    while(left_index<=mid){
	    	new_indexes[sort_index]= indexes[left_index]; 
	    	//left_index is index of Sorted Array
	    	//but count[] is recording the smaller count of the Unsorted Array
	    	//indexes[left_index] Maps the sorted array index to the unsorted array index
	    	count[indexes[left_index]]+=right_smaller_count;
	    	left_index++;
	    	sort_index++;
	    }
	    while(right_index<=end){
	    	new_indexes[sort_index]= indexes[right_index];
	    	right_index++;
	    	sort_index++;
	    }
	    for(int i =start ;i<= end;i++){
	    	indexes[i] = new_indexes[i-start];//i - start
	    }
	}
    
//    left:[5,7,9]; right:[2,4,6,8]
//    merge the two sub arrays
//				9
//    							8
//			7
//     						6
//		5		
//    					4
//			
//   				2	
	
	
	
    public List<Integer> countSmaller_BST(int[] nums) {
    	Integer[] smallerCountsArr =new Integer[nums.length];
    	Node root =null;
    	//why from the right to left, because in this way ,every time you insert, the status of all elements on right will be updated
    	for(int i = nums.length-1 ;i>=0; i--){
    		root = insert(nums[i], root, smallerCountsArr, i, 0);
    	}
    	return Arrays.asList(smallerCountsArr);
    }
	
    public Node insert(int val,Node node,Integer[] smallerCountsArr, int i, int prevSmallerCount){
    	if(node == null){
    		smallerCountsArr[i]= prevSmallerCount;//default dup = 1
    		node =  new Node(val,0);
    	}
    	else if(node.val == val){
    		node.dup ++ ;
    		smallerCountsArr[i] = node.smallerCount + prevSmallerCount;
    	}
    	else if(node.val > val ){
    		//smallerCountsArr[i] = node.smallerCount + prevSmallerCount;
    		node.smallerCount++;
    		node.left = insert(val, node.left, smallerCountsArr, i, prevSmallerCount);
    	}
    	else {//(node.val < val)
    		node.right = insert(val, node.right, smallerCountsArr, i, prevSmallerCount + node.dup + node.smallerCount);
    	}
    	return node;
    }
	
	class Node {
		Node left,right;
		int val, smallerCount ;
		int dup =1 ;
		public Node(int val, int smallerCount){
			this.val =val ;
			this.smallerCount=smallerCount ;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
