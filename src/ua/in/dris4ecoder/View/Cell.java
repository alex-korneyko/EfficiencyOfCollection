package ua.in.dris4ecoder.View;

import static ua.in.dris4ecoder.View.Cell.cellAlign.LEFT;

/**
 * Created by Alex Korneyko on 29.05.2016.
 */
public class Cell {

    private int width;
    private int height;
    private String value;
    private cellAlign align = LEFT;

    public Cell(String value) {
        this.value = value;
        width = value.length();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        width = value.length();
    }

    public cellAlign getAlign() {
        return align;
    }

    public void setAlign(cellAlign align) {
        this.align = align;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Cell && this.value.equals(((Cell) obj).value);

    }

    enum cellAlign {
        LEFT, RIGHT, CENTER
    }
}
