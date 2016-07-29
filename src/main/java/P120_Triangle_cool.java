import java.util.*;

import javax.sound.midi.Track;


public class P120_Triangle_cool {
	//bottom-up
    public int minimumTotal(List<List<Integer>> triangle) {
    	int height =triangle.size();

    	//bottom-up
    	//最底层不变 , i从height-2开始
    	for(int i=height-2;i>=0;i--){
    		for(int j=0;j<triangle.get(i).size();j++){
    			int root_v =triangle.get(i).get(j);
    			int left_v=triangle.get(i+1).get(j);
    			int right_v=triangle.get(i+1).get(j+1);
    			triangle.get(i).set(j,Math.min(root_v+left_v, root_v+right_v));
    		}
    	}
    	
    	return triangle.get(0).get(0);   
    }
    
    //up-down
    public int minimumTotal2(List<List<Integer>> triangle) {
    	
    	return getMin(0,0,triangle);   
    }
    
    public int getMin(int i,int j,List<List<Integer>> triangle){
    	if(i==triangle.size()-1)
    		return triangle.get(i).get(j);
    	
    	
    	
    	int root_v = triangle.get(i).get(j);
    	int left_v = getMin(i+1, j, triangle);
    	int right_v= getMin(i+1, j+1, triangle);
    	
    	return Math.min(root_v+left_v, root_v+right_v);
    }


    public static void main(String[] args){
    	
int[] arr =
{
46,      //  46
43,61,   // 27,45
10,-16,3,
-26,41,36,-72,
-28,-76,-22,26,51,
56,-53,38,67,86,-45,
58,53,47,-52,-54,-95,56,
-54,-93,58,68,26,-4,-45,86,
75,28,27,12,33,98,35,87,1,
-13,20,25,-98,-13,11,-44,-77,-59,-97,
-53,-14,83,80,31,89,38,-1,15,-88,53,
-22,86,-41,-94,-25,68,-96,87,55,-18,-49,-25,
-93,-48,39,17,8,61,57,-13,-92,-79,-29,87,51,
-63,3,-72,29,-9,57,-93,-46,-84,88,29,83,69,-7,
15,-49,43,90,-43,94,29,50,-21,-33,-16,43,-26,4,90,
-61,-67,-96,18,-63,32,-91,93,16,-61,86,4,67,46,-27,-63,
-38,0,79,-48,56,51,80,-17,-70,-53,67,49,-3,-52,39,12,-43,
43,-93,-7,-48,91,-13,44,-69,-27,-74,74,95,-25,-88,-43,75,90,8,
8,41,-35,91,48,-12,35,-3,62,59,-86,-49,-83,56,-42,-14,84,-74,72,
6,-44,-78,31,-92,-82,-94,-81,-49,57,85,36,-34,4,77,-66,-71,-34,45,25,
-95,4,15,-45,-3,-52,-11,83,-67,15,32,38,47,54,-54,54,48,-72,72,75,85,
35,11,-72,-61,-11,-62,-33,31,82,68,35,-37,-16,66,37,31,-44,20,40,47,-71,-45,
-6,59,0,-51,7,5,97,-40,-10,32,70,-6,47,-41,31,-86,89,-10,59,1,29,-57,-32,
-34,73,0,62,-9,-53,91,45,17,50,-54,65,-65,50,40,-6,-83,-28,-59,-13,-80,0,94,-90,
-34,-39,68,67,89,-89,-88,-67,61,-12,71,-48,11,62,73,-72,-10,95,70,1,45,10,71,38,58,
-88,-98,54,-12,95,64,31,-44,9,-25,-77,20,-14,-45,-42,73,-74,-14,-16,65,-41,-12,-68,-45,-42,32,
76,44,-20,-8,3,-32,-7,-66,56,-11,97,-36,21,7,38,43,-96,-76,74,-62,73,-99,0,-66,42,58,21};

			//n*n <   n*(n+1) = arr.length*2   <(n+1)*(n+1)
			//So    n	<     sqrt                   < n-1
			int  n=  (int) Math.sqrt(arr.length*2);
			
			List<List<Integer>> triangle =new ArrayList<List<Integer>>();
			
			for(int i=1 ,count =0;i<=n;i++){
				List<Integer> list =new ArrayList<Integer>();
				for(int j =0 ;j<i;j++){
					list.add(arr[count]);
					count ++;
				}
				triangle.add(list);
			}
			System.out.println("2: "+new P120_Triangle_cool().minimumTotal2(triangle));
			System.out.println("1: "+new P120_Triangle_cool().minimumTotal(triangle));

    }


}




//[
//     [2],
//    [3,4],
// 	 [6,5,7],
//	[4,1,8,3]
//]