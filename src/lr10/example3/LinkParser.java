/*используем библиотеку jsoup для подключения к сайту и получения его HTML-кода.
Затем мы ищем все ссылки на странице, используя метод "select()",
который принимает CSS-селектор, и выводим абсолютный URL каждой ссылки в консоль с помощью метода "attr()".
Доработка парсера:
1)	Добавьте функционал записи полученных данных в файл для сохранения информации на будущее.
2)	Добавьте обработку ошибок при получении HTML-кода страницы, например вывод сообщения об ошибке и попытка переподключения к сайту.

*/
package lr10.example3;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;

public class LinkParser {
    public static void main(String[] args)throws IOException {
        String url = "https://itlearn.ru/first-steps";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select ("a[href]");

            //Создаем новую книгу Excel
            XSSFWorkbook workbook = new XSSFWorkbook();

            //Создаем новый лист в книге
            XSSFSheet sheet = workbook.createSheet("itlearn");
            int i = 1;

            for (Element link : links){
                System.out.println(link.attr("abs:href"));

                //Записываем данные в ячейки
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Содержимое сайта");



                Row dataRow1 = sheet.createRow(i);
                dataRow1.createCell(0).setCellValue(link.attr("abs:href"));
                i++;

            }
            //Записываем книгу Excel в файл
            String filePath = "src/lr10/example3/example3LinkParser.xlsx";
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("Данные записаны в файл: " + filePath);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
