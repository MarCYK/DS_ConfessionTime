package User;

import SQLOperations.operationTest;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import SQLOperations.waitingListPop;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;



public class RunConfession extends Application {
    operationTest sql = new operationTest();
    Connection conn = sql.getConnection();
    waitingListPop pop = new waitingListPop();
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Submission.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/demo.fxml"));

        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/submission.css");
        scene.getStylesheets().add("/styles/demo.css");
	stage.setResizable(false);
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
	
	Timer time = new Timer();
	TimerTask loop = new Loop();
	
	time.schedule(loop, 1000 * 60 * 1, 1000 * 60 * 1);
    }
    public static void main(String[] args) {
        launch(args);
    }
    private static class Loop extends TimerTask {
	operationTest sql = new operationTest();
	Connection conn = sql.getConnection();
	waitingListPop pop = new waitingListPop();
	Timer time = new Timer();
	public Loop() {
	}
	@Override
	public void run() {
	    try{
	    if (sql.count("waitinglist", conn) > 10) {
		time.schedule(new MyTimerTask(), 1000 * 60 * 1);
	    } else if (sql.count("waitinglist", conn) > 5) {
		time.schedule(new MyTimerTask(), 1000 * 60 * 2);
	    } else if (sql.count("waitinglist", conn) > 0) {
		time.schedule(new MyTimerTask(), 1000 * 60 * 3);
	    } 
	    }catch(Exception e){
		JOptionPane.showMessageDialog(null, "Startup error\n"+e.getMessage());
	    }
	}
    }
}
class MyTimerTask extends TimerTask {
    waitingListPop pop = new waitingListPop();
    public void run() {
        pop.start();
    }
    
}


