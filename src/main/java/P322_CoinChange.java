import java.util.Arrays;

public class P322_CoinChange {
    
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);//increasing order
		int[] dp =new int[amount+1];//so that the last one is amount 
		//dp[i] means the minimum num of coins when amount == i

		for(int _amount=1;_amount<=amount;_amount++){
			int min_num_of_coins = Integer.MAX_VALUE;
			for(int j =0; j<coins.length;j++){
				//Key part here
				if(_amount-coins[j] >= 0 && dp[_amount-coins[j]]!= -1 ){
					if(min_num_of_coins >dp[_amount-coins[j]]+1)
					   min_num_of_coins =dp[_amount-coins[j]]+1;
				}
			}
			if(min_num_of_coins != Integer.MAX_VALUE)
				dp[_amount] = min_num_of_coins;
			else
				dp[_amount] = -1;
		}
		return dp[amount];
    }
	
//	[1]
//	1
//	[2]
//	3

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2};
		System.out.println( coinChange(a,3) );
	}

}
