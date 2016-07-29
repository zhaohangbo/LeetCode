import java.lang.reflect.Array;
import java.util.Vector;

public class P123_BestTimeToBuyAndSellStock3_2 {
//  QUESTION:
//	Say you have an array for which the ith element is the price of a given stock on day i.
//	Design an algorithm to find the maximum profit. You may complete at most two transactions.
    
	int trans_big =0;
	int trans_small =0;
	
	public int maxProfit(int[] prices) {
		
		int sum =0;
		for(int i=0; i<prices.length-1; i++){
			if(prices[i] <= prices[i+1]){
				     sum += (prices[i+1]-prices[i]);
			}
			else{
				if(trans_big < trans_small){
					swap();
				}
				if(sum > trans_small){
					trans_small = sum;
				}
				sum =0;
			}
		}
		//increasing end
	    if(sum>0){
			if(trans_big < trans_small){
				swap();
			}
			if(sum > trans_small){
				trans_small = sum;
			}
	    }
		
        return trans_big+trans_small;
    }
	
	public void swap(){
		int temp   = trans_big;
		trans_big  = trans_small;
		trans_small= temp;
	}
	
	
	
    public static void main(String[] arg){
//    	int[] prices = {2,1,2,0,1};
    	int[] prices = {3,3,5,0,0,3,1,4};
//    	int[] prices ={2,1,2,0,1};
//    	int[] prices ={3,2,6,5,0,3};
    	P123_BestTimeToBuyAndSellStock3_2 p =new P123_BestTimeToBuyAndSellStock3_2();
    	System.out.println(p.maxProfit(prices));
    	
    }

}
