package MapNavigator;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Graph graph =new Graph();
        boolean flag=true;
        while(flag){
            System.out.println("-----------");
            System.out.println("\n1.Add Edge\n2.Display Graph\n3.Find Shortest Path\n4.Exit");
            System.out.println("Choose an Option : ");
            int option=s.nextInt();

            switch (option){
                case 1 :
                    System.out.println("Enter the Source : ");
                    String source=s.next();
                    System.out.println("Enter Destination : ");
                    String destination=s.next();
                    System.out.println("Enter distance : ");
                    int distance=s.nextInt();
                    graph.addEdge(source,destination,distance);
                    break;

                case 2:
                    graph.printGraph();
                    break;

                case 3:
                    System.out.println("Enter Start Point : ");
                    String startPoint=s.next();
                    HashMap<String,Integer> shortestPath=Dijkstra.findShortestPath(graph,startPoint);
                    Dijkstra.printShortestPath(shortestPath);
                    break;

                case 4:
                    flag=false;
                    break;

                default:
                    System.out.println("Enter a valid option");
            }
        }
    }
}
