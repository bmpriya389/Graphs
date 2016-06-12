import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

/*	This class is used for creating graphs using objects and pointers
 * 	i.e Object pointer representation of graphs
 */

public class VEGraph extends Graph {
	
	int no_of_vertices;
	
	ArrayList<Vertex> vertices=new ArrayList<Vertex>();
	
	Set<Edge> edges=new LinkedHashSet<Edge>();	
	
	// Used for storing information about the layer associated with a vertex given a start point
	private HashMap<String,Integer> layer=new HashMap<String,Integer>();
	// Used with layer calculations
	private int layer_counter=0;
	
	// to maintain order of insertion and avoid duplicates in visited nodes
	private Set<Vertex> DFS_visited=new LinkedHashSet<Vertex>();

	// Constructors
	
	VEGraph(){
		// default settings; graph with 5 vertices;
		this.no_of_vertices=5;
		this.GT=GraphType.UNDIRECTED;
		this.GWT=GraphWeightType.UNWEIGHTED;
		this.RepType=GraphRepType.VERTEX_EDGE;	
	}
	
	
	VEGraph(GraphType gt,GraphWeightType gwt, int no_of_vertices){
		this.no_of_vertices=no_of_vertices;
		this.GT=gt;
		this.GWT=gwt;
		this.RepType=GraphRepType.VERTEX_EDGE;	
	}

