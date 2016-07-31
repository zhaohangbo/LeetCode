
public class P377_CombinationSumIV {
    
//	nums = [1, 2]
//	target = 4
//1,1,1,1
//1,1,2,2
//2,2



//	numbers = [1, 2, 3]
//	target = 4
//
//  target = 0
//	states[0]=1
//
//  target = 1
//	add 1,  need 0, states[1] += states[0];
//	add 2, 
//	add 3
//  states[1]=1
//
//  target = 2
//	add 1,  need 1, states[2] += states[1];
//	add 2,  need 0, states[2] += states[0];
//	add 3
//	states[2]=2;
//
//  target = 3
//	add 1,  need 2, states[3] += states[2];
//	add 2,  need 1, states[3] += states[1];
//	add 3,  need 0, states[3] += states[0];
//	states[3]=4;
//
//  target = 4
//	add 1,  need 3, states[4] += states[3];
//	add 2,  need 2, states[4] += states[2];
//	add 3,  need 1, states[4] += states[1];
//	states[4]=7;

	public int combinationSum4(int[] nums, int target) {
		int[] states = new int[target+1];
		states[0]=1;
		
		//state[i] is the result of possible combinations when target == i.
		for(int i=1;i<target+1;i++){
			//last number to add has nums.length possible options
			for(int lastPossibleNumToAdd : nums){
				if( i-lastPossibleNumToAdd>=0)
					states[i] += states[i-lastPossibleNumToAdd];
			}
		}
		return states[target];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
