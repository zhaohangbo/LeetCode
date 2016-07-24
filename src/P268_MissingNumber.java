
public class P268_MissingNumber {

    public int missingNumber(int[] nums) {
    	//if no missing, nums[i] = i, so i^nums[i] ==0;
    	//1 ^ 0 == 1, 0 ^ 0 == 0, anything ^ 0 == anything itself
    	
    	//example: 4 is missing
    	//nums[i]:0123[5]678910
    	//i      :0123[4]56789  (lenth=10)
    	int xor = 0;
    	for(int i=0;i<nums.length;i++){
    		xor ^= (i^nums[i]);
    	}
    	
    	return xor ^ nums.length ;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
