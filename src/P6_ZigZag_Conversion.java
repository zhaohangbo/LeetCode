
public class P6_ZigZag_Conversion {

    public static String convert(String s, int numRows) {
    	if(s==null) return null;
    	if(s.equals("")||s.trim().equals("")) return "";
    	if(numRows==1) return s;
    	
    	StringBuilder[] sbs = new StringBuilder[numRows];
    	for(int i =0; i<sbs.length;i++) sbs[i]=new StringBuilder();

    	int idx=0;
    	while(idx<s.length()){
    		for(int i=0;i<numRows && idx<s.length();i++)
    			sbs[i].append(s.charAt(idx++));
    		for(int i=numRows-1-1;i>=1 && idx<s.length();i--)
    			sbs[i].append(s.charAt(idx++));
    	}
    	for(int i =1; i<sbs.length;i++)
    		sbs[0].append(sbs[i]);
    	
    	return sbs[0].toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convert("AB",1);
	}

}
