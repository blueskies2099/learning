package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Dom4J {
    public static void main(String[] args) {
        URL path = Dom4J.class.getClassLoader().getResource("userConfig.xml");
        System.out.println(path.getPath());
        SAXReader reader = new SAXReader();
        reader.setEncoding("utf-8");
        Document document = null;
        try{
            document = reader.read(new File(path.getFile()));
            Element root = document.getRootElement();
            List<Element> list = root.elements("user");

            Element user1 = list.get(0);
            System.out.println(user1.element("userName").getStringValue());

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
