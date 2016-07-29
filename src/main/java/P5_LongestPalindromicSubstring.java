
public class P5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
    	if(s==null || s.isEmpty())
    		return s;
    	
    	int maxLen=-1;
    	String res=null;
    	//odd
    	for(int i=0;i<s.length();i++){
    		String tmp = this.expand(s,i-1,i+1);
    		if(tmp.length()>maxLen){
    			maxLen=tmp.length();
    			res=tmp;
    		}
    		
    	}
    	for(int i=0;i<s.length();i++){
    		String tmp = this.expand(s, i, i+1);
    		if(tmp.length()>maxLen){
    			maxLen=tmp.length();
    			res=tmp;
    		}
    	}
    	return res;
    }
    public String expand(String s, int left,int right){
    	while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
    		left--;
    		right++;
    	}
    	return s.substring(left+1,right);//left+1---right
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
