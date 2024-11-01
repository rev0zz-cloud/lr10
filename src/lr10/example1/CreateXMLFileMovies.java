/*1)	Сделайте в текстовом редакторе свой файл в формате XML в зависимости от варианта (Приложение 1). Фильмы (Movies)*/
package lr10.example1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CreateXMLFileMovies {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Создание корневого элемента
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement); //appendChild(n) — добавляет новый дочерний узел n (узел n
                                            //становится последним дочерним узлом данного узла);

            //Добавление первого фильма
            Element movie1 = doc.createElement("movie");
            rootElement.appendChild(movie1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("12 стульев"));
            movie1.appendChild(title1);

            Element director1 = doc.createElement("director");
            director1.appendChild(doc.createTextNode("Леонид Гайдай"));
            movie1.appendChild(director1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1971"));
            movie1.appendChild(year1);

            //Добавление второго фильма
            Element movie2 = doc.createElement("movie");
            rootElement.appendChild(movie2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Служебный роман"));
            movie2.appendChild(title2);

            Element director2 = doc.createElement("director");
            director2.appendChild(doc.createTextNode("Эльдар Рязанов"));
            movie2.appendChild(director2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1977"));
            movie2.appendChild(year2);

            //Добавление 3 фильма
            Element movie3 = doc.createElement("movie");
            rootElement.appendChild(movie3);

            Element title3 = doc.createElement("title");
            title3.appendChild(doc.createTextNode("Бриллиантовая рука"));
            movie3.appendChild(title3);

            Element director3 = doc.createElement("director");
            director3.appendChild(doc.createTextNode("Леонид Гайдай"));
            movie3.appendChild(director3);

            Element year3 = doc.createElement("year");
            year3.appendChild(doc.createTextNode("1968"));
            movie3.appendChild(year3);

            //Добавление 4 фильма
            Element movie4 = doc.createElement("movie");
            rootElement.appendChild(movie4);

            Element title4 = doc.createElement("title");
            title4.appendChild(doc.createTextNode("Иван Васильевич меняет профессию"));
            movie4.appendChild(title4);

            Element director4 = doc.createElement("director");
            director4.appendChild(doc.createTextNode("Леонид Гайдай"));
            movie4.appendChild(director4);

            Element year4 = doc.createElement("year");
            year4.appendChild(doc.createTextNode("1973"));
            movie4.appendChild(year4);

            //Добавление 5 фильма
            Element movie5 = doc.createElement("movie");
            rootElement.appendChild(movie5);

            Element title5 = doc.createElement("title");
            title5.appendChild(doc.createTextNode("Джентльмены удачи"));
            movie5.appendChild(title5);

            Element director5 = doc.createElement("director");
            director5.appendChild(doc.createTextNode("Александр Серый"));
            movie5.appendChild(director5);

            Element year5 = doc.createElement("year");
            year5.appendChild(doc.createTextNode("1971"));
            movie5.appendChild(year5);

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

            System.out.println("XML-файл успешно создан");
        } catch (Exception pce) {
            pce.printStackTrace();
        }
    }
}
