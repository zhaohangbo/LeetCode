
public class P121_BestTimeToBuyAndSellStock1 {
	
	//Idea
	//思想策略：动态规划（Dynamic Programing），适用于：重复子问题(每个子问题类似)
	//解决每一个相似的子问题一次，一旦结果算出将其记忆存储化。
	//下次需要同一个子问题的结果时，直接查表
	
	//结合本题：每一个子Increasing Curve的最大差值(子利润)求解，都是一个相似的子问题。
	//求出每一个子利润，存储化，比较，最终得出Max
	
	//例子：
	//1.斐波那契数列f(n)=f(n-1)+f(n-2)
	//2.背包问题，背包限定重量内，总价值最高。
	//物品i只能放0-1次，0-1背包问题。物品i能放M次，有界背包问题。物品i不限定能放置数量，无界背包问题。
    public int maxProfit(int[] prices) {
        
        int maxProCur   =0;
        int maxProSofar =0;
        
        for(int i = 1; i<prices.length; i++){
        	
        	 maxProCur += prices[i]-prices[i-1];//累加
        	 if(maxProCur<0){
        		 maxProCur =0;//清零，一旦出现一个比起点更低(小)的点，清零(相当于重置起点，清零，重新从零起累加)
        	 }
        	
        	 if(maxProSofar< maxProCur){
        		 maxProSofar =maxProCur;
        	 }
        	
        }

        return maxProSofar;
    }
    
    public static void main(String[] arg){
    	int[] prices = {6,1,3,2,4,7};
    	P121_BestTimeToBuyAndSellStock1 p =new P121_BestTimeToBuyAndSellStock1();
    	
    	System.out.println(p.maxProfit(prices));
    	
    }

}
