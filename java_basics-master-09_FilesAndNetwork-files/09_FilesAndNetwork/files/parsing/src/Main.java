import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        try {
            String filePath = "data/movementList.csv";
            List<ArrayList<String>> companyData = ParseProductCsv(filePath);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static List<ArrayList<String>> ParseProductCsv(String filePath) throws IOException {

        try {
            List<ArrayList<String>> companyData = new ArrayList<>();
            List<String> fileLines = Files.readAllLines(Paths.get(filePath));
            for (String fileLine : fileLines) {
                String[] splitText = fileLine.split(",");
                ArrayList<String> columnList = new ArrayList<>();
                for (int i = 0; i < splitText.length; i++) {
                    //Если колонка начинается на кавычки или заканчиваеться на кавычки
                    if (IsColumnPart(splitText[i])) {
                        String lastText = columnList.get(columnList.size() - 1);
                        columnList.set(columnList.size() - 1, lastText + "," + splitText[i]);
                    } else {
                        columnList.add(splitText[i]);
                    }
                }
                System.out.println("Магазин: " + columnList.get(5) + " Сумма: " + columnList.get(7));
                System.out.println("================================================================================================================================================");
                System.out.println("Сумма расходов: " + columnList.get(7) + "руб.");
                System.out.println("Сумма доходов: " + columnList.get(6) + "руб.");

            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        return null;
    }

    //Проверка след. колонки, а именно является ли колонка частью предыдущей колонки
    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна ковычка и текст на нее заканчиваеться значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }

}
