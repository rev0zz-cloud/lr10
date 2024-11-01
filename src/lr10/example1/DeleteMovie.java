/*4)	Реализуйте функцию удаления фильма из XML-файла.
Например, пользователь может ввести название фильма,
который хочет удалить, и программа удалит соответствующий элемент < movie > из XML-файла.*/
package lr10.example1;

import java.io.File;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class DeleteMovie {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr10/example1/example2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("movie");

            Scanner in = new Scanner(System.in);
            System.out.println("Введите название фильма для удаления: ");
            String c = in.nextLine();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if(c.equals(element.getElementsByTagName("title").item(0)
                            .getTextContent())) {

                        Node parentNode = element.getParentNode();
                        parentNode.removeChild(element);

//                        node.getParentNode().removeChild(element.getElementsByTagName("title").item(0));
//
//                        nodeList.item(i).removeChild(doc.getElementsByTagName("movie").item(0));
//
//                        node.removeChild(element.getElementsByTagName("title").item(0));
//                        node.removeChild(element.getElementsByTagName("director").item(0));
//                        node.removeChild(element.getElementsByTagName("year").item(0));

                    }
                }
            }
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

            System.out.println("XML-файл успешно перезаписан");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

//Подсказки
//3.	Для удаления элементов из XML-файла можно воспользоваться методами, предоставляемыми интерфейсом org.w3c.dom.Node.
// Например, для удаления элемента можно использовать следующий код:
//
//Element bookElement = ...; 	// получаем элемент книги,
//					// которую нужно удалить
//Node parentNode = bookElement.getParentNode();
//parentNode.removeChild(bookElement);
