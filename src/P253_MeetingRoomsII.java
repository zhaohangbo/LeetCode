import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P253_MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
    	if(intervals.length==0 || intervals==null)
    			return 0;
    	
        int rooms =1;
        
//        Arrays.sort(intervals, new Comparator<Interval>() {
//			@Override
//			public int compare(Interval o1, Interval o2) {
//				if(o1.start>o2.start) return 1;
//				else if(o1.start == o2.start) return 0;
//				else return -1;
//			}
//		});
        Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
		});
        
        PriorityQueue<Integer> pq =new PriorityQueue<Integer>();//Default Min-Heap
        pq.add(intervals[0].end);
        
        for(int i=1;i<intervals.length;i++){
        	if(intervals[i].start<pq.peek()){
        		rooms++;
        		pq.add(intervals[i].end);
        	}
        	else{ //>=pq.peek()
        		//Be careful!
        		//pq.poll(); should be in front of pq.add(intervals[i].end);Otherwise, may remove the new added itself
        		pq.poll();//remove the old end, because one new internal(which is biiger than the old end) added
        		pq.add(intervals[i].end);
        	}
        }
        return rooms;
    }
	
    
    
    
    public class Interval {
    	     int start;
    	     int end;
    	     Interval() { start = 0; end = 0; }
    	     Interval(int s, int e) { start = s; end = e; }
    	 }
    
	public static void main(String[] args) {
		//Test  PriorityQueue, default Min Heap
		//PriorityQueue<Integer> pq =new PriorityQueue<>();
		//pq.add(9);
		//pq.add(7);
		//pq.add(5);
		//pq.add(3);
		//pq.add(1);
		//int size =pq.size() ;
		//for(int i=0;i<size;i++){
		//	System.out.println(pq.poll());
		//}
		
		// Change to Max Heap
		//Way 1
		PriorityQueue<Integer> pq_c_reverser =new PriorityQueue<Integer>(10,Collections.reverseOrder());
		
		//Way 2
		PriorityQueue pq =new PriorityQueue(10, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1>o2) return -1;
				else if(o1==o2) return 0;
				else return 1;
			}
		});
		pq.add(9);
		pq.add(7);
		pq.add(5);
		pq.add(3);
		pq.add(1);
		int size =pq.size() ;
		for(int i=0;i<size;i++){
			System.out.println(pq.poll());
		}
	}

}
