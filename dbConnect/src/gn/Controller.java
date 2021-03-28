package gn;

import java.util.ArrayList;
import java.util.Map;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;

/*
 * This is Controller area of MVC architecture
 */

public class Controller {

	public static String getStatus() {
		String status = "OK";
		return status;
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void refreshTable(TableView tableView) {
		// TODO Auto-generated method stub
    	tableView.getColumns().clear();
    	tableView.getItems().clear();
        ArrayList<String> columns = Model.getColumns();
        // add columns
        for(String column: columns) {
        	TableColumn<Map, String> tableColumn = new TableColumn<>(column);
        	tableColumn.setCellValueFactory(new MapValueFactory<>(column));
        	tableView.getColumns().add(tableColumn);
        }
        // add rows
        tableView.getItems().addAll(Model.getItems());
	}

}
