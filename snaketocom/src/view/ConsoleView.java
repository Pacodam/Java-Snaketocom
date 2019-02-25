package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class ConsoleView extends JPanel {
	
	private JPopupMenu popupMenu;
	private JMenuItem pop1;
	private JMenuItem pop2;
	private JMenuItem pop3;
	/**
	 * Create the panel.
	 */
	public ConsoleView() {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("ff");
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("eee");
			}
		});
		
		
		
		
		popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 122, 16);
		popupMenu.setToolTipText("");
		popupMenu.setLabel("");
		addPopup(this, popupMenu);
		
		
	    pop1 = new JMenuItem("MENU");
		popupMenu.add(pop1);
		
	    pop2 = new JMenuItem("LOGOUT");
		popupMenu.add(pop2);
		
		pop3 = new JMenuItem("EXIT");
		popupMenu.add(pop3);
		setLayout(null);
			
		
	}
	

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public JMenuItem getPop1() {
		return pop1;
	}

	public JMenuItem getPop2() {
		return pop2;
	}

	public JMenuItem getPop3() {
		return pop3;
	}
	
	
}
