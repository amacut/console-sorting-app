package v1.sorting;

public class ShellSort extends SortMethod {

    public ShellSort() {
        super("Shell Sort Method");
    }

    @Override
    public Integer[] sort(Integer[] arrayToSort) {

       int n = arrayToSort.length;

        for (int gap = n/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j-gap] > key) {
                    arrayToSort[j] = arrayToSort[j-gap];
                    j -= gap;
                }
                arrayToSort[j] = key;
            }
        }
        return arrayToSort;
    }
}
