/* This class is used for creating edges in a graph 
 * for Object pointer graph representations
 */

public class Edge {
	
	Vertex from,to;
	
	Edge(Vertex from, Vertex to){
		this.from = from;
		this.to=to;
	}
	
	String getFromVertex(){return this.from.name;}
	
	String getToVertex(){return this.to.name;}
}
