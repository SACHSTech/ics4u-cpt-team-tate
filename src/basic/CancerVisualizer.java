package basic;

import java.beans.EventHandler;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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

        Button sortButton = new Button("Sort Data");

        sortButton.setLayoutX(0);
        sortButton.setLayoutY(400);
        sortButton.setPrefSize(600, 20);
        
        Pane pane = new Pane();
        pane.getChildren().addAll(vbox, sortButton);
        table.setPrefWidth(600);
        table.setPrefHeight(400);

        AnchorPane.setLeftAnchor(vbox, 50.0);
        AnchorPane.setTopAnchor(vbox, 100.0);

        Scene scene = new Scene(pane, 1100, 750);
        primaryStage.setTitle("Cancer Deaths Interactive Data Model");

        primaryStage.setScene(scene);
        primaryStage.show();

        ReadCSV.populateTableFromCSV(table, "C:\\SimpleData.csv");
        CancerDataSet.sortByColumn("Liver");

        System.out.println(CancerDataSet.linearSearch("Liver", "5719826789126759812758"));
    }
}