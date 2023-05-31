package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReadCSV {

    public static void populateTableFromCSV(TableView<String[]> table, String filePath) {
        ArrayList<String[]> data  = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ObservableList<String[]> items = FXCollections.observableArrayList(data);
        table.setItems(items);
        populateColumns(table, data.get(0));
    }
    
    private static void populateColumns(TableView<String[]> table, String[] headers) {
        table.getColumns().clear();
    
        for (int i = 0; i < headers.length; i++) {
            TableColumn<String[], String> column = new TableColumn<>(headers[i]);
            final int columnIndex = i;
            column.setCellValueFactory(cellData ->
                    new ReadOnlyStringWrapper(cellData.getValue()[columnIndex]));
            table.getColumns().add(column);
        }
    }
}
