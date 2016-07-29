
public class P75_SortColors {
//	http://blog.csdn.net/morewindows/article/details/6684558
    public void sortColors(int[] nums) {
    	
    	int left =0;
    	int right=nums.length-1;
    	int i =0;
    	//1,2,0,2,1
    	//1,2,0,2,1
    	//1,1,0,2,2
    	//0,1,1,2,2
    	
    	
    	//1,2,0
    	//1,2,0
    	//1,0,2
    	//0,1,2
    	//0,1,2
    	
    	
    	//1,0
    	//1,0
    	
    	
    	while(left<right && i <=right){ //i<=right不能少了这个等号
    		if(nums[i]==0 && i>left){
    			//nums[i]==0 means 可以把它挖掉(送给当前left处)，用来填空
    			
    			//swap(i,left)
    			int temp =nums[i];
    			nums[i] = nums[left];
    			nums[left]=temp;
    			
    			left++;
    		}
    		else if(nums[i]==2 && i<right){
    			//swap(i,right)
    			int temp =nums[i];
    			nums[i] =nums[right];
    			nums[right] =temp;
    			
    			right--;
    		}
    		else{//nums[i]==1
    			i++;
    		}
    	}
    	
    }
    
    
    
    //1,2,0
    public void sortColors2(int[] A) {

        int left=0;int right=A.length-1;
        for(int i=0;i<=right && i < A.length;) {
            if (A[i] == 0 && i > left ) {
                swap(A,i,left++);
            } 
            else if (A[i] == 2 && i < right)
                swap(A,i,right--);
            else//Only A[i]==1 || i<=left || i>=right
                i++;
        }
    }

    public void swap(int[] nums,int i,int j){
    	if(i!=j){
    		int temp =nums[i];
    		nums[i]  =nums[j];
    		nums[j]  =temp;
    	}
    }

    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums ={0,1,2};
		new P75_SortColors().sortColors(nums);
	}

}
