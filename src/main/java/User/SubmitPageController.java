/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package User;

import Engine.RepostDetection;
import Engine.SpamDetection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.*;
import SQLOperations.*;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author pirvi
 */
public class SubmitPageController implements Initializable {
    
    @FXML
    private TextArea content;
    @FXML
    private TextField replyID;
    @FXML
    private Button submit;
    
    operationTest sql = new operationTest();
    timeClass time = new timeClass();
    Connection conn = sql.getConnection();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
//    private void submitBtn(ActionEvent event) {
//	String thisid = "";
//	String replyid = "";
//	String content = "";
//	String date = "";
//	
//	SpamDetection spm = new SpamDetection();
//	RepostDetection rp = new RepostDetection();
//	String stats = "";
//        try{
//	    
//            sql.sqlAddTo("", replyID.getText(), content.getText(), time.timeNow(), "waitinglist", conn);
//	    
//	    if(spm.classifySpam(content.getText())||rp.checkRepost(content.getText())){
//		    try {
//		    PreparedStatement prp = conn.prepareStatement("insert into waitinglist (thisID,replyID,content,date) values (?,?,?,?)");
//		    prp.setString(1, thisid);
//		    prp.setString(2, replyid);
//		    prp.setString(3, content);
//		    prp.setString(4, date);
//
//		    prp.execute();
//
//		} catch (SQLException e) {
//		    JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//		}else{
//		    try{
//			PreparedStatement prp = conn.prepareStatement("update waitinglist set status = ? where thisID = '"+rs.getString("thisID")+"'");
//			prp.setString(1, "1");
//			prp.executeUpdate();
//		    }catch(Exception e){
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		    }
//		}
//	    
//            JOptionPane.showMessageDialog(null, ">>Submitted at "+time.timeNow()+"\n>>Your Confession ID is U200\n>>Your Submission Will be Published Soon");
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
    
    
}
