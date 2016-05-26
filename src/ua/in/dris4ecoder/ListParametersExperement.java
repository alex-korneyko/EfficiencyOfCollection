package ua.in.dris4ecoder;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public interface ListParametersExperement {

    public long add(int measurementCount);

    public long get(int measurementCount);

    public long remove(int measurementCount);

    public long contain(int measurementCount);

    public long populate(int startValue, int endValue);

    public long listIteratorAdd(int measurementCount);

    public long listIteratorRemove(int measurementCount);
}
