
public class P168_ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
    	if(n<=0) return null;
    	StringBuilder sb =new StringBuilder();
    	while(n!=0){
    		//n=1 -->(1-1) %26=0 -->'A'
    		//n=26-->(26-1)%26=25-->'Z', (26-1)/26==0
    		//n=27-->(27-1)%26=0
    		sb.append(converIntToChar((n-1)%26));
    		n=(n-1)/26;
    	}
    	return sb.reverse().toString();
    }
    
    public char converIntToChar(int n){
    	char res = 'A' ;
    	res += n;
    	return res;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
