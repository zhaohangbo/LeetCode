import java.util.Arrays;
import java.util.Comparator;

public class P252_MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
    	Arrays.sort(intervals,new Comparator<Interval>() {
    		public int compare(Interval i1, Interval i2){ return i1.start-i2.start;}
		});
    	int prevEnd   =-1;
    	boolean  can =true;
    	for(int i=0;i<intervals.length;i++){
    		System.out.println("i = "+i+", interval ="+"["+intervals[i].start+","+intervals[i].end+"]");
    		if(intervals[i].start < prevEnd){
    			can = false;
    			break;
    		}
    		prevEnd   = intervals[i].end;
    	}
    	
    	return can;
    }
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Wrong
    private void quickSort(Interval[] intervals,int start_index,int end_index){
    	if(start_index>=end_index){
    		return;
    	}
    	int p = sort(intervals, start_index, end_index);
    	quickSort(intervals, start_index, p-1);
    	quickSort(intervals, p+1, end_index);	
    }
    
    private int  sort(Interval[] intervals,int start_index,int end_index){
    	int left = start_index+1;
    	int right= end_index;
    	if(left ==right){
    		if(intervals[left].start<intervals[start_index].start){
    			swap(intervals,start_index,left);
    			return left;
    		}
    		else{
    			return start_index;
    		}
    	}
    	while(left<right){
    		while(intervals[left].start<intervals[start_index].start){
    			if(left == end_index) break;    
    			left++;
    		}
    		while(intervals[right].start>intervals[start_index].start){
    			if(right== start_index+1) break;
    			right--;
    		}
    		if(left<right){
    			swap(intervals,left,right);
    		}
    	}
    	//Pay attention the right here ~
    	swap(intervals,start_index,right);
    	
    	return right;
    }
    
    private void swap(Interval[] intervals,int left ,int right){
    	if(left != right) {
    		Interval temp    = intervals[left];
    		intervals[left]  = intervals[right];
    		intervals[right] = temp;
    	}
    }
    
    
    public class Interval {
    	     int start;
    	     int end;
    	     Interval() { start = 0; end = 0; }
    	     Interval(int s, int e) { start = s; end = e; }
    	 }
	
	public static void main(String[] args) {
		P252_MeetingRooms mr =new P252_MeetingRooms();
		Interval i1 =mr.new Interval(15,16);
		Interval i2 =mr.new Interval(10,15);
		Interval i3 =mr.new Interval(16,25);
		Interval[] intervals =new Interval[3];
		intervals[0] =i1;
		intervals[1] =i2;
		intervals[2] =i3;
		//(15,16);(10,15);(16,25);
		System.out.println(mr.canAttendMeetings(intervals));
	}

}
