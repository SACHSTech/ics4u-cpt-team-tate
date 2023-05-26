package basic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import basic.ReadCSV;

public class CancerVisualizer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        TableView<String[]> table = new TableView<String[]>();
        TableColumn<String[], String> country = new TableColumn<String[], String>("Country");
        table.getColumns().add(country);

        TableColumn<String[], String> year = new TableColumn<String[], String>("Year");
        table.getColumns().add(year);

        TableColumn<String[], String> deathsLiver = new TableColumn<String[], String>("Liver");
        table.getColumns().add(deathsLiver);
        
        TableColumn<String[], String> deathsKidney = new TableColumn<String[], String>("Kidney");
        table.getColumns().add(deathsKidney);
        
        TableColumn<String[], String> deathsLungs = new TableColumn<String[], String>("Lungs");
        table.getColumns().add(deathsLungs);
        
        TableColumn<String[], String> deathsOral = new TableColumn<String[], String>("Oral");
        table.getColumns().add(deathsOral);

        TableColumn<String[], String> deathsLarynx = new TableColumn<String[], String>("Larynx");
        table.getColumns().add(deathsLarynx);

        TableColumn<String[], String> deathsSkin = new TableColumn<String[], String>("Skin");
        table.getColumns().add(deathsSkin);

        // Adjust the preferred size of the table view
        table.setPrefWidth(400);
        table.setPrefHeight(100);

        try {
            ReadCSV.addColumnData("src\\basic\\total-cancer-deaths-by-type.csv", "Year", table);
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.setCenter(table);
        Scene scene = new Scene(root, 800, 750);
        primaryStage.setTitle("Cancer Deaths Interactive Data Model");

        // Adjust the size of the scene to fit the table view
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}