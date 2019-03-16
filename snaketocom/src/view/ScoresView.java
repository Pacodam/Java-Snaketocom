package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controller.Controller;

import java.util.List;
import java.awt.TextArea;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;


public class ScoresView extends JPanel {

	private JTabbedPane tabbedPane;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;
	private JButton backMenu;
	
	//tab 1 attrs
	private JTextField textField;
	private JButton find;
	private JLabel userSearch;
	private JTextArea textArea;
	private JList<String> jlist;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	public ScoresView() {
		setLayout(null);
		
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(70, 81, 586, 404);
		add(tabbedPane);
		
		backMenu = new JButton("<-");
		backMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if("" != (String) jlist.getSelectedValue()) {
					String selectedItem = (String) jlist.getSelectedValue();
					try {
						textArea.setText(Controller.userResume(selectedItem));
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
		});
	    backMenu.setBounds(31, 25, 89, 23);
	    add(backMenu);
	    
        //tab UsersList
		tab1 = new JPanel();
		tabbedPane.addTab("Users List", tab1);
		tab1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(111, 41, 298, 32);
		tab1.add(textField);
		textField.setColumns(10);
		
		find = new JButton("...");
		find.setBounds(432, 41, 89, 32);
		tab1.add(find);
		
		userSearch = new JLabel("Find:");
		userSearch.setBounds(32, 50, 46, 14);
		tab1.add(userSearch);
		
		textArea = new JTextArea(BorderLayout.CENTER);
		textArea.setBounds(216, 111, 305, 230);
		tab1.add(textArea);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedItem = (String) jlist.getSelectedValue();
				try {
					textArea.setText(Controller.userResume(selectedItem));
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
			  }
		    });
		scrollPane.setBounds(32, 115, 172, 226);
		tab1.add(scrollPane);
		
		//jlist = new JList(names);
		//scrollPane.setViewportView(jlist);
		
		
		
		
		
		tab2 = new JPanel();
		tabbedPane.addTab("Best User Score", tab2);
		tab3 = new JPanel();
	    tabbedPane.addTab("Score Filter", tab3);
	    
	    
	    
	    
	    //tab BestUserScore
	    
	    //tab Score Filter
	    
	}

	//TAB1 elements
	public void setUsersList(List<String> userNames) {
		String[] names = new String[userNames.size()];
		for(int i = 0; i < userNames.size(); i++) {
			System.out.println(userNames.get(i));
			names[i] = userNames.get(i);
		}
		jlist = new JList(names);
		scrollPane.setViewportView(jlist);
		
	}  
	
	public JList getJList() {
		return jlist;
	}
		
    public void setUserResume(String resume) {
    	textArea.setText(resume);
    }
	
	
	public JButton getBackMenu() {
		return backMenu;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getFind() {
		return find;
	}

	public JLabel getUserSearch() {
		return userSearch;
	}

}


/*
 * string columnames array de titulos
 * string data = this.mainWindow.getMyScores() dimension 2
 * table = new Jtable(data,columnames)
 * scroll pane
 * setLaout groupLayout
 * etc
 * 
 * 
 * string name = nombres
 * lsit = new Jlist(names);
 * scrollPanesetViewPortView(list)
 * 
 * a�adir listeners para sleeccion
 * 
 * 
 * */
