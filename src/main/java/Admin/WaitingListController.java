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
import javafx.scene.control.ComboBox;
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
    private String currentID = "";
    
    @FXML
    private TextField reply;
    @FXML
    private TextArea contentBox;
    
    @FXML
    private Button prev;
    @FXML
    private TextField page;
    @FXML
    private TextField status;
    

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
        contentBox.setWrapText(true);
        System.out.println("Test");
	setPost();
	total = sql.count("waitinglist", conn);
	page.setText(counter+"/"+total);
	statusUpdate();
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
	total = sql.count("waitinglist", conn);
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
	statusUpdate();
	
    }

    @FXML
    private void replyID(ActionEvent event) {
	int offset = counter-1;
	try{
	    if(sql.count("waitinglist", conn)==0){
		reply.setText("It Is Empty Here :(");
	    }else{
		ResultSet rs = sql.sqlSelect("select * from waitinglist limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
		reply.setText("#"+rs.getString("replyID"));
		currentID = rs.getString("thisID");
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
	    if(sql.count("waitinglist", conn)!=0){
		ResultSet rs = sql.sqlSelect("select * from waitinglist limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
		contentBox.setText("#"+rs.getString("thisID")+"\n\n"+rs.getString("content"));
	    }
	    
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
    }

    @FXML
    private void prevButton(ActionEvent event) {
	total = sql.count("waitinglist", conn);
	if(counter<=1){
	    JOptionPane.showMessageDialog(null, "This is the First Page");
	    counter = 1;
	}else{
	    counter--;
	    setPost();
	    
	}
	page.setText(counter+"/"+total);
	statusUpdate();
    }

    @FXML
    private void pageIndicator(ActionEvent event) {
	
    }
    private void setPost(){
	content(null);
	replyID(null);
    }


    @FXML
    private void verifyButton(ActionEvent event) {
	int offset = counter-1;
	
	try{
	    PreparedStatement prp = conn.prepareStatement("update waitinglist set status = ? where thisID = '"+currentID+"'");
	    prp.setString(1, "1");
	    prp.executeUpdate();
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
	status.setText("Verify");
    }

    @FXML
    private void spamButton(ActionEvent event) {
	int offset = counter-1;
	
	try{
	    PreparedStatement prp = conn.prepareStatement("update waitinglist set status = ? where thisID = '"+currentID+"'");
	    prp.setString(1, "0");
	    prp.executeUpdate();
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
	status.setText("Spam");
    }
    
    private void statusUpdate(){
	int offset = counter-1;
	try{
	    ResultSet rs = sql.sqlSelect("select * from waitinglist limit 1 offset "+String.valueOf(offset)+"", conn);rs.next();
	    if(rs.getString("status").equals("1")){
		status.setText("Verified");
	    }else
		status.setText("Spam");
	}catch(Exception e){
	    
	}
    }

    

    
}
