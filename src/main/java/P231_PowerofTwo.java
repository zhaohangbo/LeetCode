
public class P231_PowerofTwo {
	//Power of 2 means only one bit of n is '1', 
	//so use the trick n&(n-1)==0 to judge whether that is the case
	public boolean isPowerOfTwo(int n) {
		if(n<=0) return false;
		n = n&(n-1);
		return n==0;
	}
	
    public boolean isPowerOfTwo1(int n) {
    	int count =0;
    	for(int i=0;i<31;i++){
    		count += n&1;
    		n>>>=1;
    	}
    	if(n==1) return false; //which means the sign bit is 1
    	return count==1;
    }
	
    public boolean isPowerOfTwo2(int n) {
    	if(n==0) return false;
    	if(n==-4) return false;
    	int mod = 0;
    	while(n!=0 && n!=1){
    		mod=n%2;
    		if(mod!=0)
    			return false;
    		n/=2;
    	}
    	return true;
    }
	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  n=0b10000000000000000000000000000000;
		n <<=1; n >>>=1;
		System.out.println(n);
		
		System.out.println(Integer.toBinaryString(-2147483648));//-2147483646
		System.out.println(Integer.toBinaryString(-2147483646));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(-4%2);
		System.out.println(-3/2);
		System.out.println(-3%2);
	}

}
