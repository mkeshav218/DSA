package graph;
/***
 * 
 * BFS Traversal of undirected graph
 * v :- No of Nodes
 * e :- No of Edges
 * Time Complexity :- O(v+e)  
 * Space Complexity :- O(v)
 * 
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS {

	public static void main(String[] args) {
		HashMap<Integer,List<Integer>> adjList = new HashMap<>();
		addEdge(adjList, 1, 2);
		addEdge(adjList, 1, 5);
		addEdge(adjList, 2, 4);
		addEdge(adjList, 5, 4);
		addEdge(adjList, 4, 3);
		printAdjList(adjList);
		bfsTraversal(adjList);
	}
	
	//Add new edge
	static void addEdge(HashMap<Integer,List<Integer>> adjList,int u,int v) {
		if(adjList.containsKey(u)) {
			LinkedList<Integer> values = (LinkedList<Integer>) adjList.get(u);
			values.add(v);
			adjList.put(u, values);
		}else {
			LinkedList<Integer> values = new LinkedList<>();
			values.add(v);
			adjList.put(u, values);
		}
		
		if(adjList.containsKey(v)) {
			LinkedList<Integer> values = (LinkedList<Integer>) adjList.get(v);
			values.add(u);
			adjList.put(v, values);
		}else {
			LinkedList<Integer> values = new LinkedList<>();
			values.add(u);
			adjList.put(v, values);
		}
	}
	
	//Print Adjacency List
	static void printAdjList(HashMap<Integer,List<Integer>> adjList) {
		System.out.println("****** Adjacency List ******");
		Set<Integer> keySet = adjList.keySet();
		for(int i:keySet) {
			System.out.println(i+ " -> " + adjList.get(i));
		}
		System.out.println("\n");
	}
	
	//BFS Traversal
	static void bfsTraversal(HashMap<Integer,List<Integer>> adjList) {
		System.out.println("BFS traversal :- ");
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(1);
		boolean[] visited = new boolean[6];
		System.out.print(1 +" ");
		visited[1] = true;
		while(!q.isEmpty()) {
			int node = q.removeFirst();
			LinkedList<Integer> list = (LinkedList<Integer>) adjList.get(node);
			for(int i:list) {
				if(visited[i]==false) {
					System.out.print(i+" ");
					q.addLast(i);
					visited[i]= true;
				}
			}
		}
	}

}
