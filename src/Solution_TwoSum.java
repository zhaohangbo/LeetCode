
public class Solution_TwoSum {
    //My method 1: Time Limit Exceeded
	//Because the last input is quite long !
	
	/*
    public int[] twoSum(int[] numbers, int target) {
    	int[] arr =new int[2];
        for(int i=0 ;i<numbers.length; i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                	arr[0]=i+1;
                	arr[1]=j+1;
                    break;
                }
            }
        }
        return arr;
    }
    */
    
	//Leetcode Answer From others
	public int[] twoSum(int[] num, int target) {
	    int[] indice = new int[2];
	    
	    //if (num == null || num.length < 2) return indice;
	    
	    int left = 0, right = num.length - 1;
	    while (left < right) {
	        int v = num[left] + num[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}
    
    
	//My Final Code
    public int[] twoSum2(int[] numbers, int target) {
    	int[] arr =new int[2];
        int left  = 0 ; 
        int right = numbers.length-1;
        
        while(left  <  right){
            int val =  numbers[left] + numbers[right];
            if(val==target){
                arr[0]=left+1;
                arr[1]=right+1;
                break;
            }
            else if(val>target){
                right--;
            }
            else{
                left++;
            }
        }
        return arr;
    }
}