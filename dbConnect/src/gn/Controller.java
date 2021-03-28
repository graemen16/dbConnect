package gn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
			getData(conn, getQuerySql());
		} catch (SQLException e) {
			status = "Not OK!";
			e.printStackTrace();
		}
		return status;
	}

    private static void getData(Connection conn, String querySql) throws SQLException {
    	ResultSet rs = Model.executeSql(conn, querySql);
    	ResultSetMetaData rsMetaData = rs.getMetaData();
    	// get column names
    	int columnCount = rsMetaData.getColumnCount();
    	Model.getColumns().clear();
    	for (int i = 1; i <= columnCount; ++i) { // metadata cols start at 1
    		Model.getColumns().add(rsMetaData.getColumnName(i));
    	}
    	
    	// get row data
		Model.getItems().clear();
		while(rs.next()) {
			Map<String, Object> item = new HashMap<>();
			for (int i = 0; i < columnCount; ++i) { // array elements start at 0
				String columnName = Model.getColumns().get(i);
				item.put(columnName, rs.getObject(columnName));
			}
			Model.getItems().add(item);
		}
	}

	private static String getQuerySql() {
		String sql = "SELECT * FROM RandomStuff.dbo.Catalog";
		return sql;
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
    	return DriverManager.getConnection(sql);
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
