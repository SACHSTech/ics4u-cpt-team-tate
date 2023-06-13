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

    /**
     * A method to populate a TableView object from a given CSV file
     * @param table the table to perform the function on
     * @param filePath the filepath to the csv file.
     * @author @Ajuaman
     */
    public static void populateTableFromCSV(TableView<CancerData> table, String filePath) {

        // Initializing the CancerDataSet object
        CancerDataSet data = new CancerDataSet();
        // Reading the csv file using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Get each line of the csv file
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                // Separate each row by a comma
                String[] row = line.split(",");
                String country = row[0];
                // Parse each value into an integer, except the country name which is a String
                int liver = Integer.parseInt(row[1]);
                int kidney = Integer.parseInt(row[2]);
                int oral = Integer.parseInt(row[3]);
                int lungs = Integer.parseInt(row[4]);
                int larynx = Integer.parseInt(row[5]);
                int galbladder = Integer.parseInt(row[6]);
                int skin = Integer.parseInt(row[7]);
                int leukemia = Integer.parseInt(row[8]);
                int total = Integer.parseInt(row[9]);
                // Add that to a CancerData object
                CancerData cancerData = new CancerData(country, liver, kidney, oral, lungs, larynx, galbladder, skin, leukemia, total);
                data.addData(cancerData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        table.setItems(FXCollections.observableArrayList(data.getData()));
        // Use the populate method here
        populateColumns(table, new String[]{"Country", "Liver", "Kidney", "Oral", "Lungs", "Larynx", "Galbladder", "Skin", "Leukemia", "Total"});
    }
    
    /**
     * A helper method to populate the columns of a table from the csv file
     * @param table The table to perform the function on
     * @param headers the list of column names
     * @author @Ajuaman
     */
    private static void populateColumns(TableView<CancerData> table, String[] headers) {
        table.getColumns().clear();
        
        // Creating a column for country 
        TableColumn<CancerData, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        table.getColumns().add(countryColumn);
    
        // Creating a column for liver data
        TableColumn<CancerData, Integer> liverColumn = new TableColumn<>("Liver");
        liverColumn.setCellValueFactory(new PropertyValueFactory<>("liver"));
        table.getColumns().add(liverColumn);
    
        // Creating a column for kidney data
        TableColumn<CancerData, Integer> kidneyColumn = new TableColumn<>("Kidney");
        kidneyColumn.setCellValueFactory(new PropertyValueFactory<>("kidney"));
        table.getColumns().add(kidneyColumn);
    
        // Creating a column for oral data
        TableColumn<CancerData, Integer> oralColumn = new TableColumn<>("Oral");
        oralColumn.setCellValueFactory(new PropertyValueFactory<>("oral"));
        table.getColumns().add(oralColumn);
    
        // Creating a column for lungs data
        TableColumn<CancerData, Integer> lungsColumn = new TableColumn<>("Lungs");
        lungsColumn.setCellValueFactory(new PropertyValueFactory<>("lungs"));
        table.getColumns().add(lungsColumn);
    
        // Creating a column for larynx data
        TableColumn<CancerData, Integer> larynxColumn = new TableColumn<>("Larynx");
        larynxColumn.setCellValueFactory(new PropertyValueFactory<>("larynx"));
        table.getColumns().add(larynxColumn);
    
        // Creating a column for galbladder data
        TableColumn<CancerData, Integer> galbladderColumn = new TableColumn<>("Galbladder");
        galbladderColumn.setCellValueFactory(new PropertyValueFactory<>("galbladder"));
        table.getColumns().add(galbladderColumn);
        
        // Creating a column for skin data
        TableColumn<CancerData, Integer> skinColumn = new TableColumn<>("Skin");
        skinColumn.setCellValueFactory(new PropertyValueFactory<>("skin"));
        table.getColumns().add(skinColumn);
        
        // Creating a column for leukemia data
        TableColumn<CancerData, Integer> leukemiaColumn = new TableColumn<>("Leukemia");
        leukemiaColumn.setCellValueFactory(new PropertyValueFactory<>("leukemia"));
        table.getColumns().add(leukemiaColumn);

        // Creating a column for the total number of cases for each type of cancer type 
        TableColumn<CancerData, Integer> totalColumn = new TableColumn<>("Total");
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        table.getColumns().add(totalColumn);
    }
    
}
