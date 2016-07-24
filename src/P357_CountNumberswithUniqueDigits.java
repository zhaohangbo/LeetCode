
public class P357_CountNumberswithUniqueDigits {
//	n = 1, return   . (in the range of 0 ≤ x < 10,
//	n = 2, return 91. (in the range of 0 ≤ x < 100,  excluding [11,22,33,44,55,66,77,88,99])
	
//	n = 3, return 91. (in the range of 0 ≤ x < 1000, excluding [11, 22, 33, 44, 55, 66, 77, 88, 99],
//															   [111,222,333,444,555,666,777,888,999])
//9*9*8
	
	//Accepted
    public int countNumbersWithUniqueDigits(int n) {
    	if(n==0) return 0;
    	
    	int[] states =new int[n+1];
    	states[1] = 10;
    	for(int i=2;i<=n;i++){
    		int	digit_options  = 9;
    		int res    = 9;
    		int digits = i;
    		
    		while(digits > 1){
    			res *= digit_options;
    			digit_options --;
    			digits--;
    		}
    		states[i]= res + states[i-1];
    	}
    	return states[n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
