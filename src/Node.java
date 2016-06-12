import java.util.ArrayList;
import java.util.Collection;

/* This class is used for creating nodes in a graph
 * Used in this package to create nodes for Adjacency List graph 
 * and Adjacency matrix graph representations
 */

public class Node {
	
	String name; 
	int weight;
	ArrayList<Node> neighbors; 
	
	//Constructor definition
	Node(String name){
		this.name=name;
		this.weight=0;
		this.neighbors=new ArrayList<Node>();
	}
	
	// Creating getter and setter methods
	String getNodeName(){
		return this.name;
	}
	
	ArrayList<Node> getNodeNeighbors(){
		return this.neighbors;
	}
	
	void setNodeName(String name){
		this.name=name;
	}
	
	// add neighbors to a node
	void addNeighbor(Node n, AdacencyListGraph g){
		if(this.neighbors.size()<g.no_of_nodes)
			this.neighbors.add(n);
		else
			System.out.println("Number of neighbors cannot exceed total number of nodes");

	}
	
	void addNeighbor(Node n){
		this.neighbors.add(n);
	}

	void addNeighbors(Collection<Node> n, AdacencyListGraph g){
		if(n.size()<g.no_of_nodes)
			this.neighbors.addAll(n);
		else
			System.out.println("Number of neighbors cannot exceed total number of nodes");

	}
	
}
