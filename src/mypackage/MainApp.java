package mypackage;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.*;

public class MainApp
{
    private static JFrame jf;
    private static JPanel _currentPanel;

    /**
     * This constructor create JFrame
     */
    public MainApp()
    {
        jf = new JFrame("Book");
        jf.setSize(500, 500);

        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        jf.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int option = JOptionPane.showConfirmDialog(
                        jf,
                        "Êtes-vous sûr de vouloir fermer la fenêtre ?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION)
                {
                    // mettre ici la commande pour sauvegarder en JSON <--
                    SaveProfilJson s = new SaveProfilJson();
                    s.saveJson();
                    jf.dispose();
                }
            }
        });
        
        jf.setVisible(true);

        PanelGlobal pac = new PanelGlobal();
        jf.add(pac);
        _currentPanel = pac;
        jf.pack();
            
    }



    /**
     * This method update Jpanel
     * Remove last Jpanel and add new Jpanel
     * Repaint and pack JFrame
     * @param j
     */
    public static void updateJFrame(JPanel j)
    {
        if(j == null)
            return;
        
        jf.remove(_currentPanel);

        jf.add(j);
        _currentPanel = j;
        jf.repaint();
        jf.pack();
    }
}
