
public class P88_MergeSortedArray {
//	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//  nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2
    	//I think wrong
    	
    	if((n==0 && m==0)||(n==0 && m!=0)){
    		return;
    	}
    	
    	if(n!=0 && m==0) {
    		for(int i=0;i<n;i++){
    			nums1[i] =nums2[i];
    		}
    		return;
    	}
    	
    	for(int i=m-1;i>=0;i--){
    		nums1[i+n]=nums1[i];
    	}
    	
    	int p1 =n; // cause 
    	int p2 =0;
    	int p_cur=0;
    	
    	while(p1<m+n && p2<n){//Careful! it's && here not ||
    		
    		if(nums1[p1]<nums2[p2]){
    			nums1[p_cur]=nums1[p1];
    			p1++;
    			p_cur++;
    		}
    		else{
    			nums1[p_cur]=nums2[p2];
    			p2++;
    			p_cur++;
    		}
    		
    	}
    	
    	while(p1<m+n){
			nums1[p_cur]=nums1[p1];
			p1++;
			p_cur++;
    	}
    	while(p2<n){
			nums1[p_cur]=nums2[p2];
			p2++;
			p_cur++;
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums1 ={1,0};
		int[] nums2 ={2};
		
		merge(nums1, 1, nums2, 1);

	}

}
