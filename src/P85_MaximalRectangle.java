
public class P85_MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
    	int l_row = matrix.length;
    	if(l_row==0)
    		return 0;
    	int l_col = matrix[0].length;
    	int left[]   = new int[l_col];//at column j, the min left  index 
    	int right[]  = new int[l_col];//at column j, the max right index
    	int height[] = new int[l_col];//at column j, the max height
    	
    	for(int i = 0 ;i<l_col ;i++){
    		left[i] = 0;
    		right[i]=l_col;
    		height[i]=0;
    	}
    	int maxArea =0 ;
    	for(int i=0;i <l_row;i++){
        	int curRowMaxLeft=0;      //think why should I put this inside , it's for each row
        	//Notice: this is 1 larger than the real right boundary index,becuse the length is (right -left + 1)
        	int curRowMinRight= l_col;//think why should I put this inside , it's for each row
    		for(int j=0;j<l_col;j++){
    			//Left
    			if(matrix[i][j]=='1')
    				left[j]= Math.max(curRowMaxLeft, left[j]);
    			else{
    				left[j] =0;
    				curRowMaxLeft=j+1;
    			}
    			//Right
    			int jj = l_col-1-j;
    			if(matrix[i][jj]=='1')
    				right[jj]= Math.min(curRowMinRight, right[jj]);
    			else{
    				right[jj]=l_col;
    				curRowMinRight=jj;//record where matrix[i][jj]=='0', which 1 larger than the real right boundary
    			}
    			//Height
    			if(matrix[i][j]=='1')
    				height[j]++;
    			else
    				height[j]=0;
    			//Can not put it inside this for 
    			//maxArea = Math.max(maxArea, (right[j]-left[j])*height[j] );
    		}
    	}
		for(int k =0 ; k<height.length ;k++){
			maxArea = Math.max(maxArea, (right[k]-left[k])*height[k] );
		}
    	return maxArea;
    }
    
//    0 1 1 0 1 1 1
//    1 1 1 1 1 0 1
//    0 1 1 1 1 1 1
//    1 1 1 1 1 1 1
    
//dp       
//    0 1 2 2 2 2 3
//    1 2 4 4 5 5  
//    1 3 
//    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] matrix = {{'1','0'}};
		System.out.println(new P85_MaximalRectangle().maximalRectangle(matrix));

	}

}
