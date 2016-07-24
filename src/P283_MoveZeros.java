
public class P283_MoveZeros {
	
	
	//Idea
	
    public void moveZeroes(int[] nums) {
        int zeroNum      =  0; // the number(length) of zeros
        
     
        for(int i =0 ;i<nums.length;i++){
        	// if nums[i] ==0; zeroNum++;
            if(nums[i]==0){
               zeroNum++;
            }
            // Else nums[i]!=0;
            //        if there are N zeros before it, we should swap the most left zero and nums[i];
            //        else means no zeros if before it, all nozeros until now, just do nothing.
            else{
                if(zeroNum>0){
                    nums[i-zeroNum]= nums[i];
                    nums[i] =0;
                }
            }
            
        }
    }
    
}
