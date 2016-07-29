import java.util.HashMap;
import java.util.Vector;

public class P349_IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
    	HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
    	if(nums1==null||nums2==null) return null;
    	if(nums1.length==0 || nums2.length==0) return new int[0] ;
    	//int[] map =new int[Integer.MAX_VALUE];
    	for(int i=0;i<nums1.length;i++){
    			map.put(nums1[i],1);
    	}
    	
    	Vector<Integer> v =new Vector<Integer>() ;
    	for(int i=0;i<nums2.length;i++){
    			if(map.containsKey(nums2[i])){
    				v.add(nums2[i]);
    				map.remove(nums2[i]);
    			}
    	}
    	int[] res =new int[v.size()];
    	for(int i=0;i<res.length;i++){
    		res[i]=v.get(i);
    	}
    	return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
