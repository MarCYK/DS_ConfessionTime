/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SQLOperations;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Irfan
 */
public class batchRemoval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	
    }
    
    public void remove(String str,String tablename){
	operationTest mysql = new operationTest();
	Connection conn = mysql.getConnection();
	String statement = "delete from "+tablename+" where thisID = '"+str+"'";
	String select = "select * from "+tablename+" where replyID = '"+str+"'";
	String check = "select * from "+tablename+" where exists(select * from "+tablename+" where replyID = '"+str+"')";
	ResultSet rs = null;
	
	try{
	    while(mysql.sqlSelect(check, conn).next()){		    //check if current node has child(s) or not (if has replies or not)
		rs = mysql.sqlSelect(select, conn);
		rs.next();
		remove(rs.getString("thisID"),tablename);			    //iterate to the child node until reach childless node (post with no replies lmao)(Depth-first Search)
	    }	
	    mysql.sqlDelete(statement, conn);			    //delete the nodes, starting from the most bottom node
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
	
    }
    
}
