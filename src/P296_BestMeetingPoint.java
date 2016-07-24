
import java.util.Collections;
import java.util.Vector;

public class P296_BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
    	Vector<Integer> v_x =new Vector<Integer>(); 
    	Vector<Integer> v_y =new Vector<Integer>(); 
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(grid[i][j]!=0){
    				v_x.add(i);
    				v_y.add(j);
    			}
    		}
    	}
    	
    	if(v_x.size()==0){
    		return 0;
    	}
    	if(v_x.size()==1){
    		return 0;
    	}
    	
    	return getMin(v_x)+getMin(v_y);
    }
	
    private int getMin(Vector<Integer> vector){
    	Collections.sort(vector);
    	int i =0;int j=vector.size()-1;
    	int dis =0;
    	while(i<j){
    		dis += vector.get(j)- vector.get(i);
    		i++;
    		j--;
    	}
    	return dis;
    }
	
	public static void main(String[] args) {
		int[][] grid ={{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(new P296_BestMeetingPoint().minTotalDistance(grid));
	}

}
