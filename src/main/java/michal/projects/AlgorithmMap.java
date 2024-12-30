package michal.projects;

import java.util.HashMap;

public class AlgorithmMap {
    private static AlgorithmMap instance;
    private HashMap<String, SortingAlgorithm> map;

    private AlgorithmMap(){
        map = new HashMap<>();
        map.put("insertion sort", new InsertionSort());
        map.put("bubble sort", new BubbleSort());
        map.put("quick sort", new QuickSort());
    }

    public static AlgorithmMap getInstance(){
        if(instance == null){
            instance = new AlgorithmMap();
        }
        return instance;
    }

    public void addNewAlgorithm(String name, SortingAlgorithm algorithm){
        map.put(name, algorithm);
    }

    public SortingAlgorithm getAlgorithm(String name){
        return map.getOrDefault(name, new InsertionSort());
    }
}
