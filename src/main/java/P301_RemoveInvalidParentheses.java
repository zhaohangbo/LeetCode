import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P301_RemoveInvalidParentheses {
	
		//BFS
	    public List<String> removeInvalidParentheses(String s) {
	      List<String> res = new ArrayList<>();
	      if (s == null) return res;
	      Set<String> visited = new HashSet<>();
	      Queue<String> queue = new LinkedList<>();

	      queue.add(s);
	      visited.add(s);
	      boolean found = false;
	      while (!queue.isEmpty()) {
	        s = queue.poll();
	        if (isValid(s)) {
	          res.add(s);// found an answer, add to the result
	          found = true;
	        }
	        if (found) continue;//Must use continue, because might be several results within the same level

	        //all possible states in next level
	        for (int i = 0; i < s.length(); i++) {
	          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
	          //Must use a new String t to keep String s unchanged.
	          String t = s.substring(0, i) + s.substring(i + 1);
	          if (!visited.contains(t)) {
	            // for each state, if it's not visited, add it to the queue
	            queue.add(t);
	            visited.add(t);
	          }
	        }
	      }
	      return res;
	    }
	    
	    // helper function checks if string s contains valid parantheses
	   private boolean isValid(String s) {
	      int count = 0;
	      for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == '(') count++;
	        //if (c == ')' && count-- == 0) return false;
	        if (c == ')' ) {
	        	if(count == 0) return false;
	        	count --;
	        }
	      }
	      return count == 0;
	    }
    
	   //DFS
	   public List<String> removeInvalidParentheses_DFS(String s) {
		    Set<String> res = new HashSet<>();
		    int rmL = 0, rmR = 0;
		    for(int i = 0; i < s.length(); i++) {
		        if(s.charAt(i) == '(') rmL++;
		        if(s.charAt(i) == ')') {
		            if(rmL != 0) rmL--;
		            else rmR++;
		        }
		    }
		    DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
		    return new ArrayList<String>(res);  
		}
	    //Scan from left to right, avoiding invalid strs (on the fly) by checking num of open parens.
	    //if open < 0, means more ')' than '(' in the prefix, 
	    //if open >=0, the prefix valid, 
		public void DFS(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
		    if(i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
		        res.add(sb.toString());
		        return;
		    }
		    if(i == s.length() || rmL < 0 || rmR < 0 || open < 0) return;

		    char c = s.charAt(i);
		    int len = sb.length();
		    if(c == '(') {
		        DFS(res, s, i + 1, rmL - 1, rmR, open, sb);
		        DFS(res, s, i + 1, rmL, rmR, open + 1, sb.append(c)); 
		    } else if(c == ')') {
		        DFS(res, s, i + 1, rmL, rmR - 1, open, sb);
		        DFS(res, s, i + 1, rmL, rmR, open - 1, sb.append(c));
		    } else {
		        DFS(res, s, i + 1, rmL, rmR, open, sb.append(c)); 
		    }
		    sb.setLength(len);
		}
	   
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="(()(()";
		s= new StringBuilder(s).reverse().toString();
		System.out.println(s);
	}
}
