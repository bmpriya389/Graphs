import java.util.ArrayList;

public class GraphDemo {
	public static void main(String args[]){
	
		//Creating nodes to be added to VEgraph
		Vertex a=new Vertex("a");
		Vertex b=new Vertex("b");
		Vertex c=new Vertex("c");
		Vertex d=new Vertex("d");
		Vertex e=new Vertex("e");
		
		// Adding neighbors to the nodes created earlier
		a.addNeighbor(b);
		a.addNeighbor(c);
		b.addNeighbor(c);
		b.addNeighbor(e);
		c.addNeighbors(b.neighbors);
		d.addNeighbor(e);
		e.addNeighbor(d);
		e.addNeighbor(b);
	
		
		//creating a graph object, if default constructor is used an undrected graph is created
		VEGraph g1=new VEGraph(GraphType.UNDIRECTED);
		
		// Adding nodes to graph g1
		g1.addNodeToGraph(a);
		g1.addNodeToGraph(b);
		g1.addNodeToGraph(c);
		g1.addNodeToGraph(d);
		g1.addNodeToGraph(e);

		//display graph g1	
		g1.displayGraph();
		
		
		//Creating nodes to be added to AdjacenyListGraph
		Node a1=new Node("a1");
		Node b1=new Node("b1");
		Node c1=new Node("c1");
		Node d1=new Node("d1");
		Node e1=new Node("e1");
		
		// Adding neighbors to the nodes created earlier
		a1.addNeighbor(b1);
		a1.addNeighbor(c1);
		b1.addNeighbor(c1);
		b1.addNeighbor(e1);
		c1.addNeighbors(b1.neighbors);
		d1.addNeighbor(e1);
		e1.addNeighbor(d1);
		e1.addNeighbor(b1);
	
		
		//creating a graph object, if default constructor is used an undrected graph is created
		AdacencyListGraph g2=new AdacencyListGraph(GraphType.DIRECTED);
		
		// Adding nodes to graph g1
		g2.addNodeToGraph(a1);
		g2.addNodeToGraph(b1);
		g2.addNodeToGraph(c1);
		g2.addNodeToGraph(d1);
		g2.addNodeToGraph(e1);

		//display graph g1	
		g2.displayGraph();
		
		
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
		c2.addNeighbors(b2.neighbors);
		d2.addNeighbor(e2);
		e2.addNeighbor(d2);
		e2.addNeighbor(b2);
	
		ArrayList<Node> nodes=new ArrayList<Node>();
		
		nodes.add(a2);
		nodes.add(b2);
		nodes.add(c2);
		nodes.add(d2);
		nodes.add(e2);
		
		AdjacencyMatrixGraph g3=new AdjacencyMatrixGraph(GraphType.DIRECTED,nodes);
		g3.displayGraph();
		
	}
}
