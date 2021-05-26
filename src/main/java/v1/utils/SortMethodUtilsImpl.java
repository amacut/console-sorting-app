package v1.utils;

import v1.Sorter;
import v1.sorting.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SortMethodUtilsImpl implements SortMethodUtils {

    private Long sortTimeOneThread;
    private Long sortTimeMultiThread;
    private SortMethod bubbleSort;
    private SortMethod selectionSort;
    private SortMethod insertionSort;
    private SortMethod mergeSort;
    private SortMethod quickSort;
    private SortMethod shellSort;


    public void oneMethodSort(SortMethod sortMethod, Integer[] arrayToSort) {
        long start = System.currentTimeMillis();
        Integer[] sortIntegers = Sorter.sort(sortMethod, arrayToSort);
        sortMethod.setSortTimeOneThread(System.currentTimeMillis() - start);

        ArrayUtils.showSortedArray(sortIntegers);


    }


    public void allMethodSort(Integer[] arrayToSort) {
        List<SortMethod> sortMethodList = getSortMethodList();

        long startOneThread = System.currentTimeMillis();
        for (SortMethod sortMethod : sortMethodList) {
            Integer[] tempArr = arrayToSort.clone();

            long start = System.currentTimeMillis();
            sortMethod.sort(tempArr);
            sortMethod.setSortTimeOneThread(System.currentTimeMillis() - start);
            System.out.printf("%s (czas[ms] = %d)\n", sortMethod.getName(), sortMethod.getSortTimeOneThread());

            ArrayUtils.showSortedArray(tempArr);


        }
        sortTimeOneThread = (System.currentTimeMillis() - startOneThread);

    }

    public void oneMethodSortMultiThread(SortMethod sortMethod, Integer[] arrayToSort) {

        Integer[] tempArr = arrayToSort.clone();
        long start = System.currentTimeMillis();
        Sorter.sort(sortMethod, tempArr);
        sortMethod.setSortTimeMultiThread(System.currentTimeMillis() - start);
        System.out.printf("%s (czas[ms] = %d)\n", sortMethod.getName(), sortMethod.getSortTimeMultiThread());

        ArrayUtils.showSortedArray(tempArr);
    }

    public void allMethodSortMultiThread(Integer[] arrayToSort) {
        List<SortMethod> sortMethodList = getSortMethodList();


        ExecutorService executorService = Executors.newFixedThreadPool(sortMethodList.size());
        for (SortMethod sortMethod : sortMethodList) {
            executorService.submit(() -> oneMethodSortMultiThread(sortMethod, arrayToSort));
        }
        executorService.shutdown();


    /*    Thread threadBubbleSort = new Thread(() -> {
            Integer[] tempArr = arrayToSort.clone();
            long start = System.currentTimeMillis();
            Sorter.sort(bubbleSort, tempArr);
            bubbleSort.setSortTimeMultiThread(System.currentTimeMillis()-start);
            System.out.printf("%s (czas[ms] = %d)\n", bubbleSort.getName(), bubbleSort.getSortTimeMultiThread());
            ArrayUtils.showSortedArray(tempArr);
        });
        threadBubbleSort.setName("BubbleSortThread");
//        threadBubbleSort.run(); // uruchamia w wątku głównym
        threadBubbleSort.start(); // uruchamia metodę run w osobnym wątku
        threadMergeSort.setName("MergeSortThread");*/
    }

    public String getSortTimeOneThread() {
        if (sortTimeOneThread != null) {
            return sortTimeOneThread + "";
        }
        return "Przeprowadź operację sortowania dla wszystkich metod w jednym wątku";
    }

    public String getSortTimeMultiThread() {
        if (sortTimeMultiThread != null) {
            return sortTimeMultiThread + "";
        }
        return "Przeprowadź operację sortowania dla wszystkich metod w wielu wątkach";
    }

    public String getMethodSortTime(SortMethod sortMethod) {
        if (sortMethod != null && sortMethod.getSortTimeOneThread() != null) {
            return sortMethod.getSortTimeOneThread() + "";
        }
        return "Nie przeprowadzono operacji sortowania";
    }

    public String getMethodSortTimeMultiThread(SortMethod sortMethod) {
        if (sortMethod != null && sortMethod.getSortTimeMultiThread() != null) {
            return sortMethod.getSortTimeMultiThread() + "";
        }
        return "Nie przeprowadzono operacji sortowania";
    }

    public void setSortTimeMultiThread(Long sortTimeMultiThread) {
        this.sortTimeMultiThread = sortTimeMultiThread;
    }

    public SortMethod getBubbleSort() {
        return bubbleSort;
    }

    public void setBubbleSort(SortMethod bubbleSort) {
        this.bubbleSort = bubbleSort;
    }

    public SortMethod getSelectionSort() {
        return selectionSort;
    }

    public void setSelectionSort(SelectionSort selectionSort) {
        this.selectionSort = selectionSort;
    }

    public SortMethod getInsertionSort() {
        return insertionSort;
    }

    public void setInsertionSort(InsertionSort insertionSort) {
        this.insertionSort = insertionSort;
    }

    public SortMethod getMergeSort() {
        return mergeSort;
    }

    public void setMergeSort(SortMethod mergeSort) {
        this.mergeSort = mergeSort;
    }

    public SortMethod getQuickSort() {
        return quickSort;
    }

    public void setQuickSort(SortMethod quickSort) {
        this.quickSort = quickSort;
    }

    public SortMethod getShellSort() {
        return shellSort;
    }

    public void setShellSort(SortMethod shellSort) {
        this.shellSort = shellSort;
    }

    private List<SortMethod> getSortMethodList() {
        if (bubbleSort == null) {
            bubbleSort = new BubbleSort();
        }
        if (selectionSort == null) {
            selectionSort = new SelectionSort();
        }
        if (insertionSort == null) {
            insertionSort = new InsertionSort();
        }
        if (mergeSort == null) {
            mergeSort = new MergeSort();
        }
        if (quickSort == null) {
            quickSort = new QuickSort();
        }
        if (shellSort == null) {
            shellSort = new ShellSort();
        }

        return List.of(bubbleSort, selectionSort, insertionSort, mergeSort, quickSort, shellSort);
    }


}
