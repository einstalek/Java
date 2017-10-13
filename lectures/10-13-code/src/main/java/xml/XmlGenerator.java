package xml;

import java.lang.reflect.Field;

public class XmlGenerator {

    public String toXml(Object o) throws IllegalAccessException {
        Class<?> clazz = o.getClass();
        String xml = "<" + clazz.getSimpleName() + ">\n";
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            field.setAccessible(true);
            xml += "\t<" + field.getName() + "> " + field.get(o) + " </" + field.getName() + ">\n";
        }
        xml +=  "</" + clazz.getSimpleName() + ">";
        return xml;
    }
}
