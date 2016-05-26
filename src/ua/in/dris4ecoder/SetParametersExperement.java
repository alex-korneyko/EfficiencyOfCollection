package ua.in.dris4ecoder;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public interface SetParametersExperement {

    public long add(int measurementCount);

    public long remove(int measurementCount);

    public long containd(int measurementCount);

    public long populate(int measurementCount);
}
