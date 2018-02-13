package ch.logvidmi.explorer.view;

import ch.logvidmi.explorer.model.FileTreeNode;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeView;
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
	private TreeView<String> fileTree;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Explorer");
		
		layout = new BorderPane();
		layout.setPadding(new Insets(PADDING));
		
		createNavigationPanel();
		
		
		Scene scene = new Scene(layout, WIDTH, HEIGHT);
		window.setScene(scene);
		window.show();
	}

	private void createNavigationPanel() {
		fileTree = new TreeView<String>(FileTreeNode.createFileTree());
		fileTree.setShowRoot(false);
		layout.setCenter(fileTree);
		
	}
	
	private void setHandlers() {
		
	}

}
