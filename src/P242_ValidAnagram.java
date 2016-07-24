import java.util.Arrays;

public class P242_ValidAnagram {
	
    public boolean isAnagram(String s, String t) {
    	boolean isAna =true;
    	char[] arr_1 =s.toCharArray();
    	char[] arr_2 = t.toCharArray();
    	
    	if(arr_1.length!=arr_2.length)return false;
    	
    	Arrays.sort(arr_1);
    	Arrays.sort(arr_2);
    	
    	for(int i=0;i<arr_1.length;i++){
    		if(arr_1[i]!=arr_2[i]){
    			isAna=false;
    			break;
    		}
    	}
    	return isAna;
    }
    
    //Most voted
//    public boolean isAnagram(String s, String t) {
//        int[] alphabet = new int[26];
//        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
//        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
//        for (int i : alphabet) if (i != 0) return false;
//        return true;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
