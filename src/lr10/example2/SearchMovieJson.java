/*2)	Добавьте функционал для поиска фильма по режиссеру*/
package lr10.example2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class SearchMovieJson {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/lr10/example2/example-json-movies.json"));
            JSONObject library = (JSONObject) obj;
            JSONArray movies = (JSONArray) library.get("movies");

            String director = "Леонид Гайдай";
            for (Object o : movies) {
                JSONObject movie = (JSONObject) o;

                if(movie.get("director").equals(director) ) {

                    System.out.println("\nТекущий элемент: movie");
                    System.out.println("Название фильма: " + movie.get("title"));
                    System.out.println("Режиссер: " + movie.get("director"));
                    System.out.println("Год выхода: " + movie.get("year"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//1.	Для поиска книг по автору восользуетесь JSONArray.stream()
// для создания потока элементов массива и метод filter() для фильтрации элементов по заданному автору.
//Пример:
//
//JSONArray jsonArray = (JSONArray) jsonObject.get("books");
//String author = "Иванов";
//jsonArray.stream()
//    .filter(book -> book instanceof JSONObject)
//    .map(book -> (JSONObject) book)
//    .filter(book -> author.equals(book.get("author")))
//    .forEach(book -> {
//    System.out.println("\nТекущий элемент: book");
//    System.out.println("Название книги: " + book.get("title"));
//    System.out.println("Автор: " + book.get("author"));
//    System.out.println("Год издания: " + book.get("year"));
//    });
