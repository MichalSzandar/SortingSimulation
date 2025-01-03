package michal.projects;

public class BubbleSort extends SortingAlgorithm{

    @Override
    public void run() {
        isRunning = true;
        
        int size = list.size();
        int i, j;
        boolean swapped;

        for (i = 0; i < size - 1; i++) {
            if(!isRunning) return;

            swapped = false;
            for (j = 0; j < size - i - 1; j++) {
                double a = list.get(j).getHeight();
                double b = list.get(j+1).getHeight();
                if (a > b) {
                    swap(j, j+1);
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
        }  
    }
    
}
