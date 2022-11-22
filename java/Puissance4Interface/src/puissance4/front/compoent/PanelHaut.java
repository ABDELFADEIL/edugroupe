package puissance4.front.compoent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import puissance4.back.business.Couleur;
import puissance4.back.business.Partie;
import puissance4.back.business.Puissance4;


public class PanelHaut extends javax.swing.JPanel {

    public static boolean roleJourRouge;
    public static boolean roleJourJaune;

    public PanelHaut() {
        initComponents();
        setOpaque(false);
        btnJouer.setOpaque(true);
        updatePlayers();
    }

    
    private void updatePlayers(){
        Couleur couleur = Table.jeu.getPuissance4().getJoueurCourant().getNom();
        if(Couleur.JAUNE == couleur){
        radioBtnYello.setSelected(true);
        }else {
            radioBtnRed.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupeJoueurs = new javax.swing.ButtonGroup();
        lbJoureur1 = new javax.swing.JLabel();
        lbJoureur2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnJouer = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        radioBtnRed = new javax.swing.JRadioButton();
        radioBtnYello = new javax.swing.JRadioButton();

        lbJoureur1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lbJoureur1.setForeground(new java.awt.Color(51, 51, 51));
        lbJoureur1.setText("Joueur 1");

        lbJoureur2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lbJoureur2.setForeground(new java.awt.Color(51, 51, 51));
        lbJoureur2.setText("Joueur 2");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puissance4/front/icon/red_jeton.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puissance4/front/icon/yello_jeton.png"))); // NOI18N

        btnJouer.setBackground(new java.awt.Color(0, 204, 0));
        btnJouer.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnJouer.setForeground(new java.awt.Color(255, 255, 255));
        btnJouer.setText("Jouer");
        btnJouer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnJouer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jouer(evt);
            }
        });
        btnJouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJouerActionPerformed(evt);
            }
        });

        btnAnnuler.setBackground(new java.awt.Color(255, 51, 0));
        btnAnnuler.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnAnnuler.setForeground(new java.awt.Color(255, 255, 255));
        btnAnnuler.setText("Abandoner");
        btnAnnuler.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnnulerMouseClicked(evt);
            }
        });
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        radioBtnRed.setBackground(new java.awt.Color(182, 251, 255));
        btnGroupeJoueurs.add(radioBtnRed);
        radioBtnRed.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        radioBtnRed.setPreferredSize(new java.awt.Dimension(24, 24));
        radioBtnRed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioBtnRedItemStateChanged(evt);
            }
        });
        radioBtnRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnRedActionPerformed(evt);
            }
        });
        radioBtnRed.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                radioBtnRedPropertyChange(evt);
            }
        });

        radioBtnYello.setBackground(new java.awt.Color(182, 251, 255));
        btnGroupeJoueurs.add(radioBtnYello);
        radioBtnYello.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        radioBtnYello.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioBtnRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbJoureur1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnJouer, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 442, Short.MAX_VALUE)
                        .addComponent(radioBtnYello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbJoureur2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnJouer)
                            .addComponent(btnAnnuler)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbJoureur1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(radioBtnRed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbJoureur2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioBtnYello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnJouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJouerActionPerformed
        Couleur couleur = Table.jeu.getPuissance4().getJoueurCourant().getNom();
        if (Table.jeu.isGameOver() || Table.jeu.isGameOver()) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
           Table table = new Table();
           Table.jeu = new Puissance4(new Partie());
           topFrame.repaint();
        }
        System.err.print(couleur);
    }//GEN-LAST:event_btnJouerActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
       Table.jeu.getPuissance4().setParAbandon(true);
       Table.jeu = new Puissance4(new Partie());
       repaint();
       System.out.println("Jeu andonner");
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void jouer(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jouer
        // TODO add your handling code here:
        if (Table.jeu.isGameOver() || Table.jeu.getPuissance4().isParAbandon()) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
           Table table = new Table();
           Table.jeu = new Puissance4(new Partie());
           topFrame.repaint();
        }
    }//GEN-LAST:event_jouer

    private void btnAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseClicked
        // TODO add your handling code here:
        Table.jeu.abandonner();
        if (Table.jeu.getPuissance4().isParAbandon()) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
           Table table = new Table();
           Table.jeu = new Puissance4(new Partie());
           topFrame.repaint();
        }
    }//GEN-LAST:event_btnAnnulerMouseClicked

    private void radioBtnRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnRedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnRedActionPerformed

    private void radioBtnRedPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_radioBtnRedPropertyChange
        // TODO add your handling code here:
         JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
           topFrame.repaint();
                  System.out.println("radioBtnRedPropertyChange");

    }//GEN-LAST:event_radioBtnRedPropertyChange

    private void radioBtnRedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioBtnRedItemStateChanged
        // TODO add your handling code here:
        
                  System.out.println("radioBtnRedPropertyChange");
    }//GEN-LAST:event_radioBtnRedItemStateChanged

    public void repaintTable(){
        repaint();
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //graphics2D.setColor(Color.decode("#4ac29a"));
        graphics2D.setColor(Color.decode("#b6fbff")); //#ffefba
        graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(graphics); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnnuler;
    private javax.swing.ButtonGroup btnGroupeJoueurs;
    private javax.swing.JButton btnJouer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbJoureur1;
    private javax.swing.JLabel lbJoureur2;
    private javax.swing.JRadioButton radioBtnRed;
    private javax.swing.JRadioButton radioBtnYello;
    // End of variables declaration//GEN-END:variables
}
