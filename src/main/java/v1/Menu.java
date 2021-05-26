package v1;

import v1.sorting.*;
import v1.utils.ArrayUtils;
import v1.utils.SortMethodUtilsImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final SortMethodUtilsImpl SORT_METHOD_UTILS = new SortMethodUtilsImpl();
    private static final DataManager DATA_MANAGER = new DataManager();
    private static final int END_APP = 9;
    private static final Scanner INPUT = new Scanner(System.in);
    private static String introduces = "Witaj, jak masz na imię?";

    private static int userChoice;

    public static void startApp() {
        System.out.println(introduces);
        String userName = INPUT.nextLine();

        if (!userName.matches(".*\\d.*")) {
            System.out.println("Witaj w programie, " + userName + "!");
            showMenu();
            operationsMenu();
        } else {
            System.out.println("Imię nie może zawierać cyfr.");
            introduces = "Przedstaw się jeszcze raz";
            startApp();
        }

    }

    private static void showMenu() {
        System.out.println("Wybierz co chcesz zrobić: \n" +
                "[1] Pobierz listę liczb z pliku\n" +
                "[2] Wygeneruj dane testowe i zapisz je do pliku\n" +
                "[3] Posortuj dane wybraną metodą\n" +
                "[4] Podaj czas sortowania\n" +
                "[9] Zamknij program\n" +
                "[0] Pokaż menu");
    }

    private static void showSortingMethodsMenu() {
        System.out.println("Wybierz metodę sortowania: \n" +
                "[1] BubbleSort\n" +
                "[2] SelectionSort\n" +
                "[3] InsertionSort\n" +
                "[4] MergeSort\n" +
                "[5] QuickSort\n" +
                "[6] ShellSort\n" +
                "[7] Wszystkie metody w jednym wątki\n" +
                "[8] Wszystkie metody w wielu wątkach\n" +
                "[0] Cofnij");
    }

    private static void operationsMenu() {
        do {
            userChoice = INPUT.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Dane z pliku:");
                    try {
                        String dataFromFile = DATA_MANAGER.getDataFromFile();
                        System.out.println(dataFromFile);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Podaj ile danych wygenerować: ");
                    int amount = INPUT.nextInt();
                    int min = 0;
                    int max = 0;
                    if (amount > 0) {
                        System.out.println("Podaj wartość minimalną: ");
                        min = INPUT.nextInt();
                        System.out.println("Podaj wartość maksymalną: ");
                        max = INPUT.nextInt();
                    }
                    try {
                        List<Integer> generateData = DATA_MANAGER.generateData(amount, min, max);
                        DATA_MANAGER.saveDataToFile(generateData);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Liczba danych musi być większa od 0. Wracam do menu...\n");
                        showMenu();
                    }
                    break;
                case 3:
                    showSortingMethodsMenu();
                    try {
                        sortingMenu();
                    } catch (IOException e) {
                        System.out.println(e.getMessage() + "Wracam do menu...\n");
                        showMenu();
                    }
                    break;
                case 4:
                    System.out.println("Czas sortowania dla poszczególnych metod wynosi:\n" +
                            "BubbleSort: " + SORT_METHOD_UTILS.getMethodSortTime(SORT_METHOD_UTILS.getBubbleSort()) + "\n" +
                            "SelectionSort: " + SORT_METHOD_UTILS.getMethodSortTime(SORT_METHOD_UTILS.getSelectionSort()) + "\n" +
                            "InsertionSort: " + SORT_METHOD_UTILS.getMethodSortTime(SORT_METHOD_UTILS.getInsertionSort()) + "\n" +
                            "MergeSort: " + SORT_METHOD_UTILS.getMethodSortTime(SORT_METHOD_UTILS.getMergeSort()) + "\n" +
                            "QuickSort: " + SORT_METHOD_UTILS.getMethodSortTime(SORT_METHOD_UTILS.getQuickSort()) + "\n" +
                            "ShellSort: " + SORT_METHOD_UTILS.getMethodSortTime(SORT_METHOD_UTILS.getShellSort())+ "\n");
                    System.out.println("Czas sortowania wszystkich metod wraz z wyświetleniem (w jednym wątku): " + SORT_METHOD_UTILS.getSortTimeOneThread() + "\n");
                    System.out.println("Czas sortowania w wielu wątkach dla poszczególnych metod wynosi:\n" +
                            "BubbleSort: " + SORT_METHOD_UTILS.getMethodSortTimeMultiThread(SORT_METHOD_UTILS.getBubbleSort()) + "\n" +
                            "SelectionSort: " + SORT_METHOD_UTILS.getMethodSortTimeMultiThread(SORT_METHOD_UTILS.getSelectionSort()) + "\n" +
                            "InsertionSort: " + SORT_METHOD_UTILS.getMethodSortTimeMultiThread(SORT_METHOD_UTILS.getInsertionSort()) + "\n" +
                            "MergeSort: " + SORT_METHOD_UTILS.getMethodSortTimeMultiThread(SORT_METHOD_UTILS.getMergeSort()) + "\n" +
                            "QuickSort: " + SORT_METHOD_UTILS.getMethodSortTimeMultiThread(SORT_METHOD_UTILS.getQuickSort()) + "\n" +
                            "ShellSort: " + SORT_METHOD_UTILS.getMethodSortTimeMultiThread(SORT_METHOD_UTILS.getShellSort()) + "\n");
                    System.out.println("Czas sortowania wszystkich metod wraz z wyświetleniem (w wielu wątkach): " + SORT_METHOD_UTILS.getSortTimeMultiThread() + "\n");
                    break;
                case 9:
                    System.out.println("Zamykam program");
                    break;
                default:
                    System.out.println("Wybierz jedną z opcji: ");
                    showMenu();
            }
        } while (userChoice != END_APP);
    }

    private static void sortingMenu() throws IOException {
        String dataFromFile = DATA_MANAGER.getDataFromFile();
        Integer[] arrayToSort = ArrayUtils.formatStringArrayToIntArray(dataFromFile);
        userChoice = INPUT.nextInt();
        switch (userChoice) {
            case 1:
                if (SORT_METHOD_UTILS.getBubbleSort() == null) {
                    SORT_METHOD_UTILS.setBubbleSort(new BubbleSort());
                }
                useSortMethod(SORT_METHOD_UTILS.getBubbleSort(), arrayToSort);
                break;
            case 2:
                if (SORT_METHOD_UTILS.getSelectionSort() == null) {
                    SORT_METHOD_UTILS.setSelectionSort(new SelectionSort());
                }
                useSortMethod(SORT_METHOD_UTILS.getSelectionSort(), arrayToSort);
                break;
            case 3:
                if (SORT_METHOD_UTILS.getInsertionSort() == null) {
                    SORT_METHOD_UTILS.setInsertionSort(new InsertionSort());
                }
                useSortMethod(SORT_METHOD_UTILS.getInsertionSort(), arrayToSort);
                break;
            case 4:
                if (SORT_METHOD_UTILS.getMergeSort() == null) {
                    SORT_METHOD_UTILS.setMergeSort(new MergeSort());
                }
                useSortMethod(SORT_METHOD_UTILS.getMergeSort(), arrayToSort);
                break;
            case 5:
                if (SORT_METHOD_UTILS.getQuickSort() == null) {
                    SORT_METHOD_UTILS.setQuickSort(new QuickSort());
                }
                useSortMethod(SORT_METHOD_UTILS.getQuickSort(), arrayToSort);
                break;
            case 6:
                if (SORT_METHOD_UTILS.getShellSort() == null) {
                    SORT_METHOD_UTILS.setShellSort(new ShellSort());
                }
                useSortMethod(SORT_METHOD_UTILS.getShellSort(), arrayToSort);
                break;
            case 7:
                useAllMethods(arrayToSort);
                break;
            case 8:
                long startMultiThread = System.currentTimeMillis();
                useAllMethodsInMultiThreads(arrayToSort);
                SORT_METHOD_UTILS.setSortTimeMultiThread(System.currentTimeMillis() - startMultiThread);
                break;
            default:
                System.out.println("Wracam do menu");
                showMenu();
        }
    }

    private static void useSortMethod(SortMethod sortMethod, Integer[] arrayToSort) {
        System.out.println(sortMethod.getName());
        SORT_METHOD_UTILS.oneMethodSort(sortMethod, arrayToSort);
        System.out.println("Czas: " + sortMethod.getSortTimeOneThread());
        System.out.println("=======================");
    }

    private static void useAllMethods(Integer[] arrayToSort) {
        System.out.println("Sortowanie dla wszystkich dostępnych metod w jednym wątku");
        SORT_METHOD_UTILS.allMethodSort(arrayToSort);
    }

    private static void useAllMethodsInMultiThreads(Integer[] arrayToSort) {
        System.out.println("Sortowanie dla wszystkich dostępnych metod w wielu wątkach");
        SORT_METHOD_UTILS.allMethodSortMultiThread(arrayToSort);
    }
}
