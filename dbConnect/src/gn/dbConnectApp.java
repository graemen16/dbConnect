package gn;

import gn.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class dbConnectApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");

        Label statusStatic = new Label("Status:");
        Text statusValue = new Text();
        statusValue.setText(Controller.getStatus());
        
        GridPane statusGrid = new GridPane();
        statusGrid.add(statusStatic, 0, 0);
        statusGrid.add(statusValue, 0, 1);
        
        TableView tableView = new TableView();
        
        Controller.refreshTable(tableView);
        
        VBox vBox = new VBox(statusGrid, tableView);
        
        Scene scene = new Scene(vBox, 400, 200);
        primaryStage.setScene(scene);
          primaryStage.show();
    }
	public static void main(String[] args) {
        Application.launch(args);
    }
    
}
