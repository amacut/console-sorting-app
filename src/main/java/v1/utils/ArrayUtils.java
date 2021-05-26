package v1.utils;

public class ArrayUtils {

    public static void showSortedArray(Integer[] arrayToShow) {
        if (arrayToShow.length <= 10000) {
            for (Integer item : arrayToShow) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static Integer[] formatStringArrayToIntArray(String data) {
        String[] array = data
//                .substring(1, data.length() - 1)
                .replaceAll("[^0-9-,]", "")
                .split(",");
        Integer[] intArray = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }
}
