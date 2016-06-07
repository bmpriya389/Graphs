import java.util.ArrayList;

/*	This class is used for creating graphs using objects and pointers
 * 	i.e Object pointer representation of graphs
 */

public class VEGraph extends Graph {
	
	ArrayList<Vertex> vertices=new ArrayList<Vertex>();

	ArrayList<Edge> edges=new ArrayList<Edge>();	
	
	VEGraph(){
		this.GT=GraphType.UNDIRECTED;
		this.RepType=GraphRepType.VERTEX_EDGE;	
	}
	
	VEGraph(GraphType gt){
		this.GT=gt;
		this.RepType=GraphRepType.VERTEX_EDGE;	
	}
	
	VEGraph(GraphType gt, ArrayList<Vertex> vertices,ArrayList<Edge> edges){
		this.GT=gt;
		this.RepType=GraphRepType.VERTEX_EDGE;
		this.vertices.addAll(vertices);
		this.edges.addAll(edges);
	}
	
	void addNodeToGraph(Vertex v){
		this.vertices.add(v);
		
		for(Vertex i:vertices){
			if(this.GT==GraphType.UNDIRECTED){	
				// code for adding edges for an undirected graph
				if(i.neighbors.contains(v) && i!=v){
					if(!v.neighbors.contains(i)) 
						v.neighbors.add(i);
					edges.add(new Edge(v,i));
					edges.add(new Edge(i,v));
				}	
			}
			else{
				// code for adding edges for a directed graph
				edges.add(new Edge(v,i));
				}
		}	
	}
	
	@Override
	void displayGraph(){
		for(Edge i:edges){
			if(this.GT==GraphType.UNDIRECTED)	
				System.out.println(i.from.name +" -- "+ i.to.name);
			else
				System.out.println(i.from.name +" --> "+ i.to.name);
		}
	}

}
