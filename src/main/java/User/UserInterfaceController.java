package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UserInterfaceController implements Initializable {

    @FXML
    private Label txt_submit;
    @FXML
    private Label Txt_ViewPage;
    @FXML
    private Label txt_Search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private ImageView image_Submit;
    
    @FXML
    private ImageView image_View;
    
    @FXML
    private ImageView image_Search;
    
    @FXML
    private void ToSubmitPage(MouseEvent event) throws ClassNotFoundException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SubmitPage.fxml"));

		Scene scene = new Scene(root);
	//        scene.getStylesheets().add("/styles/submission.css");
		scene.getStylesheets().add("/styles/submitpage.css");
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		stage.setTitle("JavaFX and Maven");
		stage.setScene(scene);
		stage.show();
        
    }
    
    @FXML
    private void ToViewPage(MouseEvent event) throws ClassNotFoundException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/demo.fxml"));

		Scene scene = new Scene(root);
	//        scene.getStylesheets().add("/styles/submission.css");
		scene.getStylesheets().add("/styles/demo.css");
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		stage.setTitle("JavaFX and Maven");
		stage.setScene(scene);
		stage.show();
    }
    
    @FXML
     private void ToSearchPage(MouseEvent event) throws ClassNotFoundException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SearchPage.fxml"));

		Scene scene = new Scene(root);
	//        scene.getStylesheets().add("/styles/submission.css");
		scene.getStylesheets().add("/styles/userpage.css");
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		stage.setTitle("JavaFX and Maven");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    private void submitPageText(MouseEvent event) {
    }

    @FXML
    private void ViewPageText(MouseEvent event) {
    }

    @FXML
    private void SearchPageText(MouseEvent event) {
    }

}
