
public class P63_UniquePathsII {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	//Let's consider:
    	//the obstacleGrid[m-1][n-1] as start point
    	//the obstacleGrid[0][0]     as end   point
    	
    	int m =obstacleGrid.length;
    	int n =obstacleGrid[0].length;
    	
    	if(obstacleGrid[0][0]==1) // end is bloked
    		return 0;
    	if(obstacleGrid[m-1][n-1]==1) // start is bloked
    		return 0;
    	
    	//states[i][j], means --> F(i,j), the number of uniquePaths when input i rows and j columns grid.
    	int[][] states  = new int[m][n];
    	
    	//initialize the states, when the input grid is only 1 column, states[i][0]
        for(int i=0;i<m;i++){
        	if(obstacleGrid[i][0]==0){
        		states[i][0]=1;
        	}
        	else {
        	   break;//if obstacleGrid[k][0]==1, then the states[i>k][0] will be all blocked and has no path
			}
	    }
        //initialize the states, when the input grid is only 1 row, states[0][j]
	    for(int j=0;j<n;j++){
	        if(obstacleGrid[0][j]==0){
	        	states[0][j]=1;
	        }
	        else {
				break;//if obstacleGrid[0][k]==1, then the states[0][j>k] will be all blocked and has no path
			}
	    }
    	
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			if(obstacleGrid[i-1][j]==1 && obstacleGrid[i][j-1]==0 ){
    				states[i][j]=states[i][j-1];
    			}
    			else if(obstacleGrid[i-1][j]==0 && obstacleGrid[i][j-1]==1){
    				states[i][j]=states[i-1][j];
    			}
    			else if(obstacleGrid[i-1][j]==0 && obstacleGrid[i][j-1]==0){
    				states[i][j]=states[i-1][j]+states[i][j-1];
    			}
    			else{
    				states[i][j] = 0;
    			}
    		}
    	}
    	
    	return states[m-1][n-1];
    }

    
    
    
    public static void main(String[] aergs){
    	int[][] obstacleGrid ={{0,0},
    			               {1,1},
    			               {0,0}};
    	System.out.println(new P63_UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }
}
