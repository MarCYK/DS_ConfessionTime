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
    private void submitBtn(ActionEvent event) {
    }
    
    
}
