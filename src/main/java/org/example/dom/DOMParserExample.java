package org.example.dom;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class DOMParserExample {
    public static void main(String[] args) {
        try {
            // Create parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML file
            Document doc = builder.parse(new File("/Users/duy/TeachingAssisT/Java_Advanced(2)/Thread/untitled1/students.xml"));
            doc.getDocumentElement().normalize(); // Removes empty text nodes

            // Get root and all employee.xml elements
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            NodeList employeeList = doc.getElementsByTagName("employee");
            System.out.println(employeeList.getLength());

            // Iterate through employees
            for (int i = 0; i < employeeList.getLength(); i++) {
                Node node = employeeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Access attributes and child elements
                    String id = element.getAttribute("id");
                    String name = element.getElementsByTagName("name")
                            .item(0).getTextContent();
                    String age = element.getElementsByTagName("age")
                            .item(0).getTextContent();

                    System.out.println("Employee ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("---");
                }
            }

            // Modifying the DOM (example: adding a new element)
//            Element newEmployee = doc.createElement("employee.xml");
//            newEmployee.setAttribute("id", "3");
//
//            Element newName = doc.createElement("name");
//            newName.appendChild(doc.createTextNode("Alice Smith"));
//            newEmployee.appendChild(newName);
//
//            doc.getDocumentElement().appendChild(newEmployee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}