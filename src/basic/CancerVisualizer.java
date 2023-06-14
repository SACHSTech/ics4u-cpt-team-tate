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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CancerVisualizer extends Application {

    // variables for the sorting button, the table, and the cancer data set
    private Button sortButton;
    private TableView<CancerData> table;
    private CancerDataSet data = new CancerDataSet();

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * JavaFX start method
     * @author @Ajuaman
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        // Generating the barchart from a csv
        BarChartGenerator barChartVisualization = new BarChartGenerator();
        barChartVisualization.generateFromCSV("C:\\SimpleData.csv");

        // Creating a LineChartGenerator object
        LineChartGenerator lineChartVisalization = new LineChartGenerator("C:\\SimpleData.csv", 7);

        // Initializing the TableView and setting size
        table = new TableView<>();
        table.setMaxWidth(700);
        table.setMaxHeight(400);

        // Initializing the sort button
        sortButton = new Button("Sort Data");
        sortButton.setPrefSize(600, 20);

        // When the sortButton is pressed, sort the data in the table by total number of cases 
        sortButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 data.sortByColumn("Total");
                 table.setItems(FXCollections.observableArrayList(data.getData()));
            }
        });

        // Input text field
        TextField searchForValue = new TextField();
        searchForValue.setPrefSize(200, 20);
        
        // Search button 
        Button searchButton = new Button("Search");
        searchButton.setPrefSize(80, 20);

        // Result label to tell user if a value exists in table
        Label searchResultLabel = new Label();
        searchResultLabel.setPrefSize(400, 20);

        // Check if there is a given value in the Total column
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String columnName = "Total"; // Total column we are checking
                String target = searchForValue.getText().trim();
                int result = CancerDataSet.linearSearch(columnName, target); // Using the linear search algorithm made in CancerDataSet class
                if (result != -1) {
                    searchResultLabel.setText(target + " is present in the Total column dataset."); // Setting the label
                } else {
                    searchResultLabel.setText(target + " is not found in the Total column dataset."); // Setting the label
                }
             }
        });

        // Adding the different visual elements on the screen
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(table, sortButton, searchButton, searchForValue, searchResultLabel);

        // Adding the sortButton on screen
        AnchorPane.setTopAnchor(sortButton, 10.0);
        AnchorPane.setLeftAnchor(sortButton, 10.0);

        // Adding the table on screen
        AnchorPane.setTopAnchor(table, 50.0);
        AnchorPane.setLeftAnchor(table, 10.0);

        // Adding the input box on screen
        AnchorPane.setTopAnchor(searchForValue, 500.0);
        AnchorPane.setLeftAnchor(searchForValue, 10.0);

        // Adding the searchButton on screen
        AnchorPane.setTopAnchor(searchButton, 500.0);
        AnchorPane.setLeftAnchor(searchButton, 220.0);

        // Adding the search result label on screen
        AnchorPane.setTopAnchor(searchResultLabel, 500.0);
        AnchorPane.setLeftAnchor(searchResultLabel, 330.0);

        // Creating various tabs for the line chart, bar chart, and table view
        TabPane tabPane = new TabPane();
        Tab barChart = new Tab("Bar Chart", new Label("Show all planes available"));
        Tab lineChart = new Tab("Line Chart", new Label("Show all cars available"));
        Tab anchorPaneTab = new Tab("Table", anchorPane);

        // Adding content to the barchart and linechart tabs
        barChart.setContent(barChartVisualization.getBarChart());
        lineChart.setContent(lineChartVisalization.generateLineChart());
        
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        tabPane.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());

        tabPane.getTabs().addAll(barChart, lineChart, anchorPaneTab);
        barChart.setClosable(false);
        lineChart.setClosable(false);

        AnchorPane pane = new AnchorPane(tabPane);
        Scene scene = new Scene(pane, 1100, 750);

        // Setting title of the window
        primaryStage.setTitle("Cancer Deaths Interactive Data Model");
        primaryStage.setScene(scene);
        primaryStage.show();

        ReadCSV.populateTableFromCSV(table, "C:\\SimpleData.csv");
    }
}
