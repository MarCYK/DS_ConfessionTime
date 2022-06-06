/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SQLOperations;

import java.sql.*;

/**
 *
 * @author Irfan
 */
public class waitingListPush {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	operationTest mysql = new operationTest();
	timeClass time = new timeClass();
	
	String thisid = "";
	String replyid = "";
	String content = "";
	try{
	    Connection conn = mysql.getConnection();
	    mysql.sqlAddTo(thisid, replyid, content, time.timeNow(), "waitinglist", conn);
	    
	    conn.close();
	}catch(Exception e){
	    
	}
    }
    
}
