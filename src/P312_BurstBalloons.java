
public class P312_BurstBalloons {
	
	public static int maxCoins(int[] nums) {
	    int[] nums_x = new int[nums.length + 2];
	    for(int i=0;i<nums_x.length;i++){
	    	if(i==0 || i==nums_x.length-1)nums_x[i]=1;
	    	else nums_x[i] = nums[i-1];
	    }
	    
//		rangeValue[i][j] means the maxCoins value range from i to j
	    int[][] rangeValue = new int[nums_x.length][nums_x.length];
		
	    //length: 1 --> iNums.length
		for(int len = 1; len <= nums.length ; len++){
			//start: the subArray range start : 1 --> iNums.length
			for(int start = 1 ;start <= nums.length -len + 1;start++){
				int end = start + len - 1;
				int bestCoins = 0 ;
				for(int f =start ; f <= end;f++){
					int coins = rangeValue[start][f-1] + nums_x[start-1]*nums_x[f]*nums_x[end+1]+ rangeValue[f+1][end];
					if(bestCoins < coins) bestCoins = coins;
				}
				rangeValue[start][end] = bestCoins;
			}
		}
		return rangeValue[1][nums.length];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums = {3,1,5,8};
		System.out.println(maxCoins(nums));
	}

}
