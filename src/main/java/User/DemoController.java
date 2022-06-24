package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import SQLOperations.operationTest;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
public class DemoController implements Initializable {
    
    operationTest sql = new operationTest();
    Connection conn = sql.getConnection();
    int total = sql.count("node", conn);
    int page = 1;
    int offset = sql.count("node", conn)-page;
    boolean replySt = false;
    String currentID = "";
    
   

    @FXML
    private VBox vbox;
    @FXML
    private Pane Post;
    @FXML
    private TextArea text;
    @FXML
    private ImageView upvote;
    @FXML
    private ImageView downvote;
    private TextArea text2;
    private TextArea text3;
    private TextArea text4;
    @FXML
    private TextField score;
    @FXML
    private TextArea text1;
    @FXML
    private TextField indicator;
    @FXML
    private Button reply;
    @FXML
    private Pane Post1;
    @FXML
    private Button c;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text.setWrapText(true);
        text1.setWrapText(true);
	setPost();
    }    

   

    @FXML
    private void reportButton(ActionEvent event) {
        try {
	    ResultSet rs = sql.sqlSelect("select * from node limit 1 offset "+offset, conn);
	    rs.next();				    //Select first row from waiting list

	    sql.sqlAddTo(rs.getString("thisID"), rs.getString("replyID"), rs.getString("content"), rs.getString("date"), "flag", conn); //Copy the first row to node

	  						    
	    JOptionPane.showMessageDialog(null, "This Post Has Been Reported");
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
    }

    @FXML
    private void upvoteButton(MouseEvent event) {
	
	if(upvote.getOpacity()==0.22&&downvote.getOpacity()==0.22){
	    try {
		ResultSet rs = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);
		rs.next();
		PreparedStatement prp = conn.prepareStatement("update node set score = " + (rs.getInt("score") + 1) + " where thisID = '" + rs.getString("thisID") + "'");
		prp.executeUpdate();
		
		upvote.setOpacity(1);
		downvote.setOpacity(0.22);
		rs = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);rs.next();
		score.setText(Integer.toString(rs.getInt("score")));
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	    }
	} else if(upvote.getOpacity() == 0.22) {
	    try {
		ResultSet rs = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);
		rs.next();
		PreparedStatement prp = conn.prepareStatement("update node set score = " + (rs.getInt("score") + 2) + " where thisID = '" + rs.getString("thisID") + "'");
		prp.executeUpdate();
		
		upvote.setOpacity(1);
		downvote.setOpacity(0.22);
		rs = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);rs.next();
		score.setText(Integer.toString(rs.getInt("score")));
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	    }
	}
	
    }

    @FXML
    private void downvoteButton(MouseEvent event) {
	if(upvote.getOpacity()==0.22&&downvote.getOpacity()==0.22){
	    try {
		ResultSet rs = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);
		rs.next();
		PreparedStatement prp = conn.prepareStatement("update node set score = " + (rs.getInt("score") - 1) + " where thisID = '" + rs.getString("thisID") + "'");
		prp.executeUpdate();
		
		upvote.setOpacity(0.22);
		downvote.setOpacity(1);
		rs = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);rs.next();
		score.setText(Integer.toString(rs.getInt("score")));
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	    }
	} else if(downvote.getOpacity() == 0.22) {
	    try {
		ResultSet rs = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);
		rs.next();
		PreparedStatement prp = conn.prepareStatement("update node set score = " + (rs.getInt("score") - 2) + " where thisID = '" + rs.getString("thisID") + "'");
		prp.executeUpdate();
		
		upvote.setOpacity(0.22);
		downvote.setOpacity(1);
		rs = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);rs.next();
		score.setText(Integer.toString(rs.getInt("score")));
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	    }
	}
	
    }
    
    
    
    public void setPost(){
	try{
	    ResultSet rs1=null;
	    indicator.setText(page+"/"+total);
	    upvote.setOpacity(0.22);
	    downvote.setOpacity(0.22);
	    
	    if(offset>=0){
		rs1 = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);rs1.next();
		currentID = rs1.getString("thisID");
	    }
	    
	    
	    if(rs1!=null){
		if (rs1.getString("replyID").equals("")) {
		    text.setText(rs1.getString("thisID") +"\n["+rs1.getString("date") +"]\n\n" + rs1.getString("content"));
		    score.setText(Integer.toString(rs1.getInt("score")));
		} else {
		    text.setText(rs1.getString("thisID") +"\n["+rs1.getString("date") +"]\n\n" + "replying to : " + rs1.getString("replyID") + "\n" + rs1.getString("content"));
		    score.setText(Integer.toString(rs1.getInt("score")));
		}
	    }
	    
	    
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e);
	}
	
    }

    @FXML
    private void prevButton(ActionEvent event) {
	total = sql.count("node", conn);
	if(page<=1){
	    JOptionPane.showMessageDialog(null, "This is the first page");
	    page = 1;
	}
	else
	    {
		page--;
		offset++;
		setPost();
		
	    }
	indicator.setText(page+"/"+total);
	
        text1.setText("");
    }

    @FXML
    private void nextButton(ActionEvent event) {
	total = sql.count("node", conn);
	if(page>=total){
	    JOptionPane.showMessageDialog(null, "This is the last page");
	    page = total;
	}
	else
	    {
		page++;
		offset--;
		setPost();
		
	    }
	indicator.setText(page+"/"+total);
        
        text1.setText("");
    }

    @FXML
    private void replyButton(ActionEvent event) {
	String str = "";
	replySt = !replySt;
	
	if(replySt==true){
	    try{
		ResultSet rs1 = sql.sqlSelect("select * from node where replyID = '"+currentID+"'", conn);
		while(rs1.next()){
		    str += rs1.getString("thisID")+"\n["+rs1.getString("date")+"]\n\n"+rs1.getString("content");
		    str +="\n\n-----------------------------------------------\n\n";
		}
	    }catch(Exception e){
		JOptionPane.showMessageDialog(null, e.getMessage());
	    }
	    text1.setText(str);
	}else{
	    text1.setText("");
	}
	
    }

    @FXML
    private void BackPressed(ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserInterface.fxml"));

	Scene scene = new Scene(root);

	scene.getStylesheets().add("/styles/user.css");
	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

	stage.setTitle("JavaFX and Maven");
	stage.setScene(scene);
	stage.show();
    }
   
    

    
    
}
