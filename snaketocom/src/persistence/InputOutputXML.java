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
//import com.sun.org.apache.xml.internal.serialize.OutputFormat;
//import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import org.w3c.dom.Document;
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
	
	private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
	
	private static org.w3c.dom.Document doc;

	
	
	 public static User doLogin(String name, String pass) throws ParserConfigurationException, SAXException, IOException, SnakeExceptions{
	       
		    User user = null;
	        int i = 0;
		 
            //initial elements
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
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
	 
	 
	 /**
	  * 
	  * @param user
	  * @return
	  * @throws SnakeExceptions
	  * @throws ParserConfigurationException
	  * @throws SAXException
	  * @throws IOException
	  */
	 public static List<Score> getUserScores(User user) throws SnakeExceptions, ParserConfigurationException, SAXException, IOException{
		 
		 List<Score> scores = new ArrayList<>();
		 String dateTime = null;
		 String score = null;
		 int i, j = 0;
		 
		//initial elements
         factory = DocumentBuilderFactory.newInstance();
         builder = factory.newDocumentBuilder();
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
	                            	 dateTime = contenido;
	                                break;
	                             case "points":
	                                 score = contenido;     
	                           }
	                       }
                     }
	            	 scores.add(new Score(dateTime, score));
                  }
           }  
	    }
		return scores; 
   }
	 
	 /**
	  * 
	  * @return
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	  */
	 public static List<String> getUserNames() throws ParserConfigurationException, SAXException, IOException{
		 
		 List<String> users = new ArrayList<>();
		 //initial elements
         factory = DocumentBuilderFactory.newInstance();
         builder = factory.newDocumentBuilder();
         doc = builder.parse(PASSWORD_FILE);
         
         //Main node and child Nodelist
         Node root = doc.getFirstChild();  //passwords
         NodeList child = root.getChildNodes(); //all score inside
         
         //Processing of every child into the NodeList
         for(int i = 0; i < child.getLength(); i++) {
             Node actualItem = child.item(i);
             if(actualItem.getNodeType() == Node.ELEMENT_NODE){
                 
                 Element e = (Element)actualItem;
                 users.add(e.getAttribute("name"));
             }
	    }
		return users; 
	 }
	 
	 public static void saveScores(User userLogged) {
		 try {
	            //initialization of DocumentBuilderFactory, Document and Node root
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document doc = builder.parse(SCORES_FILE);
	            Node root = doc.getFirstChild();
	            
	            List<Score> scores = userLogged.getProvisionalScores();
	          for(Score s: scores) {
	              //Creation of the node "score" where we 
	               Node score = doc.createElement("score");
	               Element n = (Element)score;
	               n.setAttribute("name", userLogged.getName());
	             
	            // Creation of the  two nodes that are descendants of "mensaje"
	            Node time = doc.createElement("time");
	            Node points = doc.createElement("points");
	            
	            // Creation of text nodes with the respective parameters
	            Node texTime = doc.createTextNode(s.getTimeString());
	            Node textPoints= doc.createTextNode(s.getPointsFormatted());
	        
	            // Addition of every text to his node
	            time.appendChild(texTime);
	            points.appendChild(textPoints);
	            
	            // Addition to mensaje his childs
	            n.appendChild(time);
	            n.appendChild(points);
	            
	            // Addition of message inside our tree (mensajes)
	            root.appendChild(n);
	            
	          }
	            
	            //Save of modified dom into xml file
	            OutputFormat format = new OutputFormat(doc);
	            format.setIndenting(true);
	            
	            // Serialization
	            XMLSerializer serializer = new XMLSerializer(new FileOutputStream(f), format);
	            
	            // Writing into file
	            serializer.serialize(doc);
	            
	            return true;
	       } catch (ParserConfigurationException | SAXException | IOException ex) {
	            System.out.println("Error al cargar el DOM: " + ex.getMessage());
	            return false;
	       }
		 
 	 }
	 
	 /*
	 public static void saveScore(Score score, User user) {
		
         factory = DocumentBuilderFactory.newInstance();
         try {
			builder = factory.newDocumentBuilder();
            doc = builder.parse(SCORES_FILE);
         
		    Node time = createNode("time", score.getTimeString());
		    Node points = createNode("points", score.getPointsFormatted());
		    Element sc = doc.createElement("score");
		    sc.setAttribute("name", user.getName());
		    sc.appendChild(time);
		    sc.appendChild(points);
		    doc.getFirstChild().appendChild(sc);
	        writeXMLFile(doc);
		 } catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException |IOException e) {
			e.printStackTrace();
		}
	 }
	 
	   
	    private static void writeXMLFile(Document doc) throws FileNotFoundException, IOException {
	        OutputFormat format = new OutputFormat(doc);
	        format.setIndenting(true);
	        XMLSerializer serializer = new XMLSerializer(new FileOutputStream(f), format);
	        serializer.serialize(doc);
	    }
	    
	    /**
	     * Create a element node 
	     * 
	     * @param element name of element node
	     * @param text content of text node of element
	     * @return 
	     */
	    public static Node createNode(String element, String text) {
	        Node node = doc.createElement(element);
	        Node textNode = doc.createTextNode(text);
	        node.appendChild(textNode);
	        return node;
	    }
	    
	 
	
}
	 
	 
	
	  
   

