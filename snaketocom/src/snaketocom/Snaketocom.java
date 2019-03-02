package snaketocom;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controller.Controller;
import exceptions.SnakeExceptions;
import model.User;
import persistence.InputOutputXML;


public class Snaketocom {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		controller.initController();
		
		try {
			InputOutputXML.getUserScores(new User("Usuario", "usuario"));
		} catch (SnakeExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
