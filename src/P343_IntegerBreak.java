
public class P343_IntegerBreak {
	
	//			   n = 2,  > return 1  (2  = 1 + 1);
	//			   n = 3,  > return 2  (3  = 2 + 1);
	
	//			   n = 4,  = return 4  (4  = 2 + 2);  
	
	//			   n = 5,  < return 6  (5  = 3 + 2);
	//			   n = 6,  < return 9  (6  = 3 + 3);
	
	//			   given n = 7,  <return 12 (7  = 3 + 2 + 2); == 
	//			   given n = 8,  return 18 (8  = 3 + 3 + 2);
	//	   		   given n = 9,  return 27 (9  = 3 + 3 + 3);
	//			   given n = 10, return 36 (10 = 3 + 3 + 4(2+2));
	//			   given n = 11, return 54 (11 = 3 + 4(2+2) + 4(2+2));

	//			   given n = 12, return 81 (12 = 3 + 3 + 3 + 3);
	//			   given n = 13, return 96 (13 = 3 + 3 + 3 + 2 + 2);
	//			   given n = 14, return 48 (14 = 3 + 3 + 3 + 3 + 2);
	
    public int integerBreak(int n) {
    	if(n==2) return 1;
    	if(n==3) return 2;
    	if(n==4) return 4;
    	
    	int res = 1 ;
    	
    	int a = n/3;
    	int b = n%3;
    	
    	if(b==0){
    		res=1;
    	}
    	else if(b==1){
    		a--;
    		res=4;
    	}
    	else{	//b==2
    		res=2;
    	}
    	
    	while(a>0){
    		res *= 3;
    		a--;
    	}
    	return res;   
    }
    
    public int integerBreak2(int n) {
    	if(n==2) return 1;
    	if(n==3) return 2;
    	if(n==4) return 4;
    	
    	int res = 1;
    	while(n>=5){
    			n=n-3;
    			res *= 3; 
    	}
    	
	    if(n==4)
			res *= 4;
		else if(n==3)
			res *= 3;
		else if(n==2)
			res *= 2;
	    
    	return res;   
    }
    
    public int integerBreak_dp(int n) {
           int[] dp = new int[n + 1];
           dp[1] = 1;
           for(int i = 2; i <= n; i ++) {
               for(int j = 1; j < i; j ++) {
                   dp[i] = Math.max( dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])) );
               }
           }
           return dp[n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
