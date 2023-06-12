package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CancerDataSet {
    
    private static ArrayList<CancerData> data;
    
    public CancerDataSet() {
        this.data = new ArrayList<>();
    }

    public void addData(CancerData cancerData){
        data.add(cancerData);
    }

    public static ArrayList<CancerData> getData() {
        return data;
    }

    public static void sortByColumn(String columnName) {
        switch (columnName) {
            case "Country":
                sort(data, "Country");
                break;
            case "Liver":
                sort(data, "Liver");
                break;
            case "Kidney":
                sort(data, "Kidney");
                break;
            case "Oral":
                sort(data, "Oral");
                break;
            case "Lungs":
                sort(data, "Lungs");
                break;
            case "Larynx":
                sort(data, "Larynx");
                break;
            case "Galbladder":
                sort(data, "Galbladder");
                break;
            case "Skin":
                sort(data, "Skin");
                break;
            case "Leukemia":
                sort(data, "Leukemia");
                break;
            case "Total":
                Collections.sort(data, Comparator.comparingInt(CancerData::getTotal));
                break;
            default:
                sort(data, "Country");
                break;
        }
        System.out.println("Sorted list by " + columnName + ":");
        for (CancerData cancerData : data) {
            System.out.println(cancerData);
        }
    }

    private static void sort(ArrayList<CancerData> arr, String columnName) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (getColumnValue(arr.get(j), columnName) < getColumnValue(arr.get(minIndex), columnName)) {
                    minIndex = j;
                }
            }
            CancerData temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(i));
            arr.set(i, temp);
        }
    }
    
    private static int getColumnValue(CancerData data, String columnName) {
        switch (columnName) {
            case "Liver":
                return data.getLiver();
            case "Kidney":
                return data.getKidney();
            case "Oral":
                return data.getOral();
            case "Lungs":
                return data.getLungs();
            case "Larynx":
                return data.getLarynx();
            case "Galbladder":
                return data.getGalbladder();
            case "Skin":
                return data.getSkin();
            case "Leukemia":
                return data.getLeukemia();
            case "Total":
                return data.getTotal();
            default:
                throw new IllegalArgumentException("Invalid column name: " + columnName);
        }
    }

    public static int linearSearch(String columnName, String target) {
        for (CancerData cancerData : data) {
            int columnValue = getColumnValue(cancerData, columnName);
            if (String.valueOf(columnValue).equals(target)) {
                return 1; 
            }
        }
        return -1; 
    }
}
