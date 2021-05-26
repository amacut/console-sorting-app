package v1;

import java.util.*;

public class Generator {

    public static List<Integer> generate(Integer amount, Integer min, Integer max) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Random random = new Random();
            int number = random.nextInt(max + 1 - min) + min;
            integerList.add(number);
        }
        return integerList;
    }

}
