
public class P62_UniquePaths {

	//F(m  ,n  ) =1*F(m-1,n)+1*F(m-1,n-1)+1*F(m-1,n-2) + .+1*F(m-1,n-(k-1)).. + 1*F(m-1,n-(n-1))// n choices
	//F(m-1,n  )

	
	//F(3  ,n  )=1*F(2, n ) + 1*F(2,n-1)+1*F(2,n-2) + ..1*F(2,n-(k-1)).. + 1*F(1,n-(n-1))  // n items ,n choices
	//F(2  ,n  )=1*F(1 ,n ) + 1*F(1,n-1)+1*F(1,n-2) + ..1*F(1,n-(k-1)).. + 1*F(1,1)        // n items ,n choices
	
	//==============================================	
	//F(2  ,2  )=1*F(1,2 ) + 1*F(1,1)
	//F(2  ,1  )=1*F(1,1)  //1 choices
	//F(1  ,1  )=1
	
	
	//F(1  ,n  )=1
	//F(m  ,1  )=1
	
	//m down steps , n right steps, m+n  totally
    public int uniquePaths2(int m, int n) {
    	
    	int[][] states =new int[m][n];
    	for(int i=0;i<m;i++){
    		states[i][0]=1;
    	}    
    	for(int j=0;j<n;j++){
    		states[0][j]=1;
    	}   
    	
    	for(int i=1;i< m;i++){
    		for(int j=1;j<n;j++){
    			states[i][j] =states[i-1][j] + states[i][j-1];
    			//states[i-1][j] 比 states[i][j] 少向下一步
    			//states[i][j-1] 比 states[i][j] 少向左一步
    		}
    	}
    	
    	return states[m-1][n-1];
    }
    
    
    public int uniquePaths(int m, int n) {
    	
    	int[][] states =new int[m][n];
    	for(int i=0;i<m;i++){
    		states[i][0]=1;
    	}    
    	for(int j=0;j<n;j++){
    		states[0][j]=1;
    	}   
    	
    	for(int i=1;i< m;i++){
    		for(int j=1;j<n;j++){
    			for(int k=0;k<=j;k++){    				
    				states[i][j] += states[i-1][k];
    			}
    		}
    	}
    	
    	return states[m-1][n-1];
    }
    
    public static void main(String[] args){
    	System.out.println(new P62_UniquePaths().uniquePaths2(3, 3));
    }
    
}
