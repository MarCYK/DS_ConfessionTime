/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void close_app(MouseEvent event) {
    }

    @FXML
    private void closeButton(ActionEvent event) {
    }

    @FXML
    private void registerButton(ActionEvent event) {
    }

    @FXML
    private void back_to_menu(MouseEvent event) {
    }

    @FXML
    private void backButton(ActionEvent event) {
    }
    
}
