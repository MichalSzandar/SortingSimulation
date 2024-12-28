package michal.projects;

public class InsertionSort extends SortingAlgorithm{

    public InsertionSort(){
        super();
    }
    
    @Override
    public void run() {
        int size = list.size();
        try {
            for(int j = 1; j < size; j++) {
                double key = list.get(j).getHeight();
                int i = j-1;
                while (i >= 0 ) {
                    if (list.get(i).getHeight() > key) {
                        swap(i, i+1);
                        Thread.sleep(speed);
                    } else {
                        break;
                    }
                    i--;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
