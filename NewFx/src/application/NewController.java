package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class NewController {
	@FXML private JFXTextField usernameText;
	@FXML private JFXPasswordField passwordText;
public void exit() {
	Platform.exit();
}
	
	public void onClick(ActionEvent event) throws IOException, InterruptedException {
		if(usernameText.getText().equals("admin")&&passwordText.getText().equals("admin")) {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("openFxml.fxml"));
			Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage primaryStage = new Stage();
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.currentStage.close();
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
}
