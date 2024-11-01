/*3)	Добавьте функционал для добавления нового фильма в массив*/
package lr10.example2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AddJsonMovie {
    public static void main(String[] args) {

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/lr10/example2/example-json-movies.json"));
            JSONObject library = (JSONObject) obj;
            JSONArray movies = (JSONArray) library.get("movies");

            Scanner in = new Scanner(System.in);
            System.out.println("Хотите добавить фильмы в список? (y/n)");
            String c = in.nextLine();

            if ("y".equals(c)) {
                JSONObject newMovie = new JSONObject();

                System.out.println("Введите название фильма: ");
                newMovie.put("title", in.nextLine());
                System.out.println("Введите режиссера фильма: ");
                newMovie.put("director", in.nextLine());
                System.out.println("Введите год выхода фильма: ");
                newMovie.put("year", in.nextLine());

                movies.add(newMovie);

                library.put("movies", movies);

                try(FileWriter file = new FileWriter("src/lr10/example2/example-json-movies.json")){
                file.write(library.toJSONString());
                System.out.println("Фильм успешно добавлен в Json файл");
            }}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




//Подсказки
//        2.	Для добавления новой книги в массив необходимо использовать метод JSONArray.add() для добавления нового объекта JSONObject в массив JSONArray.
//        Пример:
//
//        JSONArray jsonArray = (JSONArray) jsonObject.get("books");
//        JSONObject newBook = new JSONObject();
//        newBook.put("title", "Новая книга");
//        newBook.put("author", "Новый автор");
//        newBook.put("year", 2023);
//        jsonArray.add(newBook);




//Берегись автомобиля
//<director>Эльдар Рязанов</director>
//<year>1966</year>
//</movie>
//<movie>
//<title>Невероятные приключения итальянцев в России</title>
//<director>Эльдар Рязанов</director>
//<year>1973</year>