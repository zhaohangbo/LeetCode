
public class P309_BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
    	int N = prices.length;
    	if (N ==0 || N ==1)
    		return 0;
    	
    	int[] sell =new int[N];
    	int[] buy  =new int[N];
    	int[] cool =new int[N];
    	
    	sell[0]=0;
        sell[1]=Math.max( buy[0]+prices[1], sell[0]);
    	buy [0]= - prices[0]; 
        buy [1]= Math.max( - prices[1] , buy [0]);
        cool[0]=0;
        cool[1]=sell[0];
    	
    	for(int i  = 1; i<N ;i++) {
    		if(i>=2){
    			buy[i] =Math.max(sell[i-2] + (-prices[i]) , buy[i-1]);        	
    		}
        	sell[i]=Math.max(buy [i-1] + prices[i]	  , sell[i-1]);
        	cool[i]=sell[i-1];
    	}
    	return sell[N-1];
    }
//		1, 2, 4
//sell  0  1  2
//buy  -1  -2  
//cool  0  0  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
