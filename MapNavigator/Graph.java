package MapNavigator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final HashMap<String, List<Edge>> adj;   //adjacency List
    public Graph(){
        this.adj=new HashMap<>();
    }
    public void addNode(String node){ //Only for new Node which does not exist in the hashmap
        adj.putIfAbsent(node,new ArrayList<>());
    }
    public void addEdge(String source,String destination,int weight){
        addNode(source);
        addNode(destination);
        for(Edge edge : adj.get(source)){
            if(edge.destination.equals(destination)){
                System.out.println("This Edge already exist.");
                return;
            }
        }
        adj.get(source).add(new Edge(destination,weight));
    }

    public HashMap<String, List<Edge>> getAdj() {
        return adj;
    }

    public void printGraph(){
        for (Map.Entry<String,List<Edge>> entry : adj.entrySet()){
            System.out.print(entry.getKey()+" -> ");
            for(Edge e : entry.getValue()){
                System.out.print(e.destination+"("+e.distance+") ");
            }
            System.out.println();
        }
    }
}
