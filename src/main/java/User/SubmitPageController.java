/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package User;

import Confession.Tag;
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
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
    @FXML
    private Button cmd_Back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        content.setWrapText(true);
    }    

    @FXML
    private void submitBtn(ActionEvent event) {
	Tag tag = new Tag();
	String thisid = tag.makeTag();
	String replyid = replyID.getText();
	String content = this.content.getText();
	String date = time.timeNow();
	
	SpamDetection spm = new SpamDetection();
	RepostDetection rp = new RepostDetection();
        try{
	    ResultSet check = sql.sqlSelect("select * from node where exists(select * from node where thisID = '"+replyid+"')", conn);
	    if(check.next()){
		if(spm.classifySpam(content)||rp.checkRepost(content)){
		    try {
		    PreparedStatement prp = conn.prepareStatement("insert into waitinglist (thisID,replyID,content,date,status) values (?,?,?,?,?)");
		    prp.setString(1, thisid);
		    prp.setString(2, replyid);
		    prp.setString(3, content);
		    prp.setString(4, date);
		    prp.setString(5, "0");

		    prp.execute();

		} catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, e.getMessage());
		}
		}else{
		   try {
		    PreparedStatement prp = conn.prepareStatement("insert into waitinglist (thisID,replyID,content,date,status) values (?,?,?,?,?)");
		    prp.setString(1, thisid);
		    prp.setString(2, replyid);
		    prp.setString(3, content);
		    prp.setString(4, date);
		    prp.setString(5, "1");

		    prp.execute();

		} catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, e.getMessage());
		}
		}
	    
            JOptionPane.showMessageDialog(null, ">>Submitted at "+time.timeNow()+"\n>>Your Confession ID is "+thisid+"\n>>Your Submission Will be Published Soon");
	    }else{
		JOptionPane.showMessageDialog(null, "ID Not Exist !");
	    }
	    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        this.content.setText("");
      
    }

    @FXML
    private void BackPressed(ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserInterface.fxml"));

		Scene scene = new Scene(root);
	//        scene.getStylesheets().add("/styles/submission.css");
		scene.getStylesheets().add("/styles/userinterface.css");
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		stage.setTitle("Confession Time");
		stage.setScene(scene);
		stage.show();
    }
}
