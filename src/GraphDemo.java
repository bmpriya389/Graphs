import java.util.ArrayList;

public class GraphDemo {
	public static void main(String args[]){
	
		//Creating nodes to be added to VEgraph
		Vertex a=new Vertex("a");
		Vertex b=new Vertex("b");
		Vertex c=new Vertex("c");
		Vertex d=new Vertex("d");
		Vertex e=new Vertex("e");
	
		//creating a graph object, if default constructor is used an undirected graph is created
		VEGraph g1=new VEGraph(GraphType.DIRECTED,GraphWeightType.WEIGHTED_POSITIVE,5);
		
		// Adding neighbors to the nodes created earlier
		a.addNeighbor(b,g1);
		a.addNeighbor(c,g1);
		b.addNeighbor(c,g1);
		b.addNeighbor(d,g1);
		c.addNeighbor(b,g1);
		c.addNeighbor(d,g1);
		c.addNeighbor(e,g1);
		d.addNeighbor(e,g1);
		e.addNeighbor(d,g1);
	
		int[] edge_a={0,10,3,0,0};
		int[] edge_b={0,0,1,2,0};
		int[] edge_c={0,4,0,8,2};
		int[] edge_d={0,0,0,0,7};
		int[] edge_e={0,0,0,9,0};

		// Adding nodes to graph g1

		g1.addNodeToGraph(a);
		g1.addNodeToGraph(b);
		g1.addNodeToGraph(c);
		g1.addNodeToGraph(d);
		g1.addNodeToGraph(e);
		
		//Adding edges
		g1.addEdges(a,edge_a);
		g1.addEdges(b,edge_b);
		g1.addEdges(c,edge_c);
		g1.addEdges(d,edge_d);
		g1.addEdges(e,edge_e);

		//display graph g1	
		//g1.displayGraph();
		//.displayEdges();
		//c.displayVertexNeighbors();
		//g1.BFS(a);
		//g1.DFS();
		g1.dijkstra(a);
		g1.best_first(a);

		//g1.bellmanFord(a);
		/*
		//Creating nodes to be added to AdjacenyListGraph
		Node a1=new Node("a1");
		Node b1=new Node("b1");
		Node c1=new Node("c1");
		Node d1=new Node("d1");
		Node e1=new Node("e1");
		
		//creating a graph object, if default constructor is used an undirected graph is created
		AdacencyListGraph g2=new AdacencyListGraph(GraphType.UNDIRECTED,GraphWeightType.UNWEIGHTED,5);
	
		// Adding neighbors to the nodes created earlier
		a1.addNeighbor(b1,g2);
		a1.addNeighbor(c1,g2);
		b1.addNeighbor(c1,g2);
		b1.addNeighbor(e1,g2);
		c1.addNeighbors(b1.neighbors,g2);
		d1.addNeighbor(e1,g2);
		e1.addNeighbor(d1,g2);
		e1.addNeighbor(b1,g2);
	
		// Adding nodes to graph g1
		g2.addNodeToGraph(a1);
		g2.addNodeToGraph(b1);
		g2.addNodeToGraph(c1);
		g2.addNodeToGraph(d1);
		g2.addNodeToGraph(e1);

		//display graph g1	
		g2.displayGraph();
		g2.BFS(a1);
		
		//Creating nodes to be added to AdjacenyMatrixGraph
		Node a2=new Node("a2");
		Node b2=new Node("b2");
		Node c2=new Node("c2");
		Node d2=new Node("d2");
		Node e2=new Node("e2");
		
		// Adding neighbors to the nodes created earlier
		a2.addNeighbor(b2);
		a2.addNeighbor(c2);
		b2.addNeighbor(c2);
		b2.addNeighbor(e2);
		c2.addNeighbor(b2);
		d2.addNeighbor(e2);
		e2.addNeighbor(d2);
		e2.addNeighbor(b2);
	
		ArrayList<Node> nodes=new ArrayList<Node>();
		
		nodes.add(a2);
		nodes.add(b2);
		nodes.add(c2);
		nodes.add(d2);
		nodes.add(e2);
		
		AdjacencyMatrixGraph g3=new AdjacencyMatrixGraph(GraphType.UNDIRECTED,nodes);
		g3.displayGraph();
		g3.BFS(a2);
		*/
	}
}
