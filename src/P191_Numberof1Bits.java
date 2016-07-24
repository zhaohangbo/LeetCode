
public class P191_Numberof1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count =0;
    	while(n!=0){
    		count +=(n & 1);
    		n=n>>>1;
    	}
    	return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a =  2147483648;
		
	}

}
