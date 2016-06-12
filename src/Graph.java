import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

// Abstract super class for graph representations

public abstract class Graph {
	GraphRepType RepType;
	GraphType GT;
	GraphWeightType GWT;

	abstract void displayGraph();
	
	void BFS(Node v) {
		// checks if the graph is a unweighted graph
		if(this.GWT==GraphWeightType.UNWEIGHTED){	
			LinkedList<Node> frontier=new LinkedList<Node>();
			Set<Node> visited=new LinkedHashSet<Node>();
			frontier.add(v);
			Node current;		
			
			while(!frontier.isEmpty()){
				current=frontier.removeFirst();
				for(Node j:current.neighbors){
					if(!visited.contains(j)){
						frontier.add(j);
					}
				}
				visited.add(current);
			}
			
			for(Node k:visited)
				System.out.println("Visited " + k.getNodeName());
		
		}
		else{
			System.out.println("Cannot do a Bread First Search to find shortest paths in weighted graphs");
		}
	}
	
}
