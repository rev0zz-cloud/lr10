/*3)	Добавьте возможность поиска фильмов по режиссеру или году создания.
Например, пользователь может ввести режиссера или год создания,
а программа выведет список фильмов, удовлетворяющих этому критерию поиска*/
package lr10.example1;
import java.io.File;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class SearchMovie {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr10/example1/example2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("movie");

            Scanner in = new Scanner(System.in);
            System.out.println("Введите режиссера или год: ");
            String c = in.nextLine();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if(c.equals(element.getElementsByTagName("director").item(0)
                            .getTextContent())||
                            c.equals(element.getElementsByTagName("year").item(0)
                                    .getTextContent())
                    ) {
                        System.out.println("Название фильма: "
                                + element.getElementsByTagName("title").item(0)
                                .getTextContent());
                        System.out.println("Режиссер: "
                                + element.getElementsByTagName("director").item(0)
                                .getTextContent());
                        System.out.println("Год выхода: "
                                + element.getElementsByTagName("year").item(0)
                                .getTextContent());
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

//Подсказки
//2.	Для поиска книг по автору или году издания можно воспользоваться Java Stream API и методом filter().
//Пример:
//
//List<Element> books = nodeList.stream()
//        .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
//        .map(node -> (Element) node)
//        .filter(element -> {
//            String author = element.getElementsByTagName("author").item(0).getTextContent();
//            String year = element.getElementsByTagName("year").item(0).getTextContent();
//            return author.equalsIgnoreCase("Лев Толстой") && year.equals("1869");
//        })
//        .collect(Collectors.toList());
