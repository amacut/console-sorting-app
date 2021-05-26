package v1;

import v1.sorting.SortMethod;

public class Sorter {

    public static Integer[] sort(SortMethod sortMethod, Integer[] arrayToSort) {
        return sortMethod.sort(arrayToSort);
    }
}
