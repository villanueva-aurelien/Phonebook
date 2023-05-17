package mypackage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp
{
    private static JFrame jf;
    private static JPanel _currentPanel;


    public MainApp()
    {
        jf = new JFrame("Book");
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        PanelGlobal pac = new PanelGlobal();
        jf.add(pac);
        _currentPanel = pac;
        jf.pack();
            
    }

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
