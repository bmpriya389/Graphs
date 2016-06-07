import java.util.ArrayList;

/*	This class is used for creating graphs arraylists
 * 	i.e Adjacency List representation of graphs
 */

public class AdacencyListGraph extends Graph{
	// List of nodes in the Graph
	ArrayList<Node> nodes=new ArrayList<Node>();
	
	AdacencyListGraph(){
		this.GT=GraphType.UNDIRECTED;
		this.RepType=GraphRepType.ADJ_LIST;	
	}
	
	AdacencyListGraph(GraphType gt){
		this.GT=gt;
		this.RepType=GraphRepType.ADJ_LIST;	
	}
	
	AdacencyListGraph(GraphType gt, ArrayList<Node> nodes){
		this.nodes.addAll(nodes);
		this.GT=gt;
		this.RepType=GraphRepType.ADJ_LIST;
	}
	
	void addNodeToGraph(Node n){
		this.nodes.add(n);
		if(this.GT==GraphType.UNDIRECTED){
			
			/* 	Code for adding in neighbors for a node and listing
			 * this node in the neighbor's neighbor list when the graph
			 * is undirected */
			
			for(Node i:nodes){
				if(i.neighbors.contains(n) && !n.neighbors.contains(i) && i!=n){
					n.neighbors.add(i);
				}
			}
		}
			
	}
	
	void displayGraph(){
		for(Node i:nodes){
			System.out.print(i.name+" | ");
			if(!i.neighbors.isEmpty()){
				for(Node k:i.neighbors){
					System.out.print(" -" + k.name);
				}
				System.out.println();
			}
		}
	}
	
}
