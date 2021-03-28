package gn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		try {
			Connection conn = getConnection();
		} catch (SQLException e) {
			status = "Not OK!";
			e.printStackTrace();
		}
		return status;
	}

    private static Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
    	String server = "localhost";
    	String user = "sa";
    	String password = "WdMcRg6qwXL7AE";
    	String port = "1433";
    	String sql = "jdbc:sqlserver://" + server 
    			+ ":" + port 
    			+ ";user=" + user 
    			+ ";password=" + password;
    	DriverManager.getConnection(sql);
		return null;
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
