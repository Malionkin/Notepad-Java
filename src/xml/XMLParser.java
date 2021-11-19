
package xml;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class XMLParser {
    private String filename="src/pattern.xml";
    public XMLParser(){}
    public XMLParser(String file){filename = file;}
    public  ArrayList<Pattern_> Read() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(filename);
        ArrayList<Pattern_> res = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        int len = doc.getDocumentElement().getElementsByTagName("color").getLength();

        for (int i = 0; i < len; i++){
            int len1 = doc.getElementsByTagName("color").item(i).getChildNodes().getLength();
            for (int j = 0; j< len1; j++) {
                var a = doc.getElementsByTagName("color").item(i).getChildNodes().item(j).getTextContent();
                var b = doc.getElementsByTagName("color").item(i).getAttributes().item(0).getTextContent();
                res.add(new Pattern_(a, Color.decode(b)));
            }
        }
        return res;

    }



}