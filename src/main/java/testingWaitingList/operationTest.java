/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testingWaitingList;
import java.sql.*;
//import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
/**
 *
 * @author Irfan
 */
public class operationTest {
    public Connection getConnection(){
	final String user = "root";
        final String pass = "rotikeju";
        final String path = "jdbc:mysql://localhost:3306/confession";

        final String driver = "com.mysql.cj.jdbc.Driver";
        Connection myConn = null;
        try {
            Class.forName(driver);
            myConn = DriverManager.getConnection(path, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Connection refused!!!");
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText(null);
//            alert.setContentText("Connection refused!!!");
//            alert.showAndWait();
        }

        return myConn;
    }
    
    public ResultSet sqlSelect(String str,Connection conn){
	try{
	    PreparedStatement prp = conn.prepareStatement(str);
	    ResultSet rs = prp.executeQuery();
	    return rs;
	}catch(SQLException e){
	    System.out.println(e.getMessage());
//	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText(null);
//            alert.setContentText("SQL Selection Error");
	    return null;
	}
    }
    
    public void sqlDelete(String str,Connection conn){
	try{
	    PreparedStatement prp = conn.prepareStatement(str);
	    prp.executeUpdate();
	}catch(Exception e){
	    System.out.println(e.getMessage());
//	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText(null);
//            alert.setContentText("SQL Deletion Error");
	}
    }
    
    public void sqlAddToNode(String thisid,String replyid,String content,String date,Connection conn){
	try{
	    PreparedStatement prp = conn.prepareStatement("insert into node (thisID,replyID,content,date) values (?,?,?,?)");
	    prp.setString(1, thisid);
	    prp.setString(2, replyid);
	    prp.setString(3, content);
	    prp.setString(4, date);
	    
	    prp.execute();
	    
	}catch(SQLException e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
    }
    
    public int count(String tableName,Connection conn){
	try{
	    PreparedStatement prp = conn.prepareStatement("select count(*) from "+tableName);
	    ResultSet rs=prp.executeQuery();
	    rs.next();
	    return rs.getInt(1);
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	    return -1;
	}
	
	
    }
}
