/*
	TESTING
	1.From waiting list, move confession to node/hold list once every n seconds
	Not imply GUI yet, the output can be seen from MySQL IDE and cmd
	Not separate spam post yet
 */
package SQLOperations;

import Confession.Tag;
import java.awt.HeadlessException;
import SQLOperations.operationTest;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Irfan
 */
public class waitingListPop {
    
    public static void main(String[] args) {
	start();
    }
    
    public static void start() {
	timeClass time = new timeClass();
        Tag tag = new Tag();
	operationTest mysql = new operationTest();
	try{
	    Connection conn = mysql.getConnection();
	    
	    ResultSet rs = mysql.sqlSelect("select * from waitinglist limit 1", conn);rs.next();				    //Select first row from waiting list
	    mysql.sqlAddTo(rs.getString("thisID"), rs.getString("replyID"), rs.getString("content"), time.timeNow(), "node", conn); //Copy the first row to node
	    System.out.println("\n"+rs.getString("thisID")+"\n"+rs.getString("content")+"\n"+time.timeNow());
	    mysql.sqlDelete("delete from waitinglist limit 1", conn);							    //Delete first row from waiting list
	    System.out.println("test");
		
	    
	    
	    
	}catch(HeadlessException | SQLException e){
	    JOptionPane.showMessageDialog(null, "u got error btw lmao\n\n"+e.getMessage());
	}
    }
    
}
