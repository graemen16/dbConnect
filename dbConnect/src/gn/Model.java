package gn;

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

	public static java.lang.Object getItems() {
		return items;
	}

	/* JDBC calls */
	
}
