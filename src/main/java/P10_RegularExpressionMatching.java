
public class P10_RegularExpressionMatching {
	
//	isMatch("aa","a")   	→ false
//	isMatch("aa","aa")  	→ true
//	isMatch("aaa","aa") 	→ false
//	isMatch("aa", "a*") 	→ true
//	isMatch("aa", ".*") 	→ true
//	isMatch("ab", ".*") 	→ true
//	isMatch("aab", "c*a*b") → true
	
//	class Solution {
//		public:
//		    bool isMatch(string s, string p) {
//		        if (p.empty())    return s.empty();
//
//		        if ('*' == p[1])
//		            // x* matches empty string or at least one character: x* -> xx*
//		            // *s is to ensure s is non-empty
//		            return (isMatch(s, p.substr(2)) || !s.empty() && (s[0] == p[0] || '.' == p[0]) && isMatch(s.substr(1), p));
//		        else
//		            return !s.empty() && (s[0] == p[0] || '.' == p[0]) && isMatch(s.substr(1), p.substr(1));
//		    }
//		};
	
	
	//!!!!
	//s.subString(i,j) ,if j > s.length ,then return empty str.
	//!!!!
	public boolean isMatch(String s, String p) {
		//s.length >= p.length
		if(p.isEmpty()) return s.isEmpty();
		//length ==1
		if(p.length()==1){
			return !s.isEmpty() && (s.charAt(0)==p.charAt(0)||'.'==p.charAt(0) )&& isMatch(s.substring(1),"");
		}
		//length >=2
		if(p.charAt(1) == '*'){
		    return   !s.isEmpty() && s.charAt(0)==p.charAt(0)  && isMatch(getSubString(s,1),p)
		    	  || !s.isEmpty() && p.charAt(0)=='.' 		   && isMatch(getSubString(s,1),p)
				  || isMatch(s,getSubString(p,2));
		}
		else{
			return   !s.isEmpty() && s.charAt(0)==p.charAt(0)  && isMatch(getSubString(s,1), getSubString(p,1))
				  || !s.isEmpty() && p.charAt(0)=='.'		   && isMatch(getSubString(s,1), getSubString(p,1));
		}
	}
	
	public String getSubString(String str , int begin){
		if(begin>str.length())
			return "";
		else
			return str.substring(begin);
	}
	
    public boolean isMatch2(String s, String p) {
    	int p2 = -1;  //where '*' located, to separate the p
    	int p1 = -1;  
    	
    	for(int i=1;i<p.length();i++){
    		if(p.charAt(i)=='*'){
    			p2=i;
    			break;
    		}
    	}
    	
    	if(p2!=-1 && p2!=p.length()-1){//if p contains '*' and '*' is not the last position
    		//1.  p.subString(0,p2+1) match s.subString(0,p1)
    		//2.  p.subString(p2+1)   match p.subString(p1)	
    		int len = p.length() - (p2+1) ;  //exclude position p2, so
    		p1   = s.length() - len;	
    	  
    		return isMatch(s.substring(0,p1),p.substring(0,p2+1))
    			&& isMatch(s.substring(p1),p.substring(p2+1));
    	}
    	else if(p2 == p.length()-1){//else if p contains '*' but '*' is the last position
    		if(p.charAt(p2-1)=='.'){
    			//   s:XXXXXXXX    p:XXX   .   *
    			//	   0 ~ p2-1	     0 ~ p2-1  p2
    			return isMatch(s.substring(0,p2-1),p.substring(0,p2-1));
    		}
    		else{
    			//Case 1   s:ABCP XX 		  p:GHFFFT XXXXXXXXXXXXX*
    			//    	   0 ~  i             0  ~   j
    			//Case 2   s:ABCP XXXXXXXXXX  p:GHFFFT XXX*
    			//	       0 ~  i             0  ~   j
    			int i=s.length()-1;
    			int j=p2-1;
    			while(i>=0 && j>=0 && s.charAt(i)==p.charAt(p2-1) && p.charAt(j)==p.charAt(p2-1)){
    				i--;
    				j--;
    			}
    			//i,j means the index where they are different for the first
    			if(s.charAt(i)== p.charAt(p2-1)){//Case 2
    				while(i>=0 && s.charAt(i)==p.charAt(p2-1)){
    					i--;
    				}
    				return isMatch(s.substring(0,i+1), p.substring(0,j+1));
    			}
    			else if(p.charAt(j)== p.charAt(p2-1)){//Case 1
    				return false;
    			}
    			else{
    				return isMatch(s.substring(0,i+1), p.substring(0,j+1));
    			}
    		}
    	}
    	else{//else p doesn't contains '*'
    		if(s.length()!=p.length())
    			return false;
    		boolean isMatch =true;
    		for(int i=0;i<s.length();i++){
    			if(s.charAt(i)!=p.charAt(i) && p.charAt(i)!='.'){
    				isMatch =false;
    			}
    		}
    		return isMatch;
    	}
    }
	
    
    
//	for(int p2=1;p2<p.length();p2++){
//		
//		if(p.charAt(p2)=='*'){
//		//1.  p.subString(0,p2+1) match s.subString(0,p1)
//			  boolean b1 = true;
//		//2.  p.subString(p2+1)   match p.subString(p1)	
//			  boolean b2 = false;
//			int len = p.length() - (p2+1) ;  //exclude position p2, so
//			int p1  = s.length() - len;
//			
//			//1.  p.subString(0,p2+1) match s.subString(0,p1)
//			if(p.charAt(p2-1)=='.')
//				b1 =true;
//			else{
//				for(int i =0;i<p1;i++){
//					if(s.charAt(i) != p.charAt(p2-1)){
//						b1 =false;
//					}
//				}
//			}
//			//2.  p.subString(p2+1)   match p.subString(p1)	
//			b2 = isMatch(s.substring(p1),p.substring(p2+1));
//			return b1 && b2;
//		}
//		else{
//			return true;
//		}
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="a";
		System.out.println(s.substring(999));
	}

}
