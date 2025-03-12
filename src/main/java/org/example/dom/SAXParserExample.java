package org.example.dom;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
// Simple API XML
public class SAXParserExample extends DefaultHandler {
    private String currentElement;
    private StringBuilder content;
    private String currentId;

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXParserExample handler = new SAXParserExample();
            parser.parse("/Users/duy/TeachingAssisT/Laptrinhjava(2)_git/Thread/untitled1/employee.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        content = new StringBuilder();

        if (qName.equals("employee.xml")) {
            System.out.println("Employee ID: " + currentId);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (content != null) {
            content.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("Name")) {
            System.out.println("Name: " + content.toString().trim());
        } else if (qName.equals("age")) {
            System.out.println("Age: " + content.toString().trim());
        } else if (qName.equals("employee.xml")) {
            System.out.println("---");
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Starting XML parsing...");
    }

    @Override
    public void endDocument() {
        System.out.println("Finished parsing XML.");
    }
}