package graph;
import java.util.Arrays;
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
import java.util.Stack;
class NodeVsWeight{
	int node;
	int weight;
	public NodeVsWeight(int node,int weight) {
		this.node=node;
		this.weight=weight;
	}
	@Override
	public String toString() {
		return "[node=" + node + ", weight=" + weight + "]";
	}
}
public class ShortestPath_in_Directed_Acyclic_Graph {

	public static void main(String[] args) {
		HashMap<Integer,LinkedList<NodeVsWeight>> adjList = new HashMap<>();
		addEdge(adjList, 0, 1, 5);
		addEdge(adjList, 0, 2, 3);
		addEdge(adjList, 1, 2, 2);
		addEdge(adjList, 1, 3, 6);
		addEdge(adjList, 2, 3, 7);
		addEdge(adjList, 2, 4, 4);
		addEdge(adjList, 2, 5, 2);
		addEdge(adjList, 3, 4, -1);
		addEdge(adjList, 4, 5, -2);
		printAdjList(adjList);
		
		Stack<Integer> topologicalSortedNodes = new Stack<>();
		boolean[] visited = new boolean[6];
		topologicalSort(adjList, topologicalSortedNodes, 0, visited);
		System.out.println(topologicalSortedNodes);
		
		int noOfNodes = 6;
		int srcNode = 1;
		int[] shortestDist = new int[noOfNodes];
		for(int i=0;i<noOfNodes;i++) {
			shortestDist[i]=Integer.MAX_VALUE;
		}
		shortestDist[srcNode]=0;
		while(!topologicalSortedNodes.isEmpty()){
			int node = topologicalSortedNodes.pop();
			if(shortestDist[node]!=Integer.MAX_VALUE) {
				List<NodeVsWeight> allNodes = adjList.get(node);
				if(allNodes!=null) {
					for(NodeVsWeight nodeVsWeight:allNodes) {
						if(shortestDist[node]+nodeVsWeight.weight<shortestDist[nodeVsWeight.node]) {
							shortestDist[nodeVsWeight.node] = shortestDist[node]+nodeVsWeight.weight;
						}
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(shortestDist));
	}
	

	static void topologicalSort(HashMap<Integer,LinkedList<NodeVsWeight>> adjList,Stack<Integer> sortedNode,int src,boolean[] visited) {
		visited[src] =true;
		LinkedList<NodeVsWeight> connectedNodes = adjList.get(src);
		if(connectedNodes!=null) {
			for(NodeVsWeight nodeVsWeight : connectedNodes) {
				if(!visited[nodeVsWeight.node]) {
					topologicalSort(adjList, sortedNode, nodeVsWeight.node, visited);
				}
			}
		}
		sortedNode.push(src);
	}

	//Add new edge
	static void addEdge(HashMap<Integer,LinkedList<NodeVsWeight>> adjList,int src,int dest, int weight) {
		if(adjList.containsKey(src)) {
			LinkedList<NodeVsWeight> values =  adjList.get(src);
			values.add(new NodeVsWeight(dest, weight));
			adjList.put(src, values);
		}else {
			LinkedList<NodeVsWeight> values = new LinkedList<>();
			values.add(new NodeVsWeight(dest, weight));
			adjList.put(src, values);
		}
	}

	//Print Adjacency List
	static void printAdjList(HashMap<Integer,LinkedList<NodeVsWeight>> adjList) {
		System.out.println("****** Adjacency List ******");
		Set<Integer> keySet = adjList.keySet();
		for(int i:keySet) {
			System.out.println(i+ " -> " + adjList.get(i));
		}
		System.out.println("\n");
	}


}
