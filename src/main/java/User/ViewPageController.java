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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private Button button_Reaction;
    
    @FXML
    private Button button_Reply;
    
    @FXML
    private boolean Reacting() throws ClassNotFoundException {
        Stage mainStage = (Stage) button_Reaction.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("ReactionIcon.fxml"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Confession Time!");
        }
            catch(Exception e){}
        return true;
    }
    
    @FXML
    private boolean Replying() throws ClassNotFoundException {
        Stage mainStage = (Stage) button_Reply.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("SubmitPage.fxml"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Confession Time!");
        }
            catch(Exception e){}
        return true;
    }
}
   
    

   
    

