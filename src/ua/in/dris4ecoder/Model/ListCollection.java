package ua.in.dris4ecoder.Model;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public class ListCollection extends AllCollections {

    public ListCollection(int collectionSize, List<Integer> list) {
        this.collection = list;
        this.collectionSize = collectionSize;
        this.populate(0, Integer.MAX_VALUE, 1);
    }

    @Override
    public double add(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            ((List<Integer>) collection).add(randomGenerator(0, collection.size() - 1), 0);
        }

        return (double) (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public double get(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            ((List<Integer>) collection).get(randomGenerator(0, collection.size() - 1));
        }

        return (double) (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public double remove(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            collection.remove(randomGenerator(0, collection.size() - 1));
        }

        return (double) (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public double contain(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            collection.contains(randomGenerator(0, Integer.MAX_VALUE));
        }

        return (double) (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public double populate(int startValue, int endValue, int measurementCount) {

        final long start = System.currentTimeMillis();

        for (int j = 0; j < measurementCount; j++) {
            this.collection.clear();
            while (collection.size() < collectionSize) {
                collection.add(randomGenerator(startValue, endValue));
            }
        }

        return (double) (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public double listIteratorAdd(int measurementCount) {
        ListIterator<Integer> iterator = ((List<Integer>) collection).listIterator();

        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            iterator.add(0);
        }

        return (double) (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public double listIteratorRemove(int measurementCount) {
        ListIterator<Integer> iterator = ((List<Integer>) collection).listIterator();

        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            iterator.next();
            iterator.remove();
        }

        return (double) (System.currentTimeMillis() - start) / measurementCount;
    }
}
