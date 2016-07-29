
public class P256_PaintHouse {
    
	public int minCost(int[][] costs) {
		int len =costs.length;
		if(costs==null||costs.length==0){// Don't forget the special case.
	        return 0;
	    }
		int[] c_red   =new int[len];
		int[] c_blue  =new int[len];
		int[] c_green =new int[len];
		
		//c_red[i] represents the cost of the i-th house which is painted with red color.
		c_red  [0] =costs[0][0];
		c_blue [0] =costs[0][1];
		c_green[0] =costs[0][2];
		
		for(int i=0+1; i<len; i++){
			c_red[i]  = costs[i][0]+Math.min(c_blue[i-1], c_green[i-1]);
			c_blue[i] = costs[i][1]+Math.min(c_red[i-1],  c_green[i-1]);
			c_green[i]= costs[i][2]+Math.min(c_red[i-1],  c_blue[i-1]);
		}
		
		return Math.min(c_red[len-1], Math.min(c_blue[len-1], c_green[len-1]));
    }

	
	public static void main(String[] args){
		int[][] c =new int[3][400];
		System.out.println(c.length);
	}
}
