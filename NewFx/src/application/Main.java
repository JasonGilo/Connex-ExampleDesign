package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    static Stage currentStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setResizable(false);
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewFxml.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root,600,390);
	        primaryStage.initStyle(StageStyle.UNDECORATED);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               xOffset = event.getSceneX();
               yOffset = event.getSceneY();
           }
       });
            
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            });
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			currentStage = primaryStage;
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
