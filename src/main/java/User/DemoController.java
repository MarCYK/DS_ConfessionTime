package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import SQLOperations.operationTest;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Irfan
 */
public class DemoController implements Initializable {
    
    operationTest sql = new operationTest();
    Connection conn = sql.getConnection();
    int page = 1;
    int offset = sql.count("node", conn)-1;
   

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
    @FXML
    private TextField score1;
    @FXML
    private Pane Post2;
    @FXML
    private TextArea text2;
    @FXML
    private ImageView upvote2;
    @FXML
    private ImageView downvote2;
    @FXML
    private TextField score2;
    @FXML
    private Pane Post3;
    @FXML
    private TextArea text3;
    @FXML
    private ImageView upvote3;
    @FXML
    private ImageView downvote3;
    @FXML
    private TextField score3;
    @FXML
    private Pane Post4;
    @FXML
    private TextArea text4;
    @FXML
    private ImageView upvote4;
    @FXML
    private ImageView downvote4;
    @FXML
    private TextField score4;
    @FXML
    private TextField score;
    @FXML
    private Pane Post1;
    @FXML
    private TextArea text1;
    @FXML
    private ImageView upvote1;
    @FXML
    private ImageView downvote1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	setPost();
    }    

   

    @FXML
    private void reportButton(ActionEvent event) {
    }

    @FXML
    private void upvoteButton(MouseEvent event) {
    }

    @FXML
    private void downvoteButton(MouseEvent event) {
    }
    
    @FXML
    private void reportButton1(ActionEvent event) {
    }
    
    @FXML
    private void upvoteButton1(MouseEvent event) {
    }

    @FXML
    private void downvoteButton1(MouseEvent event) {
    }

    @FXML
    private void reportButton2(ActionEvent event) {
    }

    @FXML
    private void upvoteButton2(MouseEvent event) {
    }

    @FXML
    private void downvoteButton2(MouseEvent event) {
    }

    @FXML
    private void reportButton3(ActionEvent event) {
    }

    @FXML
    private void upvoteButton3(MouseEvent event) {
    }

    @FXML
    private void downvoteButton3(MouseEvent event) {
    }

    @FXML
    private void reportButton4(ActionEvent event) {
    }

    @FXML
    private void upvoteButton4(MouseEvent event) {
    }

    @FXML
    private void downvoteButton4(MouseEvent event) {
    }
    
    
    public void setPost(){
	try{
	    int off1 = offset - 1;ResultSet rs1=null;
	    int off2 = offset - 2;ResultSet rs2=null;
	    int off3 = offset - 3;ResultSet rs3=null;
	    int off4 = offset - 4;ResultSet rs4=null;ResultSet rs5=null;
	    
	    if(offset>=0){
		rs1 = sql.sqlSelect("select * from node limit 1 offset " + offset + "", conn);rs1.next();
	    }
	    if(off1>=0){
		rs2 = sql.sqlSelect("select * from node limit 1 offset " + (offset - 1) + "", conn);rs2.next();
	    }
	    if(off2>=0){
		rs3 = sql.sqlSelect("select * from node limit 1 offset " + (offset - 2) + "", conn);rs3.next();
	    }
	    if(off3>=0){
		rs4 = sql.sqlSelect("select * from node limit 1 offset " + (offset - 3) + "", conn);rs4.next();
	    }
	    if(off4>=0){
		rs5 = sql.sqlSelect("select * from node limit 1 offset " + (offset - 4) + "", conn);rs5.next();
	    }
	    
	    
	    if(rs1!=null){
		if (rs1.getString("replyID").equals("")) {
		    text.setText(rs1.getString("thisID") + "\n\n" + rs1.getString("content"));
		} else {
		    text.setText(rs1.getString("thisID") + "\n\n" + "replying to : " + rs1.getString("replyID") + "\n" + rs1.getString("content"));
		}
	    }
	    if(rs2!=null){
		if(rs2.getString("replyID").equals("")){
		text1.setText(rs2.getString("thisID")+"\n\n"+rs2.getString("content"));
	    }else{
		text1.setText(rs2.getString("thisID")+"\n\n"+"replying to : "+rs2.getString("replyID")+"\n"+rs2.getString("content"));
	    }
	    }
	    if(rs3!=null){
		if(rs3.getString("replyID").equals("")){
		text2.setText(rs3.getString("thisID")+"\n\n"+rs3.getString("content"));
	    }else{
		text2.setText(rs3.getString("thisID")+"\n\n"+"replying to : "+rs3.getString("replyID")+"\n"+rs3.getString("content"));
	    }
	    }
	    if(rs4!=null){
		if(rs4.getString("replyID").equals("")){
		text3.setText(rs4.getString("thisID")+"\n\n"+rs4.getString("content"));
	    }else{
		text3.setText(rs4.getString("thisID")+"\n\n"+"replying to : "+rs4.getString("replyID")+"\n"+rs4.getString("content"));
	    }
	    }
	    if(rs5!=null){
		if(rs5.getString("replyID").equals("")){
		text4.setText(rs5.getString("thisID")+"\n\n"+rs5.getString("content"));
	    }else{
		text4.setText(rs5.getString("thisID")+"\n\n"+"replying to : "+rs5.getString("replyID")+"\n"+rs5.getString("content"));
	    }
	    }
	    
	    
	    
	    
	    
	    
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, e);
	}
	
    }

    

    
    
}
