package ua.in.dris4ecoder;

import java.util.LinkedList;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public class LinkedListCollection extends ListCollection {

    public LinkedListCollection(int collectionSize) {

        super(collectionSize, new LinkedList<>());
    }
}
