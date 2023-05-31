package basic;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CancerVisualizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        TableView<String[]> table = new TableView<>();
        VBox vbox = new VBox(table);

        TableColumn<String[], String> country = new TableColumn<>("Country");
        table.getColumns().add(country);

        TableColumn<String[], String> deathsLiver = new TableColumn<>("Liver");
        table.getColumns().add(deathsLiver);

        TableColumn<String[], String> deathsKidney = new TableColumn<>("Kidney");
        table.getColumns().add(deathsKidney);

        TableColumn<String[], String> deathsOral = new TableColumn<>("Oral");
        table.getColumns().add(deathsOral);

        TableColumn<String[], String> deathsLungs = new TableColumn<>("Lungs");
        table.getColumns().add(deathsLungs);

        TableColumn<String[], String> deathsLarynx = new TableColumn<>("Larynx");
        table.getColumns().add(deathsLarynx);

        TableColumn<String[], String> deathsGalbladder = new TableColumn<>("Galbladder");
        table.getColumns().add(deathsGalbladder);

        TableColumn<String[], String> deathsSkin = new TableColumn<>("Skin");
        table.getColumns().add(deathsSkin);

        TableColumn<String[], String> deathsLeukemia = new TableColumn<>("Leukemia");
        table.getColumns().add(deathsLeukemia);

        table.setPrefWidth(600);
        table.setPrefHeight(400);

        AnchorPane root = new AnchorPane();
        root.getChildren().add(vbox);

        AnchorPane.setLeftAnchor(vbox, 50.0);
        AnchorPane.setTopAnchor(vbox, 100.0);

        Scene scene = new Scene(root, 1100, 750);
        primaryStage.setTitle("Cancer Deaths Interactive Data Model");

        primaryStage.setScene(scene);
        primaryStage.show();

        ReadCSV.populateTableFromCSV(table, "src\\basic\\Cancer Deaths Country Data - Sheet1 (1).csv");
    }
}