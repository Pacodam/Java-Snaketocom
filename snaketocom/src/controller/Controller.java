package controller;


import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import exceptions.SnakeExceptions;
import model.User;
import persistence.InputOutputXML;
import view.ConsoleView;
import view.LoginView;
import view.MenuView;
import view.MyView;
import view.Snake;
import view.mainSnake;

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
	   console.getPop1().addActionListener(e -> {
		try {
			switchToMenu();
		} catch (SnakeExceptions e1) {
			JOptionPane.showMessageDialog(null, e1, "Info", JOptionPane.INFORMATION_MESSAGE);
			e1.getMessage();	
		}
	  });
	  console.getPop2().addActionListener(e -> switchToLogin());
	  console.getPop3().addActionListener(e -> exit());
		 
	 }
	 
	 public void consoleMenuOptions() {
		 System.out.println("pressed");
	 }
	 
	 /**
	  * The listeners of the login view
	  */
	 public void initController() {
		login.getLoginButton().addActionListener(e -> login()); 
	}
	 
	 public void login() {
		 try {
			 String name = login.getsName().getText();
			 String pass = login.getPassword().getText();
			 userLogged = InputOutputXML.doLogin(name, pass);
			 menu = new MenuView();
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
		 menu.getNewGame().addActionListener(e -> newGame());
		 menu.getScores().addActionListener(e -> scores());
		 menu.getExit().addActionListener(e -> exit()); 
	 }
	 
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
		 view.setGame(snake);
	 }
	 
	 public void scores() {
		 
	 }
	 
	 public void exit() {
		 
	 }
}
