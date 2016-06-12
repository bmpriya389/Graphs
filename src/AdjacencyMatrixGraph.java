import java.util.ArrayList;

/*	This class is used for creating graphs using arrays
 * 	i.e AdjacencyMatrix representation of graphs
 */

public class AdjacencyMatrixGraph extends Graph {
	String[][] nodes;
//	private Set<String> DFS_visited=new LinkedHashSet<String>();

	AdjacencyMatrixGraph() {
		// TODO Auto-generated constructor stub
		this.GT=GraphType.UNDIRECTED;
		this.RepType=GraphRepType.ADJ_MATRIX;
		nodes=new String[0][0];
	}
	
	AdjacencyMatrixGraph(GraphType gt,ArrayList<Node> nodes){
		this.GT=gt;
		this.RepType=GraphRepType.ADJ_MATRIX;
		this.nodes=new String[nodes.size()][nodes.size()];
		for(int i=0;i<nodes.size();i++){	
			for(int j=0;j<nodes.size();j++){	
				if(nodes.get(i).getNodeNeighbors().contains(nodes.get(j))){
					this.nodes[i][j]=(String) nodes.get(j).getNodeName();
					if(GT.equals(GraphType.UNDIRECTED))	
						this.nodes[j][i]=(String) nodes.get(i).getNodeName();
				}
			}
		}
	}
	
	AdjacencyMatrixGraph(GraphType gt,int no_of_nodes){
		this.GT=gt;
		this.RepType=GraphRepType.ADJ_MATRIX;
		this.nodes=new String[no_of_nodes][no_of_nodes];
	}
		

	@Override
	void displayGraph() {
		// TODO Auto-generated method stub
		for(int i=0;i<nodes.length;i++){	
			for(int j=0;j<nodes.length;j++){	
				if(this.nodes[i][j]!=null)
					System.out.print(" " +this.nodes[i][j]+" ");
				else
					System.out.print(" 0 ");
			}
			System.out.println();
		}
	}
	
}
