/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package User;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import SQLOperations.operationTest;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
public class LoginController implements Initializable {

    @FXML
    private TextField id;
    
    @FXML
    private Button login;
    
     operationTest sql = new operationTest();
     Connection conn = sql.getConnection();
    @FXML
    private PasswordField pass;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void loginButton(ActionEvent event) {
	try{
	    ResultSet rs = sql.sqlSelect("select * from admin where userID = '"+id.getText()+"' and password = '"+pass.getText()+"'", conn);
	    if(rs.next()){
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/waitinglist.fxml"));

		Scene scene = new Scene(root);
	//        scene.getStylesheets().add("/styles/submission.css");
		scene.getStylesheets().add("/styles/waitinglist.css");
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		stage.setTitle("JavaFX and Maven");
		stage.setScene(scene);
		stage.show();
	    }else{
		JOptionPane.showMessageDialog(null, "Invalid Credentials");
	    }
	}catch(Exception e){
	    
	}
    }
    
}
