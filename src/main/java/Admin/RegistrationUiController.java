/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Admin;

import static Admin.Launch.stage;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import SQLOperations.operationTest;
import java.sql.*;
import javafx.scene.Scene;


public class RegistrationUiController implements Initializable {
    
    @FXML
    private Button closeBtn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private Button registerBtn;
    @FXML
    private Button backBtn;
    @FXML
    private PasswordField confirmpass;
    @FXML
    private PasswordField referralkey;
    
    
    
    operationTest sql = new operationTest();
    Connection conn = sql.getConnection();
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
        
    }

    @FXML
    private void closeButton(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void backButton(ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcomePage.fxml"));

        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/submission.css");
        scene.getStylesheets().add("/styles/welcomepage.css");
	stage.setResizable(false);
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void registerButton(ActionEvent event) {
	String userID = username.getText();
	String mail = email.getText();
	String pass = password.getText();
	String conpass = confirmpass.getText();
	String rk = referralkey.getText();
        try{
            if(rk.equals("asdf")){
		if(pass.equals(conpass)){
//		    if(sql.isValidEmail(mail)){

			try {
			    PreparedStatement prp = conn.prepareStatement("insert into admin (userID,password,email) values (?,?,?)");
			    prp.setString(1, userID);
			    prp.setString(2, pass);
			    prp.setString(3, mail);
			    prp.executeUpdate();
			    
			    JOptionPane.showMessageDialog(null, "Registration Completed !");
			} catch (SQLException ex) {
//			    Logger.getLogger(RegistrationUiController.class.getName()).log(Level.SEVERE, null, ex);
			    JOptionPane.showMessageDialog(null, "Registration Error");
			}
//		    }else{
//			JOptionPane.showMessageDialog(null, "Invalid Email !");
//		    }
		}else{
		    JOptionPane.showMessageDialog(null, "Password mismatch !");
		}
	    }else{
		JOptionPane.showMessageDialog(null, "Wrong Referral Key,\nTry Again");
	    }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
