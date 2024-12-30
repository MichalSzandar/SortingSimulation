package michal.projects;

public class QuickSort extends SortingAlgorithm {

    int partition(int low, int high)
    {
        double pivot = list.get(high).getHeight(); 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (list.get(j).getHeight() <= pivot)
            {
                i++;
                swap(i, j);
            }
        }

        swap(high, i+1);

        return i+1;
    }


    void sort(int l, int h)
    {
        if (l < h)
        {
            int pi = partition(l, h);

            // Recursively sort elements before
            // partition and after partition
            sort(l, pi-1);
            sort(pi+1, h);
        }
    }

    @Override
    public void run() {
        sort(0, list.size()-1);
    }
    
}
