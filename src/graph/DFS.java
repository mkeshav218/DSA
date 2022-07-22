package graph;
/***
 * 
 * DFS Traversal of undirected graph
 * v :- No of Nodes
 * e :- No of Edges
 * Time Complexity :- O(v+e)  
 * Space Complexity :- O(v)
 * 
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
		addEdge(adjList, 1, 2);
		addEdge(adjList, 1, 5);
		addEdge(adjList, 2, 4);
		addEdge(adjList, 5, 4);
		addEdge(adjList, 4, 3);
		printAdjList(adjList);
		
		boolean[] visited = new boolean[6];
		dfsTraversal(adjList, visited, 1);
	}
	
	static void addEdge(HashMap<Integer,LinkedList<Integer>> adjList,int u,int v) {
		if(adjList.containsKey(u)) {
			LinkedList<Integer> values = adjList.get(u);
			values.add(v);
			adjList.put(u, values);
		}else {
			LinkedList<Integer> values = new LinkedList<>();
			values.add(v);
			adjList.put(u, values);
		}
		
		if(adjList.containsKey(v)) {
			LinkedList<Integer> values = adjList.get(v);
			values.add(u);
			adjList.put(v, values);
		}else {
			LinkedList<Integer> values = new LinkedList<>();
			values.add(u);
			adjList.put(v, values);
		}
	}
	
	static void printAdjList(HashMap<Integer,LinkedList<Integer>> adjList) {
		System.out.println("****** Adjacency List ******");
		Set<Integer> keySet = adjList.keySet();
		for(int i:keySet) {
			System.out.println(i+ " -> " + adjList.get(i));
		}
		System.out.println("\n");
	}
	
	static void dfsTraversal(HashMap<Integer, LinkedList<Integer>> adjList,boolean[] visited,int node) {
		System.out.print(node+" ");
		visited[node] = true;
		LinkedList<Integer> nodes = adjList.get(node);
		for(int n:nodes) {
			if(visited[n]==false) {
				dfsTraversal(adjList, visited, n);
			}
		}
	}

}
