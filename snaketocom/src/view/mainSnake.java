package view;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class mainSnake extends JFrame {

    public mainSnake() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Snake());
               
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new mainSnake();
            ex.setVisible(true);
        });
    }
}
