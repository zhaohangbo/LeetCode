
public class P4_MedianofTwoSortedArrays {

//1. (i+1)+(j+1)= (m-i-1)+(n-j-1);
//	 j = (m+n-1)/2 - i
//2. nums1[i-1]  < nums2[j]
//	 nums2[j-1]  < nums2[i]
	
//left_part            	   |  right_part
//A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
//B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)  {
    	if(nums1.length==0){
    		if(nums2.length%2==0)
    			return (nums2[nums2.length/2-1]+nums2[nums2.length/2]) / 2.0;
    		else 
    			return nums2[nums2.length/2];
    	}
    	if(nums2.length==0){
    		if(nums1.length%2==0)
    			return (nums1[nums1.length/2-1]+nums1[nums1.length/2]) / 2.0;
    		else 
    			return nums1[nums1.length/2];
    	}
    	
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	//make sure nums1 is the shorter one, so that time complexity is O(log(min(m,n)))
    	//choose min(m,n) here. than range i from 0 to min(m,n);
    	if(m>n) return findMedianSortedArrays(nums2, nums1);
    	
    	int i,j;    
    	int iMin =0;
    	int iMax =m;//i range from iMin to iMax
    	int half_len= (m+n+1)/2; //even is half , odd is half_with_1_more
    	
    	int maxOfLeft  =0; 
    	int minOfRight =0;

    	while(iMin <= iMax){
    		i = (iMin+iMax)/2; 	
    		j = half_len - i;// i+j==half_len
    		
    		if(j>0 && i<m && nums2[j-1]>nums1[i])
    			//i is too small, choose the right half range to increase i;
    			iMin = i+1;
    		else if(i>0 && j<n && nums1[i-1]>nums2[j])
    			//i is too big,   choose the left half range to decrease i;
    			iMax = i-1;
    		else{
    			//i is perfect
    			if(i==0) maxOfLeft =nums2[j-1];
    			else if(j==0) maxOfLeft = nums1[i-1];
    			else maxOfLeft = Math.max(nums1[i-1], nums2[j-1]);
    			
    			if((m+n)%2==1) return maxOfLeft;//i+j = (m+n+1)/2, even is half , odd is half_with_1_more
    											//j=half_len-i
    			
    			if(i==m) minOfRight=nums2[j];
    			else if(j==n) minOfRight=nums1[i];
    			else minOfRight = Math.min(nums1[i], nums2[j]);
    			
    			return (maxOfLeft + minOfRight)/2.0;
    		}
    	}
    	return 0.10086;//any value
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 ={1,2,3,5,6};
		int[] nums2 ={4};
		findMedianSortedArrays(nums1,nums2);
	}

}
