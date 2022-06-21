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
        try{
	    Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcomePage.fxml"));

        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/submission.css");
        scene.getStylesheets().add("/styles/welcomepage.css");
	stage.setResizable(false);
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
	
	Timer time = new Timer();
	MyTimerTask task = new MyTimerTask();
	TimerTask pause = new NoTask();
	
	
	
	
	

	    if (sql.count("waitinglist", conn) > 10) {
		time.schedule(new MyTimerTask(), 1000 * 60 * 5, 1000 * 60 * 5);
	    } else if (sql.count("waitinglist", conn) > 5) {
		time.schedule(new MyTimerTask(), 1000 * 60 * 10, 1000 * 60 * 10);
	    } else if (sql.count("waitinglist", conn) > 0) {
		time.schedule(new MyTimerTask(), 1000 * 60 * 15, 1000 * 60 * 15);
	    } else {
		time.schedule(new NoTask(), 1000 * 60 * 1, 1000 * 60 * 1);
	    }
	
	
	
	
	}catch(Exception e){
	    JOptionPane.showMessageDialog(null, "Startup error\n"+e.getMessage());
	}
    }
    
    

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
	
	
    }

    private static class NoTask extends TimerTask {

	public void run() {
	}
    }

}
class MyTimerTask extends TimerTask {
    operationTest sql = new operationTest();
    Connection conn = sql.getConnection();
    waitingListPop pop = new waitingListPop();
    public void run() {
        pop.start();
    }
    
}


