
public class P329_LongestIncreasingPathInaMatrix {
	
	//https://leetcode.com/discuss/81389/15ms-concise-java-solution
	//1.Do DFS from every cell
	//2.Compare every 4 direction and skip cells that are out of boundary or smaller
	//3.Get matrix max from every cell's max
	//4.Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
	//5.The key is to cache(dp[i][j]) the max distance because it's highly possible to revisit a cell
	
	int[][] dp ;// recording the max Path Length at [i][j]
	int m=0;int n=0;
	int[][] moves ={{-1,0},{0,1},{1,0},{0,-1}}; 
    public int longestIncreasingPath(int[][] matrix) {
    	if(matrix==null || matrix.length==0) return 0;
    	m=matrix.length;  n=matrix[0].length;
    	dp =new int[m][n];
    	
    	int max = 1;
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			max= Math.max(max, dfs(i,j,dp,matrix));
    		}
    	}
    	return max;
    }
    
	//return the maxLen
    //2 cases;
    //has no increasing path, return 1;
    //has a increasing path , return 1+dp[x][y];where dp[x][y]!=0
    public int dfs(int i, int j,int[][] dp,int[][] matrix){
    	if(dp[i][j] !=0) return dp[i][j];//!!!
    	int max = 1;
    	for(int[] move : moves ){
    		int x = i+move[0]; int y =j+move[1];
    		if(x<0||x>=m || y<0||y>=n || matrix[x][y] <= matrix[i][j]) continue;
    		int len  = 1 + dfs(x,y, dp,matrix);
    		max = Math.max(max, len);
    	}
    	dp[i][j] = max;
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
