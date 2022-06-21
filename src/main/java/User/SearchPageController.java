/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package User;

import Confession.showPost;
import SQLOperations.operationTest;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Marvin Chin Yi Kai
 */
public class SearchPageController implements Initializable {

    @FXML
    private TextField textField_promptInput;
    @FXML
    private TableView<showPost> table_Search;
    @FXML
    private TableColumn<showPost, String> column_ID;
    @FXML
    private TableColumn<showPost,String> column_Content;
    @FXML
    private TableColumn<showPost, String> column_Time;
    @FXML
    private ImageView image_Return;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operationTest sql = new operationTest();
        Connection conn = sql.getConnection();
        ObservableList<showPost> ob = FXCollections.observableArrayList();
        try{
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM node");
            
            while(rs.next()){
                String id = rs.getString("thisID");
                String cont = rs.getString("content");
                String dat = rs.getString("date");
                ob.add(new showPost(rs.getString("thisID"), rs.getString("content"), rs.getString("date")));
                System.out.println(id + " " + cont + " " + dat + " added");
            }
            
            column_ID.setCellValueFactory(new PropertyValueFactory<>("thisID"));
            column_Content.setCellValueFactory(new PropertyValueFactory<>("content"));
            column_Time.setCellValueFactory(new PropertyValueFactory<>("date"));
            table_Search.setItems(null);
            table_Search.setItems(ob);
            
            FilteredList<showPost> filtered = new FilteredList<>(ob, b -> true);
            textField_promptInput.textProperty().addListener((observable,oldValue,newValue) -> {
                filtered.setPredicate(showPost -> {
                    
                    if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }               
                    
                    String search = newValue.toLowerCase();
                    
                    if(showPost.thisIDProperty().toString().toLowerCase().contains(search)){
                        return true;
                    }
                    
                    else if(showPost.contentProperty().toString().toLowerCase().contains(search)){
                        return true;
                    }
                    
                    else if(showPost.dateProperty().toString().contains(search)){
                        return true;
                    }
                    
                    else if(showPost.dateOnlyProperty().toString().indexOf(search) > -1){
                        return true;
                    }
                    
                    else
                        return false;
                });
            });
            
            SortedList<showPost> sl = new SortedList<>(filtered);
            sl.comparatorProperty().bind(table_Search.comparatorProperty());
            
            table_Search.setItems(sl);
        }
        
        catch(SQLException e){
            Logger.getLogger(SearchPageController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
	    
	    JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    

    @FXML
    private void BackToUserInterface(MouseEvent event) {
    }
    
}
