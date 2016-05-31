package ua.in.dris4ecoder;

import ua.in.dris4ecoder.Model.ListCollection;
import ua.in.dris4ecoder.Model.SetCollection;
import ua.in.dris4ecoder.View.files.FileResults;
import ua.in.dris4ecoder.View.files.FileType;
import ua.in.dris4ecoder.View.charts.BordersType;
import ua.in.dris4ecoder.View.charts.Chart;

import java.util.*;

import static ua.in.dris4ecoder.View.charts.ChartAlign.*;

/**
 * Программа должна сравнивать различные имплементации
 * коллекций по эффективности выполнения следующих операций:
 * <p>
 * List
 * <p>
 * add(index)
 * get(index)
 * remove(index)
 * contains(value)
 * populate (наполнение коллекции)
 * ListIterator.add()
 * ListIterator.remove()
 * <p>
 * Set
 * <p>
 * add(value)
 * remove(value)
 * contains(value)
 * populate (наполнение коллекции)
 * <p>
 * Сравнения должны выполнятся на объемах: 10К (10 000) 100К 1000К элементов.
 * <p>
 * Для каждого набора (10К, 100К, 1000К) выполнить не менее 100 измерений и вычислить среднее значение.
 * <p>
 * Created by Alex Korneyko on 26.05.2016.
 */
public class Main {

    private static final int MEASUREMENT_COUNT = 100;

    public static void main(String[] args) {

        ListCollection listCollection;
        Map<String, Double> testResults;
        FileResults txtFileResults = new FileResults("results.txt", FileType.TXT_FILE);

        for (int size = 100_000; size <= 10_000_000; size *= 10) {

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

            chart.toConsole(BordersType.WITHOUT_HEADER);
            chart.toFile(txtFileResults, BordersType.WITHOUT_HEADER);
            System.out.println();
        }

        txtFileResults.close();
    }
}
