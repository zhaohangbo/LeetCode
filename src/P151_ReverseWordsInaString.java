
public class P151_ReverseWordsInaString {

    public String reverseWords(String s) {
    	String[] parts = s.trim().split("\\s+");
    	String out = "";
    	if (parts.length > 0) {
    	    for (int i = parts.length - 1; i > 0; i--) {
    	        out += parts[i] + " ";
    	    }
    	    out += parts[0];
    	}
    	return out;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input ="   a   b ";
//		System.out.println(reverseWords(input));
	}

}
