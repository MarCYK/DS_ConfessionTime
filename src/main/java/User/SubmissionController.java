/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package User;

import Confession.Tag;
import SQLOperations.operationTest;
import SQLOperations.timeClass;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marvin Chin Yi Kai
 */
public class SubmissionController implements Initializable {

    @FXML
    private Button cmd_onSubmit;
    @FXML
    private TextField txt_Comment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSubmit(ActionEvent event) {
	operationTest mysql = new operationTest();
	timeClass time = new timeClass();
	Tag tag = new Tag();
	String thisid = tag.makeTag();
	String replyid = "";
	String content = txt_Comment.getText();
	try{
	    Connection conn = mysql.getConnection();
	    mysql.sqlAddTo(thisid, replyid, content, time.timeNow(), "waitinglist", conn);
	    
	    conn.close();
	}catch(Exception e){
	    
	}
    }

    @FXML
    private void onComment(ActionEvent event) {
	
    }
    
}
