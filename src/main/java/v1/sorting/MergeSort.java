package v1.sorting;

public class MergeSort extends SortMethod {

    private static int[] extraArray;

    public MergeSort() {
        super("MergeSort Method");
    }

    @Override
    public Integer[] sort(Integer[] arrayToSort) {
        extraArray = new int[arrayToSort.length];
        mergeSort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }

    private static void mergeSort(Integer[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middle = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, middle);
            mergeSort(array, middle + 1, rightIndex);
            merge(array, leftIndex, middle, rightIndex);
        }
    }

    private static void merge(Integer[] array, int leftIndex, int middleIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            extraArray[i] = array[i];
        }
        int finger1 = leftIndex;
        int finger2 = middleIndex + 1;
        int current = leftIndex;

        while (finger1 <= middleIndex && finger2 <= rightIndex) {
            if (extraArray[finger1] <= extraArray[finger2]) {
                array[current] = extraArray[finger1];
                finger1++;
            } else {
                array[current] = extraArray[finger2];
                finger2++;
            }
            current++;
        }

        while (finger1 <= middleIndex) {
            array[current] = extraArray[finger1];
            finger1++;
            current++;
        }
    }
}
