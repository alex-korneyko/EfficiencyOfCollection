package ua.in.dris4ecoder;

/**
 * Created by Alex Korneyko on 26.05.2016.
 */
public class Main {

    public static void main(String[] args) {

        ListCollection arrayListCollection = new ArrayListCollection(10_000_000);

        System.out.println("Add method: "+ arrayListCollection.add(100) + "ms");
        System.out.println("Get method: "+ arrayListCollection.get(100) + "ms");
        System.out.println("Remove method: "+ arrayListCollection.remove(100) + "ms");
        System.out.println("Contain method: "+ arrayListCollection.contain(100) + "ms");
        System.out.println("ListIterator Set method: "+ arrayListCollection.listIteratorAdd(100) + "ms");
        System.out.println("ListIterator Remove method: "+ arrayListCollection.listIteratorRemove(100) + "ms");
        System.out.println();

        ListCollection linkedListCollection = new LinkedListCollection(10_000_000);

        System.out.println("Add method: "+ arrayListCollection.add(100) + "ms");
        System.out.println("Get method: "+ arrayListCollection.get(100) + "ms");
        System.out.println("Remove method: "+ arrayListCollection.remove(100) + "ms");
        System.out.println("Contain method: "+ arrayListCollection.contain(100) + "ms");
        System.out.println("ListIterator Set method: "+ arrayListCollection.listIteratorAdd(100) + "ms");
        System.out.println("ListIterator Remove method: "+ arrayListCollection.listIteratorRemove(100) + "ms");
    }
}
