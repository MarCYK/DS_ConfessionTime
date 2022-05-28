package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */
import java.util.Arrays;
import testingWaitingList.operationTest;
import java.sql.*;

import static Confession.util.*;
public class Page_Main {

    public static void main(String[] args) {
        
//	  operationTest sql = new operationTest();
//	
//        Graph<String> graph1 = new Graph<>();
//        String[] vertex = {"1", "2", "3", "4", "5", "6"};
//        for (String ver : vertex) {
//            graph1.addVertex(ver);
//        }
//        
//        System.out.println(graph1.getAllVertices());
//
//        
//        graph1.addEdge("1", new Post(1, "Test1"));
//        graph1.addEdge("1", new Post(2, "Test2"));
//        graph1.addEdge("2", new Post(3, "Test3"));
//        graph1.addEdge("3", new Post(4, "Test4"));
//        
//        System.out.println(graph1.getNeighbors("1"));
//	System.out.println(graph1.getSize("1"));
//        System.out.println(graph1.getAllVertices());
//	
//        Post post = new Post(1, "Test");
//        System.out.println(post);
//	try{
//	    Connection conn = sql.getConnection();
//	    sql.sqlAddToNode(graph1.getKeySet(0), graph1.getNeighbors("1").get(0), null, null, conn);
//	}catch(Exception e){
//	    System.out.println(e.getMessage());
//	}
    }
    
    public static void user_Pager() {
        String str;
        do {
            str =ask(1, "Enter '0' to create new post\n or '1' to reply to an existing post\n or '-1' to close", "");
        }
    }
}
