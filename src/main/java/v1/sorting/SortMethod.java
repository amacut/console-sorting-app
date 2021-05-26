package v1.sorting;

public abstract class SortMethod {

    private String name;
    private Long sortTimeOneThread;
    private Long sortTimeMultiThread;

    protected void swap(Integer[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public SortMethod(String name) {
        this.name = name;
    }

    public abstract Integer[] sort(Integer[] arrayToSort);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSortTimeOneThread() {
        return sortTimeOneThread;
    }

    public void setSortTimeOneThread(Long sortTimeOneThread) {
        this.sortTimeOneThread = sortTimeOneThread;
    }

    public Long getSortTimeMultiThread() {
        return sortTimeMultiThread;
    }

    public void setSortTimeMultiThread(Long sortTimeMultiThread) {
        this.sortTimeMultiThread = sortTimeMultiThread;
    }
}
