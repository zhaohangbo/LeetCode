
public class P136_SingleNumber {
	
    public static int singleNumber(int[] nums) {
    	int result =0;
    	for(int i=0;i<nums.length;i++){
    		System.out.println("before "+result +" "+ nums[i]);
    		result ^= nums[i];
    		System.out.println("after "+ result );
        }
    	return   result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums ={1,2,3,1,2,3,4,4,5};
		System.out.println(singleNumber(nums));
		
		//bitwise ^ exclusive OR operation is 异或
		//1 ^ 1 = 0
		//0 ^ 0 = 0
		//1 ^ 0 = 1
		//0 ^ 1 = 1
		System.out.println(2^2);
		System.out.println(2^3);
		System.out.println(2^4);
		System.out.println(2^5);
	}

}
