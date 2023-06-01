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

    public ArrayList<CancerData> getData() {
        return data;
    }

    public static void sortByColumn(String columnName) {
        switch (columnName) {
            case "Country":
                Collections.sort(data, Comparator.comparing(CancerData::getCountry));
                break;
            case "Liver":
                Collections.sort(data, Comparator.comparing(CancerData::getLiver));
                break;
            case "Kidney":
                Collections.sort(data, Comparator.comparing(CancerData::getKidney));
                break;
            case "Oral":
                Collections.sort(data, Comparator.comparing(CancerData::getOral));
                break;
            case "Lungs":
                Collections.sort(data, Comparator.comparing(CancerData::getLungs));
                break;
            case "Larynx":
                Collections.sort(data, Comparator.comparing(CancerData::getLarynx));
                break;
            case "Galbladder":
                Collections.sort(data, Comparator.comparing(CancerData::getGalbladder));
                break;
            case "Skin":
                Collections.sort(data, Comparator.comparing(CancerData::getSkin));
                break;
            case "Leukemia":
                Collections.sort(data, Comparator.comparing(CancerData::getLeukemia));
                break;
            default:
                System.out.println("Invalid column name!");
                break;
        }
        System.out.println("Sorted list by " + columnName + ":");
        for (CancerData cancerData : data) {
            System.out.println(cancerData);
        }
    }

}
