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
import javafx.scene.control.cell.PropertyValueFactory;

public class ReadCSV {

    public static void populateTableFromCSV(TableView<CancerData> table, String filePath) {
        CancerDataSet data = new CancerDataSet();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                String country = row[0];
                int liver = Integer.parseInt(row[1]);
                int kidney = Integer.parseInt(row[2]);
                int oral = Integer.parseInt(row[3]);
                int lungs = Integer.parseInt(row[4]);
                int larynx = Integer.parseInt(row[5]);
                int galbladder = Integer.parseInt(row[6]);
                int skin = Integer.parseInt(row[7]);
                int leukemia = Integer.parseInt(row[8]);
                CancerData cancerData = new CancerData(country, liver, kidney, oral, lungs, larynx, galbladder, skin, leukemia);
                data.addData(cancerData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        table.setItems(FXCollections.observableArrayList(data.getData()));
        populateColumns(table, new String[]{"Country", "Liver", "Kidney", "Oral", "Lungs", "Larynx", "Galbladder", "Skin", "Leukemia"});
    }
    
    private static void populateColumns(TableView<CancerData> table, String[] headers) {
        table.getColumns().clear();
    
        TableColumn<CancerData, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        table.getColumns().add(countryColumn);
    
        TableColumn<CancerData, Integer> liverColumn = new TableColumn<>("Liver");
        liverColumn.setCellValueFactory(new PropertyValueFactory<>("liver"));
        table.getColumns().add(liverColumn);
    
        TableColumn<CancerData, Integer> kidneyColumn = new TableColumn<>("Kidney");
        kidneyColumn.setCellValueFactory(new PropertyValueFactory<>("kidney"));
        table.getColumns().add(kidneyColumn);
    
        TableColumn<CancerData, Integer> oralColumn = new TableColumn<>("Oral");
        oralColumn.setCellValueFactory(new PropertyValueFactory<>("oral"));
        table.getColumns().add(oralColumn);
    
        TableColumn<CancerData, Integer> lungsColumn = new TableColumn<>("Lungs");
        lungsColumn.setCellValueFactory(new PropertyValueFactory<>("lungs"));
        table.getColumns().add(lungsColumn);
    
        TableColumn<CancerData, Integer> larynxColumn = new TableColumn<>("Larynx");
        larynxColumn.setCellValueFactory(new PropertyValueFactory<>("larynx"));
        table.getColumns().add(larynxColumn);
    
        TableColumn<CancerData, Integer> galbladderColumn = new TableColumn<>("Galbladder");
        galbladderColumn.setCellValueFactory(new PropertyValueFactory<>("galbladder"));
        table.getColumns().add(galbladderColumn);
    
        TableColumn<CancerData, Integer> skinColumn = new TableColumn<>("Skin");
        skinColumn.setCellValueFactory(new PropertyValueFactory<>("skin"));
        table.getColumns().add(skinColumn);
    
        TableColumn<CancerData, Integer> leukemiaColumn = new TableColumn<>("Leukemia");
        leukemiaColumn.setCellValueFactory(new PropertyValueFactory<>("leukemia"));
        table.getColumns().add(leukemiaColumn);
    }
    
}
