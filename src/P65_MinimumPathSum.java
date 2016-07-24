import java.lang.Thread.State;

public class P65_MinimumPathSum {
	
    public int minPathSum(int[][] grid) {
    	int m =grid.length;
    	int n =grid[0].length;
    	if(m==0 && n==0){
    		return 0;
    	}
    	if(m==1 && n==1){
    		return grid[0][0];
    	}
    	int[][] states =new int[m][n];
    	
//    	grid[0][0]     destination
    	states[0][0]   = grid[0][0];
//    	grid[m-1][n-1] start point
    	
    	//left down
    	//down left
    	
    	//down
    	//left
    	
    	//
    	//
    	for(int i =0;i<m;i++){//i works in horizontal
    		for(int j = 0;j<n;j++){//j works in vertical
    			if(i==0 && j==0){
    			}
    			else if(i==0 && j!=0){ //means at the bottom border
    				states[i][j] =  states[i][j-1]+grid[i][j];
    			}
    			else if(j==0 && i!=0){ // means at the right border
    				states[i][j] =  states[i-1][j]+grid[i][j];
    			}
    			else{    				
    				states[i][j] = Math.min(states[i-1][j]+grid[i][j], states[i][j-1]+grid[i][j]);
    			}
    		}
    	}
    	
    	return states[m-1][n-1];
    }
    
    public static void main(String[] args){
    	int[][] grid ={{1,3,1},
    			       {1,5,1},
    			       {4,2,1}};
    	System.out.println(new P65_MinimumPathSum().minPathSum(grid));
    }
    
}
