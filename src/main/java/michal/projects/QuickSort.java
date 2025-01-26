package michal.projects;

public class QuickSort extends SortingAlgorithm {

    private int partition(final int low, final int high) {
        double pivot = list.get(high).getHeight();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (!isRunning) {
                return -1;
                // If current element is smaller than or
                // equal to pivot
            }

            if (list.get(j).getHeight() <= pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(high, i + 1);

        return i + 1;
    }

    private void sort(final int l, final int h) {
        if (!isRunning) {
            return;
        }

        if (l < h) {
            int pi = partition(l, h);
            if (pi < 0) {
                return;
            }

            // Recursively sort elements before
            // partition and after partition
            sort(l, pi - 1);
            sort(pi + 1, h);
        }
    }

    @Override
    public final void run() {
        isRunning = true;
        sort(0, list.size() - 1);
    }
}
