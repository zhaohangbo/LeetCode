import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

    private int index = -100;
    private List<Integer> v1 =null;
    private int l1 =-1;
    private List<Integer> v2 =null;
    private int l2 =-1;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.index = 0;
        this.v1    = v1;
        this.l1    =v1.size();
        this.v2    = v2;
        this.l2    =v2.size();
    }

    
    public int next() {
         int val = -100;
         if(hasNext()){
        	 
             if(l1 <= l2){
            	if(index/2 < l1){
            	   if(index%2==0){
            		   val =v1.get(index/2);
            	   }
            	   else{
            		   val =v2.get(index/2);
            	   }
            	}
            	else
            	{
            		val =v2.get(index-l1);
            	}
             }
             else//l1>l2
             {
            	 if(index/2 <l2){
              	   if(index%2==0){
            		   val =v1.get(index/2);
            	   }
            	   else{
            		   val =v2.get(index/2);
            	   }
            	 }
            	 else{
            		 val =v1.get(index-l2);
            	 }
            	 
             }
             
             index++;
         }
         return val;
    }

    public boolean hasNext() {
        if(index < v1.size()+v2.size()){
            return true;
        }
        else{
            return false;
        }
    }


/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
	
    public static void main(String[] arg){
    	List<Integer> v1 = new ArrayList<Integer>();
    	v1.add(1);
    	v1.add(2);
    	
    	List<Integer> v2 = new ArrayList<Integer>();
    	v2.add(3);
    	v2.add(4);
    	v2.add(5);
    	v2.add(6);
    	
    	ZigzagIterator i = new ZigzagIterator(v1, v2);
    	while(i.hasNext()){
    		System.out.println(i.next());
    	}
    }
	
}
