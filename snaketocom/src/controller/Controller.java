package controller;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import exceptions.SnakeExceptions;
import model.Score;
import model.User;
import model.UserScore;
import persistence.InputOutputXML;
import view.ConsoleView;
import view.LoginView;
import view.MenuView;
import view.MyView;
import view.ScoresView;
import view.Snake;
import view.TableData;
import utils.Events;


public class Controller {

	 private User userLogged;
	
	 private MyView view;
	 private ConsoleView console;
	 private LoginView login;
	 private ScoresView scores;
	 private MenuView menu;
	 private Snake snake;
	 
	 private static final Controller instance = new Controller();
	 public static Controller getInstance() { return instance; }
	 
	 
	 //Controller inits the initial view (SplitView with JPanel left and Jpanel right)
	 public Controller() {
	   console = new ConsoleView();
	   login = new LoginView();
	   view = new MyView(console, login);
	   initController();
	   initConsole();

	 }
	 
	 //console view logic
	 
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
	    console.getItem2().addActionListener(e -> {
	    	saveScores();
	    	switchToLogin();
	    });
	    console.getItem3().addActionListener(e -> exit());
	 }
	 
	 //Login View logic
	 
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
			 menu = new MenuView();
			 console.setTextEvent(Events.LOGIN + " " + userLogged.getName());
			 switchToMenu();
			 }catch(IOException | ParserConfigurationException | SAXException | SnakeExceptions e) {
				 JOptionPane.showMessageDialog(null, e, "Info", JOptionPane.INFORMATION_MESSAGE);
				 e.getMessage();
			 }
	 }
	 
	 /**
	  * 
	  */
	 public void switchToLogin() {
		 login = new LoginView();
		 view.setLogin(login);
		 console.setTextEvent(Events.LOGOUT);
		 userLogged = null;
		 console.initEvents();
	
	 }
	 
	 
	 
	 //Menu View logic
	 
	 /**
	  * 
	  */
	 public void consoleMenuOptions() {
		 //System.out.println("pressed");
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
		 console.setTextEvent(Events.MENU);
		 console.setTextEvent(Events.XML);
		 
			try {
				List<Score> scores = InputOutputXML.getUserScores(userLogged);
				 //for(Score s: scores){
		         //	 System.out.println(s.toString());
		         //} 
				TableData td = new TableData(scores);
				menu.setDataModel(td);
			} catch (SnakeExceptions | ParserConfigurationException | SAXException | IOException e) {
				JOptionPane.showMessageDialog(null, e, "Info", JOptionPane.INFORMATION_MESSAGE);
				
			}  
		 menu.getNewGame().addActionListener(e -> newGame());
		 menu.getScores().addActionListener(e -> {
			try {
				switchToScores();
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		 menu.getExit().addActionListener(e -> {
			saveScores(); 
			exit();
		 }); 
	 }
	 
	
	 //Snake view logic
	 
	 /**
	  * 
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
				addNewScore(snake.getScore());
				System.out.println(snake.getScore());
				switchToMenu();
			} catch (SnakeExceptions e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}); 
	 }
	 
	 public void addNewScore(int score) {
		 Score newScore = new Score(score);
		 userLogged.addNewProvisionalScore(newScore);
	 }
	 
	 
	 //scores view logic
	 
	 /**
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	  * 
	  */
	 public void switchToScores() throws ParserConfigurationException, SAXException, IOException {
		scores = new ScoresView();
		view.setScores(scores);
		console.setTextEvent(Events.SCORES);
		//tab1 
		scores.getBackMenu().addActionListener(e -> {
			try {
				switchToMenu();
			} catch (SnakeExceptions e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		List<String> userNames = InputOutputXML.getUserNames();
		scores.setUsersList(userNames);
		
		//tab2
		scores.setBestScoreResume(getBestPlayer());
		
	 }
	 
	 public String getBestPlayer() {
	     List<UserScore> userScores = new ArrayList<>();
		 try {
			List<String> userNames = InputOutputXML.getUserNames();
			for(String s: userNames) {
				List<Score> scores = InputOutputXML.getUserScores(new User(s, "x"));
				for(Score ss: scores) {
					userScores.add(new UserScore(s, ss));
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException | SnakeExceptions e) {
			e.printStackTrace();
		}
		 	
		Collections.sort(userScores);
		UserScore ms = userScores.get(0);
		 
		 String s = "Name: " + ms.getName() + "\n" +
		          "Score: " + ms.getScore().getPointsFormatted() + "\n"+
				  "Date : " +  ms.getScore().actualTimeString();
		         
		return s;
	}
		
	 
	     //tab 1, "users list" logic
	     public static String userResume(String name){
	    	 try {
	    		 User userSearched = new User(); 
	    		 userSearched.setName(name);
	    		 List<Score> scores = InputOutputXML.getUserScores(userSearched);
	    		 if(scores.isEmpty()) {
	    			 throw new SnakeExceptions(SnakeExceptions.USER_NO_EXISTS);
	    		 }
	    		 userSearched.setScoresHistory(scores);	 
	    		 return userSearched.getResumeForScore1();
	    	}catch(SAXException | IOException | ParserConfigurationException | SnakeExceptions e) {
	    		JOptionPane.showMessageDialog(null, e, "Info", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	return null;
	     }
	     
	     public String[] getScoresList(int value) {
	    	 List<UserScore> userScores = new ArrayList<>();
			 try {
				List<String> userNames = InputOutputXML.getUserNames();
				for(String s: userNames) {
					List<Score> scores = InputOutputXML.getUserScores(new User(s, "x"));
					for(Score ss: scores) {
						if(ss.getPoints() >= value) {
						userScores.add(new UserScore(s, ss));
						}
					}
				}
			} catch (ParserConfigurationException | SAXException | IOException | SnakeExceptions e) {
				e.printStackTrace();
			}
			String[] result = new String[userScores.size()];
			 Collections.sort(userScores);
			 for(int i = 0; i < userScores.size(); i++) {
				 result[i] = userScores.get(i).toString();
				 System.out.println(userScores.get(i).toString());
			 }
			 return result;
	     }
	 
	 
	 //exit events
	 
	 /**
	  * 
	  */
	 public void exit() {
		 System.exit(0); 
	 }
	 
	 public void saveScores() {
		 System.out.println("saveee");
		 InputOutputXML.saveScores(userLogged);
	 }
	 
	 
	 
	 
	 
	 /*
	 public void mouseClicked(MouseEvent e) {
	        if (e.getClickCount() == 1) {
	           String selectedItem = (String) list.getSelectedValue();
	           // add selectedItem to your second list.
	           DefaultListModel model = (DefaultListModel) list2.getModel();
	           if(model == null)
	           {
	                 model = new DefaultListModel();
	                 list2.setModel(model);
	           }
	           model.addElement(selectedItem);

	         }
	    }
	    */
}
