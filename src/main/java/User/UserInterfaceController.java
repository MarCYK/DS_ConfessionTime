package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UserInterfaceController implements Initializable {

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
    private boolean ToSubmitPage() throws ClassNotFoundException {
        Stage mainStage = (Stage) image_Submit.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("SubmitPage.fxml"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Confession Time!");
        }
            catch(Exception e){}
        return true;
    }
    
    @FXML
    private boolean ToViewPage() throws ClassNotFoundException {
        Stage mainStage = (Stage) image_View.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("ViewPage.fxml"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Confession Time!");
        }
            catch(Exception e){}
        return true;
    }
    
     private boolean ToSearchPage() throws ClassNotFoundException {
        Stage mainStage = (Stage) image_Search.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Confession Time!");
        }
            catch(Exception e){}
        return true;
    }

    @FXML
    private void ToSearchInterface(MouseEvent event) {
    }
}
