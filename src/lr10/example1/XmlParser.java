/*Эта программа на Java использует библиотеку javax.xml.parsers для чтения и анализа XML-файла. Программа имеет класс XmlParser, в котором есть единственный метод main, который является точкой входа в программу.
Когда программа запускается, она открывает XML-файл src/lr10/example.xml, используя класс java.io.File, который представляет файл на диске. Затем программа создает экземпляр класса javax.xml.parsers.DocumentBuilderFactory, который используется для создания javax.xml.parsers.DocumentBuilder, который, в свою очередь, используется для создания org.w3c.dom.Document.
Далее, программа вызывает метод parse у экземпляра DocumentBuilder, передавая в качестве аргумента File, который был создан ранее. Этот метод читает XML-файл и возвращает объект Document, который представляет собой древовидное представление содержимого XML-файла.
Затем программа вызывает метод getDocumentElement у объекта Document, чтобы получить корневой элемент XML-документа. С помощью метода getNodeName программа выводит имя корневого элемента на консоль.
Затем программа получает все элементы book из XML-документа, используя метод getElementsByTagName у объекта Document. Затем программа проходит циклом по этим элементам и выводит на консоль название книги, имя автора и год издания, используя методы getElementsByTagName и getTextContent у объектов Element.

*/
package lr10.example1;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlParser {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr10/example1/example1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nТекущий элемент: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Название книги: "
                            + element.getElementsByTagName("title").item(0)
                            .getTextContent());
                    System.out.println("Автор: "
                            + element.getElementsByTagName("author").item(0)
                            .getTextContent());
                    System.out.println("Год издания: "
                            + element.getElementsByTagName("year").item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
