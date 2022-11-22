package edugroup.app;

import edugroup.app.component.PanelBroder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.EventQueue.invokeLater;

public class Main extends JFrame{
    private JPanel MainPanel;
    private JTextField textField1;
    private JButton button1;

    public Main() {
        setPreferredSize(new Dimension(780, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        //LayoutManager layout = new ;
        //setLayout(null);
        //setBackground(new Color(0, 0, 0, 0));
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    public static void main(String[] args) {
        invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });

    }
}
