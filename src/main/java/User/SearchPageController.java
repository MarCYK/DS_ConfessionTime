package User;

import Confession.showPost;
import SQLOperations.operationTest;
import java.io.IOException;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marvin Chin Yi Kai
 */
public class SearchPageController implements Initializable {
    
    String[] value = {"All", "Search by ID","Search by Keyword","Search by Date Only","Search by Date/Time"};
    
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
    @FXML
    private ChoiceBox<String> choicebox;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	choicebox.getItems().addAll(FXCollections.observableArrayList(value));
	choicebox.show();
	table_Search.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	column_ID.setReorderable(false);
	column_Content.setReorderable(false);
	column_Time.setReorderable(false);
	
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
           
            choicebox.setOnAction((event) -> {
                String choice = choicebox.getSelectionModel().getSelectedItem();
                //Search keyword
                if(choice.equals("Search by ID")) {
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

                            else
                                return false;
                        });
                    });

                    SortedList<showPost> sl = new SortedList<>(filtered);
                    sl.comparatorProperty().bind(table_Search.comparatorProperty());

                    table_Search.setItems(sl);

                } else if(choice.equals("Search by Keyword")) {
                                        FilteredList<showPost> filtered = new FilteredList<>(ob, b -> true);
                    textField_promptInput.textProperty().addListener((observable,oldValue,newValue) -> {
                        filtered.setPredicate(showPost -> {

                            if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                                return true;
                            }               

                            String search = newValue.toLowerCase();

                            if(showPost.contentProperty().toString().toLowerCase().contains(search)){
                                return true;
                            }

                            else
                                return false;
                        });
                    });

                    SortedList<showPost> sl = new SortedList<>(filtered);
                    sl.comparatorProperty().bind(table_Search.comparatorProperty());

                    table_Search.setItems(sl);
                    
                } else if(choice.equals("Search by Date Only")) {
                    FilteredList<showPost> filtered = new FilteredList<>(ob, b -> true);
                    textField_promptInput.textProperty().addListener((observable,oldValue,newValue) -> {
                        filtered.setPredicate(showPost -> {

                            if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                                return true;
                            }               

                            String search = newValue.toLowerCase();

                            if(showPost.dateOnlyProperty().toString().indexOf(search) > -1){
                                return true;
                            }

                            else
                                return false;
                        });
                    });

                    SortedList<showPost> sl = new SortedList<>(filtered);
                    sl.comparatorProperty().bind(table_Search.comparatorProperty());

                    table_Search.setItems(sl);
                    
                } else if(choice.equals("Search by Date/Time")) {
                    FilteredList<showPost> filtered = new FilteredList<>(ob, b -> true);
                    textField_promptInput.textProperty().addListener((observable,oldValue,newValue) -> {
                        filtered.setPredicate(showPost -> {

                            if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                                return true;
                            }               

                            String search = newValue.toLowerCase();

                            if(showPost.dateProperty().toString().contains(search)){
                                return true;
                            }

                            else
                                return false;
                        });
                    });

                    SortedList<showPost> sl = new SortedList<>(filtered);
                    sl.comparatorProperty().bind(table_Search.comparatorProperty());

                    table_Search.setItems(sl);
                    
                } else {
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
            });
            
        }
        
        catch(SQLException e){
            Logger.getLogger(SearchPageController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }
    }    

    @FXML
    private void BackToUserInterface(MouseEvent event) throws ClassNotFoundException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserInterface.fxml"));

		Scene scene = new Scene(root);
	//        scene.getStylesheets().add("/styles/submission.css");
		scene.getStylesheets().add("/styles/userinterface.css");
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		stage.setTitle("Confession Time");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    private void choiceBox(MouseEvent event) {
    }
    
}
