package MapNavigator;

import java.util.*;

public class Dijkstra {
    public static HashMap<String,Integer> findShortestPath(Graph graph,String sourceNode){
        HashMap<String,Integer> distances=new HashMap<>();
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b) -> (a.distance - b.distance));
        Set<String> visited=new HashSet<>();   //to check for the node is visited or not

        for(String node : graph.getAdj().keySet()){
            distances.put(node,Integer.MAX_VALUE);
        }
        distances.put(sourceNode,0);
        pq.add(new Node(sourceNode,0));

        while(!pq.isEmpty()){
            Node cur=pq.poll();

            if(visited.contains(cur.name)) continue;
            visited.add(cur.name);

            for(Edge edge : graph.getAdj().get(cur.name)){
                if(visited.contains(edge.destination)) continue;

                int newDist= cur.distance+ edge.distance;
                if(newDist < distances.get(edge.destination)){
                    distances.put(edge.destination, newDist);
                    pq.add(new Node(edge.destination,newDist));
                }

            }
        }

        return distances;
    }

    public static void printShortestPath(HashMap<String,Integer> path){
        for(Map.Entry<String,Integer> m : path.entrySet()){
            System.out.println(m.getKey()+" -> "+m.getValue());
        }
    }
}
