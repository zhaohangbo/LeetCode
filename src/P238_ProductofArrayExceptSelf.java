
public class P238_ProductofArrayExceptSelf {

	//Solve it without division and in O(n).
    public int[] productExceptSelf(int[] nums) {
    	int[] res =new int[nums.length];
    	
    	res[0] = 1;
    	for(int i=1;i<nums.length;i++){
    		res[i] = res[i-1]*nums[i-1];
    	}
    	int r= 1;
    	for(int i=nums.length-1-1;i>=0;i--){
    		r*=nums[i+1];
    		res[i] *=r;
    	}
    	return res;
    }
	
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
