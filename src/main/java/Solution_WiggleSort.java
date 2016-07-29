public class Solution_WiggleSort {
    
    public void wiggleSort(int[] nums) {
        for(int i=0 ;i< nums.length; i++){
            if(i%2==0){//even: number at even index should always be in the situation that nums[i]<=nums[i+1] 
                //i!=nums.length-1 , avoid IndexOutOfBoundsException
                if(i!=nums.length-1 && nums[i]>nums[i+1]){
                    swap(nums,i);    
                    //if nums[1]>nums[2], 
                    //no matter swap them or not,the situation nums[1]>=nums[0] won't change 
                }
            }
            else{//odd: number at odd index should always be in the situation that nums[i]>=nums[i+1]
                if(i!=nums.length-1 && nums[i]<nums[i+1]){
                    swap(nums,i);
                }
            }
        }
    }
    
    public void swap(int[] nums,int i){
           int temp =nums[i];
           nums[i]  =nums[i+1];
           nums[i+1]=temp;
    }
}