package controller;


import javax.swing.JOptionPane;

import view.ConsoleView;
import view.LoginView;
import view.MenuView;
import view.MyView;

public class Controller {

	
	 private MyView view;
	 private ConsoleView console;
	 private LoginView login;
	 private MenuView menu;
	 
	 
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
		 String name = login.getsName().getText();
		 String pass = login.getPassword().getText();
		 //JOptionPane.showMessageDialog(null, name, "Info", JOptionPane.INFORMATION_MESSAGE);
		 menu = new MenuView();
		 switchToMenu();
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
		 
	 }
	 
	 public void scores() {
		 
	 }
	 
	 public void exit() {
		 
	 }
}
