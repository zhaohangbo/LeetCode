
public class P200_NumberofIslands {
	//My Solution
    public int numIslands(char[][] grid) {
        if(grid ==null||grid.length==0||grid[0].length==0)
        	return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
    	int count =0;
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(grid[i][j]=='1' && !visited[i][j]){//land , not visited
    				markIsland(i,j,grid,visited);
    				count++;
    			}
    		}
    	}
    	return count;
    }
    public void markIsland(int i, int j, char[][] grid,boolean[][] visited){
    	visited[i][j]= true;
    	if(i-1>=0 && grid[i-1][j]=='1' &&!visited[i-1][j] )
    		markIsland(i-1,j,grid,visited);
    	if(i+1<visited.length && grid[i+1][j]=='1' && !visited[i+1][j])
    		markIsland(i+1,j,grid,visited);
    	if(j-1>=0 && grid[i][j-1]=='1'&& !visited[i][j-1])
    		markIsland(i,j-1,grid,visited);
    	if(j+1<visited[0].length && grid[i][j+1]=='1'&& !visited[i][j+1])
    		markIsland(i,j+1,grid,visited);
    }
    
    //BAOZI Training's
    
    public final int[] xDimension ={-1,0,1,0};
    public final int[] yDimension ={0,-1,0,1};
    public int numIslands2(char[][] grid) {
        if(grid ==null||grid.length==0||grid[0].length==0) return -1;

        
        boolean[][] visited = new boolean [grid.length][grid[0].length];
        int count=0;
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(shouldExplore(i,j,grid,visited)){
    				
    			}
    		}
    	}
        
    	return count;
    }
    public void explore(int i,int j,char[][] grid,boolean[][] visited){
    	
    }
    public boolean shouldExplore(int i,int j,char[][] grid,boolean[][] visited){
    	if(grid[i][j]=='1' && !visited[i][j])
    		return true;
    	return false;
    }
    
    public static void testGan(boolean[][] visited){
    	for(int i=0;i<visited.length;i++){
    		for(int j=0;j<visited[0].length;j++){
    			visited[i][j]=true;
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] visited ={{false,false},{false,false}};
		testGan(visited);
    	for(int i=0;i<visited.length;i++){
    		for(int j=0;j<visited[0].length;j++){
    			System.out.println(visited[i][j]);
    		}
    	}
	}

}
