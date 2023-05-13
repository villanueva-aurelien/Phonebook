package mypackage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAddContact extends JPanel
{

    public PanelAddContact()
    {
    
        this.setPreferredSize(new Dimension(400, 400));


        JButton bRep = new JButton("Repertoire");
        this.add(bRep);

        bRep.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateMainApp();
            }
            
        });
    }

    private void updateMainApp()
    {
        MainApp.updateJFrame(new PanelFormularContact());
    }
}
