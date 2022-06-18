package Admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import SQLOperations.operationTest;
import javax.swing.JOptionPane;
import java.sql.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
public class WaitingListController implements Initializable {

    @FXML
    private StackPane parentContainer;
    private int counter = 1;
    private int total = 1;
    
    @FXML
    private TextField reply;
    @FXML
    private TextArea contentBox;
    @FXML
    private Button prev;
    @FXML
    private TextField page;

    public StackPane getParentContainer() {
	return parentContainer;
    }
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private Button Button;

    public Button getButton() {
	return Button;
    }
    @FXML
    private Button next;

    operationTest sql = new operationTest();
    Connection conn = sql.getConnection();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	setPost();
	try{
	    total = sql.count("waitinglist", conn);
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
	page.setText(counter+"/"+total);
    }    

    @FXML
    private void loadFlag(ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/FlaggedPost.fxml"));
        Scene scene = Button.getScene();
        root.translateXProperty().set(scene.getWidth());

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(anchorRoot);
        });
        timeline.play();
    }

    @FXML
    private void nextButton(ActionEvent event) {
	if(counter==total)
	    JOptionPane.showMessageDialog(null, "This is the last page");
	else
	    {
		counter++;
		setPost();
		page.setText(counter+"/"+total);
	    }
	
    }

    @FXML
    private void replyID(ActionEvent event) {
	int offset = counter-1;
	try{
	    
	    ResultSet rs = sql.sqlSelect("select * from waitinglist limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
	    reply.setText("#"+rs.getString("replyID"));
	    if(reply.getText().equals("#null"))
		reply.setText("none");
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
	
    }

    @FXML
    private void content(MouseEvent event) {
	int offset = counter-1;
	try{
	    
	    ResultSet rs = sql.sqlSelect("select * from waitinglist limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
	    contentBox.setText("#"+rs.getString("thisID")+"\n\n"+rs.getString("content"));
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
    }

    @FXML
    private void prevButton(ActionEvent event) {
	if(counter==1){
	    JOptionPane.showMessageDialog(null, "This is the First Page");
	}else{
	    counter--;
	    setPost();
	    page.setText(counter+"/"+total);
	}
    }

    @FXML
    private void pageIndicator(ActionEvent event) {
	
    }
    private void setPost(){
	content(null);
	replyID(null);
    }
    
}
