package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Score;
import model.User;

public class JDomMethods {
	
	private static final String SEPARATOR = File.separator;
	private static final File XML_FOLDER = new File("xmlfiles");
	private static final File PASSWORD_FILE = new File(XML_FOLDER + SEPARATOR + "passwords.xml");
	private static final File SCORES_FILE = new File(XML_FOLDER + SEPARATOR + "scores.xml");

	
	public static void saveScores(User userLogged) {
		
		
		try{

	          Document document = null;
	          Element root = null;

	        if(SCORES_FILE.exists()){

	              FileInputStream fis = new FileInputStream(SCORES_FILE);
	              SAXBuilder sb = new SAXBuilder();
	              document = sb.build(fis);
	              root = document.getRootElement();
	              fis.close();
	              
	          }else{
	              document = new Document();
	              root = new Element("scores");
	          }
	        
	          List<Score> scores = userLogged.getProvisionalScores();
              for(Score s: scores) {
	            Element score = new Element("score");
	            score.setAttribute(new Attribute("name", userLogged.getName()));
	            score.addContent(new Element("time").setText(s.actualTimeString()));
	            score.addContent(new Element("points").setText(s.getPointsFormatted()));

	            root.addContent(score);
	            document.setContent(root);
	          
              }

	          FileWriter writer = new FileWriter(SCORES_FILE);
	            XMLOutputter outputter = new XMLOutputter();
	            outputter.setFormat(Format.getPrettyFormat());
	            outputter.output(document, writer);
	            outputter.output(document, System.out);
	            writer.close(); // close writer

	          } catch (IOException io) {
	            System.out.println(io.getMessage());
	          } catch (JDOMException e) {
	            e.printStackTrace();
	        }
	}
}
