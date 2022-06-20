package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import SQLOperations.operationTest;
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
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author User
 */
public class SearchPageController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    
    @FXML
    private ImageView image_Return;
    
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
    

