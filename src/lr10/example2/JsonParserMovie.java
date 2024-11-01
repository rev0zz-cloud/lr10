/*1)	Сделайте парсер JSON
в зависимости от варианта (Приложение 1). Фильмы (Movies)*/
package lr10.example2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
public class JsonParserMovie {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse (new FileReader("src/lr10/example2/example-json-movies.json"));
            JSONObject jsonObjest = (JSONObject) obj;
            System.out.println("Корневой элемент: "
                    +jsonObjest.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray)  jsonObjest.get ("movies");

            for (Object o : jsonArray){
                JSONObject movie = (JSONObject) o;
                System.out.println("\nТекущий элемент: movie");
                System.out.println("Название фильма: "+ movie.get("title"));
                System.out.println("Режиссер: "+ movie.get("director"));
                System.out.println("Год выхода: "+ movie.get("year"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
