import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineChartGenerator {

    private final String csvFilePath;
    private final int numLinesToRead;

    public LineChartGenerator(String csvFilePath, int numLinesToRead) {
        this.csvFilePath = csvFilePath;
        this.numLinesToRead = numLinesToRead;
    }

    public LineChart<Number, Number> generateLineChart() throws IOException {
        // Create axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        // Create chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("CSV Line Chart");

        // Read data from CSV
        ObservableList<XYChart.Series<Number, Number>> seriesList = getDataFromCSV();

        // Add series to chart
        lineChart.getData().addAll(seriesList);

        return lineChart;
    }

    private ObservableList<XYChart.Series<Number, Number>> getDataFromCSV() throws IOException {
        ObservableList<XYChart.Series<Number, Number>> seriesList = FXCollections.observableArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            int lineCount = 0;

            // Read CSV file
            while ((line = br.readLine()) != null && lineCount < numLinesToRead) {
                String[] values = line.split(",");

                XYChart.Series<Number, Number> series = new XYChart.Series<>();
                series.setName("Series " + (lineCount + 1));

                for (int i = 0; i < values.length; i++) {
                    series.getData().add(new XYChart.Data<>(i + 1, Double.parseDouble(values[i])));
                }

                seriesList.add(series);
                lineCount++;
            }
        }

        return seriesList;
    }
}