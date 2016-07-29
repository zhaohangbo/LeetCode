
public class P221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
    	int len_row = matrix.length;
    	if (len_row == 0)
    		return 0;
    	int len_col = matrix[0].length;
    	
    	int[] left   = new int[matrix[0].length];
    	int[] right  = new int[matrix[0].length];
    	int[] height = new int[matrix[0].length];
    	
    	for(int i =0;i<height.length; i++){
    		left[i]  =0; 
    		right[i] =len_col;
    		height[i]=0;
    	}
    	
    	int maxArea = 0;
    	for(int i = 0; i< len_row;i++){
    		int curRowMaxLeft = 0;
    		int curRowMinRight=len_col;
    		for(int j = 0; j< len_col;j++){
    			if(matrix[i][j]=='1'){
    			   left[j]=Math.max(curRowMaxLeft, left[j]);// 1st means the current row, 2nd means the history in the previous row
    			}
    			else{
    				curRowMaxLeft = j+1;//next head
    				left[j] = 0; //no worry, it won;t be used, because the height here is always 0
    			}
    		}
    		for(int j=len_col-1;j>=0;j--){
    			if(matrix[i][j]=='1'){
    				right[j]=Math.min(curRowMinRight, right[j]);
    			}
    			else{
    				curRowMinRight= j;//one larger than the real boundary, because length is j - i + 1
    				right[j] = len_col;//no worry, it won;t be used, because the height here is always 0
    			}
    		}
    		for(int j = 0; j< len_col;j++){
    			if(matrix[i][j]=='1')
    				height[j]++;
    			else
    				height[j]=0;
    		}
    		for(int j =0;j<height.length;j++){ 
    			int side_len =Math.min( right[j]-left[j], height[j]);
    			maxArea =Math.max(maxArea, side_len*side_len);
    		}
    	}
    	return maxArea;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] matrix = {{'1'}};
//		char[][] matrix = {{'0','0','0'},{'0','0','0'},{'1','1','1'}};
//		["010100",
//		 "001101"]
		char[][] matrix = {{'0','1','0','1','0','0'},{'0','0','1','1','0','1'}};
		System.out.println(new P221_MaximalSquare().maximalSquare(matrix));
	}

}
