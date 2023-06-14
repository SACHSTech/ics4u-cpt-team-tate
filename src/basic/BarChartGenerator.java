package basic;

import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BarChartGenerator {

    // Bar chart class variable
    private BarChart<String, Number> barChart;

    /**
     * Constructor method for BarChartGenerator
     * @author @Ajuaman
     */
    public BarChartGenerator() {
        // Create axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create bar chart
        barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Cancer Data Barchart By Country");
        barChart.setCategoryGap(60);
    }

    /**
     * Getter method for barchart
     * @return the barchart
     * @author @Ajuaman
     */
    public BarChart<String, Number> getBarChart() {
        return barChart;
    }

    /**
     * Method to populate the barchart from a csv file
     * @param csvFilePath the csv file path
     * @author @Ajuaman
     */
    public void generateFromCSV(String csvFilePath) {

        // Try reading the file using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line = br.readLine();
            int row = 0;

            // Get series
            XYChart.Series<String, Number> series = new XYChart.Series<>();

            //Get Liver series
            XYChart.Series liverSeries = new XYChart.Series();
            liverSeries.setName("Liver");

            // Get Kidney series
            XYChart.Series kidneySeries = new XYChart.Series();
            kidneySeries.setName("Kidney");

            // Get oral Series
            XYChart.Series oralSeries = new XYChart.Series();
            oralSeries.setName("Oral");

            // Get lungs series
            XYChart.Series lungsSeries = new XYChart.Series();
            lungsSeries.setName("Lungs");

            // get Larynx series
            XYChart.Series larynxSeries = new XYChart.Series();
            larynxSeries.setName("Larynx");

            // get Gallblader series
            XYChart.Series galbladderSeries = new XYChart.Series();
            galbladderSeries.setName("Gallbladder");

            // Get skin series
            XYChart.Series skinSeries = new XYChart.Series();
            skinSeries.setName("Skin");

            // Get leukemia series
            XYChart.Series leukemiaSeries = new XYChart.Series();
            leukemiaSeries.setName("Leukemia");

            while ((line = br.readLine()) != null && row < 7) {
                String[] data = line.split(",");
                String category = data[0];
                double value = Double.parseDouble(data[1]);
                // Add to the series
                liverSeries.getData().add(new XYChart.Data<>(category, Double.parseDouble(data[1])));
                kidneySeries.getData().add(new XYChart.Data<>(category, Double.parseDouble(data[2])));
                oralSeries.getData().add(new XYChart.Data<>(category, Double.parseDouble(data[3])));
                larynxSeries.getData().add(new XYChart.Data<>(category, Double.parseDouble(data[4])));
                galbladderSeries.getData().add(new XYChart.Data<>(category, Double.parseDouble(data[5])));
                skinSeries.getData().add(new XYChart.Data<>(category, Double.parseDouble(data[6])));
                leukemiaSeries.getData().add(new XYChart.Data<>(category, Double.parseDouble(data[7])));
                row++;
            }

            // Add the data
           barChart.getData().addAll(liverSeries, kidneySeries, oralSeries, galbladderSeries, skinSeries, leukemiaSeries);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
