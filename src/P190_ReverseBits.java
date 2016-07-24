
public class P190_ReverseBits {

    // you need treat n as an unsigned value
	//	Follow up:
	//	If this function is called many times, how would you optimize it?
    public int reverseBits(int n) {
    	int res = 0;
    	for(int i=0;i<32;i++){
    		res+=n&1;
    		n>>>=1;
    		if(i<31)
    			res<<=1;
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(Integer.toBinaryString(1).toCharArray().length);
		
		int a = 999;
		while (a!=0){
			a<<=1;
			System.out.println(a);
		}
	}

}
