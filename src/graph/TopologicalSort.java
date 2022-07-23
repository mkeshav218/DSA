package graph;

/***
 * 
 * @author User
 * Applicable Only for Directed Acyclic Graph.
 * cyclic graphs don't have valid topological orderings.
 * 
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, 
 * vertex u comes before v in the ordering.
 * 
 * Time Complexity :- O(V+E)
 * Space Complexity :- O(V)
 * 
 * https://www.interviewcake.com/concept/java/topological-sort
 * 
 * The most common use for topological sort is ordering steps of a process where some the steps depend on each other.
 *
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

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
		boolean[] visited = new boolean[10];
		Stack<Integer> sortedData = new Stack<>();
		for(int i=1;i<=6;i++) {
			if(!visited[i]) {
				topologicalSort(sortedData, i, visited, adjList);
			}
		}
		System.out.println("Topological Sorted Data :- ");
		while(!sortedData.isEmpty()) {
			System.out.print(sortedData.pop()+" ");
		}
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
	
	private static void topologicalSort(Stack<Integer> sortedData,int node,boolean[] visited,HashMap<Integer,LinkedList<Integer>> adjList) {
		visited[node] = true;
		LinkedList<Integer> allConnectedNodes = adjList.get(node);
		if (allConnectedNodes!=null) {
			for (int i : allConnectedNodes) {
				if(visited[i]==false) {
					topologicalSort(sortedData, i, visited, adjList);
				}
			} 
		}
		sortedData.push(node);
	}

}
