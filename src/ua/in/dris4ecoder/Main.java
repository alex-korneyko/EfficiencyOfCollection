package ua.in.dris4ecoder;

import ua.in.dris4ecoder.Model.ListCollection;
import ua.in.dris4ecoder.Model.SetCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public class Main {

    public static void main(String[] args) {

        final int COLLECTION_SIZE = 1_000_000;
        final int measurementCount = 100;

        ListCollection listCollection = new ListCollection(COLLECTION_SIZE, new ArrayList<>());
        System.out.println(listCollection.allMethodsToString(measurementCount) + "\n");

        listCollection = new ListCollection(COLLECTION_SIZE, new LinkedList<>());
        System.out.println(listCollection.allMethodsToString(measurementCount) + "\n");

        SetCollection setCollection = new SetCollection(COLLECTION_SIZE, new HashSet<>());
        System.out.println(setCollection.allMethodsToString(measurementCount) + "\n");

        setCollection = new SetCollection(COLLECTION_SIZE, new TreeSet<>());
        System.out.println(setCollection.allMethodsToString(measurementCount) + "\n");

    }
}
