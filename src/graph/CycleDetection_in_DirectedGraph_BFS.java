package graph;
/***
 * 
 *Check if cycle is present in directed graph
 * v :- No of Nodes
 * e :- No of Edges
 * Time Complexity :- O(v+e)  
 * Space Complexity :- O(v)
 * 
 * Value of variable count will be equal to total no Of nodes, in case there is no cycle.
 * Because in that case there will be no node having indegree greater than 1, 
 * So when parent node of any node will pop out from queue it will set indegree of that node to zero
 * And that node will be pushed to queue.
 * 
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CycleDetection_in_DirectedGraph_BFS {

	public static void main(String[] args) {
		HashMap<Integer,List<Integer>> adjList = new HashMap<>();
		addEdge(adjList, 1, 2);
		addEdge(adjList, 2, 3);
		addEdge(adjList, 3, 4);
		addEdge(adjList, 3, 5);
		addEdge(adjList, 4, 5);
		addEdge(adjList, 2, 6);
		addEdge(adjList, 6, 7);
		addEdge(adjList, 7, 8);
		addEdge(adjList, 8, 6);
		printAdjList(adjList);

		System.out.println("Is cycle present :- "+isCyclePresentIteratively(adjList,8));
	}
	
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
	}
	
	static void printAdjList(HashMap<Integer,List<Integer>> adjList) {
		System.out.println("****** Adjacency List ******");
		Set<Integer> keySet = adjList.keySet();
		for(int i:keySet) {
			System.out.println(i+ " -> " + adjList.get(i));
		}
		System.out.println("\n");
	}
	
	static boolean isCyclePresentIteratively(HashMap<Integer,List<Integer>> adjList,int v) {
		int[] indegree = new int[v+1];
		Set<Integer> keySet = adjList.keySet();
		for(int i:keySet) {
			for(int node:adjList.get(i)) {
				indegree[node]++;
			}
		}
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=1;i<=v;i++) {
			if(indegree[i]==0)
				q.addLast(i);
		}
		int count = 0;
		while(!q.isEmpty()) {
			int node = q.removeFirst();
			count++;
			LinkedList<Integer> allConnectedNodes = (LinkedList<Integer>) adjList.get(node);
			if (allConnectedNodes!=null) {
				for (int i : allConnectedNodes) {
					if (--indegree[i] == 0) {
						q.addLast(i);
					}
				} 
			}
		}
		if(count==v) {
			return false;
		}
		return true;
	}

}
