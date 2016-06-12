/* This class is used for creating edges in a graph 
 * for Object pointer graph representations
 */

public class Edge {
	
	Vertex from,to;
	int weight;
	
	Edge(Vertex from, Vertex to,int weight){
		this.from = from;
		this.to=to;
		this.weight=weight;
	}
	
	String getFromVertex(){
		return this.from.name;
	}
	
	String getToVertex(){
		return this.to.name;
	}
	
	int getWeight(){
		return this.weight;
	}
	
}
