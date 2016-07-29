import java.util.Hashtable;

public class P359_LoggerRateLimiter {
	public class Logger {
		Hashtable<String,Integer> map ;
	    /** Initialize your data structure here. */
	    public Logger() {
	    	map = new Hashtable<String,Integer>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	    	if(!map.containsKey(message)){
	    		map.put(message, timestamp);	    		
	    		return true;
	    	}
	    	else{
	    		int lastTimestamp = map.get(message);
	    		if(timestamp-lastTimestamp>=10){
	    			map.remove(message);
	    			map.put(message, timestamp);
	    			return true;
	    		}
	    		else{
	    			return false;
	    		}
	    	}
	    }
	}

	/**
	 * Your Logger object will be instantiated and called as such:
	 * Logger obj = new Logger();
	 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Logger obj = new P359_LoggerRateLimiter().new Logger();
//		 [],[1,"foo"],[2,"bar"],[3,"foo"],[8,"bar"],[10,"foo"],[11,"foo"]]
		 boolean param_1 = obj.shouldPrintMessage(1,"foo");
		 boolean param_2 = obj.shouldPrintMessage(2,"foo");
		 System.out.println(param_1);
		 System.out.println(param_2);
		 
	}

}
