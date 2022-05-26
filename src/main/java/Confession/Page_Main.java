package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */
public class Page_Main {

    public static void main(String[] args) {
        Graph<String> graph1 = new Graph<>();
        String[] vertex = {"1", "2", "3", "4", "5", "6"};
        for (String ver : vertex) {
            graph1.addVertex(ver);
        }
        
        System.out.println(graph1.getAllVertices());
        System.out.println(graph1.getSize());
        
        graph1.addEdge("1", "3");
        graph1.addEdge("1", "4");
        graph1.addEdge("2", "5");
        graph1.addEdge("3", "6");
        
        System.out.println(graph1.getNeighbors("1"));
        
        graph1.batchRemoval("1");
        System.out.println(graph1.getSize());
        System.out.println(graph1.getAllVertices());
    }
    
}
