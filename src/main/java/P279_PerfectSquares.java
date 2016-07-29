
public class P279_PerfectSquares {
	//dp[0] = 0
	//dp[1] = 1
	//dp[2] =dp[2-1*1]+1=2
	//dp[3] =dp[3-1*1]+1=3
	//dp[4] =min(dp[4-1*1]+1,dp[4-2*2]+1)
	//      =min(dp[3]+1    ,dp[0]+1)   =1
	
	
//	https://leetcode.com/discuss/62526/an-easy-understanding-dp-solution-in-java
    public int numSquares(int n) {
        int[] dp =new int[n+1];
    	int min=0;
    	dp[0]=0;
    	dp[1]=1;
    	int sqrt =0;
    	for(int i =2;i<=n;i++){
    		sqrt =(int) Math.sqrt(i);
    		min =Integer.MAX_VALUE;
    		for(int j =1;j<=sqrt;j++){
    			dp[i] = Math.min(min,dp[i-j*j]+1);
    			min   = dp[i];
    		}
    	}
    	return dp[n];
        
    }
    
    public static void main(String[] args){
    	System.out.println(new P279_PerfectSquares().numSquares(12));
    }
    
}
