package puissance4.front.main;

import java.awt.Color;


public class Puissance4 extends javax.swing.JFrame {


    public Puissance4() {
        initComponents();
        //setBackground(new Color(0, 0, 0, 1));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBrder1 = new puissance4.front.JPanelBrder();
        panelBas1 = new puissance4.front.compoent.PanelBas();
        grille2 = new puissance4.front.compoent.Grille();
        panelHaut1 = new puissance4.front.compoent.PanelHaut();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Puissance 4");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        javax.swing.GroupLayout panelBas1Layout = new javax.swing.GroupLayout(panelBas1);
        panelBas1.setLayout(panelBas1Layout);
        panelBas1Layout.setHorizontalGroup(
            panelBas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBas1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(grille2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelBas1Layout.setVerticalGroup(
            panelBas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBas1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grille2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanelBrder1Layout = new javax.swing.GroupLayout(jPanelBrder1);
        jPanelBrder1.setLayout(jPanelBrder1Layout);
        jPanelBrder1Layout.setHorizontalGroup(
            jPanelBrder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBrder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBrder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBas1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelHaut1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelBrder1Layout.setVerticalGroup(
            jPanelBrder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBrder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHaut1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBas1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBrder1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBrder1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puissance4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private puissance4.front.compoent.Grille grille2;
    private puissance4.front.JPanelBrder jPanelBrder1;
    private puissance4.front.compoent.PanelBas panelBas1;
    private puissance4.front.compoent.PanelHaut panelHaut1;
    // End of variables declaration//GEN-END:variables
}
