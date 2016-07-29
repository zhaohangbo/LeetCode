
public class P87_ScrambleString {
    public static boolean isScramble(String s1, String s2) {
    	if(s1.equals(s2))
    			return true;
    	
    	//to judge if s1 and s2 has the same number of different char 'a','b'','c','d'...
    	int[] arr =new int[26];
    	for(int i=0; i<s1.length();i++){
    		arr[s1.charAt(i)-'a']++;
    		arr[s2.charAt(i)-'a']--;
    	}
    	for(int i=0;i<26;i++){
    		if(arr[i] !=0 )
    			return false;
    	}
    	
    	for(int i=1; i <=s1.length()-1 ;i++){
    		if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)) ){
    			return true;
    		}
    		if(isScramble(s1.substring(0,i),s2.substring(s1.length()-i)) && isScramble(s1.substring(i),s2.substring(0,s1.length()-i)) ){
    			return true;
    		}
    	}
    	return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 ="ab";
		String s2 ="ba";
		
		s1 ="ab";
		s2 ="ba";
		s1 ="abb";
		s2 ="bba";
		System.out.println(isScramble(s1,s2));
	}

}
