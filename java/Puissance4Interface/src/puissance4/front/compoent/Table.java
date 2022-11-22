package puissance4.front.compoent;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import puissance4.back.business.Couleur;
import puissance4.back.business.Jeton;
import puissance4.back.business.Partie;

/**
 *
 * @author fadeil
 */
public class Table extends JTable {

    Partie partie;
    public static puissance4.back.business.Puissance4 jeu;
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(50);
        partie = new Partie();
        jeu = new puissance4.back.business.Puissance4(partie);
        
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                return header;
            }
            
        });
       
        getTableHeader().addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = columnAtPoint(e.getPoint());
                Couleur couleur = jeu.getPuissance4().getJoueurCourant().getNom();
                //header.setIcon(icon);
                insertJeton(col);
                if(Couleur.JAUNE == couleur){
                    PanelHaut.roleJourJaune = true;
                    PanelHaut.roleJourRouge = false;
                    System.err.println("PanelHaut.roleJourJaune = " + PanelHaut.roleJourJaune);
                    System.err.println("PanelHaut.roleJourRouge = " + PanelHaut.roleJourRouge);
                }else if(Couleur.ROUGE == couleur){
                    PanelHaut.roleJourRouge = true;
                    PanelHaut.roleJourJaune = false;
                    System.err.println("PanelHaut.roleJourJaune = " + PanelHaut.roleJourJaune);
                    System.err.println("PanelHaut.roleJourRouge = " + PanelHaut.roleJourRouge);
                }
                
                if (jeu.isGameOver()) {
                //partie = new Partie();
                //jeu = new puissance4.back.business.Puissance4(partie); 
                }
                repaint();
            }
            
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                //Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                //com.setBackground(Color.WHITE);
                //setBorder(noFocusBorder);
                //com.setForeground(new Color(102, 102, 102));
                //jtable.getTableHeader().setUI(null);
                Jeton jeton = jeu.getPuissance4().getGrille().getJetons()[i][i1];
                ImageIcon icon = null;
                if (jeton != null) {
                    if (Couleur.JAUNE == jeton.couleur) {
                        icon = new ImageIcon(getClass().getResource("/puissance4/front/icon/yello_jeton.png"));
                    } else if (Couleur.ROUGE == jeton.couleur) {
                        icon = new ImageIcon(getClass().getResource("/puissance4/front/icon/red_jeton.png"));
                    }
                }
                return new Label_Grille(icon);
            }
        });
        
  
    }

    private void insertJeton(int col){
        jeu.jouer(col);
        //jeu.getPuissance4().getGrille().insererJeton(new Jeton(jeu.getPuissance4().getJoueurCourant().getNom()), col);
    }
   

   

}
