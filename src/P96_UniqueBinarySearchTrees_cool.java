
public class P96_UniqueBinarySearchTrees_cool {
	
    public int numTrees(int n) {
    	if (n==0) return 0;
    	int[] left =new int[n];
    	int[] right=new int[n];
    	
    	//left[i] represents  the number of possible values on the i-th left child node.
    	//For example, left[0] = 1, means there are (k-1) possiblities at the root node.
    	//			   left[1] = 1*(k-1)
    	//			   right[1]= 1*(n-(k-1))
    	for(int i=1;i<=n;i++){
    		
    	}
    	
    	return 0;
    }
    
    /**
     * Taking 1~n as root respectively:
     *      1 as root: # of trees = F(0) * F(n-1)  // F(0) == 1
     *      2 as root: # of trees = F(1) * F(n-2) 
     *      3 as root: # of trees = F(2) * F(n-3)
     *      ...
     *      n-1 as root: # of trees = F(n-2) * F(1)
     *      n as root:   # of trees = F(n-1) * F(0)
     *
     * So, the formulation is:
     *      F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)
     */

    int numTrees2(int n) {
        int[] F =new int[n+1];
        F[0] = F[1] = 1;
        for (int i=2; i<=n; i++) {//F(i),means the num of Possible Trees when input n values. 
            F[i] = 0;
            for (int j=1; j<=i; j++) {//j, means value from 1 to i
                 F[i] += F[j-1] * F[i-j];// F(n)=Sigma ( (j-1)*F(n-j) ), j from 1 to i
            }
        }
        return F[n];
    }

}
