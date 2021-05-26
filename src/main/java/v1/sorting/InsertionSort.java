package v1.sorting;

public class InsertionSort extends SortMethod {


    public InsertionSort() {
        super("Insertion Sort Method");
    }

    @Override
    public Integer[] sort(Integer[] arrayToSort) {
        int in;
        int out;

        for (out = 1; out < arrayToSort.length; out++) {        // out to pierwszy nieposortowane element
            int temp = arrayToSort[out];                        // kopiujemy wyróżniony (nieposortowany) element
            in = out;                                           // zaczynamy od out
            while (in > 0 && arrayToSort[in-1] >= temp) {       // dopóki elementy nie napotkają początku tablicy i są większe niż temp (czyli wyróżniony element)
                arrayToSort[in] = arrayToSort[in-1];            // przesuwamy elementy w prawo
                --in;                                           // przesuwamy się w lewo
            }
            arrayToSort[in] = temp;                             // wstawiamy wyróżniony (nieposortowany) element na odpowiednie miejsce
        }
        return arrayToSort;
    }
}
