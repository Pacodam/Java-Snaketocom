package persistence;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;






public class InputOutputXML {
	
	private static final String SEPARATOR = File.separator;
	private static final File XML_FOLDER = new File("xmlfiles");
	private static final File PASSWORD_FILE = new File(XML_FOLDER + SEPARATOR + "passwords.xml");
	private static final File SCORES_FILE = new File(XML_FOLDER + SEPARATOR + "scores.xml");
	
	private static org.w3c.dom.Document doc;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	
	
	 public static boolean loginCheck(String name, String pass) throws ParserConfigurationException, SAXException, IOException{
	       
		    String n = null;
		    String p = null;
	        int i, j = 0;
		 
            //initial elements
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(PASSWORD_FILE);
            
            //Main node and child Nodelist
            Node root = doc.getFirstChild();  //passwords
            NodeList child = root.getChildNodes(); //all score inside
            
            //Processing of every child into the NodeList
            for(i = 0; i < child.getLength(); i++) {
                Node actualItem = child.item(i);
                if(actualItem.getNodeType() == Node.ELEMENT_NODE){
                 
                    //transformation of String into localDateTime:
                    Element e = (Element)actualItem;
                    n = e.getAttribute("name");
                    p = e.getAttribute("psw");
                    System.out.println(n);
                    System.out.println(p);
                 }
            }
        return true;
	    } 
	   
}
