package v1.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    private final SelectionSort SELECTION_SORT = new SelectionSort();
    private final Integer[] ARRAY_TO_SORT = {4, 1, 5, 7, 2, 9, 3, 6, 8};
    private final Integer[] EXPECTED = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    void should_sort_array_using_selection_sort() {
        Integer[] result = SELECTION_SORT.sort(ARRAY_TO_SORT);

        Assertions.assertThat(result).isEqualTo(EXPECTED);
    }
}