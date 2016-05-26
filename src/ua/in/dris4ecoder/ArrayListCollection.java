package ua.in.dris4ecoder;

import java.util.ArrayList;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public class ArrayListCollection extends ListCollection {

    public ArrayListCollection(int collectionSize) {

        super(collectionSize, new ArrayList<>());
    }
}
