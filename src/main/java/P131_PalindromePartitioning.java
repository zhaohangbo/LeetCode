import java.util.ArrayList;
import java.util.List;

public class P131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	backTracking(res,new ArrayList<>(), s, 0);
    	return res;
    }
	
    public void backTracking(List<List<String>> res, List<String> tmpList, String s, int low){
    	if(low==s.length()){//not length-1 
    		res.add(new ArrayList<>(tmpList));
    	}
    	for(int high=low; high<s.length(); high++){
    			if(isPalindrome(s, low, high)){
    				tmpList.add(s.substring( low, high+1));
    				backTracking(res, tmpList, s, high+1);
    				tmpList.remove(tmpList.size()-1);
    			}
    		}
    }
    
    public boolean isPalindrome(String s, int low, int high){
    	while(low<=high){
    		if(s.charAt(low++)!=s.charAt(high--))
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
