package v1.sorting;

public class SelectionSort extends SortMethod{

    public SelectionSort() {
        super("Selection Sort Method");
    }

    @Override
    public Integer[] sort(Integer[] arrayToSort) {
        int min;
        int out;
        int in;

        for (out = 0; out < arrayToSort.length-1; out++) {
            min = out;
            for (in = out + 1; in < arrayToSort.length; in++) {
                if (arrayToSort[in] < arrayToSort[min]) {
                    min = in;
                }
            }
            swap(arrayToSort, out, min);
        }
        return arrayToSort;
    }
}
