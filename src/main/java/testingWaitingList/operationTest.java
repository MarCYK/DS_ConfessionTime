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
}
