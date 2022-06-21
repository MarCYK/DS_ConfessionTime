/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package User;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SearchPageController implements Initializable {

    @FXML
    private TableView<?> table_Search;
    @FXML
    private TableColumn<?, ?> column_ID;
    @FXML
    private TableColumn<?, ?> column_Content;
    @FXML
    private TableColumn<?, ?> column_Time;
    @FXML
    private ImageView image_Return;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void BackToUserInterface(MouseEvent event) {
    }
    
}
