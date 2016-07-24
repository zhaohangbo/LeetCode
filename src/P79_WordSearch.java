
public class P79_WordSearch {
	
	
    public boolean exist(char[][] board, String word) {
    	if(board==null||board.length==0||board[0].length==0||word==null||word.length()==0)return false;
    	
    	boolean[][] visited = new boolean[board.length][board[0].length];
    	
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board[0].length ; j++){
    			//Do DFS
    			if(dfsHelper(board,0,i,j,visited,word))
    				return true;
    		}
    	}
    	return false;
    }

    public boolean dfsHelper(char[][] board,int index ,int i, int j, boolean[][] visited, String word) {
    	if(index==word.length())//not length - 1, 
    		return true;//base case
    	
    	if(!(i>=0&&i<board.length&&j>=0&&j<board[0].length))
    		return false;
    	
    	if(visited[i][j]==true || word.charAt(index)!=board[i][j])
    		return false;
    	
    	visited[i][j] = true;
    	boolean shoudExplore = dfsHelper(board,index+1,i+1,j,visited,word) ||
    						   dfsHelper(board,index+1,i-1,j,visited,word) ||
    						   dfsHelper(board,index+1,i,j+1,visited,word) ||
    						   dfsHelper(board,index+1,i,j-1,visited,word) ;
    	visited[i][j] = false;
    	return shoudExplore;
    }
}
