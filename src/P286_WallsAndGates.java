import java.util.LinkedList;
import java.util.Queue;

public class P286_WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        int len = rooms.length;
        if (len ==0) return;
        int hei = rooms[0].length;

    	Queue<int[]> q =new LinkedList<int[]>();
    	for(int i =0;i < rooms.length; i++){
    		for(int j=0; j<rooms[0].length; j++){
    			if(rooms[i][j]==0){
    				int[] arr = new int[2]; arr[0] =i; arr[1] =j;
    				q.add(arr);
    			}
    		}
    	}
    	//all gates queue at the head at the beginning 
        while(!q.isEmpty()){
        		int[] pos = q.poll();
        		int i = pos[0]; int j = pos[1];
//        		if(i-1>=0 && rooms[i-1][j]!=0 && rooms[i-1][j]!= -1){ // they're different
        		if(i-1>=0 && rooms[i-1][j]==Integer.MAX_VALUE){
        			if(rooms[i-1][j]>rooms[i][j]+1){
        			   rooms[i-1][j]=rooms[i][j]+1;
        			   q.add(new int[]{i-1,j});
        			}
        		}
        		if(i+1<len && rooms[i+1][j]==Integer.MAX_VALUE){
        			if(rooms[i+1][j]>rooms[i][j]+1){
        			   rooms[i+1][j]=rooms[i][j]+1;
        			   q.add(new int[]{i+1,j});
        			}
        		}
        		if(j-1>=0 && rooms[i][j-1]==Integer.MAX_VALUE){
        			if(rooms[i][j-1]>rooms[i][j]+1){
        			   rooms[i][j-1]=rooms[i][j]+1;
        			   pos[0]=i;pos[1]=j-1;
        			   q.add(new int[]{i,j-1});
        			}
        		}
        		if(j+1<hei && rooms[i][j+1]==Integer.MAX_VALUE){
        			if(rooms[i][j+1]>rooms[i][j]+1){
        			   rooms[i][j+1]=rooms[i][j]+1;
        			   pos[0]=i;pos[1]=j+1;
         			   q.add(new int[]{i,j+1});
        			}
        		}
        }	
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
