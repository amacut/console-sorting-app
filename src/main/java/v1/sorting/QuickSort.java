package v1.sorting;

public class QuickSort extends SortMethod{


    public QuickSort() {
        super("QuickSort Method");
    }

    @Override
    public Integer[] sort(Integer[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length == 0) {
            return null;
        }
        int n = arrayToSort.length;
        quickSort(arrayToSort, 0, n - 1);
        return arrayToSort;
    }

    private static void quickSort(Integer[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int border = partitionArray(array, left, right);

        // zmniejszenie stosu wywołań - zawsze sprawdzamy najpierw krótszą część
        if (border - left < right - border) {
            quickSort(array, left, border - 1);
            quickSort(array, border + 1, right);
        } else {
            quickSort(array, border + 1, right);
            quickSort(array, left, border - 1);
        }

    }

    private static int partitionArray(Integer[] array, int left, int right) {
        int pivotValue = choosePivot(array, left, right);
        int border = left - 1;
        int i = left;

        while (i < right) {
            if (array[i] < pivotValue) {
                border++;
                if (border != i) {
                    // zamiana elementów
                    int temp = array[border];
                    array[border] = array[i];
                    array[i] = temp;
                }
            }
            i++;
        }

        border++;
        if (border != right) {
            // zamiana elementów
            int temp = array[border];
            array[border] = array[right];
            array[right] = temp;
        }
        return border;
    }

    // move pivot to end of array
    private static int choosePivot(Integer[] array, int left, int right) {
//        return array[right];
        int mid = left + (right - left) / 2;
        int pivotValue = array[mid];
        int temp = array[mid];
        array[mid] = array[right];
        array[right] = temp;
        return pivotValue;
    }
}
