import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Solution_PalindromePermutation {

	//My Solution
	//Idea is no matter char_arr length is odd or even.
	//The one character occurred for even times, won't change the Palindrome at all
	//Only when the number of characters occurred for even times is more than 1, Palindrome will fail.
	
	//And I use hashmap to store all the [character] and [its occurred times]
		static HashMap<Character,Integer> map =new HashMap<Character,Integer>();
	//  If I put the map here,and without map.clear() in the method, the reuslt will be wrong.
	//  Cause The leetcode server will new one Solution Object.
	    public boolean canPermutePalindrome(String s) {
	        map.clear();
	    	char[] char_arr =s.toCharArray();
	    	
	    	for(int i =0; i<char_arr.length; i++){
	    		if(!map.containsKey(char_arr[i])){    			
	    			map.put(char_arr[i], 1);
	    		}
	    		else{
	    			map.put(char_arr[i], map.get(char_arr[i])+1);
	    		} 
	    	}
	    	
	    	Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();	
	    	boolean canPalindrome =true;
	    	int  count =0;
	    		
	    	Entry<Character, Integer> entry =null;
	    	while(it.hasNext()){
	    		entry =it.next();
	    		if(entry.getValue()%2 != 0){
	    			count++;
	    		}
	    		
	    		if(char_arr.length%2==0 ){
	    			if(count>=1){
	    				canPalindrome =false;
	    				break;
	    			}
	    		}
	    		else{
	    			if(count>=2){
	    				canPalindrome =false;
	    				break;
	    			}
	    		}
	    	}
	    	return canPalindrome;
	    }
	    
	    
	    //Idea:
	    //Only use set only store the odd character.
	    public boolean canPermutePalindrome2(String s) {
	    	Set<Character> set = new HashSet<Character>();
	    	
	    	for(int i =0 ;i<s.length();++i){
	    		if(!set.contains(s.charAt(i))){
	    			set.add(s.charAt(i));
	    		}
	    		else{
	    			set.remove(s.charAt(i));
	    		}
	    		
	    	}
	    	
	    	return set.size()==0 || set.size()==1;
	    }
	    
	    public boolean canPermutePalindrome3(String s) {

	    	
	    	return false;
	    }
	
}
