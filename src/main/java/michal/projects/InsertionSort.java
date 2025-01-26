package michal.projects;

public class InsertionSort extends SortingAlgorithm {

    @Override
    public final void run() {
        isRunning = true;

        int size = list.size();

        for (int j = 1; j < size; j++) {
            if (!isRunning) {
                return;
            }

            double key = list.get(j).getHeight();
            int i = j - 1;
            while (i >= 0) {
                if (i + 1 < size && list.get(i).getHeight() > key) {
                    swap(i, i + 1);
                } else {
                    break;
                }
                i--;
            }
        }
    }
}
