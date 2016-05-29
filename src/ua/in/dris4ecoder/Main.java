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

        ListCollection listCollection = new ListCollection(10_000_000, new ArrayList<>());
        System.out.println(listCollection.allMethodsToString(100) + "\n");

        listCollection = new ListCollection(10_000_000, new LinkedList<>());
        System.out.println(listCollection.allMethodsToString(100) + "\n");

        SetCollection setCollection = new SetCollection(10_000_000, new HashSet<>());
        System.out.println(setCollection.allMethodsToString(100) + "\n");

        setCollection = new SetCollection(10_000_000, new TreeSet<>());
        System.out.println(setCollection.allMethodsToString(100) + "\n");

    }
}
