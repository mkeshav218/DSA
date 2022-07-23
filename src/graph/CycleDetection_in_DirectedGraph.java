package graph;
/***
 * 
 *Check if cycle is present in directed graph
 * v :- No of Nodes
 * e :- No of Edges
 * Time Complexity :- O(v+e)  
 * Space Complexity :- O(v)
 * 
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CycleDetection_in_DirectedGraph {

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

		boolean[] visited = new boolean[10];
		boolean[] currentStackCalls = new boolean[10];
		System.out.println("Is cycle present :- "+isCyclePresentRecursively(adjList, 1, visited, currentStackCalls));
		System.out.println(Arrays.toString(visited));
		System.out.println(Arrays.toString(currentStackCalls));
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
	
	static boolean isCyclePresentIteratively(HashMap<Integer,List<Integer>> adjList) {
		HashMap<Integer,Integer> nodeToParentMap = new HashMap<Integer, Integer>();
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(1);
		boolean[] visited = new boolean[7];
		visited[1] = true;
		nodeToParentMap.put(1,-1);
		while(!q.isEmpty()) {
			int node = q.removeFirst();
			LinkedList<Integer> list = (LinkedList<Integer>) adjList.get(node);
			for(int i:list) {
				if(visited[i]==false) {
					q.addLast(i);
					visited[i]= true;
					nodeToParentMap.put(i, node);
				}else {
					int parent = nodeToParentMap.get(node);
					if(i!=parent) {
						return true;
					}
				}
			}

		}
		return false;
	}
	
	static boolean isCyclePresentRecursively(HashMap<Integer,List<Integer>> adjList,int node,boolean[] visited,boolean[] currentStackCalls) {
		if(visited[node]==true && currentStackCalls[node]==true) {
			return true;
		}
		if(visited[node]==true && currentStackCalls[node]==false) {
			return false;
		}
		if(visited[node]==false) {
			visited[node]=true;
			currentStackCalls[node]=true;
			LinkedList<Integer> allConnectedNodes = (LinkedList<Integer>) adjList.get(node);
			boolean ans = false;
			if (allConnectedNodes!=null) {
				for (int i : allConnectedNodes) {
					ans = ans || isCyclePresentRecursively(adjList, i, visited, currentStackCalls);
					if (ans)
						return true;
				} 
			}
			currentStackCalls[node] = false;
			return ans;
		}
		return false;
	}
	
	static void bfsTraversal(HashMap<Integer,List<Integer>> adjList) {
		System.out.println("BFS traversal :- ");
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(1);
		boolean[] visited = new boolean[7];
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
		System.out.println("\n");
	}

}
