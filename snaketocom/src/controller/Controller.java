package controller;


import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import persistence.InputOutputXML;
import view.ConsoleView;
import view.LoginView;
import view.MenuView;
import view.MyView;
import view.mainSnake;

public class Controller {

	
	 private MyView view;
	 private ConsoleView console;
	 private LoginView login;
	 private MenuView menu;
	 private mainSnake snake;
	 
	 
	 //Controller inits the initial view (SplitView with JPanel left and Jpanel right)
	 public Controller() {
	   console = new ConsoleView();
	   login = new LoginView();
	   view = new MyView(console, login);
	   initController();

	 }
	 
	 /**
	  * The listeners of the login view
	  */
	 public void initController() {
		login.getLoginButton().addActionListener(e -> checkLogin()); 
	}
	 
	 public void checkLogin() {
		 try {
		 String name = login.getsName().getText();
		 String pass = login.getPassword().getText();
		 boolean b = InputOutputXML.loginCheck(name, pass);
		 
		 menu = new MenuView();
		 switchToMenu();
		 }catch(IOException | ParserConfigurationException | SAXException e) {
			 JOptionPane.showMessageDialog(null, "name", "Info", JOptionPane.INFORMATION_MESSAGE);
			 e.getMessage();
		 }
	 }
	 
	 /**
	  * Init menu and listeners
	  */
	 public void switchToMenu() {
		 view.setMenu(menu);
		 menu.getNewGame().addActionListener(e -> newGame());
		 menu.getScores().addActionListener(e -> scores());
		 menu.getExit().addActionListener(e -> exit()); 
	 }
	 
	 public void newGame() {
		 snake = new mainSnake();
		 view.setGame(snake);
	 }
	 
	 public void scores() {
		 
	 }
	 
	 public void exit() {
		 
	 }
}
