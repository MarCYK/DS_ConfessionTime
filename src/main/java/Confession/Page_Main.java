package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */
import java.util.Arrays;
import SQLOperations.operationTest;
import java.sql.*;
import java.util.Scanner;

import static Confession.util.*;
public class Page_Main {
    Graph<String> graph = new Graph<>();
    
    public static void main(String[] args) {
        Tag tag = new Tag();
        System.out.println(new Post("test"));
        System.out.println("\n\n");
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
        user_Page();
    }
    
    public static void user_Page() {
        String str;
        do {
            System.out.println("Welcome to Confession Time");
            str = ask(2,"'0' to close\n'1' to create new post\n'2' to reply to an existing post", "");
            if(isInteger(str)) {
                int choice = Integer.parseInt(str);
                switch(choice) {
                    case 0: return;
                    case 1: newPost();
                    case 2: replyPost();
                }           
            }
        } while(true);
    }
    
    public static void newPost() {
        Scanner in = new Scanner(System.in);
        System.out.println("~~~ Create New Post ~~~");
        System.out.println("Add Content:");
        String content = in.nextLine();
        
        
    }
    
    public static void replyPost() {

    }
}
