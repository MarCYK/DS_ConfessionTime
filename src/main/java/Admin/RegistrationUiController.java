/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.*;
import SQLOperations.operationTest;
import javax.swing.JOptionPane;

public class RegistrationUiController implements Initializable {
    
    operationTest sql = new operationTest();
    private Connection conn = sql.getConnection();

    @FXML
    private TextField username;
    @FXML
    private PasswordField email;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmpass;
    @FXML
    private Button register;
    @FXML
    private TextField referralkey;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void back_to_menu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcomePage.fxml"));

		Scene scene = new Scene(root);

		scene.getStylesheets().add("/styles/waitinglist.css");
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		stage.setTitle("JavaFX and Maven");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    private void registerButton(ActionEvent event) {
	
	String userID = username.getText();
	String pass = password.getText();
	String mail = email.getText();
	String conpass = confirmpass.getText();
	String rk = referralkey.getText();
	try{
	    if(rk.equals("kaptenmarvin")){
		if(pass.equals(conpass)){
		    PreparedStatement prp = conn.prepareStatement("insert into admin (userID,password,email) values (?,?,?)");
		    prp.setString(1, userID);
		    prp.setString(2, pass);
		    prp.setString(3, mail);

		    prp.execute();
		}else{
		    JOptionPane.showMessageDialog(null, "Mismatch Confirm Password");
		}
	    }else{
		JOptionPane.showMessageDialog(null, "Wrong Referral Key,\nTry Again");
	    }
	}catch(Exception e){
	    
	}
    }
}
