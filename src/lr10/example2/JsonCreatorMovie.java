/*1)	Сделайте в текстовом редакторе свой файл в формате JSON
в зависимости от варианта (Приложение 1). Фильмы (Movies)*/
package lr10.example2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class JsonCreatorMovie {
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray movies = new JSONArray();

        JSONObject movie1 = new JSONObject();
        movie1.put("title", "12 стульев");
        movie1.put("director", "Леонид Гайдай");
        movie1.put("year", 1971);

        JSONObject movie2 = new JSONObject();
        movie2.put("title", "Служебный роман");
        movie2.put("director", "Эльдар Рязанов");
        movie2.put("year", 1977);

        JSONObject movie3 = new JSONObject();
        movie3.put("title", "Бриллиантовая рука");
        movie3.put("director", "Леонид Гайдай");
        movie3.put("year", 1968);

        JSONObject movie4 = new JSONObject();
        movie4.put("title", "Иван Васильевич меняет профессию");
        movie4.put("director", "Леонид Гайдай");
        movie4.put("year", 1973);

        JSONObject movie5 = new JSONObject();
        movie5.put("title", "Джентльмены удачи");
        movie5.put("director", "Александр Серый");
        movie5.put("year", 1971);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        library.put("movies", movies);

        try (FileWriter file = new FileWriter("src/lr10/example2/example-json-movies.json")){
            file.write(library.toJSONString());
            System.out.println("Json файл успешно создан");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
