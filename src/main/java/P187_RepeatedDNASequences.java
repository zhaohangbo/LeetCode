import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P187_RepeatedDNASequences {

	
    public List<String> findRepeatedDnaSequences(String s) {
    	HashSet<Integer> setOnce =new HashSet<Integer>();
    	HashSet<Integer> setTwiceOrMore =new HashSet<Integer>();//to avoid add the same subStr twice
    	List<String>     res =new ArrayList<String>();
    	int[] map = new int[26];//A, C, G, T, only 4 digits
    	map['A'-'A']  = 0; //00
    	map['C'-'A']  = 1; //01
    	map['G'-'A']  = 2; //10
    	map['T'-'A']  = 3; //11
    	
    	for(int i =0;i<s.length()-9;i++){//pay attention,length-9 here
    		int strCode=0;
    		for(int j=i;j<i+10;j++){
    			int charCode = map[s.charAt(j)-'A'];
    			strCode |=charCode;
    			strCode <<=2;//shift 2 bits to left
    		}
    		
    		
    		if( !setOnce.contains(strCode) ){
    			setOnce.add(strCode);
    		}
    		else if(setOnce.contains(strCode) && !setTwiceOrMore.contains(strCode)){
    			setTwiceOrMore.add(strCode);
    			res.add(s.substring(i,i+10));
    		}
    		else{
    			//do nothing to avoid add the same subStr twice
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AAAAAAAAAAA";
		new P187_RepeatedDNASequences().findRepeatedDnaSequences(s);

	}

}
