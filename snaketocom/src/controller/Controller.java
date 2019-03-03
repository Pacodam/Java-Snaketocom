package controller;


import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import exceptions.SnakeExceptions;
import model.Score;
import model.User;
import persistence.InputOutputXML;
import view.ConsoleView;
import view.LoginView;
import view.MenuView;
import view.MyView;
import view.Snake;
import view.TableData;
import utils.Events;


public class Controller {

	 private User userLogged;
	
	 private MyView view;
	 private ConsoleView console;
	 private LoginView login;
	 private MenuView menu;
	 private Snake snake;
	 
	 
	 //Controller inits the initial view (SplitView with JPanel left and Jpanel right)
	 public Controller() {
	   console = new ConsoleView();
	   login = new LoginView();
	   view = new MyView(console, login);
	   initController();
	   initConsole();

	 }
	 
	 /**
	  * Listener of popup menu in console view
	  */
	 public void initConsole() {
		
	    console.getItem1().addActionListener(e -> {
			try {
				switchToMenu();
			} catch (SnakeExceptions e1) {
				
				e1.printStackTrace();
			}
		});
	    console.getItem2().addActionListener(e -> switchToLogin());
	    console.getItem3().addActionListener(e -> exit());
	 }
	 
	 /**
	  * 
	  */
	 public void consoleMenuOptions() {
		 System.out.println("pressed");
	 }
	 
	 /**
	  * The listeners of the login view
	  */
	 public void initController() {
		login.getLoginButton().addActionListener(e -> login()); 
	}
	 
	 /**
	  * 
	  */
	 public void login() {
		 try {
			 String name = login.getsName().getText();
			 String pass = login.getPassword().getText();
			 userLogged = InputOutputXML.doLogin(name, pass);
			 System.out.println(userLogged.getName());
			 menu = new MenuView();
			 console.setTextEvent(Events.LOGIN + " " + userLogged.getName());
			 switchToMenu();
			 }catch(IOException | ParserConfigurationException | SAXException | SnakeExceptions e) {
				 JOptionPane.showMessageDialog(null, e, "Info", JOptionPane.INFORMATION_MESSAGE);
				 e.getMessage();
			 }
	 }
	 
	 /**
	  * Init menu and listeners
	 * @throws SnakeExceptions 
	  */
	 public void switchToMenu() throws SnakeExceptions {
		if(userLogged == null) {
			throw new SnakeExceptions(SnakeExceptions.MENU_NOT_ALLOWED);
		}
		 view.setMenu(menu);
		 
			try {
				List<Score> scores = InputOutputXML.getUserScores(userLogged);
				 for(Score s: scores){
		        	 System.out.println(s.toString());
		         } 
				TableData td = new TableData(scores);
				menu.setDataModel(td);
			} catch (SnakeExceptions | ParserConfigurationException | SAXException | IOException e) {
				JOptionPane.showMessageDialog(null, e, "Info", JOptionPane.INFORMATION_MESSAGE);
				
			}  
		 menu.getNewGame().addActionListener(e -> newGame());
		 menu.getScores().addActionListener(e -> switchToScores());
		 menu.getExit().addActionListener(e -> exit()); 
	 }
	 
	 /**
	  * 
	  */
	 public void switchToLogin() {
		 login = new LoginView();
		 view.setLogin(login);
		 userLogged = null;
	 }
	 
	 /**
	  * problematic
	  */
	 public void newGame() {
		 snake = new Snake();
		 console.setTextEvent(Events.NEW_GAME);
		 view.setGame(snake);
		 snake.getPlayAgain().addActionListener(e -> {
	     addNewScore(snake.getScore());
		 newGame();
		 });
		 snake.goMenu().addActionListener(e -> {
			try {
				switchToMenu();
			} catch (SnakeExceptions e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}); 
	 }
	 
	 public void addNewScore(String newScore) {
		 //userLogged.addNewScore(new Score());
	 }
	 
	 /**
	  * 
	  */
	 public void switchToScores() {
		
	 }
	 
	 /**
	  * 
	  */
	 public void exit() {
		 
	 }
}
