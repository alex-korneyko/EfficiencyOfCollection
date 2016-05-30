package ua.in.dris4ecoder.View;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Alex Korneyko on 29.05.2016.
 */
public class Chart {

    Cell[][] chart;

    public Chart(int rows, int columns) {
        chart = new Cell[rows][columns];
    }

    public Chart(int rows, Set<String> header) {
        this(rows, header.size());
        this.setHeader(header);
    }

    boolean autoCellWidth = true;
    int maxCellWidth;

    public void setHeader(Set<String> header) {

        if (header.size() > this.chart[0].length) {
            this.chart = new Cell[chart.length][header.size()];
        }

        for (int i=0; i<header.size(); i++) {
            chart[0][i] = new Cell((String) header.toArray()[i]);
        }
    }

    public void addRow(Map<String, String> rowValues) {
        List<Cell> row = new ArrayList<>();
        for (String columnName : rowValues.keySet()) {

        }
    }

    public void printToConsole(){

        for(int i=0; i<chart.length; i++){
            for(int j=0; j<chart[0].length; j++){
                System.out.print(chart[i][j]);
            }
            System.out.print("\n");
        }
    }
}