	// utility functions
	void displayEdges(){
		for(Edge e:this.edges){
			System.out.println("FROM: "+ e.getFromVertex() + " TO: "+ e.getToVertex() + " WEIGHT: " + e.getWeight());
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
	
	// Graph Manipulation functions
	
	void addNodeToGraph(Vertex v){
		// check of current vertices list is not exceeding allowed capacity.
		if(vertices.size()<this.no_of_vertices)
			this.vertices.add(v);
	}
	
	void addEdgeToGraph(Edge e){
		// check if total number of edges is not greater than number of edges for complete graphs 
		if(edges.size()<Math.pow(this.no_of_vertices,2))
				this.edges.add(e);
	}
	
	void addEdges(Vertex v, int []weights){
		for(Vertex i:vertices){
			if(this.GT==GraphType.UNDIRECTED){ // code for adding edges for an undirected graph
				if(i.getVertexNeighbors().contains(v) && i!=v){ // condition i!=v assures there  no self edges
				    
					if(!v.getVertexNeighbors().contains(i)) // adds i to v's neighbors if v has i as a neighbor 
						v.getVertexNeighbors().add(i);

					// Assigning weights to graphs
					if(this.GWT==GraphWeightType.UNWEIGHTED){
						edges.add(new Edge(v,i,0));
						edges.add(new Edge(i,v,0));
					}
					else{
						edges.add(new Edge(v,i,weights[vertices.indexOf(i)]));
						edges.add(new Edge(i,v,weights[vertices.indexOf(i)]));
					}
				}
				else{
					System.out.println(i.getVertexName() +" and "+v.getVertexName()+"  not connected, so edge weight "+ weights[vertices.indexOf(i)] +" provided will not be included");
				}
			}
			
			else{
				if(v.getVertexNeighbors().contains(i) && i!=v){
				// code for adding edges and weights for a directed graph
					if(this.GWT==GraphWeightType.UNWEIGHTED)
						edges.add(new Edge(v,i,0));
					else
						edges.add(new Edge(v,i,weights[vertices.indexOf(i)]));
				}
			}
		}	

	}
	
	
	//Traversal functions for unweighted graphs
	
	void BFS(Vertex v) {
		// checks if the graph is a unweighted graph
		
		if(this.GWT==GraphWeightType.UNWEIGHTED){
			LinkedList<Vertex> frontier=new LinkedList<Vertex>();
			Set<Vertex> visited=new LinkedHashSet<Vertex>();
			frontier.add(v);
			Vertex current;		
			
			while(!frontier.isEmpty()){
				current=frontier.removeFirst();
				for(Vertex j:current.getVertexNeighbors()){
					if(!visited.contains(j)){
						frontier.add(j);
					}
				}
				visited.add(current);
			}
			
			for(Vertex k:visited)
				System.out.println(" Visited BFS " + k.getVertexName());
			
			}
		else
			System.out.println("Cannot do a Bread First Search to find shortest paths in weighted graphs");
			
	}

	void DFS() {
		layer_counter=0;
		// checks if the graph is a unweighted graph
		if(this.GWT==GraphWeightType.UNWEIGHTED){
			for(Vertex i:this.vertices){
					if(!DFS_visited.contains(i)){
						DFS_visited.add(i);
						layer.put(i.getVertexName(), layer_counter);
						DFS_visit(i);
					}
				}
				for(Vertex k:DFS_visited)
					System.out.println(" Visited DFS " + k.getVertexName());
		}
		else
			System.out.println("Cannot do a Depth First Search to explore weighted graphs");
		
	}		
	
	void DFS_visit(Vertex s){
		for(Vertex j: s.getVertexNeighbors()){
			if(!DFS_visited.contains(j)){
				DFS_visited.add(j);
				layer.put(j.getVertexName(),layer_counter++);
				DFS_visit(j);
			}
		}
	}
	
	// Shortest path functions for weighted graphs
	void dijkstra(Vertex a){
		Set<String> S=new LinkedHashSet<String>();  
		HashMap<Vertex,Double> Q=new HashMap<>();
		double min=Double.POSITIVE_INFINITY;
		HashMap<Vertex,Double> totalcost=new HashMap<>();
		HashMap<Vertex,Vertex> parent=new HashMap<>();
		
		Vertex u=a;
		
		//Initialization
		for(Vertex i:vertices)
			Q.put(i,min);
		Q.put(u,0.0);
		totalcost.put(u,0.0);
		parent.put(u, new Vertex("None",null));
		
		while(!Q.isEmpty()){
			min=Double.POSITIVE_INFINITY;
			
			// EXTRACT_MIN
			for(Entry<Vertex, Double> e:Q.entrySet()){ 	
				if(e.getValue()<=min){
					min=e.getValue();
					u=e.getKey();
				}
			}
			
			totalcost.put(u, min);
			
			
			S.add(u.getVertexName());
			Q.remove(u);
			
			
			//Relaxing
			for(Vertex n:u.neighbors){
				if(!S.contains(n.getVertexName())){
					for(Edge m:edges){
						if(m.from==u && m.to==n){
							Q.put(n,totalcost.get(u)+(double)m.weight);
							parent.put(n, u);
						}
					}
				}
			}
		}
		
		for(Vertex v:vertices){
			System.out.println("Vertex: "+v.getVertexName()+" Parent: "+ parent.get(v).getVertexName() + " Shortest Path Cost "+totalcost.get(v));
		}
	
		
	}
	
	
	void bellmanFord(Vertex a){
		int pass=0;
		HashMap<Vertex,Entry<Double,Edge>> Q=new HashMap<>();
		Vertex u=a;
		
		//Initialization
		for(Vertex i:vertices)
			Q.put(i,new AbstractMap.SimpleEntry<Double,Edge>(Double.POSITIVE_INFINITY, null));
		Q.put(u,new AbstractMap.SimpleEntry<Double,Edge>(0.0, new Edge(a,a,0)));
		
		while(pass<this.no_of_vertices){
		pass++;
			for(Edge e:edges){
				if(Q.get(e.from).getKey()+e.getWeight()<Q.get(e.to).getKey())
					Q.put(e.to,new AbstractMap.SimpleEntry<Double, Edge>((double)e.getWeight()+Q.get(e.from).getKey(),e));
			}
		}
		
		for(Edge e:edges){
			if(Q.get(e.to).getKey()>Q.get(e.from).getKey()+ e.getWeight()){
				System.out.println("Negative cycle exists");
			}
		}
		
		for(Entry<Vertex,Entry<Double,Edge>> bell:Q.entrySet()){
			System.out.println(
					"Vertex: "+((Vertex) bell.getKey()).getVertexName()+" Min Distance " +((Entry<Double,Edge>) bell.getValue()).getKey()+" via edge " +((Entry<Double,Edge>) bell.getValue()).getValue().getFromVertex()+"->"
					+((Entry<Double,Edge>) bell.getValue()).getValue().getToVertex());
		}
	}
	
	
	void best_first(Vertex a){
		//heuristic function: vertex.index
		Set<String> S=new LinkedHashSet<String>();  
		HashMap<Vertex,Double> Q=new HashMap<>();
		double min=Double.POSITIVE_INFINITY;
		
		HashMap<Vertex,Double> totalcost=new HashMap<>();
		HashMap<Vertex,Vertex> parent=new HashMap<>();
		
		Vertex u=a;
		
		//Initialization
		for(Vertex i:vertices)
			Q.put(i,min);
		Q.put(u,0.0);
		totalcost.put(u,0.0);
		parent.put(u, new Vertex("None",null));
		
		while(!Q.isEmpty()){
			min=Double.POSITIVE_INFINITY;
			
			// EXTRACT_MIN
			for(Entry<Vertex, Double> e:Q.entrySet()){ 	
				if(e.getValue()<=min){
					min=e.getValue();
					u=e.getKey();
				}
			}
			
			totalcost.put(u, min);
			
			
			S.add(u.getVertexName());
			Q.remove(u);
			
			
			//Relaxing
			for(Vertex n:u.neighbors){
				if(!S.contains(n.getVertexName())){
					for(Edge m:edges){
						if(m.from==u && m.to==n){
							Q.put(n,min+(vertices.indexOf(u)));
							parent.put(n, u);
						}
					}
				}
			}
		}
		
		for(Vertex v:vertices){
			System.out.println("Vertex: "+v.getVertexName()+" Parent: "+ parent.get(v).getVertexName() + " Shortest Path Cost "+totalcost.get(v));
		}
	}
}
