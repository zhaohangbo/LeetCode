
public class P371_SumofTwoIntegers {

	//Calculate the sum of two integers a and b,
	//but you are not allowed to use the operator + and -
	
	
//	0+0=0 
//	0+1=1 
//	1+0=1 
//	1+1=0 (and generates carry)
//
//	noCarrySum = a ^ b
//	carry = (a & b) << 1
	
	//Iterative, until carry == 0, when the noCarrySum == realSum
    public int getSum_iterative(int a, int b) {
    	if(a==0) return b;
    	if(b==0) return a;
    	
    	while(b!=0){
    		int noCarrySum = a^b;
    		int carry = (a&b)<<1;
    		a=noCarrySum;
    		b=carry;
    	}
      //when carry == 0,  noCarrySum == realSum
      return a;
    }
	
    //recursive, a as noCarrySum, b as carry, only when carry == 0,  noCarrySum == realSum
    public int getSum(int a, int b) {
    	if(b==0) return a;
    	int noCarrySum = a^b;
    	int carry = (a&b)<<1;//don't forget brackets
    	return getSum(noCarrySum,carry);
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
