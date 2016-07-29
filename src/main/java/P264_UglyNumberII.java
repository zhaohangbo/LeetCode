import java.util.Set;
import java.util.TreeSet;

public class P264_UglyNumberII {
	
    public int nthUglyNumber(int n) {
    	int[] dp = new int[n];	  
    	//dp[i] means the  i-th UglyNumber
    	dp[0]= 1;
    	for(int i=1;i< n ;i++){
    		int dp2=-1;int dp3=-1;int dp5=-1;
    		//dp[i] = min(dp[x]*2,dp[y]*3,dp[z]*5), where dp[x]*2,dp[y]*3,dp[z]*5  > dp[i-1] for the first time
    		for(int j=0; j< i ; j++){
    			if(dp2!=-1 && dp2!=-1 && dp2!=-1)
    				break;
    			if(dp2==-1 && dp[j]*2 >dp[i-1]){
    				dp2 = dp[j]*2;
    			}
    			if(dp3==-1 && dp[j]*3 >dp[i-1]){
    				dp3 = dp[j]*3;
    			}
    			if(dp5==-1 && dp[j]*5 >dp[i-1]){
    				dp5 = dp[j]*5;
    			}
    		}
    		dp[i] = Math.min(dp2, Math.min(dp3,dp5));
    	}
    	return dp[n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
