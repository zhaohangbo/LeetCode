import java.util.HashMap;

public class P3_LongestSubstringWithoutRepeatingCharacters {

	//Most Voted
	public int lengthOfLongestSubstring(String s) {
	        if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int max=0;
	        for (int i=0, j=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	                j = Math.max(j,map.get(s.charAt(i))+1);
	            }
	            map.put(s.charAt(i),i);
	            max = Math.max(max,i-j+1);
	        }
	        return max;
	}
	
    public int lengthOfLongestSubstring_mine(String s) {
    	if (s.length()==0) return 0;
    	HashMap<Character,Integer> map =new HashMap<Character,Integer>();
    	int max = 0;
    	//"tmmzuxt"
    	//"abba"
    	char[] arr =s.toCharArray();
    	for(int i=0, p1=0;i<arr.length;i++){
    		if(map.containsKey(arr[i])){
    		   p1=Math.max(map.get(arr[i])+1,p1);//pay attention '+1' here, means next of the repeated char
    		}
    		map.put(arr[i], i);
    		max =Math.max((i+1)-p1, max);
    	}
    	return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
