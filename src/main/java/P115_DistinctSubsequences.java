import java.util.*;

public class P115_DistinctSubsequences {

	
    public int numDistinct(String s, String t) {
    	int s_len =s.length();
    	int t_len =t.length();
    	if(s_len==0 ) return 0;
    	if(t_len==0 ) return 1;
    	
    	int[][] dp = new int[t.length()+1][s.length()+1];
    	for(int ss=0; ss< s.length()+1; ss++){
    		dp[0][ss] = 1 ;//if t is a empty subsequence(has 0 char) , then all subsequences of s will contains t only once
    	}
    	for(int tt=1; tt< t.length()+1; tt++){
    		dp[tt][0] = 0 ;//if s is a empty subsequence(has 0 char) , then all subsequences of s will not contains t
    	}
    	
    	//for each  subsequence of t with tt length(all subsequences begin from the 1st char)
    		//for each subsequence of s with ss length(all subsequences begin from the 1st char)
    			//how many times does sub_s contains sub_t, record the status at dp[tt][ss]
    	for(int tt =1;tt < t.length()+1;tt++){
    		for(int ss=1; ss<s.length()+1;ss++){
    			if(t.charAt(tt-1)==s.charAt(ss-1)){
    				dp[tt][ss]= dp[tt][ss-1]     //how many times does the subsequence of s with length of ss-1 contains the subsequence of t with length of tt
    						   +dp[tt-1][ss-1] ; 
    			//    A  |  B
    			//-----------------
    			// X  m  |     
    			// B  n  | n + m*1 (without B, already has n; add a B to s == add m *(1) )     	
    			}
    			else{
    				dp[tt][ss]= dp[tt][ss-1] ;
    			}
    		}
    	}
    	return dp[t.length()][s.length()];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new P115_DistinctSubsequences().numDistinct("rarabbbit", "rabbit");
//		r   [0,2]
//		a	[1,3]
//		b	[4,5,6]
//		b	[4,5,6]
//		i	[7]
//		t	[8]
		
		
//Example 1: S: [ AcdABefBcAAB] and T: [AB]
//Example 2: S: [ dddd] 		and T: [ddd]
//S = 	   [ AcdABefBcAAB]
//mem[1] = [0111222222344]
//mem[2] = [0000022244448]
		
		 //dddd
	  //d 01234
	  //d 00136
	  //d 00014 
	}

}
