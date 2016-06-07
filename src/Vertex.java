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
	
	void addNeighbor(Vertex n){
		this.neighbors.add(n);
	}

	void addNeighbors(Collection<Vertex> n){
		this.neighbors.addAll(n);
	}
}
