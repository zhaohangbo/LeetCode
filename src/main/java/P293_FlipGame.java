import java.util.ArrayList;
import java.util.List;

public class P293_FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
    	List<String> res = new ArrayList<String>();
    	for(int i=0;i<s.length()-1;i++){
    		if(s.charAt(i)=='+'&&s.charAt(i+1)=='+'){
    			String ss = s.substring(0,i)+"--"+s.substring(i+1+1);
    			res.add(ss);
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
