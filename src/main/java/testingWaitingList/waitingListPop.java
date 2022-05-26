/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testingWaitingList;

import testingWaitingList.operationTest;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Irfan
 */
public class waitingListPop {
    
    
    
    public static void main(String[] args) {
	timeClass<String> time = new timeClass<>();
	operationTest mysql = new operationTest();
	try{
	    Connection conn = mysql.getConnection();
	    String isEmpty = "select * from waitinglist";
	    while(mysql.sqlSelect(isEmpty, conn).next()){
		ResultSet rs = mysql.sqlSelect("select * from waitinglist limit 1", conn);rs.next();
		System.out.println("\n"+rs.getString("thisID")+"\n"+rs.getString("content")+"\n"+time.timeNow());
		mysql.sqlDelete("delete from waitinglist limit 1", conn);
		Thread.sleep(10000L);
	    }
	    JOptionPane.showMessageDialog(null, "The waiting list is now empty");
	    
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, "u got error btw lmao\n\n"+e);
	}
    }
    
}
