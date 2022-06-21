package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import Confession.Post;
import Engine.Search;
import SQLOperations.operationTest;
import SQLOperations.timeClass;
import java.awt.Button;
import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.sql.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author User
 */
public class SearchPageController implements Initializable {
    
    @FXML
    private ImageView image_Return;
    
    @FXML
    private TextField textField_promptInput;
    
    @FXML
    private TableView <Post> table_Search;
    
    @FXML
    private TableColumn <Post, String> column_ID;
    
    @FXML
    private TableColumn <Post, String> column_Content;
    
    @FXML
    private TableColumn <Post, Timestamp> column_Time;
    
    ObservableList<Post> ob = FXCollections.observableArrayList();

    //Search sr = new Search();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operationTest sql = new operationTest();
        Connection conn = sql.getConnection();
        
        String query = "SELECT thisID, content, date FROM node";
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                
                String queryID = rs.getString("thisID");
                String queryContent = rs.getString("content");
                Timestamp queryTime = rs.getTimestamp("date");
                ob.add(new Post(queryID, queryContent, queryTime));
            }
            
            column_ID.setCellValueFactory(new PropertyValueFactory<>("thisid"));
            column_Content.setCellValueFactory(new PropertyValueFactory<>("Content"));
            column_Time.setCellValueFactory(new PropertyValueFactory<>("Date"));
            
            table_Search.setItems(ob);
            
            FilteredList<Post> filtered = new FilteredList<>(ob, b -> true);
            textField_promptInput.textProperty().addListener((observable,oldValue,newValue) -> {
                filtered.setPredicate(Post -> {
                    
                    if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }               
                    
                    String search = newValue.toLowerCase();
                    
                    if(Post.getThisID().toLowerCase().indexOf(search) > -1){
                        return true;
                    }
                    
                    else if(Post.getContent().toLowerCase().indexOf(search) > -1){
                        return true;
                    }
                    
                    else if(Post.getDate().toString().indexOf(search) > -1){
                        return true;
                    }
                    
                    else if(Post.getDateOnly().toString().indexOf(search) > -1){
                        return true;
                    }
                    
                    else
                        return false;
                });
            });
            
            SortedList<Post> sl = new SortedList<>(filtered);
            sl.comparatorProperty().bind(table_Search.comparatorProperty());
            
            table_Search.setItems(sl);
        }
        
        catch(SQLException e){
            Logger.getLogger(SearchPageController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }
    }
    
    @FXML
    private boolean BackToUserInterface() throws ClassNotFoundException {
        Stage mainStage = (Stage) image_Return.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.setTitle("Test Window");
        }
            catch(Exception e){}
        return true;
    }
    
}
    

