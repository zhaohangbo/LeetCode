
public class P7_ReverseInteger {
	
    public int reverse(int x) {
    	int res = 0;
    	while(x!=0){
    		int newRes = res*10 + x%10;
    		if((newRes-x%10)/10 != res)
    			return 0;
    		res =newRes;
    		x/=10;
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
