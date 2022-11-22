package puissance4.front.compoent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JButton {

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        //setBackground(Color.BLUE);
        //setFont(new Font("sansserif", 1, 12));
        setPreferredSize(new Dimension(40, 30));
        setForeground(new Color(102, 102, 102));
        //setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    
     
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(230, 230, 230));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}
