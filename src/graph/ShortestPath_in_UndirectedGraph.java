package graph;
/***
 * 
 * Shortest Path between two nodes
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

public class ShortestPath_in_UndirectedGraph {

	public static void main(String[] args) {
		HashMap<Integer,List<Integer>> adjList = new HashMap<>();
		addEdge(adjList, 1, 2);
		addEdge(adjList, 1, 3);
		addEdge(adjList, 1, 4);
		addEdge(adjList, 2, 5);
		addEdge(adjList, 3, 8);
		addEdge(adjList, 4, 6);
		addEdge(adjList, 5, 8);
		addEdge(adjList, 6, 7);
		addEdge(adjList, 7, 8);
		printAdjList(adjList);
		boolean[] visited = new boolean[9];
		LinkedList<Integer> shortestPath = new LinkedList<>();
		LinkedList<Integer> currentPath = new LinkedList<>();
		System.out.println("Length of Shortest path = " + findShortestPath(adjList, 1, 8, visited,shortestPath,currentPath));
		System.out.println("Shortest Path = " + shortestPath);
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

	static int findShortestPath(HashMap<Integer,List<Integer>> adjList,int src,int dest,boolean[] visited,LinkedList<Integer> shortestPath,LinkedList<Integer> currentPath) {
		LinkedList<Integer> allNodes = (LinkedList<Integer>) adjList.get(src);
		visited[src] = true;
		currentPath.add(src);
		if(allNodes.contains(dest)) {
			currentPath.add(dest);
			if(shortestPath.size()==0 || shortestPath.size()>currentPath.size()) {
				shortestPath.clear();
				for(int i:currentPath) {
					shortestPath.add(i);
				}
				currentPath.removeLast();
				currentPath.removeLast();
			}
			return 1;
		}else {
			int min = Integer.MAX_VALUE;
			for(int i:allNodes) {
				if(!visited[i]) {
					int ans =  findShortestPath(adjList, i, dest, visited,shortestPath,currentPath);
					if(ans<min) {
						min = ans;
					}
				}
			}
			currentPath.removeLast();
			return min + 1;
		}

	}

}
