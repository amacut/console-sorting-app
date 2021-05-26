package v1.sorting;

public class BubbleSort extends SortMethod {


    public BubbleSort() {
        super("Bubble Sort Method");
    }

    @Override
    public Integer[] sort(Integer[] integers) {
        int nElements = integers.length;

        // tablica 5 el
        // n = 5

        for (int i = nElements - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                int index1 = j + 1;
                if (integers[j] > integers[index1]) {
                    swap(integers, j, index1);
                }
            }
        }
        return integers;
    }
}
