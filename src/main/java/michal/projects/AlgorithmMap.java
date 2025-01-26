package michal.projects;

import java.util.HashMap;

public final class AlgorithmMap {
    /**instance of AlgorithmMap object. */
    private static AlgorithmMap instance;
    /**Map algorithm name - SortingAlgorithm object. */
    private HashMap<String, SortingAlgorithm> map;

    private AlgorithmMap() {
        map = new HashMap<>();
        map.put("insertion sort", new InsertionSort());
        map.put("bubble sort", new BubbleSort());
        map.put("quick sort", new QuickSort());
        map.put("merge sort", new MergeSort());
    }

    /**
     * method to access instance of AlgorithmMap object.
     * @return AlgorithmMap instance
     */
    public static AlgorithmMap getInstance() {
        if (instance == null) {
            instance = new AlgorithmMap();
        }
        return instance;
    }

    /**
     * maps name of the algorithm with SortingAlgorithm object.
     * @param name - name of sorting algorithm
     * @param algorithm - SortingAlgorithm object
     */
    public void addNewAlgorithm(final String name,
                                final SortingAlgorithm algorithm) {
        map.put(name, algorithm);
    }

    /**
     * method to access SortingAlgorithm object by its name.
     * @param name - name of the algorithm
     * @return SortingAlgorithm that is mapped with given name
     */
    public SortingAlgorithm getAlgorithm(final String name) {
        return map.getOrDefault(name, new InsertionSort());
    }
}
