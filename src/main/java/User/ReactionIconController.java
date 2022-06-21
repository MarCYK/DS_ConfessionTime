/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package User;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ReactionIconController implements Initializable {

    @FXML
    private ImageView icon_Like;
    
    @FXML
    private ImageView icon_Love;
    
    @FXML
    private ImageView icon_Funny;
    
    @FXML
    private ImageView icon_Sad;
    
    @FXML
    private ImageView icon_Angry;
    
    @FXML
    private ImageView icon_Surprised;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Liking(MouseEvent event) {
        
    }

    @FXML
    private void Loving(MouseEvent event) {
    }

    @FXML
    private void Laughing(MouseEvent event) {
    }

    @FXML
    private void Crying(MouseEvent event) {
    }

    @FXML
    private void Angrying(MouseEvent event) {
    }

    @FXML
    private void Shocking(MouseEvent event) {
    }
    
}
