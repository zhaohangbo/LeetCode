import java.util.Iterator;
import java.util.Stack;

public class P32_LongestValidParentheses {
	
    public int longestValidParentheses(String s) {
    	if(s.length()==0)
    		return 0;
    	//push index into st  		
    	Stack<Integer> st =new Stack<Integer>();
    	for(int i=0;i<s.length();i++){
    		char c = s.charAt(i);
    		if(st.isEmpty())
    			st.push(i);
    		else{
    			
    			if(c=='(')
    				st.push(i);
    			else{
    				//!!!!!!!!!!!!!!
    			   if(s.charAt(st.peek())=='(')
    				  st.pop();
    			   else
    				   st.push(i);
    			}
    		}
    	}
    	
//    	if (st.isEmpty())
//    		return s.length();
    	int maxLen = 0 ;
    	int end = s.length();
    	int head= 0;
    	
    	while(!st.isEmpty()){
    		head = st.pop();
    		maxLen = Math.max(maxLen,end - head - 1);//here -1, because we should delete position of the index
    		end =head;
    	}
    	//index = length - 1
    	maxLen = Math.max(maxLen,end - 0);
        return maxLen;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="())";
		s="())";
//		s=")(";
		s="()(()()())";
		System.out.println(new P32_LongestValidParentheses().longestValidParentheses(s));
	}

}
