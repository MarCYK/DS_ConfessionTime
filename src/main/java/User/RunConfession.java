package User;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import SQLOperations.waitingListPop;
import java.util.Timer;
import java.util.TimerTask;


public class RunConfession extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Submission.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcomePage.fxml"));

        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/submission.css");
        scene.getStylesheets().add("/styles/welcomepage.css");
	stage.setResizable(false);
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
	
	waitingListPop pop = new waitingListPop();
	Timer time = new Timer();
	TimerTask task = new TimerTask(){
	    public void run(){
		pop.start();
	    }
	};
	time.scheduleAtFixedRate(task, 1000 * 60 * 2 , 1000 * 60 * 1);
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

}
