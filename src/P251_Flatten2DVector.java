import java.util.Iterator;
import java.util.List;

public class P251_Flatten2DVector {

	public class Vector2D implements Iterator<Integer> {
		List<List<Integer>> vec2d;
		int total;
		int i,j;
		int count;
	    public Vector2D(List<List<Integer>> vec2d) {
	        this.vec2d=vec2d;
	        for(List<Integer> list :vec2d){
	        	total +=list.size();
	        }
	        i=0;j=0;
	        count=0;
	    }

	    @Override
	    public Integer next() {
	    	Integer result =null;
	    	if(vec2d.get(i).size()==0){//[[],[3]]
	    		i++;j=0;
	    		return next();
	    	}
	    	else{
	    			result = vec2d.get(i).get(j);
	    	}
	    	
	    	if(j==vec2d.get(i).size()-1){
	    		i++;j=0;
	    	}
	    	else
	    		j++;
	    	
	    	count++;
	        return result;
	    }

	    @Override
	    public boolean hasNext() {
//	    	return i<vec2d.size() && j<vec2d.get(i).size(); //[[],[3]], maybe one row is empty
//	    	return i<vec2d.size()-1 || (i==vec2d.size()-1 && j<vec2d.get(vec2d.size()-1).size()); //[[-1],[],[]]
	    	return count < total;
	    }

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}

	/**
	 * Your Vector2D object will be instantiated and called as such:
	 * Vector2D i = new Vector2D(vec2d);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
