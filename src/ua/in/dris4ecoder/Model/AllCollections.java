package ua.in.dris4ecoder.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex Korneyko on 29.05.2016.
 */
public abstract class AllCollections implements CollectionResearchParameters {

    protected Collection<Integer> collection;
    protected int collectionSize;

    @Override
    public abstract long add(int measurementCount);

    @Override
    public long get(int measurementCount) {
        return 0;
    }

    @Override
    public abstract long remove(int measurementCount);

    @Override
    public abstract long contain(int measurementCount);

    @Override
    public abstract long populate(int startValue, int endValue, int measurementCount);

    @Override
    public long listIteratorAdd(int measurementCount) {
        return 0;
    }

    @Override
    public long listIteratorRemove(int measurementCount) {
        return 0;
    }

    public void clear() {
        this.collection.clear();
    }

    protected int randomGenerator(int lowerLimit, int upperLimit) {

        //Формула случайного числа в определённом диапазоне
        return lowerLimit + (int) (Math.random() * ((upperLimit - lowerLimit) + 1));
    }

    public Map<String, Long> allMethods(int measurementCount) {
        Map<String, Long> result = new HashMap<>();
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
        Map<String, Long> allTest = this.allMethods(measurementCount);
        String result = "Exploration for " + this.collection.getClass().toString()
                + " (" + collectionSize + " elements, " + measurementCount + " attempts)\n";
        for (String key : allTest.keySet()) {
            result += "Method " + key + ": " + allTest.get(key) + "ms\n";
        }
        result += "Total execution time (100 attempts):" + (System.currentTimeMillis() - execTime) + "ms";

        return result;
    }
}
