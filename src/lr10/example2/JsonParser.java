/*используем библиотеку JSON.simple для работы с файлом JSON. Мы создаем экземпляр класса JSONParser, который используется для чтения файла JSON. Затем мы преобразуем объект в JSONObject и получаем ключ корневого элемента. Мы получаем массив книг, проходим по каждой книге и получаем значения полей*/
package lr10.example2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonParser {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse (new FileReader("src/lr10/example2/example-json.json"));
            JSONObject jsonObjest = (JSONObject) obj;
            System.out.println("Корневой элемент: "
                    +jsonObjest.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray)  jsonObjest.get ("books");

            for (Object o : jsonArray){
                JSONObject book = (JSONObject) o;
                System.out.println("\nТекущий элемент: book");
                System.out.println("Название книги: "+ book.get("title"));
                System.out.println("Автор: "+ book.get("author"));
                System.out.println("Год издания: "+ book.get("year"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

