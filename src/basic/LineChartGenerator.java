package basic;

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
    private final int numberofLines;
    public LineChartGenerator(String csvFilePath, int numberofLines) {
        this.csvFilePath = csvFilePath;
        this.numberofLines = numberofLines;
    }

    public LineChart<Number, Number> generateLineChart() throws IOException {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("CSV Line Chart");

        ObservableList<XYChart.Series<Number, Number>> seriesList = getDataFromCSV();

        lineChart.getData().addAll(seriesList);

        return lineChart;
    }

  private ObservableList<XYChart.Series<Number, Number>> getDataFromCSV() throws IOException {
        ObservableList<XYChart.Series<Number, Number>> seriesList = FXCollections.observableArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the header row
            br.readLine();

            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null && lineCount < numberofLines) {
                String[] values = line.split(",");

                String category = values[0];

                XYChart.Series<Number, Number> series = new XYChart.Series<>();
                series.setName(category);

                XYChart.Data<Number, Number> liverData = new XYChart.Data<>(1, Double.parseDouble(values[1]));
                XYChart.Data<Number, Number> kidneyData = new XYChart.Data<>(2, Double.parseDouble(values[2]));
                XYChart.Data<Number, Number> oralData = new XYChart.Data<>(3, Double.parseDouble(values[3]));
                XYChart.Data<Number, Number> lungsData = new XYChart.Data<>(4, Double.parseDouble(values[4]));
                XYChart.Data<Number, Number> larynxData = new XYChart.Data<>(5, Double.parseDouble(values[5]));
                XYChart.Data<Number, Number> gallbladderData = new XYChart.Data<>(6, Double.parseDouble(values[6]));
                XYChart.Data<Number, Number> skinData = new XYChart.Data<>(7, Double.parseDouble(values[7]));
                XYChart.Data<Number, Number> leukemiaData = new XYChart.Data<>(8, Double.parseDouble(values[8]));

                series.getData().addAll(liverData, kidneyData, oralData, lungsData, larynxData, gallbladderData, skinData, leukemiaData);

                seriesList.add(series);
                lineCount++;
            }
        }

        return seriesList;
    }
}