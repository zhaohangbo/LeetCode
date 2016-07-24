import java.lang.reflect.Array;
import java.util.Vector;

public class P123_BestTimeToBuyAndSellStock3 {
//  QUESTION:
//	Say you have an array for which the ith element is the price of a given stock on day i.
//	Design an algorithm to find the maximum profit. You may complete at most two transactions.
   
	
	
	
//	https://leetcode.com/discuss/48151/my-c-solution-o-n-time-o-1-space-8ms
	
//	It is similar to other buy/sell problems. 
//	Just do DP and define an array of states to track the current maximum profits at different stages. 
//	For example, in the below code:
//	states[][0]: one buy
//	states[][1]: one buy, one sell
//	states[][2]: two buys, one sell
//	states[][3]: two buy, two sells
//	The states transistions occurs when buy/sell operations are executed. 
//	For example, state[][0] can move to state[][1] via one sell operation.

	int cur = 0, next =1;
    public int maxProfit(int[] prices) {
//        int[2][4] states = {Integer.MIN_VALUE,0,Integer.MIN_VALUE,0}; // 0: 1 buy, 1: one buy/sell, 2: 2 buys/1 sell, 3, 2 buys/sells
        int[][] states =new int[2][4];
        states[0][0] =Integer.MIN_VALUE;
        states[0][1] =0;
        states[0][2] =Integer.MIN_VALUE;
        states[0][3] =0;
        
        int len = prices.length, i;
        for(i=0; i<len; ++i)
        {
            states[next][0] = Math.max(states[cur][0], -prices[i]);
            states[next][1] = Math.max(states[cur][1], states[cur][0]+prices[i]);
            states[next][2] = Math.max(states[cur][2], states[cur][1]-prices[i]);
            states[next][3] = Math.max(states[cur][3], states[cur][2]+prices[i]);
            swap_cur_with_next();
        }
        return Math.max(states[cur][1], states[cur][3]);
    }

    
	public void swap_cur_with_next(){
		int temp = cur;
		cur = next;
		next= temp;
	}
	
    public static void main(String[] arg){
//    	int[] prices = {2,1,2,0,1};
//    	int[] prices = {0,1};
//    	int[] prices ={6,1,3,2,4,7};
    	int[] prices ={3,2,6,5,0,3};
    	P123_BestTimeToBuyAndSellStock3 p =new P123_BestTimeToBuyAndSellStock3();
    	
    	System.out.println(p.maxProfit(prices));
    	
    }

}
