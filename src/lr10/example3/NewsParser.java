/*Данная программа предназначена для парсинга (извлечения данных) с HTML-страницы, в данном случае - новостей с сайта fat.urfu.ru.
Сначала программа использует метод connect() из библиотеки Jsoup для получения HTML-кода страницы.
Затем, с помощью метода select(), программа извлекает список новостей из HTML-кода.
Для каждой новости в списке программа выводит в консоль ее тему и дату.
Для этого она применяет методы getElementsByClass() и childNodes() из библиотеки Jsoup.
Доработка парсера:
1)	Добавьте функционал записи полученных данных в файл для сохранения информации на будущее.
2)	Добавьте обработку ошибок при получении HTML-кода страницы, например вывод сообщения об ошибке и попытка переподключения к сайту.

*/
package lr10.example3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Node;

public class NewsParser {
    public static void main(String[] args) throws IOException {

        try {
            //Получаем HTML-код страницы
            Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();

            //Извлекаем список новостей
            Elements newsParent = doc
                    .select("body > table > tbody > tr > td > div > table > " +
                            "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                            "tr > td:nth-child(1)");

            //Создаем новую книгу Excel
            XSSFWorkbook workbook = new XSSFWorkbook();

            //Создаем новый лист в книге
            XSSFSheet sheet = workbook.createSheet("news");
            int k = 1;

            //Выводим последние 10 новостей в консоль
            for (int i = 3; i < 20; i++) {
                if (!(i % 2 == 0)) {
                    List<Node> nodes = newsParent.get(0).childNodes();
                    System.out.println("Тема : " +
                            ((Element) nodes.get(i))
                                    .getElementsByClass("blocktitle")
                                    .get(0).childNodes().get(0));


                    System.out.println("Дата : " +
                            ((Element) nodes.get(i))
                                    .getElementsByClass("blockdate")
                                    .get(0).childNodes().get(0) +
                            "\n");

                    //Записываем данные в ячейки
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("Дата");
                    headerRow.createCell(1).setCellValue("Тема");

                    Row dataRow1 = sheet.createRow(k);
                    dataRow1.createCell(0).setCellValue("Дата : " +
                            ((Element) nodes.get(i))
                                    .getElementsByClass("blockdate")
                                    .get(0).childNodes().get(0));
                    dataRow1.createCell(1).setCellValue("Тема : " +
                            ((Element) nodes.get(i))
                                    .getElementsByClass("blocktitle")
                                    .get(0).childNodes().get(0));

                    k++;
                }
            }
            //Записываем книгу Excel в файл
            String filePath = "src/lr10/example3/example3NewsParser.xlsx";
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (HttpStatusException e) {
            System.out.println("Invalid website");

            Connection session = Jsoup.newSession()
                    .timeout(20 * 1000)
                    .userAgent("FooBar 2000");

            Document doc2 = session.newRequest()
                    .url("http://fat.urfu.ru/index.html")
                    .get();
            System.out.println(doc2);
        }
    }
}

