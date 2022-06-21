package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import SQLOperations.operationTest;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
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
    
    @FXML
    private ImageView image_Return;
    @FXML
    private Button button_Reaction;
    @FXML
    private Button button_Reply;
    @FXML
    private Label label_ID;
    @FXML
    private Label label_DateTime;
    @FXML
    private Label label_ReplyingToID;
    @FXML
    private ScrollPane Pane_Scrolling;
    @FXML
    private TextArea [] textarea_Content;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operationTest sql = new operationTest();
        Connection conn = sql.getConnection();
        
        
        int label_count = sql.count("node", conn);
        TextArea[] textarea_Content = new TextArea[label_count];
        for(int i = 0; i < label_count; i++){
            Pane_Scrolling.setContent(textarea_Content[i]);
        }
    }
    
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
   
    

   
    

