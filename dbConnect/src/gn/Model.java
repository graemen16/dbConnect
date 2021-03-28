package gn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/*
 * This is Model area of MVC model
 */
public class Model {

	/* data area */
	private final static ArrayList<String> columns = new ArrayList<>();
	
	private final static ObservableList<Map<String, Object>> items =
		    FXCollections.<Map<String, Object>>observableArrayList();
	
	public static ArrayList<String> getColumns() {
		return columns;
	}

	public static ObservableList<Map<String, Object>> getItems() {
		return items;
	}

	/* JDBC calls */
	
	static ResultSet executeSql(Connection conn, String querySql) throws SQLException {
		Statement statement = conn.createStatement();
		return statement.executeQuery(querySql);
	}

}
