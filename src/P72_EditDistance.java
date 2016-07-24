
public class P72_EditDistance {
	
	//convert word1 to word2
    public int minDistance(String word1, String word2) {
    	if(word1.length()==0)
    		return word2.length();
    	if(word2.length()==0)
    		return word1.length();
    	int [][] dp =new int[word1.length()+1][word2.length()+1]; 
    	
    	for(int j=0;j<word2.length()+1;j++){
			//(empty word1) to word2 with length j
			dp[0][j]= j;
    	}
		for(int i =0 ;i< word1.length()+1;i++){
			//(word2 with length i ) to empty word1 
			dp[i][0] = i;
		}
    	
    	for(int i=1; i<word1.length()+1; i++){
    		for(int j=1; j<word2.length()+1; j++){
    			if(word1.charAt(i-1)==word2.charAt(j-1)){
    				dp[i][j] = dp[i-1][j-1];//because word1[i] == word2[j],
    			}
    			else{
    				//replace word2[j] with word1[i]
    				int replace = dp[i-1][j-1] + 1;// 1 operation of replace
    				//delete  word1[i]
    				int delete = dp[i-1][j] +1;
    				//insert  word2[j]
    				int insert = dp[i][j-1] +1;
    		
    				dp[i][j] = Math.min(replace, Math.min(delete, insert));
    			}
    		}
    	}
    	return dp[word1.length()+1-1][word2.length()+1-1];   
    }
    //   b c
    //a  1 2
    //b  1 2

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
