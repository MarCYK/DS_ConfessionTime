/*
	TESTING
	1.From waiting list, move confession to node/hold list once every n seconds
	Not imply GUI yet, the output can be seen from MySQL IDE and cmd
	Not separate spam post yet
 */
package SQLOperations;

import Confession.Tag;
import Engine.RepostDetection;
import Engine.SpamDetection;
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
	
    }
    
    public void start() {
	timeClass time = new timeClass();
        Tag tag = new Tag();
	operationTest mysql = new operationTest();
        RepostDetection rp = new RepostDetection();
	try{
	    Connection conn = mysql.getConnection();
	    
	    if(mysql.count("waitinglist", conn)!=0){
		ResultSet rs = mysql.sqlSelect("select * from waitinglist limit 1", conn);rs.next();				    //Select first row from waiting list
		
		
		
		
		if(rs.getString("status").equals("1") && !rp.checkRepost(rs.getString("content"))){
		    mysql.sqlAddTo(rs.getString("thisID"), rs.getString("replyID"), rs.getString("content"), time.timeNow(), "node", conn); //Copy the first row to node
		}
		else if(rs.getString("status").equals("0") || rp.checkRepost(rs.getString("content"))){
		    mysql.sqlAddTo(rs.getString("thisID"), rs.getString("replyID"), rs.getString("content"), time.timeNow(), "spam", conn);
		}
		else{
		    JOptionPane.showMessageDialog(null, "update error");
		}
		System.out.println("\n"+rs.getString("thisID")+"\n"+rs.getString("content")+"\nPopped at "+time.timeNow());
		mysql.sqlDelete("delete from waitinglist limit 1", conn);							    //Delete first row from waiting list
                System.out.println("");
	    }
		
	    
	    
	    
	}catch(HeadlessException | SQLException e){
	    JOptionPane.showMessageDialog(null, "u got error btw lmao\n\n"+e.getMessage());
	}
    }
    
}
