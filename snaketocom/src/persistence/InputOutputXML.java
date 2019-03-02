package persistence;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import exceptions.SnakeExceptions;
import model.Score;
import model.User;






public class InputOutputXML {
	
	private static final String SEPARATOR = File.separator;
	private static final File XML_FOLDER = new File("xmlfiles");
	private static final File PASSWORD_FILE = new File(XML_FOLDER + SEPARATOR + "passwords.xml");
	private static final File SCORES_FILE = new File(XML_FOLDER + SEPARATOR + "scores.xml");
	
	private static org.w3c.dom.Document doc;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");

	//m.setTime(LocalDateTime.parse(n.getAttributes().getNamedItem("fechahora").getNodeValue(), formatter));
	
	 public static User doLogin(String name, String pass) throws ParserConfigurationException, SAXException, IOException, SnakeExceptions{
	       
		    User user = null;
	        int i = 0;
		 
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
                    
                    Element e = (Element)actualItem;
                    if(e.getAttribute("name").equals(name) && e.getAttribute("psw").contentEquals(pass)) {
                      return new User(e.getAttribute("name"), e.getAttribute("psw"));
                    }
                 }
            }
            if(user == null) {
            	throw new SnakeExceptions(SnakeExceptions.WRONG_LOGIN);
            }
          return null;
	    } 
	 
	 
	 public static List<Score> getUserScores(User user) throws SnakeExceptions, ParserConfigurationException, SAXException, IOException{
		 
		 List<Score> scores = new ArrayList<>();
		 LocalDateTime dateTime = null;
		 String score = null;
		 int i, j = 0;
		 
		//initial elements
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         doc = builder.parse(SCORES_FILE);
         
         //Main node and child Nodelist
         Node root = doc.getFirstChild();  //scores
         NodeList child = root.getChildNodes(); //all scores nodes
         System.out.println(child.getLength());
         
         //Processing of every child into the NodeList
         for(i = 0; i < child.getLength(); i++) {
             Node actualItem = child.item(i);    //score 0 to score n
             if(actualItem.getNodeType() == Node.ELEMENT_NODE){
            	 
            	 Element e = (Element)actualItem;
                 if(e.getAttribute("name").equals(user.getName())) {
            	     NodeList content = actualItem.getChildNodes();  //time, points
             
	            	 for (j = 0; j < content.getLength(); j++){
	                     Node actual = content.item(j); 
	                     
	                       if (actual.getNodeType() == Node.ELEMENT_NODE) {
	                    	   String contenido = actual.getTextContent();
	                    	   switch (actual.getNodeName()) {
	                             case "time":
	                            	 dateTime = LocalDateTime.parse(contenido, formatter);
	                                break;
	                             case "score":
	                                 score = contenido;     
	                           }
	                       }
                     }
	            	 scores.add(new Score(dateTime, score));
                  }
           }  
	    }
         /*
         for(Score s: scores){
        	 System.out.println(s.toString());
         } */
		return scores; 
   }
}
	 
	 
	
	  
   

