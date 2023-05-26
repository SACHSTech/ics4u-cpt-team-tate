package basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ReadCSV {

    public static void addColumnData(String csvFilePath, String columnName, TableView table) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
        String line = br.readLine(); 
        if (line != null) {
            String[] headers = line.split(",");
            
            int columnIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals(columnName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex != -1) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length > columnIndex) {
                        table.getItems().add(values);
                    }
                }
            }
        }
    }
}