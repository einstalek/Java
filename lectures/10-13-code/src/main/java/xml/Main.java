package xml;

import super_junit.TestRunner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Alex", 12);
        String xml = new XmlGenerator().toXml(person);
        System.out.println(xml);
    }
}
