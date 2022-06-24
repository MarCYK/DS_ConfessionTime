/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Admin;

import Confession.Tag;
import SQLOperations.operationTest;
import SQLOperations.timeClass;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
public class SpamPostsController implements Initializable {
    
    private int counter = 1;
    private int total = 1;
    operationTest sql = new operationTest();
    Connection conn = sql.getConnection();
    timeClass time = new timeClass();
    Tag tag = new Tag();
    String currentID = "";
    
    @FXML
    private Button gotoWaiting;
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
    private Button verify;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contentBox.setWrapText(true);
	setPost();
	total = sql.count("spam", conn);
	page.setText(counter+"/"+total);
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
    private void replyID(ActionEvent event) {
	int offset = counter-1;
	try{
	    if(sql.count("spam", conn)==0){
		reply.setText("It Is Empty Here :(");
	    }else{
		ResultSet rs = sql.sqlSelect("select * from spam limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
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
	    if(sql.count("spam", conn)!=0){
		ResultSet rs = sql.sqlSelect("select * from spam limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
		contentBox.setText("#"+rs.getString("thisID")+"\n\n"+rs.getString("content"));
	    }
	    
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
    }

    @FXML
    private void nextButton(ActionEvent event) {
	total = sql.count("spam", conn);
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
	total = sql.count("spam", conn);
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
    private void verifyButton(ActionEvent event) {
	
	try{
	    
	    if(sql.count("spam", conn)!=0){
		ResultSet rs = sql.sqlSelect("select * from spam where thisID = '"+currentID+"'", conn);rs.next();				    //Select first row from waiting list
		sql.sqlAddTo(rs.getString("thisID"), rs.getString("replyID"), rs.getString("content"), time.timeNow(), "node", conn); //Copy the first row to node
		
		System.out.println("\n"+rs.getString("thisID")+"\n"+rs.getString("content")+"\n"+time.timeNow());
		sql.sqlDelete("delete from spam where thisID = '"+currentID+"'", conn);							    //Delete first row from waiting list
		System.out.println("test");
		JOptionPane.showMessageDialog(null, "Post Verified !");
	    }
	    
	    
	    
	    
	    
	}catch(HeadlessException | SQLException e){
	    JOptionPane.showMessageDialog(null, "u got error btw lmao\n\n"+e.getMessage());
	}
    }

    @FXML
    private void deleteButton(ActionEvent event) {
	sql.sqlDelete("delete from spam where thisID = '"+currentID+"'", conn);
	JOptionPane.showMessageDialog(null, "Post has been removed !");
    }
    
}
