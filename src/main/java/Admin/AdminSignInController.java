/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pirvi
 */
public class AdminSignInController implements Initializable {

    private AnchorPane parent;
    @FXML
    private Pane content_area;
    @FXML
    private Label signup;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void open_registration (MouseEvent event) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/RegistrationUi.fxml"));
        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/submission.css");
        scene.getStylesheets().add("/styles/RegistrationUi.css");
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
	
//        Parent fxml = FXMLLoader.load(getClass().getResource("RegistrationUi.fxml"));
//        content_area.getChildren().removeAll();
//        content_area.getChildren().setAll(fxml);
    }
    
    @FXML
    private void close_app (MouseEvent event){
        System.exit(0);
    }
    
    
    
}
