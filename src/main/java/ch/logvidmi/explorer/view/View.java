package ch.logvidmi.explorer.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Main view class
 * 
 * @author Dmitry Logvinovich
 *
 */
public class View extends Application{
	
	private final static int PADDING = 5;
	private final static int WIDTH = 500;
	private final static int HEIGHT = 650;

	public static void main(String[] args) {
		launch(args);
	}

	private Stage window;
	
	private BorderPane layout;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Explorer");
		
		layout = new BorderPane();
		layout.setPadding(new Insets(PADDING));
		
		Scene scene = new Scene(layout, WIDTH, HEIGHT);
		window.setScene(scene);
		window.show();
	}

}