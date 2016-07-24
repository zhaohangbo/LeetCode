import java.util.Stack;

public class P137_SingleNumberII {
	
	public static int singleNumber(int[] A) {
		int k =3; int p =1;
		return singleNumbberGeneral(A,k,p);
	}
	
	public static int singleNumbberGeneral(int[] A,int k,int p){
		int numOfBits = (int) Math.ceil( Math.log(k)/Math.log(2));
		int[] counter = new int[numOfBits]; //counter[0] = ones,   counter[1] =twos
		int kk = k;  	int[] k_in_binary = new int[numOfBits];
		for(int i=k_in_binary.length-1;i>=0;i--){
			k_in_binary[i]=kk&1;//if k=10, k_in_binary=[1,   0,  1,   0]
								//                      last ..  twos ones
			kk=kk>>>1;
		}
		int mask =0; //mask will be 0 only when the count reaches k 
					 // 		 be 1 for all other count cases
		for(int i: A){
			for(int m=counter.length-1;m>=0;m--){//m from counter.length-1 to 0
				//int tmp=1;//Stupid here, define tmp =1, means 00000001;
				int tmp=0b11111111111111111111111111111111;
				for(int n=m-1;n>=0;n--){ 
					tmp &= counter[n]; //counter[m] = counter[m]^(counter[m-1]&counter[m-2].&.counter[0]&i)
				}
				counter[m] ^= tmp&i;
			}
			
			//int tmp=1;//Stupid here, define tmp =1, means 00000001;
			int tmp =0b11111111111111111111111111111111;
			for(int j=numOfBits-1; j>=0; j--){
				if(k_in_binary[j]==0)
					tmp &= ~counter[numOfBits-1-j];//counter[0]==ones  corresponding to k_in_binary[last_bit]
				else
					tmp &=  counter[numOfBits-1-j];
			}
			mask = ~tmp;// mark= ~(counter[0]'&counter[1]'&...counter[last]')
			
			for(int j=0;j<counter.length;j++)
				counter[j] &=mask;
		}
		return  counter[0];
	}
	
//	解题思路
//	　　方法一：考虑全部用二进制表示，如果我们把 第ith个位置上所有数字的和对3取余，
//	  		  那么只会有两个结果 0 或 1 (根据题意，3个0或3个1相加余数都为0). 
//	  		  因此取余的结果就是那个 “Single Number”。一个直接的实现就是用大小为 32的数组来记录所有位上的和。 
	public int singleNumber_1(int[] nums) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int n : nums) {
                // 统计第i位的1的个数
                if (((n >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result |= (count[i] % 3) << i;
        }
        return result;
    }
	
	
//	public int singleNumber(int[] A) {
//	    int ones = 0, twos = 0;
//	    for(int i = 0; i < A.length; i++){
//	        ones = (ones ^ A[i]) & ~twos;
//	        twos = (twos ^ A[i]) & ~ones;
//	    }
//	    return ones;
//	}
    
//	What we need to do is to store the number of '1's of every bit. 
//	Since each of the 32 bits follow the same rules, we just need to consider 1 bit. 
//	We know a number appears 3 times at most, so we need 2 bits to store that. 
//	Now we have 4 state, 00, 01, 10 and 11, but we only need 3 of them.

//	In this solution, 00, 01 and 10 are chosen. 
//	！！
//	Let 'ones' represents the first bit, 'twos' represents the second bit. 
//	！！
//	Then we need to set rules for 'ones' and 'twos' so that they act as we hopes. 
//	The complete loop is 00->10->01->00(0->1->2->3/0).

//	    00->10->01->00(0->1->2->3/0).
//ones  0   1   0   0
//twos   0   0   1   0
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		反码（ones' complement），补码（two's complement）
		
		// 0000 0010  -> 1111 1110  补码 (two's complement)
		// every bit is opposite except one bit
		int[] A ={2,2,3,2};
		System.out.println(singleNumber(A));
		
 	}

}
