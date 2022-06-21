/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package User;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
public class WelcomePageController implements Initializable {

    @FXML
    private ImageView imageBg;
    @FXML
    private Button admin;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private StackPane Stack;
    @FXML
    private Button cmd_GuestLogin;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	
    }    

    @FXML
    private void adminSign(ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Scene scene = admin.getScene();
        root.translateXProperty().set(scene.getWidth());
	anchorPane.translateXProperty().set(scene.getWidth());

        Stack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
	KeyValue kv1 = new KeyValue(anchorPane.translateXProperty(), 0, Interpolator.DISCRETE);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
	KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);
        timeline.getKeyFrames().add(kf);
	timeline.getKeyFrames().add(kf1);
        timeline.setOnFinished(t -> {
            Stack.getChildren().remove(anchorPane);
        });
        timeline.play();
    }

    @FXML
    private void guestLoginPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserInterface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene (root);
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
    
}
