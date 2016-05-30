package ua.in.dris4ecoder.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex Korneyko on 29.05.2016.
 */
public abstract class AllCollections {

    protected Collection<Integer> collection;
    protected int collectionSize;


    public abstract double add(int measurementCount);

    public double get(int measurementCount) {
        return 0;
    }

    public abstract double remove(int measurementCount);

    public abstract double contain(int measurementCount);

    public abstract double populate(int startValue, int endValue, int measurementCount);

    public double listIteratorAdd(int measurementCount) {
        return 0;
    }

    public double listIteratorRemove(int measurementCount) {
        return 0;
    }

    public void clear() {
        this.collection.clear();
    }

    protected int randomGenerator(int lowerLimit, int upperLimit) {

        //Формула случайного числа в определённом диапазоне
        return lowerLimit + (int) (Math.random() * ((upperLimit - lowerLimit) + 1));
    }

    public Map<String, Double> allMethods(int measurementCount) {
        Map<String, Double> result = new HashMap<>();
        result.put("populate", this.populate(0, Integer.MAX_VALUE, measurementCount));
        result.put("add", this.add(measurementCount));
        result.put("get", this.get(measurementCount));
        result.put("remove", this.remove(measurementCount));
        result.put("contains", this.contain(measurementCount));
        result.put("listIteratorAdd", this.listIteratorAdd(measurementCount));
        result.put("listIteratorRemove", this.listIteratorRemove(measurementCount));

        this.clear();

        return result;
    }

    public String allMethodsToString(int measurementCount) {
        Long execTime = System.currentTimeMillis();
        Map<String, Double> allTest = this.allMethods(measurementCount);
        String result = "Exploration for " + this.collection.getClass().toString()
                + " (" + collectionSize + " elements, " + measurementCount + " attempts)\n";
        for (String key : allTest.keySet()) {
            result += "Method " + key + ": " + allTest.get(key) + "ms\n";
        }
        result += "Total execution time (100 attempts):" + (System.currentTimeMillis() - execTime) + "ms";

        return result;
    }
}
