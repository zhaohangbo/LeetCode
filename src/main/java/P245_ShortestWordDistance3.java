
public class P245_ShortestWordDistance3 {
	//Idea
	
	//The Difference to WordDistance1 and WordDistance2 is that, word1 and word2 can be same now. 
	//So two conditions
	//1. word1 word2 are same
	//2. not same, then just call the same method in Distance1 
	
    public int shortestWordDistance(String[] words, String word1, String word2) {
    	
    	if(word1.equals(word2)){
    		int shortest =Integer.MAX_VALUE;
    		int m1 =-1 ;
    		int m2 =-1 ;
    		boolean isM1Turn =true;
    		for(int i =0 ;i<words.length;i++){
    			if(words[i].equals(word1)){
    				if(isM1Turn){
    					m1 =i;
    					isM1Turn = !isM1Turn;
    				}
    				else{
    					m2 =i;
    					isM1Turn = !isM1Turn;
    				}
    			}
    			
    			if(m1 !=-1 && m2 !=-1){
    				shortest = shortest>Math.abs(m1-m2)?Math.abs(m1-m2):shortest;
    			}
    		}
    		return shortest;
    	}
    	else{
    		return shortestWordDistanceWhenNotSame(words, word1, word2);
    	}
    }
    
    
    
    public int shortestWordDistanceWhenNotSame(String[] words, String word1, String word2) {
    	int shortest = Integer.MAX_VALUE;
    	int w1 =-1;
    	int w2 =-1;
    	for(int i=0 ;i<words.length; i++){
    		if(words[i].equals(word1)){
    			w1 =i;
    		}
    		if(words[i].equals(word2)){
    			w2 =i;
    		}
    		if(w1!=-1 && w2!=-1 && shortest>Math.abs(w1-w2)){
    			shortest =Math.abs(w1-w2);
    		}
    	}
    	return shortest;
    }
    
    public static void main(String[] arg){
    	P245_ShortestWordDistance3 s =new P245_ShortestWordDistance3();
    	String[] words ={"a","b"};
    	System.out.println(s.shortestWordDistance(words,"a","b"));
    	
    }

}
