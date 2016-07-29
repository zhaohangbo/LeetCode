
public class P304_RangeSumQuery2D_Immutable {
		
		
	  public P304_RangeSumQuery2D_Immutable(int[][] matrix) {
		  //dp[i][j] means the sum of the area from (0,0) to (i,j)
		  if(matrix.length!=0){
			  dp =new int[matrix.length][matrix[0].length];
			  dp[0][0]=matrix[0][0];
			  for(int j=1;j <matrix[0].length;j++){
				  dp[0][j] = dp[0][j-1]+matrix[0][j];
			  }
			  for(int i=1;i <matrix.length;i++){
				  dp[i][0] = dp[i-1][0]+matrix[i][0];
			  }
			  for(int i= 1 ;i< matrix.length ;i++){
				  for(int j=1; j <matrix[0].length ;j++){
					  dp[i][j] = matrix[i][j] + ( dp[i][j-1]+ dp[i-1][j]- dp[i-1][j-1] );
				  }
			  }  
		  }
	  }
	  
	  int[][] dp ;
//    public NumMatrix(int[][] matrix) {
//	  //dp[i][j] means the sum of the area from (0,0) to (i,j)
//	  if(matrix.length!=0){
//		  dp =new int[matrix.length][matrix[0].length];
//		  dp[0][0]=matrix[0][0];
//		  for(int j=1;j <matrix[0].length;j++){
//			  dp[0][j] = dp[0][j-1]+matrix[0][j];
//		  }
//		  for(int i=1;i <matrix.length;i++){
//			  dp[i][0] = dp[i-1][0]+matrix[i][0];
//		  }
//		  for(int i= 1 ;i< matrix.length ;i++){
//			  for(int j=1; j <matrix[0].length ;j++){
//				  dp[i][j] = matrix[i][j] + ( dp[i][j-1]+ dp[i-1][j]- dp[i-1][j-1] );
//			  }
//		  }  
//	  }
//    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (dp ==null)
    		return 0;
    	else if(row1==0 && col1 ==0)
    		return dp[row2][col2];
    	else if(row1==0 && col1 !=0)
    		return dp[row2][col2]-dp[row2][col1-1];
    	else if(row1!=0 && col1 ==0)
    		return dp[row2][col2]-dp[row1-1][col2];
    	else
    		return dp[row2][col2]-(dp[row1-1][col2]+dp[row2][col1-1]-dp[row1-1][col1-1]);
    }
    
    
 // Your NumMatrix object will be instantiated and called as such:
 // NumMatrix numMatrix = new NumMatrix(matrix);
 // numMatrix.sumRegion(0, 1, 2, 3);
 // numMatrix.sumRegion(1, 2, 3, 4);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
