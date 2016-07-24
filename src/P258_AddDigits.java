
public class P258_AddDigits {

//	Explain, take 438 as an example, 9+1=10, so 9 is the key to carry in decimal
//	Step 1:
//	438  == 40*10 +3*10 +8
//	4+3+8 == 4*(10%9)*(10%9)+3*(10%9)+8%9= 15
//	Step 2:
//	15  == 1*10 + 5
//	1+5 == 1*(10%9)+5%9= 6
//	So:
//	ab%9%9%9==ab%9
//	just return num%9; and don't forget num==0 or num==9
	
    public int addDigits(int num) {
    	 return num==0?0:(num%9==0?9:(num%9));
    	 //return 1 + (num-1)%9; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
