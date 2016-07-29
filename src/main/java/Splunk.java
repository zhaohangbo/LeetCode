import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splunk {
	    public double solution(double[] A) {
	        // write your code in Java SE 8
	        if (A.length==0)
				return 0;
			
			double posi  =  A[0];
			double nega  =  A[0];
			double maxSofar = A[0];
			
			for(int i=1;i<A.length;i++){
				double tempP = posi;
				double tempN = nega;
				
				posi = Math.max(Math.max(tempP*A[i], tempN*A[i]), A[i]);
				nega = Math.min(Math.min(tempP*A[i], tempN*A[i]), A[i]);
				maxSofar=Math.max(maxSofar, posi);
				if(maxSofar>1000000000.0)
				   return   1000000000.0;
			}
			
			return maxSofar;
	    }
	    
	    static   int solution1(int[] A, int X) {
	        int N = A.length;
	        if (N == 0) {
	            return -1;
	        }
	        int l = 0;
	        int r = N - 1;
	        while (l < r-1) {
	            int m = (l + r) / 2;
	            if (A[m] > X) {
	                r = m - 1;
	            } else {
	                l = m;
	            }
	        }
	        if (A[l] == X || A[r]==X) {
		        return A[l]==X?l:r;
	        }
	        return -1;
	    }
	    
	    
	    public boolean solution2(int[] A) {
	        // write your code in Java SE 8
	    	
	    	return mergeSort(A, 0, A.length-1);
	    }
	    
	    int _count = 0;
	    public boolean mergeSort(int[] A,int start,int end){
	    	if(start < end){
	    		int mid = (start+end)/2;
	    		mergeSort(A, start, mid);
	    		mergeSort(A, mid+1, end);
	    		merge(A,start,mid,end);
	    	}
	    	return _count <=1;
	    }
	    
	    public void merge(int[] A,int start,int mid,int end){
	    	int[] tmp  =new int[A.length];
	    	int p1 =start;
	    	int p2 =mid+1;
	    	int i  =start;
	    	while(p1<=mid && p2<=end){
	    		if(A[p1]<=A[p2]){
	    			tmp[i]=A[p1];
	    			i++; p1++;
	    		}
	    		else{
	    			tmp[i]=A[p2];
	    			_count++;
	    			i++; p2++;
	    		}
	    	}
	    	
	    	while(p1<=mid){
	    		tmp[i]=A[p1];
	    		i++;p1++;
	    	}
	    	while(p2<=end){
	    		tmp[i]=A[p2];
	    		i++;p2++;
	    	}
	    	for(int k=start;k<=end;k++){
	    		A[k] = tmp[k];
	    	}
	    }
	    
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
	  //Both the left[] and right[] are already sorted
	  //It's impossible the index in count[index] will be bigger(>) than mid,
	  //in another word, index in count[index] is limited to the left half.
	          new_indexes[sort_index] = indexes[left_index];
	          count[indexes[left_index]]+=right_smaller_count;
	          left_index++;
	        }
	        sort_index++;
	      }
	      while(left_index<=mid){
	  //left_index is index of Sorted Array
	  //but count[] is recording the smaller count of the Unsorted Array
	  //indexes[left_index] Maps the sorted array index to the unsorted array index
	        new_indexes[sort_index]= indexes[left_index];
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
	    public boolean solution_2(int[] A) {
	        // write your code in Java SE 8
	    	int[] A_clone =A.clone();
	    	Arrays.sort(A);
	    	
	    	int count =0;
	    	for(int i=0;i<A.length;i++){
	    		if(A[i] != A_clone[i]){
	    			count ++;
	    		}
	    	}
	    	return count<=2;
	    }
	    
	    public int solution_3_still_wrong(int[] A) {
	        // write your code in Java SE 8
	    	int p=1;
	    	int q=3;
	    	
	    	int[] minCost = new int[A.length];
	    	minCost[0]=Integer.MAX_VALUE;minCost[p]=Integer.MAX_VALUE;
	    	minCost[2]=Integer.MAX_VALUE;minCost[q]=Integer.MAX_VALUE;
	    	minCost[4]=A[1]+A[3];
	    	
	    	for(int i=5;i<=A.length-1;i++){
	    		if(A[p]+A[q+1] <= A[p+1]+A[q+1]){//notice "="
	    			if(A[p]+A[q+1] < A[p]+A[q]){
	    				minCost[i]=A[p]+A[q+1];
	    				q++;
	    			}
	    			else{
	    				minCost[i]=minCost[i-1];
	    			}
	    		}
	    		else{
	    			if(A[p+1]+A[q+1] < A[p]+A[q]){
	    				minCost[i]=A[p+1]+A[q+1];
	    				p++;q++;
	    			}
	    			else{
	    				minCost[i]=minCost[i-1];
	    			}
	    		}
//	    		minCost[i]=Math.min(minCost[i-1], Math.min(A[p]+A[q], A[p]+A[q+1]));
	    	}
	    	return minCost[A.length-1];
	    }

	    public static void main(String[] args){
	    	Splunk splunk =new Splunk();
	    	System.out.println(splunk.solution2(new int[]{1, 5, 3, 3, 7}));
	    }
}
