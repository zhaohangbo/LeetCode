import java.util.LinkedList;
import java.util.Queue;

public class P346_MovingAveragefromDataStream {

	
	public class MovingAverage {
		Queue<Integer> q  ;
		int  size;
		double  sum;
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        q =new LinkedList<Integer>();
	        this.size=size;
	    }
	    
	    public double next(int val) {
	    	if(q.size()>=this.size){
	    		q.add(val);
	    		sum +=val;
	    		sum -=q.poll();
	    	}
	    	else{
	    		q.add(val);
	    		sum +=val;
	    	}
	    	return sum/q.size();
	    }
	}

	/**
	 * Your MovingAverage object will be instantiated and called as such:
	 * MovingAverage obj = new MovingAverage(size);
	 * double param_1 = obj.next(val);
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
