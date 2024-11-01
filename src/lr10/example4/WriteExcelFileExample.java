/*Эта программа создает новый Excel-файл в формате XLSX и записывает в него данные.
В начале программы мы импортируем необходимые классы из библиотеки Apache POI, которые позволяют работать с Excel-файлами. Затем мы определяем основной метод программы main, который выбрасывает исключение IOException, связанное с записью файла. Далее мы создаем новую книгу Excel, используя класс XSSFWorkbook. Затем мы создаем новый лист в книге с названием "Товары", используя метод createSheet. После этого мы заполняем ячейки листа данными. Сначала мы создаем заголовок таблицы, используя метод createRow. Затем мы создаем строки данных и заполняем их значениями, используя метод createRow. В этом примере мы создали две строки данных, содержащие информацию о книге и компьютере соответственно. Каждая строка содержит три ячейки: название товара, характеристики и стоимость.
После заполнения данных мы записываем книгу Excel в файл, используя объект FileOutputStream. Здесь мы записываем содержимое книги в файл с помощью метода write, а затем закрываем книгу и поток вывода.
Наконец, программа выводит на экран сообщение о том, что данные успешно записаны в файл.
*/
package lr10.example4;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFileExample {
    public static void main(String[] args) throws IOException {
        //Создаем новую книгу Excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Создаем новый лист в книге
        XSSFSheet sheet = workbook.createSheet("Товары");

        //Записываем данные в ячейки
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Товар");
        headerRow.createCell(1).setCellValue("Характеристики");
        headerRow.createCell(2).setCellValue("Стоимость");

        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("Книга");
        dataRow1.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И. И.");
        dataRow1.createCell(2).setCellValue(500.0);

        Row dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("Компьютер");
        dataRow2.createCell(1).setCellValue("Процессор: Intel Core i5, Оперативная память");
        dataRow2.createCell(2).setCellValue(25000.0);

        //Записываем книгу Excel в файл
        String filePath = "src/lr10/example4/example4.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }
}
