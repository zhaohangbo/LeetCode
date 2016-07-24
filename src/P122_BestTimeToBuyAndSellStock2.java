
public class P122_BestTimeToBuyAndSellStock2 {
	
	//Idea 
	//思想策略：贪婪算法，适用于最有子结构问题（子问题最优==总问题最优）
	//结合本题：总利润最大，只需每次子交易的利润最大(每一个单调增曲线的最大差值),最终累加每个子利润，总利润最大。
	
	//贪婪算法Vs动态规划
	//http://www.cnblogs.com/batys/p/3322553.html
	//这篇博客中的倒三角问题很棒！背下来！动态规划和贪婪的区别！！
	//贪婪算法，对每一个子问题做出选择，不能回退。
	//动态规划，则保存以前运算结果，并根据以前运算结果对当前做出选择决策，能够回退。
	
	
	//Idea:
	
	//sum the profits of every seperated incresing curve !
	
    public int maxProfit(int[] prices) {
        
        int curPro =0;
        int maxPro_ShortCur =0;
        int sumPro =0;
        
        for(int i = 1; i<prices.length; i++){
        	
        	if(prices[i]- prices[i-1] >=0){//increasing
        		curPro += prices[i]- prices[i-1];
        	}
        	if(prices[i] - prices[i-1] <0){//decreasing，reset start point for the next increaseing
        		curPro = 0;        		
        	}
        	
        	if(maxPro_ShortCur<curPro){
        		maxPro_ShortCur =curPro;   //maxProfit for each Short increasing Curve
        	}
        	
        	if(i==prices.length-1 || curPro==0){//when a increasing curve ends，sumPro && reset maxP=0
        		sumPro += maxPro_ShortCur;
        		maxPro_ShortCur =0;
        	}
        	
        }

        return sumPro;
    }
    
    public int maxProfit2_simplified(int[] prices) {
        
        int curPro =0;
        int sumPro =0;
        
        for(int i = 1; i<prices.length; i++){
        	
        	
        	if(prices[i]- prices[i-1] >=0){//increasing
        		curPro += prices[i]- prices[i-1];
        	}
        	
        	if(i==prices.length-1 || prices[i] - prices[i-1]<0){//when a increasing curve ends,sum and reset curPro to 0!
        														//Only when finish array or begin to decrease
        		
        		sumPro += curPro; //when deceasing, curPro always 0, until increaing occurs.
        		curPro =0;
        	}
        	
        }

        return sumPro;
    }
    
    

    public static void main(String[] arg){
    	int[] prices = {6,1,3,2,4,7};
    	P122_BestTimeToBuyAndSellStock2 p =new P122_BestTimeToBuyAndSellStock2();
    	
    	System.out.println(p.maxProfit(prices));
    	
    }
}
