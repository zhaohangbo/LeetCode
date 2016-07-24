import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P261_GraphValidTree {
	//Union and Find
	public boolean validTree(int n, int[][] edges) {
		//n nodes, must give n-1 edges.
		//if edges is less than n-1 , then not all the nodes are connected
		//n=4; int[][]edges= {{0,1},{2,3}}; number of edges less than (4-1), false
		if(edges.length != n - 1) return false;
		int[] nodes =new int[n];
		for(int i=0;i<n;i++)
			nodes[i] = i;
		
		for(int i=0;i<edges.length;i++){
    		if(edges[i].length!=2) 
    			return false;
    		int n1 = findRoot(edges[i][0],nodes);
    		int n2 = findRoot(edges[i][1],nodes);
    		if  (n1==n2) //means edges[i][0] and edges[i][1] has same root, circle
    			return false;
    		
    		union(n1,n2,nodes);
		}
		return true;
	}
	
	public void union(int n1,int n2, int[] nodes){
		nodes[n1] = n2;// node at index n1 linked to parent n2
	}
	public int findRoot(int curNode,int[] nodes){
		if(curNode!=nodes[curNode]){
			curNode = findRoot(nodes[curNode],nodes);
		}
		return curNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P261_GraphValidTree a = new  P261_GraphValidTree();

		int n = 4;
		int[][]edges = {{0,1},{2,3}};
		
	}

}
