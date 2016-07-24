
public class P97_InterleavingString {
	
	//Dp
    public boolean isInterleave2(String s1, String s2, String s3) {
    	if((s1.length()+s2.length())!=s3.length())
    		return false;
//    	if(s1.length()==0 && s2.length()==0 && s3.length()==0)
//    		return true;
    	
    	int [][]dp =new int[s1.length()+1][s2.length()+1];
//    	dp[i][j], s1.charAt(i) , s2.charAt(j), if(s3.charAt(i+j) == s1.charAt(i) or s3.charAt(i+j) == s2.charAt(j))
//		0~i of s1 and 0~j of s2, can they form the 0~i+j of s3
    	
    	dp[0][0] =1;//empty s1 && empty s2 to form empty s3, it is true
    	//0 of s1 ;  0~j of s2
    	for(int j=1;j<s2.length()+1;j++){
    		if( s2.charAt(j-1) == s3.charAt(j-1 + 0)){
    			if(dp[0][j-1]==1)
    			   dp[0][j] = 1;
    		}
    	}
    	//0~i of s1 ;  0 of s2
    	for(int i=1;i<s1.length()+1;i++){
    		if( s1.charAt(i-1) == s3.charAt(i-1 + 0)){
    			if(dp[i-1][0]==1)
    			   dp[i][0] = 1;
    		}
    	}
    	
    	for(int i=1;i<s1.length()+1;i++){
    		for(int j=1;j<s2.length()+1;j++){
    			if(s1.charAt(i-1) != s3.charAt(i+j-1) && s2.charAt(j-1) != s3.charAt(i+j-1)){
    				dp[i][j]=0;
    			}
    			else if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) != s3.charAt(i+j-1)){
    				//we only take one more from s1
    				//so if dp[i-1][j]==1 which means without the last i, 0~i-1 s1 and 0~j s2 can form 0~i+j of s3
    				if(dp[i-1][j]==1){
    					dp[i][j]=1;
    				}
    			}    		
    			else if(s2.charAt(j-1) == s3.charAt(i+j-1) && s1.charAt(i-1) != s3.charAt(i+j-1)){
       				//we only take one more from s2
    				if(dp[i][j-1]==1){
    					dp[i][j]=1;
    				}
    			}
    			else if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1)){
    				if(dp[i][j-1]==1 || dp[i-1][j]==1){
    					dp[i][j]=1;
    				}
    			}
    			else{//do nothing
    			}
    		}
       	}
    	
    	return dp[s1.length()][s2.length()]==1;
    }
    
    //Recursive
    public boolean isInterleave(String s1, String s2, String s3) {
    	int l1 =s1.length();int l2 =s2.length();int l3 =s3.length();
    	if(l1+l2 != l3)
    		return false;
    	if(l1==0 && l2==0 && l3==0)
    		return true;
    	if(l1==0)
    		return s2.equals(s3);
    	if(l2==0)
    		return s1.equals(s3);
    	if(l3==0)
    		return (l2==0) && (l1==0) ;
    	if(s1.charAt(l1-1) == s3.charAt(l3-1) && s2.charAt(l2-1) != s3.charAt(l3-1))
    		return  isInterleave(s1.substring(0,l1-1),s2,s3.substring(0,l3-1));
    	else if(s2.charAt(l2-1) == s3.charAt(l3-1) && s1.charAt(l1-1) != s3.charAt(l3-1))
    		return  isInterleave(s1,s2.substring(0,l2-1),s3.substring(0,l3-1));
    	else if(s1.charAt(l1-1) == s3.charAt(l3-1) && s2.charAt(l2-1) == s3.charAt(l3-1))
    		return  isInterleave(s1.substring(0,l1-1),s2,s3.substring(0,l3-1))
    			  ||isInterleave(s1,s2.substring(0,l2-1),s3.substring(0,l3-1));
    	else
    		return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "db";
		String s2 = "b";
		String s3 = "cbb";
//		System.out.println(new P97_InterleavingString().isInterleave2(s1, s2, s3));
		System.out.println(new P97_InterleavingString().isInterleave(s1, s2, s3));
	}

}
