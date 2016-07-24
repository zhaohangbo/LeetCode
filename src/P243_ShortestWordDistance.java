
public class P243_ShortestWordDistance {
	
	//Idea
	//The Idea is traverse the String array.
	//When find one word that is equal with the word1, start from that index
	//and travese from that index on the both side to left and right and find the first word2,
	//return 
    public int shortestDistance(String[] words, String word1, String word2) {
    	
    	int shortest = Integer.MAX_VALUE;
    	for(int i=0 ;i<words.length; i++){
    		if(words[i].equals(word1)){
    			int nearestFromDoubleSide = findShortest(words, i, word2);
    			if (shortest > nearestFromDoubleSide){
    				shortest = nearestFromDoubleSide;
    			}
    		}
    	}
    	
    	return shortest;
    }
    
    
    public int findShortest(String[] words,int start,String targetWord){
    	int shortest = -1;
    	for(int i=start,j=start ;i<words.length||j>=0; i++,j--){
    		if(i<words.length && words[i].equals(targetWord)){
    			shortest = i-start>0?i-start:start-i; 
    			break;
    		}
    		if(j>=0 && words[j].equals(targetWord)){
    			shortest = j-start>0?j-start:start-j;
    			break;
    		}
    	}
    	return shortest;
    }
    
    
    public int shortestDistance2(String[] words, String word1, String word2) {
    	
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

}
