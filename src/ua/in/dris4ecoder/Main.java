package ua.in.dris4ecoder;

import ua.in.dris4ecoder.Model.ListCollection;
import ua.in.dris4ecoder.Model.SetCollection;
import ua.in.dris4ecoder.View.FileResults;
import ua.in.dris4ecoder.View.FileType;
import ua.in.dris4ecoder.View.charts.BordersType;
import ua.in.dris4ecoder.View.charts.Chart;

import java.io.File;
import java.util.*;

import static ua.in.dris4ecoder.View.charts.ChartAlign.*;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public class Main {

    private static final int MEASUREMENT_COUNT = 100;

    public static void main(String[] args) {

        ListCollection listCollection;
        Map<String, Double> testResults;
        FileResults txtFileResults = new FileResults("results.txt", FileType.TXT_FILE);

        for (int size = 10_000; size <= 10_000; size *= 10) {

            Chart chart = new Chart(new ArrayList<String>() {{
                add("populate");
                add("add");
                add("get");
                add("contains");
                add("remove");
                add("listIteratorAdd");
                add("listIteratorRemove");
            }});
            chart.setColumnSeparator("|");
            chart.setAlign(LEFT);
            chart.addColumn(0, "Collection");

            listCollection = new ListCollection(size, new ArrayList<>());
            testResults = listCollection.allMethods(MEASUREMENT_COUNT);
            chart.addRow(testResults);
            chart.setCell(1, 0, "ArrayList(" + size + ")");

            listCollection = new ListCollection(size, new LinkedList<>());
            testResults = listCollection.allMethods(MEASUREMENT_COUNT);
            chart.addRow(testResults);
            chart.setCell(2, 0, "LinkedList(" + size + ")");

            SetCollection setCollection = new SetCollection(size, new HashSet<>());
            testResults = setCollection.allMethods(MEASUREMENT_COUNT);
            chart.addRow(testResults);
            chart.setCell(3, 0, "HashSet(" + size + ")");

            setCollection = new SetCollection(size, new TreeSet<>());
            testResults = setCollection.allMethods(MEASUREMENT_COUNT);
            chart.addRow(testResults);
            chart.setCell(4, 0, "TreeSet(" + size + ")");

            chart.toConsole(BordersType.WITH_HEADER);
            chart.toFile(txtFileResults, BordersType.SIMPLE);
            System.out.println();
        }

        txtFileResults.close();
    }
}
