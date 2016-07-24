
public class P67_AddBinary {

    public String addBinary(String a, String b) {
    	int i= a.length()-1;
    	int j= b.length()-1;
    	StringBuilder  sb =new StringBuilder();

    	int carry=0;
    	while(i>=0 && j>=0){
    		int aDigit = a.charAt(i)=='0'?0:1;
    		int bDigit = b.charAt(j)=='0'?0:1;
    		sb.append((aDigit+bDigit+carry)%2);
    		carry= (aDigit+bDigit+carry)/2;
    		i--;
    		j--;
    	}
    	
    	while(i>=0){
    		int aDigit = a.charAt(i)=='0'?0:1;
    		sb.append((aDigit+carry)%2);
    		carry= (aDigit+carry)/2;
    		i--;
    	}
    	while(j>=0){
    		int bDigit = b.charAt(j)=='0'?0:1;
    		sb.append((bDigit+carry)%2);
    		carry= (bDigit+carry)/2;
    		j--;
    	}
    	if(carry==1){
    		sb.append(1);
    	}
    	return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
