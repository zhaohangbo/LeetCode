import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P323_NumberofConnectedComponentsInAnUndirectedGraph {
	
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph_map = new HashMap<Integer,List<Integer>>();
        
        for(int i=0;i<n;i++){
        	graph_map.put(i,new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
        		int n1 = edges[i][0];
        		int n2 = edges[i][1];
        		if(!graph_map.get(n1).contains(n1)){
        			graph_map.get(n1).add(n2);//undirected edges
        			graph_map.get(n2).add(n1);//undirected edges
        		}
        }
        
        Iterator<Integer> key_iterator = graph_map.keySet().iterator();
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] visited=new int[n];
        int components =0;
//      [1,0]
        while(key_iterator.hasNext()){
        	int key = key_iterator.next();
        	if(visited[key]==0){
	        	queue.add(key);
	        	visited[key] = 1 ;
	        	while(!queue.isEmpty())	{
	        		List<Integer> adjacent =  graph_map.get(queue.poll());
	        		for(Integer e : adjacent){
	        			if(visited[e]==0 ){
	        			   visited[e]=1;
	        			   queue.add(e);
	        			}
	        		}
	        	}
	        	components++;
        	}
        }
    	return components;
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]edges= {{1,0}};
		System.out.println(new P323_NumberofConnectedComponentsInAnUndirectedGraph().countComponents(2, edges));
	}

}
