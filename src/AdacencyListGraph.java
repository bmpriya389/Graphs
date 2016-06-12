import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/*	This class is used for creating graphs arraylists
 * 	i.e Adjacency List representation of graphs
 */

public class AdacencyListGraph extends Graph{
	int no_of_nodes;
	// List of nodes in the Graph
	ArrayList<Node> nodes=new ArrayList<Node>();
	private Set<Node> DFS_visited=new LinkedHashSet<Node>();

	AdacencyListGraph(){
		// default graph with 5 vertices.
		this.no_of_nodes=5;
		this.GT=GraphType.UNDIRECTED;
		this.GWT=GraphWeightType.UNWEIGHTED;
		this.RepType=GraphRepType.ADJ_LIST;	
	}
	
	AdacencyListGraph(GraphType gt, GraphWeightType gwt, int no_of_nodes){
		this.no_of_nodes=no_of_nodes;
		this.GT=gt;
		this.GWT=gwt;
		this.RepType=GraphRepType.ADJ_LIST;	
	}
	
	AdacencyListGraph(GraphType gt,GraphWeightType gwt, ArrayList<Node> nodes){
		this.nodes.addAll(nodes);
		this.no_of_nodes=this.nodes.size();
		this.GT=gt;
		this.GWT=gwt;
		this.RepType=GraphRepType.ADJ_LIST;
	}
	
	void addNodeToGraph(Node n){
		if(this.nodes.size()<this.no_of_nodes){
			this.nodes.add(n);
				if(this.GT==GraphType.UNDIRECTED){
					/* 	Code for adding in neighbors for a node and listing
					 * this node in the neighbor's neighbor list when the graph
					 * is undirected */
					for(Node i:nodes){
						if(i.getNodeNeighbors().contains(n) && !n.getNodeNeighbors().contains(i) && i!=n){
							n.getNodeNeighbors().add(i);
						
						}
					}
				}
		}
		else{
			System.out.println("Cannot add more nodes to this graph");
		}
	}
	
	void DFS() {
		for(Node i:this.nodes){
			if(!DFS_visited.contains(i)){
				System.out.println(i.name);
				DFS_visited.add(i);
				DFS_visit(i);
			}
		}
		for(Node k:DFS_visited)
			System.out.println("Visited " + k.getNodeName());	
	}		
	
	void DFS_visit(Node s){
		if(this.GWT==GraphWeightType.UNWEIGHTED){
			for(Node j: s.getNodeNeighbors()){
				if(!DFS_visited.contains(j)){
					System.out.println(j.name);
					DFS_visited.add(j);
					DFS_visit(j);
				}
			}
		}	
		else{
			System.out.println("Cannot do a Depth First Search to explore weighted graphs");
		}
	}
	
	void displayGraph(){
		for(Node i:nodes){
			System.out.print(i.name+" | ");
			if(!i.getNodeNeighbors().isEmpty()){
				for(Node k:i.getNodeNeighbors()){
					System.out.print(" -" + k.name);
				}
				System.out.println();
			}
		}
	}
	
}
