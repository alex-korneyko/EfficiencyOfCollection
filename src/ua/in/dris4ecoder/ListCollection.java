package ua.in.dris4ecoder;

import javax.tools.JavaCompiler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public abstract class ListCollection<T extends List> implements ListParametersExperement {

    private List<Integer> list;
    private int collectionSize;

    public ListCollection(int collectionSize, List<Integer> newList) {
        list = newList;
        this.collectionSize = collectionSize;
        System.out.println("Populating: " + this.populate(0, Integer.MAX_VALUE) + "ms");
    }

    @Override
    public long add(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            list.add(randomGenerator(0, list.size() - 1), 0);
        }

        return (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public long get(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            list.get(randomGenerator(0, list.size() - 1));
        }

        return (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public long remove(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            list.remove(randomGenerator(0, list.size() - 1));
        }

        return (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public long contain(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            list.contains(randomGenerator(0, Integer.MAX_VALUE));
        }

        return (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public long populate(int startValue, int endValue) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < collectionSize; i++) {
            list.add(randomGenerator(startValue, endValue));
        }

        return System.currentTimeMillis() - start;
    }

    @Override
    public long listIteratorAdd(int measurementCount) {
        final long start = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator();

        for (int i = 0; i < measurementCount; i++) {
            iterator.add(0);
        }

        return System.currentTimeMillis() - start;
    }

    @Override
    public long listIteratorRemove(int measurementCount) {
        final long start = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator();

        for (int i = 0; i < measurementCount; i++) {
            iterator.next();
            iterator.remove();
        }

        return System.currentTimeMillis() - start;
    }

    private int randomGenerator(int lowerLimit, int upperLimit) {

        //Формула случайного числа в определённом диапазоне
        return lowerLimit + (int) (Math.random() * ((upperLimit - lowerLimit) + 1));
    }
}
