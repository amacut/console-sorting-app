package v1;

import java.io.*;
import java.util.List;

public class DataManager {

    public List<Integer> generateData(Integer amount, Integer min, Integer max) {
        if (amount > 0) {
            List<Integer> integerList = Generator.generate(amount, min, max);
            return integerList;
        } else {
            throw new IllegalArgumentException("Liczba danych musi być większa od 0");
        }
    }

    public void saveDataToFile(List<Integer> data) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("dane.txt"));
            writer.println(data);
            writer.close();
            System.out.println("Dane zostały zapisane");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("dane.txt"));

        String data = "";
        while ((data = reader.readLine()) != null) {
            return data;
        }
        throw new IOException("Nie udało się odczytać danych.");
    }
}
