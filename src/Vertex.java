import java.util.ArrayList;
import java.util.Collection;

/* This class is used for creating vertices in a graph
 * Used in this package to create vertices for Object pointer
 * graph representations
 */

public class Vertex {

	String name;
	ArrayList<Vertex> neighbors=new ArrayList<Vertex>();
	
	Vertex(String v){
		this.name=v;
	}
	
	Vertex(String v, ArrayList<Vertex> neighbors){
		this.name=v;
		this.neighbors=neighbors;
	}
	
	String getVertexName(){
		return this.name;
	}
	
	ArrayList<Vertex> getVertexNeighbors(){
		return this.neighbors;
	}
	
	void addNeighbor(Vertex n, VEGraph g){
		if(this.neighbors.size()<g.no_of_vertices)
			this.neighbors.add(n);
		else
			System.out.println("Number of neighbors cannot exceed total number of vertices");
	}

	void addNeighbors(Collection<Vertex> n, VEGraph g){
		if(n.size()<g.no_of_vertices)
			this.neighbors.addAll(n);
		else
			System.out.println("Number of neighbors cannot exceed total number of vertices");
	}
	
	void displayVertexNeighbors(){
		for(Vertex b:this.neighbors)
			System.out.println(b.getVertexName());
	}
	
}
