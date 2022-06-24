package Admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import SQLOperations.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
public class FlaggedPostsController implements Initializable {
    
    private int counter = 1;
    private int total = 1;
    operationTest sql = new operationTest();
    Connection conn = sql.getConnection();
    String currentID = "";

    @FXML
    private Button loadSpam;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField reply;
    @FXML
    private TextArea contentBox;
    
    @FXML
    private Button next;
    @FXML
    private Button prev;
    @FXML
    private TextField page;
    @FXML
    private Button unflag;
    @FXML
    private Button remove;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contentBox.setWrapText(true);
	setPost();
	total = sql.count("flag", conn);
	page.setText(counter+"/"+total);
    }    


    @FXML
    private void gotoSpam(ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/SpamPost.fxml"));
        Scene scene = loadSpam.getScene();
        root.translateXProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) loadSpam.getScene().getRoot();

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
    private void replyID(ActionEvent event) {
	int offset = counter-1;
	try{
	    if(sql.count("flag", conn)==0){
		reply.setText("It Is Empty Here :(");
	    }else{
		ResultSet rs = sql.sqlSelect("select * from flag limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
		currentID = rs.getString("thisID");
		reply.setText("#"+rs.getString("replyID"));
		if(reply.getText().equals("#null"))
		    reply.setText("none");
	    }
	    
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
    }

    @FXML
    private void content(MouseEvent event) {
	int offset = counter-1;
	try{
	    if(sql.count("flag", conn)!=0){
		ResultSet rs = sql.sqlSelect("select * from flag limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
		contentBox.setText("#"+rs.getString("thisID")+"\n\n"+rs.getString("content"));
	    }
	    
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
    }

    @FXML
    private void nextButton(ActionEvent event) {
	total = sql.count("flag", conn);
	if(counter>=total){
	    JOptionPane.showMessageDialog(null, "This is the last page");
	    counter = total;
	}
	else
	    {
		counter++;
		setPost();
	    }
	page.setText(counter+"/"+total);
    }

    @FXML
    private void prevButton(ActionEvent event) {
	total = sql.count("flag", conn);
	if(counter<=1){
	    JOptionPane.showMessageDialog(null, "This is the First Page");
	    counter = 1;
	}else{
	    counter--;
	    setPost();
	    
	}
	page.setText(counter+"/"+total);
    }
    
    private void setPost(){
	content(null);
	replyID(null);
    }

    @FXML
    private void unflagButton(ActionEvent event) {
	sql.sqlDelete("delete from flag where thisID = '"+currentID+"'", conn);
	JOptionPane.showMessageDialog(null, "Post Unflagged");
    }

    @FXML
    private void removeButton(ActionEvent event) {
	batchRemoval br = new batchRemoval();
	br.remove(currentID,"node");
	br.remove(currentID, "flag");
	JOptionPane.showMessageDialog(null, "Post Deleted");
    }

    
}
