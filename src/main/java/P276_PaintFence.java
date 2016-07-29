
public class P276_PaintFence {
	
	 public int numWays(int n, int k) {
		    if (n == 0 || k == 0) return 0;
		    if (n == 1) return k;
		    // same[i] means the ith post has the same color with the (i-1)th post.
		    int[] same = new int[n];
		    // diff[i] means the ith post has a different color with the (i-1)th post.
		    int[] diff = new int[n];
		    same[0] = k;
		    same[1] = 1*same[0];
		    diff[0] = k;
		    diff[1] = (k - 1)*diff[0];
		    for (int i = 2; i < n; ++i) {
		        same[i] = 1 * diff[i-1] ;							 //Dynamic Dynamic Dynamic
		        diff[i] = (k - 1) * diff[i-1] + (k - 1) * same[i-1] ;//Dynamic Dynamic Dynamic
		    }
		    return same[n-1] + diff[n-1];
	}

    
    public int numWays2(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }
    
    public int numWays3(int n,int k) {
	    if (n == 0 || k == 0) return 0;
	    if (n == 1) return k;
	    
    	int[] same =new int[n];
    	int[] diff =new int[n];
    	same[0] =k;
    	same[1] =1*k;
    	diff[0] =k;
    	diff[1] =(k-1)*k;
    	
    	for(int i=2;i<n;i++){
    		same[i] = 1* diff[i-1];
    		diff[i] = (k-1)*diff[i-1]+(k-1)*same[i-1];
    	}
    	int finalStatus_same =same[n-1];
    	int finalStatus_diff =diff[n-1];
    	return finalStatus_same + finalStatus_diff;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
