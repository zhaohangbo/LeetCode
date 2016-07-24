
public class P311_SparseMatrixMultiplication {

	//2 sparse matrices, so if calculate directly, time will exceed
    public int[][] multiply_exceed(int[][] A, int[][] B) {
    	if(A==null || B== null) return null;
    	if(A.length==0 || A[0].length==0) return null;
    	if(B.length==0 || B[0].length==0) return null;
    	int[][] res =new int[A.length][B[0].length];
    	
    	for(int i=0;i<A.length;i++){
    		for(int j=0;j<B[0].length;j++){
    			for(int k=0;k<A[0].length;k++)
    				res[i][j] += A[i][k]*B[k][j];
    		}
    	}
    	return res;
    }
	
    //A sparse matrix can be represented as a sequence of rows, 
    //each of rows is a sequence of (column-number, value) pairs of the nonzero values in the row.
    public int[][] multiply(int[][] A, int[][] B) {
    	if(A==null || B== null) return null;
    	if(A.length==0 || A[0].length==0) return null;
    	if(B.length==0 || B[0].length==0) return null;
    	int[][] res =new int[A.length][B[0].length];
    	
    	for(int Am=0;Am<A.length;Am++){
    		for(int An=0;An<A[0].length;An++){
    			if(A[Am][An]!=0){
    				for(int Bn=0;Bn<B[0].length;Bn++){
    					if(B[An][Bn]!=0)
    						res[Am][Bn] += A[Am][An] * B[An][Bn];
    				}
    			}
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
