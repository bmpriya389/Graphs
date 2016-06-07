import java.util.ArrayList;

/*	This class is used for creating graphs using arrays
 * 	i.e AdjacencyMatrix representation of graphs
 */

public class AdjacencyMatrixGraph extends Graph {
	int[][] nodes;
	
	AdjacencyMatrixGraph() {
		// TODO Auto-generated constructor stub
		this.GT=GraphType.UNDIRECTED;
		this.RepType=GraphRepType.ADJ_MATRIX;
		nodes=new int[0][0];
	}
	
	AdjacencyMatrixGraph(GraphType gt,ArrayList<Node> nodes){
		this.GT=gt;
		this.RepType=GraphRepType.ADJ_MATRIX;
		this.nodes=new int[nodes.size()][nodes.size()];
		
		for(int i=0;i<nodes.size();i++){	
			for(int j=0;j<nodes.size();j++){	
				if(nodes.get(i).neighbors.contains(nodes.get(j))){
					this.nodes[i][j]=1;
					
					if(GT.equals(GraphType.UNDIRECTED))	
						this.nodes[j][i]=1; //adding an extra edge for undirected graphs
					}
				}
			}
	}
	
	AdjacencyMatrixGraph(GraphType gt,int no_of_nodes){
		this.GT=gt;
		this.RepType=GraphRepType.ADJ_MATRIX;
		this.nodes=new int[no_of_nodes][no_of_nodes];
	}
		
	
	
	@Override
	void displayGraph() {
		// TODO Auto-generated method stub
		for(int i=0;i<nodes.length;i++){	
			for(int j=0;j<nodes.length;j++){	
				System.out.print(" " +this.nodes[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
