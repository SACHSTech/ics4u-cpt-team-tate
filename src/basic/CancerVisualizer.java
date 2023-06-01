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
        TableView<CancerData> table = new TableView<>();
        VBox vbox = new VBox(table);

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

        ReadCSV.populateTableFromCSV(table, "C:\\SimpleData.csv");
        CancerDataSet.sortByColumn("Liver");
    }
}