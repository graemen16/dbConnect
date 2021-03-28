package gn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class dbConnectApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");

        Label label = new Label("Hello World, JavaFX !\n\r");
        Label statusStatic = new Label("Status:");
        Label statusValue = new Label();
        
        GridPane statusGrid = new GridPane();
        statusGrid.add(statusStatic, 0, 0);
        statusGrid.add(statusValue, 0, 1);
        
        Scene scene = new Scene(statusGrid, 400, 200);
        primaryStage.setScene(scene);
          primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
