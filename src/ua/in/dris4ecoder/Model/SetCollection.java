package ua.in.dris4ecoder.Model;

import java.util.Set;

/**
 * Created by Alex Korneyko on 29.05.2016.
 */
public class SetCollection extends AllCollections {

    public SetCollection(int collectionSize, Set<Integer> set) {
        this.collectionSize = collectionSize;
        this.collection = set;
        this.populate(0, Integer.MAX_VALUE, 1);
    }

    @Override
    public long add(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            collection.add(randomGenerator(0, collection.size() - 1));
        }

        return (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public long remove(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            collection.remove(randomGenerator(0, collection.size() - 1));
        }

        return (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public long contain(int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < measurementCount; i++) {
            collection.contains(randomGenerator(0, Integer.MAX_VALUE));
        }

        return (System.currentTimeMillis() - start) / measurementCount;
    }

    @Override
    public long populate(int startValue, int endValue, int measurementCount) {
        final long start = System.currentTimeMillis();

        for (int j = 0; j < measurementCount; j++) {
            this.collection.clear();
            while (collection.size() < collectionSize){
                collection.add(randomGenerator(startValue, endValue));
            }
        }

        return (System.currentTimeMillis() - start) / measurementCount;
    }
}
