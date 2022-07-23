package graph;

/***
 * 
 * @author User
 * Applicable Only for Directed Acyclic Graph.
 * cyclic graphs don't have valid topological orderings.
 * 
 * Also Known as Kahn's Algorithm
 * 
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, 
 * vertex u comes before v in the ordering.
 * 
 * Time Complexity :- O(V+E)
 * Space Complexity :- O(V)
 * 
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class TopologicalSort_BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,LinkedList<Integer>> adjList = new HashMap<>();
//		addEdge(adjList, 6, 5);
//		addEdge(adjList, 5, 2);
//		addEdge(adjList, 5, 0);
//		addEdge(adjList, 4, 0);
//		addEdge(adjList, 4, 1);
//		addEdge(adjList, 2, 3);
//		addEdge(adjList, 3, 1);

		
		addEdge(adjList, 1, 2);
		addEdge(adjList, 1, 3);
		addEdge(adjList, 2, 4);
		addEdge(adjList, 3, 4);
		addEdge(adjList, 4, 5);
		addEdge(adjList, 4, 6);
		addEdge(adjList, 5, 6);
		
		printAdjList(adjList);

		LinkedList<Integer> sortedData = new LinkedList<>();
		topologicalSort(adjList, sortedData);
		System.out.println(sortedData);
	}
	
	private static void addEdge(HashMap<Integer, LinkedList<Integer>> adjList,int u,int v) {
		if(adjList.containsKey(u)) {
			LinkedList<Integer> nodes = adjList.get(u);
			nodes.add(v);
			adjList.put(u, nodes);
		}else {
			LinkedList<Integer> nodes = new LinkedList<>();
			nodes.add(v);
			adjList.put(u, nodes);			
		}
	}
	
	private static void printAdjList(HashMap<Integer,LinkedList<Integer>> adjList) {
		System.out.println("****** Adjacency List ******");
		Set<Integer> keySet = adjList.keySet();
		for(int i:keySet) {
			System.out.println(i+ " -> " + adjList.get(i));
		}
		System.out.println("\n");
	}
	
	private static void topologicalSort(HashMap<Integer,LinkedList<Integer>> adjList,LinkedList<Integer> sortedData) {
		int[] indegreeArr = new int[7];
		Set<Integer> keySet = adjList.keySet();
		for(int node:keySet) {
			for(int n:adjList.get(node)) {
				indegreeArr[n]++;
			}
		}
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=1;i<indegreeArr.length;i++) {
			if(indegreeArr[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.removeFirst();
			sortedData.addLast(node);
			LinkedList<Integer> allConnectedNodes = adjList.get(node);
			if(allConnectedNodes!=null) {
				for(int n:allConnectedNodes) {
					if(--indegreeArr[n] == 0) {
						q.push(n);
					}
				}
			}
		}
	}

}
