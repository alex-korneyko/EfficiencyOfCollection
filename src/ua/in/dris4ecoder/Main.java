package ua.in.dris4ecoder;

import ua.in.dris4ecoder.Model.ListCollection;
import ua.in.dris4ecoder.Model.SetCollection;
import ua.in.dris4ecoder.View.charts.Chart;

import java.util.*;

import static ua.in.dris4ecoder.View.charts.ChartAlign.*;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public class Main {

    private static int COLLECTION_SIZE = 1_000_000;
    private static final int MEASUREMENT_COUNT = 100;

    public static void main(String[] args) {

        ListCollection listCollection;
        Map<String, Double> testResults;

        for (int i = 100_000; i <= 10_000_000; i *= 10) {
            COLLECTION_SIZE = i;

            Chart chart = new Chart(new ArrayList<String>() {{
                add("populate");
                add("add");
                add("get");
                add("contains");
                add("remove");
                add("listIteratorAdd");
                add("listIteratorRemove");
            }});
            chart.setColumnSeparator('|');
            chart.setAlign(LEFT);
            chart.addColumn(0, "Collection");

            listCollection = new ListCollection(COLLECTION_SIZE, new ArrayList<>());
            testResults = listCollection.allMethods(MEASUREMENT_COUNT);
            chart.addRow(testResults);
            chart.setCell(1, 0, "ArrayList(" + COLLECTION_SIZE + ")");

            listCollection = new ListCollection(COLLECTION_SIZE, new LinkedList<>());
            testResults = listCollection.allMethods(MEASUREMENT_COUNT);
            chart.addRow(testResults);
            chart.setCell(2, 0, "LinkedList(" + COLLECTION_SIZE + ")");

            SetCollection setCollection = new SetCollection(COLLECTION_SIZE, new HashSet<>());
            testResults = setCollection.allMethods(MEASUREMENT_COUNT);
            chart.addRow(testResults);
            chart.setCell(3, 0, "HashSet(" + COLLECTION_SIZE + ")");

            setCollection = new SetCollection(COLLECTION_SIZE, new TreeSet<>());
            testResults = setCollection.allMethods(MEASUREMENT_COUNT);
            chart.addRow(testResults);
            chart.setCell(4, 0, "TreeSet(" + COLLECTION_SIZE + ")");

            chart.toConsole();
            System.out.println();
            chart.toFile("");
        }
    }
}
