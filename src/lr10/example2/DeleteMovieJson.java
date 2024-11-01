/*4)	Добавьте функционал для удаления фильма из массива по названию.*/
package lr10.example2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

public class DeleteMovieJson {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/lr10/example2/example-json-movies.json"));
            JSONObject library = (JSONObject) obj;
            JSONArray movies = (JSONArray) library.get("movies");

            String title = "111";
            Iterator iterator = movies.iterator();
            while (iterator.hasNext()) {
                JSONObject book = (JSONObject) iterator.next();
                if (title.equals(book.get("title"))) {
                iterator.remove();
                }}

            library.put("movies", movies);

            try(FileWriter file = new FileWriter("src/lr10/example2/example-json-movies.json")){
                file.write(library.toJSONString());
                System.out.println("Фильм успешно удален из Json файла");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//3.	Для удаления книги из массива необходимо использовать метод Iterator.remove() для удаления объекта из массива JSONArray.
//Пример:
//
//JSONArray jsonArray = (JSONArray) jsonObject.get("books");
//String title = "Название книги";
//Iterator iterator = jsonArray.iterator();
//while (iterator.hasNext()) {
//    JSONObject book = (JSONObject) iterator.next();
//    if (title.equals(book.get("title"))) {
//    iterator.remove();
//    }} 
