package v1.utils;

import v1.sorting.SortMethod;

public interface SortMethodUtils {

    void oneMethodSort(SortMethod sortMethod, Integer[] arrayToSort);
    void allMethodSort(Integer[] arrayToSort);
    void oneMethodSortMultiThread(SortMethod sortMethod, Integer[] arrayToSort);
    void allMethodSortMultiThread(Integer[] arrayToSort);
    String getSortTimeOneThread();
    String getSortTimeMultiThread();
    String getMethodSortTime(SortMethod sortMethod);
    String getMethodSortTimeMultiThread(SortMethod sortMethod);
}
