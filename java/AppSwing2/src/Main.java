import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel mainPanel;
    private JTextField textFieldMain;
    private JLabel myLabelMain;

    public Main(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        textFieldMain.setSize(400, 160);
        myLabelMain.setSize(200, 160);
        myLabelMain.setFont(new Font("Courier", Font.PLAIN,24));
        mainPanel.setFont(new Font("Courier", Font.PLAIN,24));
        //setUndecorated(true);
        //setBackground(new Color(0, 0, 0, 0));
        //pack();
        //mainPanel = new PanelBorder();
        setSize(1200, 800);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        JFrame jFrame = new Main("App Swing");
        jFrame.setVisible(true);
        /*
        invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
         */
    }


}
