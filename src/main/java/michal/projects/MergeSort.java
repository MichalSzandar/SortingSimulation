package michal.projects;

public class MergeSort extends SortingAlgorithm {

    /**
     * merges two sub arrays
     * @param l - left bound
     * @param m - middle 
     * @param r - right bound
     */
    private void merge(int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        double L[] = new double[n1];
        double R[] = new double[n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = list.get(l+i).getHeight();
        for (int j = 0; j < n2; ++j)
            R[j] = list.get(m + 1 + j).getHeight();

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if(!isRunning) return;
            if (L[i] <= R[j]) {
                setVal(k, L[i]);
                i++;
            }
            else {
                setVal(k, R[j]);
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            if(!isRunning) return;
            setVal(k, L[i]);
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            if(!isRunning) return;
            setVal(k, R[j]);
            j++;
            k++;
        }
    }

    /**
     * main sort function for merge sort algorithm
     * @param l - left bound
     * @param r - right bound
     */
    private void sort(int l, int r)
    {
        if(!isRunning) return;
        if (l < r) {

            // Find the middle point
            int m = (l+r) / 2;

            // Sort first and second halves
            sort(l, m);
            sort(m + 1, r);

            // Merge the sorted halves
            merge(l, m, r);
        }
    }

    @Override
    public void run() {
        isRunning = true;
        
        sort(0, list.size()-1);
    }
    
}
