import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class P347_TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
    	int n = nums.length;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(!map.containsKey(nums[i]))
    			map.put(nums[i], 1);
    		else
    			map.put(nums[i],map.get(nums[i])+1);
    	}
    	
    	List<Integer>[] buckets = new List[n+1];
    	
    	for(int valOfNum : map.keySet()){
    		int freq = map.get(valOfNum);
    		if(buckets[freq]==null)
    			buckets[freq] =new ArrayList<Integer>();
    		
    		buckets[freq].add(valOfNum);
    	}
    	List<Integer> res = new ArrayList<Integer>();
    	for(int i=n; i>0 && k>0; i--){
    		for(int j=0; buckets[i]!=null && j < buckets[i].size() ; j++, k--){
        		res.add(buckets[i].get(j));
    		}
    	}
    	return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		heap.add(3);
		heap.add(1);
		heap.add(2);
		
		while(!heap.isEmpty()){
			System.out.println(heap.poll());
		}
	}

}
