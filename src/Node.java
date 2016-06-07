import java.util.ArrayList;
import java.util.Collection;

/* This class is used for creating nodes in a graph
 * Used in this package to create nodes for Adjacency List graph 
 * and Adjacency matrix graph representations
 */

public class Node {
	
	String name; 
	ArrayList<Node> neighbors; 
	
	//Constructor definition
	Node(String name){
		this.name=name;
		this.neighbors=new ArrayList<Node>();
	}
	
	// Creating getter and setter methods
	String getNodeName(Node m){
		return m.name;
	}
	
	ArrayList<Node> getNodeNeighbours(Node m){
		return m.neighbors;
	}
	
	void setNodeName(String name){
		this.name=name;
	}
	
	// add neighbors to a node
	void addNeighbor(Node n){
		this.neighbors.add(n);
	}

	void addNeighbors(Collection<Node> n){
		this.neighbors.addAll(n);
	}
	
}
