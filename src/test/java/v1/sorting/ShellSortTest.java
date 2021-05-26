package v1.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    private final ShellSort SHELL_SORT = new ShellSort();
    private final Integer[] ARRAY_TO_SORT = {4, 1, 5, 7, 2, 9, 3, 6, 8};
    private final Integer[] EXPECTED = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    void should_sort_array_using_shell_sort() {
        Integer[] result = SHELL_SORT.sort(ARRAY_TO_SORT);

        assertArrayEquals(EXPECTED, result);
    }
}