package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */
import java.util.Arrays;
import testingWaitingList.operationTest;
import java.sql.*;
public class Page_Main {

    public static void main(String[] args) {
	operationTest sql = new operationTest();
	
        Graph<String> graph1 = new Graph<>();
        String[] vertex = {"1", "2", "3", "4", "5", "6"};
        for (String ver : vertex) {
            graph1.addVertex(ver);
        }
        
        System.out.println(graph1.getAllVertices());

        
        graph1.addEdge("1", "3");
        graph1.addEdge("1", "4");
        graph1.addEdge("2", "5");
        graph1.addEdge("3", "6");
        
        System.out.println(graph1.getNeighbors("1"));
	System.out.println(graph1.getSize("1"));
        System.out.println(graph1.getAllVertices());
	
//	try{
//	    Connection conn = sql.getConnection();
//	    sql.sqlAddToNode(graph1.getKeySet(0), graph1.getNeighbors("1").get(0), null, null, conn);
//	}catch(Exception e){
//	    System.out.println(e.getMessage());
//	}
    }
    
}
