/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
public class SpamPostsController implements Initializable {

    @FXML
    private Button gotoWaiting;
    @FXML
    private Button Confirm;
    @FXML
    private AnchorPane AnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void loadWaiting(ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/WaitingList_1.fxml"));
        Scene scene = gotoWaiting.getScene();
        root.translateXProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) gotoWaiting.getScene().getRoot();

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(AnchorPane);
        });
        timeline.play();
    }

    @FXML
    private void confirmButton(ActionEvent event) {
    }
    
}
