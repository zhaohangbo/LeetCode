
public class P265_PaintHouse2 {
	//states[i][j] =  在i-1的房子中，k!=j种颜色 取最小的
	//
	//
	
	   //solve it in O(nk) runtime
	   public int minCostII(int[][] costs) {
	    	
	    	int m =costs.length;
	    	if(m==0)return 0;
	    	
	    	int n =costs[0].length;
	    	if(m==1 && n==1)return costs[0][0];
	    	
	    	int[][] states =new int[m][n];
	    	//states[i][j], means minimum cost to paint the i-th house with the j-th color.    	
	    	int minPrev  =Integer.MAX_VALUE;
	    	int minPrev2 =Integer.MAX_VALUE;
	    	int j_prev =-1;
	    	int minCur  =Integer.MAX_VALUE;
	    	int minCur2 =Integer.MAX_VALUE;
	    	int j_cur =-1;
	    	for(int i=0;i<m;i++){
	    		for(int j=0;j<n;j++){
	    			if(i==0){
	    				states[0][j] = costs[0][j];
	    						//if minPre found at first time, then minPre2 will be Integer.Max
	    						//So, use else if to find the minPre2 in the rest sequence
	    						//if minPre not found at first time, then everyting will be fine just in if()
			    				if(minPrev>states[i][j]){
			    				   minPrev2 =minPrev;
			    				   minPrev=states[i][j];
			    				   j_prev =j;
			    				}
			    				else if(minPrev2>states[i][j]){
			    					minPrev2=states[i][j];
			    				}
	    			}
	    			else{
	    				if(j==j_prev){
	    				   states[i][j] = minPrev2+costs[i][j];
	    				}
	    				else{
	    				   states[i][j] = minPrev+costs[i][j];
	    				}
			    				if(minCur>states[i][j]){
			    					minCur2=minCur;
			    					minCur =states[i][j];
			    					j_cur  = j;
			    				}
			    				else if(minCur2>states[i][j]){
			    					minCur2=states[i][j];
			    				}
	    			}
	    		}
	    		
	    	
	    		if(i!=0){
	    			minPrev  = minCur;
	    			minPrev2 = minCur2;
	    			j_prev   = j_cur;
	    			
	    	    	minCur  =Integer.MAX_VALUE;
	    	    	minCur2 =Integer.MAX_VALUE;
	    	    	j_cur =-1;
	    		}
	    			
	    		
	    	}
	    	return minPrev;
	    }
	
	
	
	
	   //Time complexity is High
	   public int minCostII2(int[][] costs) {
	    	
	    	int m =costs.length;
	    	if(m==0)return 0;
	    	
	    	int n =costs[0].length;
	    	if(m==1 && n==1)return costs[0][0];
	    	
	    	int[][] states =new int[m][n];
	    	//states[i][j], means minimum cost to paint the i-th house with the j-th color.    	
	    	
	    	for(int i=0;i<m;i++){
	    		for(int j=0;j<n;j++){
	    			if(i==0){
	    				states[0][j] = costs[0][j];
	    			}
	    			else{
	    				states[i][j] = getMin(states[i-1],j)+costs[i][j];
	    			}
	    		}
	    	}
	    	
	    	return getMin(states[m-1], -1);
	        
	    }
	    
	    public int getMin(int[] arr,int color_at_j){
	    	int min =Integer.MAX_VALUE;
	    	for(int i=0;i<arr.length;i++){
	    		if(i==color_at_j){
	    			continue;
	    		}
	    		if(min>arr[i]){
	    			min =arr[i];
	    		}
	    	}
	    	return min;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs ={{20,19,11,13,12,16,16,17,15,9,5,18}
		               ,{3,8,15,17,19,8,18,3,11,6,7,12}
		               ,{15,4,11,1,18,2,10,9,3,6,4,15}};
		System.out.println(new P265_PaintHouse2().minCostII(costs));
	}

}
