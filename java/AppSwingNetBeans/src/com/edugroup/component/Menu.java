package com.edugroup.component;

import com.edugroup.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

/**
 *
 * @author fadeil
 */
public class Menu extends javax.swing.JPanel {

   
    public Menu() {
        initComponents();
        setOpaque(true);
        listMenu1.setOpaque(false);
        init();
    }
    
    private void init() {
        listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "UI Elements", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("3", "Comonents", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("4", "Forms Stuff", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "Date Table", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));

        listMenu1.addItem(new Model_Menu("", "My Data", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("6", "Icons", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("7", "Sample Page", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("8", "Extra", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("9", "More", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("10", "Logout", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }

    @Override
    protected void paintChildren(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradientPaint = 
                new GradientPaint(0, 0,  Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        graphics2D.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(graphics);
    }
    
    int x;
    int y;

    public void initMoving(JFrame fram){
        
        panelMoviMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent event) {
                x = event.getX();
                y = event.getY();
            }
            
        });
        panelMoviMenu.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent event) {
                fram.setLocation(event.getXOnScreen() - x, event.getYOnScreen() - y);
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoviMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new com.edugroup.swing.ListMenu<>();

        panelMoviMenu.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edugroup/icon/Logo_EduGroupe2019(1).png"))); // NOI18N
        jLabel1.setText("EduGroupe");

        javax.swing.GroupLayout panelMoviMenuLayout = new javax.swing.GroupLayout(panelMoviMenu);
        panelMoviMenu.setLayout(panelMoviMenuLayout);
        panelMoviMenuLayout.setHorizontalGroup(
            panelMoviMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoviMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMoviMenuLayout.setVerticalGroup(
            panelMoviMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoviMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoviMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoviMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.edugroup.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoviMenu;
    // End of variables declaration//GEN-END:variables
}
