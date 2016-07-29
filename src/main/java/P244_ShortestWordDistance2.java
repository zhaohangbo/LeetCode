import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P244_ShortestWordDistance2 {
	
	private HashMap<String, List<Integer>> map =new HashMap<String, List<Integer>>(); 
	//Idea
	//The difference is that constrctor will be executed once but method will be excuted many times
	//And be aware of that there is a loop in method, so every time this method is executed, there is a loop  
    
	//Now let's just loop once in the constructor and store that array in a hashmap to avoid traversal.
	public P244_ShortestWordDistance2(String[] words) {
        for(int i =0 ;i< words.length ;i++){
        	if(map.containsKey(words[i])){
        		map.get(words[i]).add(i);
        	}
        	else{
        		List<Integer> list =new ArrayList<Integer>();
        		list.add(i);
        		map.put(words[i], list);
        	}
        	
        }
    }

    public int shortest(String word1, String word2) {
        int shortestL = Integer.MAX_VALUE;
        List<Integer> l1 =map.get(word1);
        List<Integer> l2 =map.get(word2);
    	
        for(int i =0; i<l1.size();i++){
        	for(int j=0; j<l2.size();j++){
        		int dis = Math.abs(l1.get(i)-l2.get(j));
        		if(shortestL>dis){
        			shortestL=dis;
        		}
        	}
        }
        
        return shortestL;
    }

}
