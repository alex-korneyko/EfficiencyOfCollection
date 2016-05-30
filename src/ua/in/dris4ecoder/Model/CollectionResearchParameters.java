package ua.in.dris4ecoder.Model;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public interface CollectionResearchParameters {

    long add(int measurementCount);

    long get(int measurementCount);

    long remove(int measurementCount);

    long contain(int measurementCount);

    long populate(int startValue, int endValue, int measurementCount);

    long listIteratorAdd(int measurementCount);

    long listIteratorRemove(int measurementCount);


}
