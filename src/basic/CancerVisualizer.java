package basic;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CancerVisualizer extends Application {

    private Button sortButton;
    private TableView<CancerData> table;
    private ComboBox<String> comboBox;
    private ArrayList<CancerData> data;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BarChartGenerator barChartVisualization = new BarChartGenerator();
        barChartVisualization.generateFromCSV("C:\\SimpleData.csv");
        table = new TableView<>();
        table.setMaxWidth(590);
        table.setMaxHeight(400);

        String[] columns = {"Liver", "Kidney", "Oral", "Lungs", "Larynx", "Gallbladder", "Skin", "Leukemia"};
        comboBox = new ComboBox<>(FXCollections.observableArrayList(columns));
        comboBox.setMaxWidth(100);
        comboBox.setMaxHeight(10);

        sortButton = new Button("Sort Data");
        sortButton.setPrefSize(600, 20);

        Label comboBoxLabel = new Label("Select the cancer to sort by");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(table, comboBox, sortButton, comboBoxLabel);

        AnchorPane.setTopAnchor(sortButton, 10.0);
        AnchorPane.setLeftAnchor(sortButton, 10.0);

        AnchorPane.setTopAnchor(table, 50.0);
        AnchorPane.setLeftAnchor(table, 10.0);

        AnchorPane.setTopAnchor(comboBox, 460.0);
        AnchorPane.setLeftAnchor(comboBox, 160.0);

        AnchorPane.setTopAnchor(comboBoxLabel, 460.0);
        AnchorPane.setLeftAnchor(comboBoxLabel, 10.0);

        TabPane tabPane = new TabPane();
        Tab barChart = new Tab("Bar Chart", new Label("Show all planes available"));
        Tab lineChart = new Tab("Line Chart", new Label("Show all cars available"));
        Tab anchorPaneTab = new Tab("Table", anchorPane);

        barChart.setContent(barChartVisualization.getBarChart());
        
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        tabPane.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());

        tabPane.getTabs().addAll(barChart, lineChart, anchorPaneTab);
        barChart.setClosable(false);
        lineChart.setClosable(false);
        AnchorPane pane = new AnchorPane(tabPane);
        Scene scene = new Scene(pane, 1100, 750);

        primaryStage.setTitle("Cancer Deaths Interactive Data Model");
        primaryStage.setScene(scene);
        primaryStage.show();

        ReadCSV.populateTableFromCSV(table, "C:\\SimpleData.csv");
    }
}
