
public class P70_ClimbingStairs {
	
	//F(n)   = F(n-1)+F(n-2)
	//F(n-1) = F(n-2)+F(n-3)
	
	
	//F(3)   = F(2)+F(1)
	//F(2)   = 2
	//F(1)   = 1
	
	
	//Dynamic Programing
    public int climbStairs2(int n) {
    	if(n==0)return 0;
    	if(n==1)return 1;
    	if(n==2)return 2;
    	
    	int[] ways=new int[n];
    	ways[0]   =1;
    	ways[1]   =2;
    	
    	for(int i=2;i<n;i++){
    		ways[i]=ways[i-1]+ways[i-2];
    	}
    	
    	return ways[n-1];
    }	
	
	
	
	//Recursion
    public int climbStairs(int n) {
    	if(n==1) return 1;
    	if(n==2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    
    public static void main(String[] args){
    	System.out.println(new P70_ClimbingStairs().climbStairs2(6));
    }
}
