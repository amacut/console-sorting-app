package v1.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    private final InsertionSort INSERTION_SORT = new InsertionSort();
    private final Integer[] ARRAY_TO_SORT = {4, 1, 5, 7, 2, 9, 3, 6, 8};
    private final Integer[] EXPECTED = {1, 2, 3, 4, 5, 6, 7, 8, 9};


    @Test
    void should_sort_array_using_insertion_sort() {
        Integer[] result = INSERTION_SORT.sort(ARRAY_TO_SORT);

        Assertions.assertThat(result).isEqualTo(EXPECTED);
    }
}