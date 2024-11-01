package lr10.example1;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlParserMovies {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr10/example1/example2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("movie");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nТекущий элемент: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Название фильма: "
                            + element.getElementsByTagName("title").item(0)
                            .getTextContent());
                    System.out.println("Режиссер: "
                            + element.getElementsByTagName("director").item(0)
                            .getTextContent());
                    System.out.println("Год выхода: "
                            + element.getElementsByTagName("year").item(0)
                            .getTextContent());
                    System.out.println("Режиссер: "
                            + element.getElementsByTagName("director").item(0)
                            .getTextContent());

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
