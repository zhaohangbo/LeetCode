
public class P171_ExcelSheetColumnNumber {

//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
	
    public int titleToNumber(String s) {
    	int res = 0;
    	for(int i=0;i<s.length();i++){
    		char c =s.charAt(i);
    		res *=26;
    		res +=c-'A'+1;
    	}
    	return res;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
