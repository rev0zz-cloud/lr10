/*2)	Добавьте возможность записывать новые фильмы в XML-файл.
Например, пользователь может ввести данные о новом фильме, а программа добавит новый элемент <movie> в XML-файл.*/
package lr10.example1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;



public class AddXMLFileMovies {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Хотите добавить фильмы в список? (y/n)");
            String c = in.nextLine();

            if ("y".equals(c)) {
                File inputFile = new File("src/lr10/example1/example2.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                Element rootElement = doc.getDocumentElement();

                NodeList nodeList = doc.getElementsByTagName("movie");

                System.out.println("Введите название фильма: ");
                //Добавление нового фильма
                //String m = "movie";
                Element movie6 = doc.createElement("movie");
                rootElement.appendChild(movie6);

                Element title6 = doc.createElement("title");
                title6.appendChild(doc.createTextNode(in.nextLine()));
                movie6.appendChild(title6);

                System.out.println("Введите режиссера фильма: ");
                Element director6 = doc.createElement("director");
                director6.appendChild(doc.createTextNode(in.nextLine()));
                movie6.appendChild(director6);

                System.out.println("Введите год выхода фильма: ");
                Element year6 = doc.createElement("year");
                year6.appendChild(doc.createTextNode(in.nextLine()));
                movie6.appendChild(year6);

                //Запись XML- файла
                doc.setXmlStandalone(true);
                doc.normalizeDocument();
                javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
                javax.xml.transform.Transformer transformer = tf.newTransformer();
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
                javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
                javax.xml.transform.stream.StreamResult result =
                        new javax.xml.transform.stream.StreamResult(new File("src/lr10/example1/example2.xml"));
                transformer.transform(source, result);

                System.out.println("Новый фильм успешно записан в XML-файл");
            }
            } catch(Exception pce){
                pce.printStackTrace();
            }
        }
    }

//Берегись автомобиля
//<director>Эльдар Рязанов</director>
//<year>1966</year>
//</movie>
//<movie>
//<title>Невероятные приключения итальянцев в России</title>
//<director>Эльдар Рязанов</director>
//<year>1973</year>

//Подсказки:
//
//1.	Для записи данных в XML-файл можно воспользоваться классом javax.xml.transform.Transformer.
//Пример:
//
//Transformer transformer =
//		TransformerFactory.newInstance().newTransformer();
//DOMSource source = new DOMSource(doc);
//StreamResult result = new StreamResult(new File("src/lr10/example1/example.xml"));
//transformer.transform(source, result);

