
public class P260_SingleNumberIII {

    public int[] singleNumber(int[] nums) {
    	int diff = 0;
    	for(int num : nums){
    		diff^=num;
    	}
    	//Be aware that we represent negative in 2's Complement
    	//Don't need to worry about sign
    	
    	//0b011111111111111111111111111111111;
    	//0b100000000000000000000000000000000;
    	
    	//0b000000000000000000000000000000000;
    	//0b111111111111111111111111111111111;
    	//diff<<=1; diff>>>=1;
    	int bitPos =0;
    	while(diff !=0){
    		bitPos ++;
    		diff>>>=1;
    	}
    	bitPos--;
    	diff = bitPos<<1;
//    	diff &= -diff;
    	int[] res =new int[2];
    	for(int num : nums){
    		if((num&diff)==0)
    			res[0] ^=num;
    		else
    			res[1] ^=num;
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0b00000000111000000001111110001100;
		int b = 0b00000000000000000000000000000000;
		System.out.println(Integer.toBinaryString(0b011111111111111111111111111111111));
		System.out.println(Integer.toBinaryString(0xAAAADDDD));
		System.out.println(Integer.toBinaryString(07777777777));
		System.out.println("0b011111111111111111111111111111111".length());
		
		int i = 0b1;
		int j = 0b000000000000000000000000011101110111011101110111011101110;
		
		//Be aware that we represent negative in 2's Complement
		System.out.println(Integer.toBinaryString(i));
		
		System.out.println(Integer.toBinaryString(0-i));
		
		int m =0b00000000000000000000000000000100;//4
		int n =0b11111111111111111111111111111100;//-4, 补码(反码+1)
		System.out.println( m);
		System.out.println(Integer.toBinaryString(~(m-1)));
		System.out.println( n);
		System.out.println( "00000000000000000000000000000"+Integer.toBinaryString(~(n-1)));
		
		System.out.println( Integer.toBinaryString(m&n));
//		[+1] = [00000001]原 = [00000001]反 = [00000001]补
//		[-1] = [10000001]原 = [11111110]反 = [11111111]补
	}

}
