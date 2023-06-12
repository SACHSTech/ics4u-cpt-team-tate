package basic;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private CancerDataSet data = new CancerDataSet();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        BarChartGenerator barChartVisualization = new BarChartGenerator();
        barChartVisualization.generateFromCSV("C:\\SimpleData.csv");

        LineChartGenerator lineChartVisalization = new LineChartGenerator("C:\\SimpleData.csv", 7);

        table = new TableView<>();
        table.setMaxWidth(700);
        table.setMaxHeight(400);
        sortButton = new Button("Sort Data");
        sortButton.setPrefSize(600, 20);

       sortButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 data.sortByColumn("Total");
                 table.setItems(FXCollections.observableArrayList(data.getData()));
            }
        });

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(table, sortButton);

        AnchorPane.setTopAnchor(sortButton, 10.0);
        AnchorPane.setLeftAnchor(sortButton, 10.0);

        AnchorPane.setTopAnchor(table, 50.0);
        AnchorPane.setLeftAnchor(table, 10.0);

        TabPane tabPane = new TabPane();
        Tab barChart = new Tab("Bar Chart", new Label("Show all planes available"));
        Tab lineChart = new Tab("Line Chart", new Label("Show all cars available"));
        Tab anchorPaneTab = new Tab("Table", anchorPane);

        barChart.setContent(barChartVisualization.getBarChart());
        lineChart.setContent(lineChartVisalization.generateLineChart());
        
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
