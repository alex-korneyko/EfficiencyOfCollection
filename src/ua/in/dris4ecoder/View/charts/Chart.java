package ua.in.dris4ecoder.View.charts;

import ua.in.dris4ecoder.View.FileResults;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static ua.in.dris4ecoder.View.charts.ChartAlign.*;

/**
 * Created by Alex Korneyko on 29.05.2016.
 */
public class Chart implements Cloneable {

    private List<ArrayList<Cell>> chart = new ArrayList<>();

    boolean allWidthAsBiggest = false;
    private String columnSeparator = " ";
    private ChartAlign chartAlign = LEFT;

    public void setAlign(ChartAlign chartAlign) {
        this.chartAlign = chartAlign;
    }

    public Chart() {
    }

    public Chart(List<String> header) {
        this.setHeader(header);
    }

    public void setHeader(List<String> header) {
        chart.add(new ArrayList<>());

        List<Cell> hdr = header.stream().map(Cell::new).collect(Collectors.toList());

        for (Cell columnName : hdr) {
            chart.get(0).add(columnName);
        }
    }

    public void addColumn(String columnName) {
        addColumn(chart.get(0).size(), columnName);
    }

    public void addColumn(int columnPosition, String columnName) {
        chart.get(0).add(columnPosition, new Cell(columnName));
    }

    public void addRow(Map<String, Double> rowValues) {
        ArrayList<Cell> row = new ArrayList<>();
        for (int i = 0; i < chart.get(0).size(); i++) {
            row.add(new Cell(""));
        }

        for (String columnName : rowValues.keySet()) {
            int columnNumber = chart.get(0).indexOf(new Cell(columnName));
            if (columnNumber == -1) continue;
            row.set(columnNumber, new Cell(rowValues.get(columnName).toString()));
        }

        chart.add(row);
    }

    public void setCell(int row, int column, String value) {
        chart.get(row).set(column, new Cell(value));
    }

    public String getCell(int row, int column) {
        try {
            return chart.get(row).get(column).getValue();
        } catch (IndexOutOfBoundsException e) {
            return "Cell not found!";
        }
    }

    public void setColumnSeparator(String separator) {
        this.columnSeparator = separator;
    }

    public void toConsole(BordersType bordersType) {

        if (bordersType == BordersType.WITH_HEADER) columnSeparator = "│";

        for (int i = 0; i < chart.size(); i++) {
            System.out.println(prepareRow(chart.get(i)));
        }

    }

    public void toFile(FileResults file, BordersType bordersType) {

        if (bordersType == BordersType.WITH_HEADER) columnSeparator = "│";

        for (int i=0; i< chart.size(); i++){
            file.writeLine(prepareRow(chart.get(i)));
        }

    }

    private String prepareRow(ArrayList<Cell> row) {
        String result = "";
        for (int i = 0; i < row.size(); i++) {
            arrangeColumn(i);
            result += columnSeparator;
            result += row.get(i).getValue();
        }
        result += columnSeparator;
        return result;
    }

    private void arrangeColumn(int columnNumber) {
        int maxCellWidth = 0;

        for (ArrayList<Cell> row : chart) {
            if (row.get(columnNumber).getValue().length() > maxCellWidth)
                maxCellWidth = row.get(columnNumber).getValue().length();
        }

        for (int i = 0; i < chart.size(); i++) {
            String value = getCell(i, columnNumber);
            String resultValue;

            if (chartAlign == RIGHT) {
                resultValue = "";
            } else {
                resultValue = value;
            }

            for (int j = 0; j < maxCellWidth - value.length(); j++) {
                resultValue += " ";
            }

            if (chartAlign == RIGHT) resultValue += value;

            chart.get(i).set(columnNumber, new Cell(resultValue));
        }
    }
}
