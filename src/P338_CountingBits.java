
public class P338_CountingBits {
	
	//An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
	public int[] countBits(int num) {
	    int[] f = new int[num + 1];
	    for (int i=1; i<=num; i++) 
	    	f[i] = f[i >> 1] + (i & 1);// ==> f[i] = f[i / 2] + i % 2.
	    	//explain
	    	//take number n for example,  10011001
	    	//divide it in 2 parts, 
	    	//the last  digit (1 or 0, which is (i&1), == (i%2) )
	    	//the other digits(the number of 1 is f[i >> 1], == f[i/2])
	    return f;
	}
	
	
	public int[] countBits2(int num) {
		int[] res =new int[num+1];
		int pow =1;
		int t =0;
		for(int i=1;i<=num;i++,t++){
			if(i==pow){
			   pow *=2;
			   t =0;
			}
			res[i] =1 + res[t];
		}
		return res;
	}
	
    public int[] countBits3(int num) {
    	int[] res =new int[num+1];
    	int len =4;
    	int k   =1;
    	int i   =0;
    	while(k>=0 && i<=num){
    		if(i==0||i==1) {res[i]=i; i++; continue; };  //res[0]=0;res[1]=1;
    		res[i]= 1 + res[i-len];
			k--;
			
			i++;
    		if( i == len*2){
    			len *=2;
    			k  =len;
    		}
    	}
    	return res;
    }
    
    
    
    
//00000000   0   0
//00000001   1   1
//00000010   1   2
//00000011   2   3
//00000100   1   4
//00000101   2
//00000110   2
//00000111   3

}
