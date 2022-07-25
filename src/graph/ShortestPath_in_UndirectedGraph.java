package graph;
/***
 * 
 * Given source & destination node 
 * Find Shortest Path between two given nodes
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
		System.out.println("Length of Shortest path = " + findShortestPathDFS(adjList, 2, 7, -1,visited,shortestPath,currentPath));
		System.out.println("Shortest Path using DFS = " + shortestPath);
		
		System.out.println("Shortest Path using BFS = " + findShortestPathBFS(adjList, 2, 7,8));
	}

	static int findShortestPathDFS(HashMap<Integer,List<Integer>> adjList,int src,int dest,int parent,boolean[] visited,LinkedList<Integer> shortestPath,LinkedList<Integer> currentPath) {
		LinkedList<Integer> allNodes = (LinkedList<Integer>) adjList.get(src);
		visited[src] = true;
		currentPath.add(src);
		if(allNodes.contains(dest)) {
			currentPath.add(dest);
			System.out.println(currentPath);
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
				if(i!=parent) {
					int ans =  findShortestPathDFS(adjList, i, dest,src, visited,shortestPath,currentPath);
					if(ans<min) {
						min = ans;
					}
				}
			}
			currentPath.removeLast();
			return min + 1;
		}
	}
	
	static List<Integer> findShortestPathBFS(HashMap<Integer,List<Integer>> adjList,int src,int dest,int v){
		int[] nodeToParentMap = new int[v+1];
		LinkedList<Integer> ans = new LinkedList<>();
		LinkedList<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100];
		q.addLast(src);
		nodeToParentMap[src] = -1;
		while(!q.isEmpty()) {
			int node = q.removeFirst();
			visited[node] = true;
			LinkedList<Integer> allConnectedNodes = (LinkedList<Integer>) adjList.get(node);
			for(int i:allConnectedNodes) {
				if(!visited[i]) {
					q.addLast(i);
					if(nodeToParentMap[i]==0) {
						nodeToParentMap[i]=node;
					}
				}
			}
		}
		int parent = -1;
		ans.addFirst(dest);
		while(parent!=src) {
			parent = nodeToParentMap[dest];
			ans.addFirst(parent);
			dest = parent;
		}
		return ans;
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


}
