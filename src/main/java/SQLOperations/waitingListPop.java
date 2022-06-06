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
	timeClass time = new timeClass();
        Tag tag = new Tag();
	operationTest mysql = new operationTest();
	try{
	    Connection conn = mysql.getConnection();
	    String isEmpty = "select * from waitinglist where exists(select * from waitinglist limit 1)";
	    while(mysql.sqlSelect(isEmpty, conn).next()){
		ResultSet rs = mysql.sqlSelect("select * from waitinglist limit 1", conn);rs.next();				    //Select first row from waiting list
		mysql.sqlAddTo(tag.makeTag(), rs.getString("replyID"), rs.getString("content"), rs.getString("date"), "node", conn); //Copy the first row to node
		System.out.println("\n"+rs.getString("thisID")+"\n"+rs.getString("content")+"\n"+rs.getString("date"));
		mysql.sqlDelete("delete from waitinglist limit 1", conn);							    //Delete first row from waiting list
		System.out.println("test");
		if(mysql.count("waitinglist", conn)>10){									    //Delay time depends on waiting list's size
		    Thread.sleep(10000L);
		}
		else if(mysql.count("waitinglist", conn)>5){
		    Thread.sleep(5000L);
		}
		else{
		    Thread.sleep(3000L);
		}
		
	    }
	    JOptionPane.showMessageDialog(null, "The waiting list is now empty");
	    
	}catch(HeadlessException | InterruptedException | SQLException e){
	    JOptionPane.showMessageDialog(null, "u got error btw lmao\n\n"+e.getMessage());
	}
    }
    
}
