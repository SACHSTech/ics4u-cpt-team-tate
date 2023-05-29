package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SortingData {

    public SortingData(String filePath) {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
    
            for (int i = 0; i < data.size(); i++) {
                System.out.println(Arrays.toString(data.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    public static void selectionSort(ArrayList<String[]> array) {
        int size = array.size();
        
        for (int step = 0; step < size - 1; step++) {
            int minIdx = step;
            
            for (int i = step + 1; i < size; i++) {
                String[] currentRow = array.get(i);
                String[] minRow = array.get(minIdx);
                int currentValue = Integer.parseInt(currentRow[0]);
                int minValue = Integer.parseInt(minRow[0]);
                
                if (currentValue < minValue) {
                    minIdx = i;
                }
            }
            
            String[] temp = array.get(step);
            array.set(step, array.get(minIdx));
            array.set(minIdx, temp);
        }
    }
}
