package mypackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDisplayContact extends JPanel
{
    private GridBagConstraints _constraint = new GridBagConstraints();
    
    /**
     * This constructor create
     * - JPanel with the information contained in profile
     * - 4 JButton "Delete", "Previous", "Return", "Next"
     * 
     * @param p is type Profil
     */
    public PanelDisplayContact(Profil p)
    {
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridBagLayout());        

        createField(0, 0, "Name");
        createField(1, 0, p.getName());
        
        createField(0, 1, "Pseudo");
        createField( 1, 1, p.getPseudo());

        createField(0, 2, "NumberPhone");
        createField(1, 2, p.getNumberPhone());

        createField(0, 3, "Address");
        createField( 1, 3, p.getAddress());

        createField(0, 4, "Email");
        createField( 1, 4, p.getEmail());

        createField(0, 5, "Anniversary");
        createField(1, 5, p.getAnniversary());

        createFieldNote(0, 6, "Note");
        createFieldNote(1, 6, p.getNote());

        JButton jbPrevious = new JButton("Previous");
        
        _constraint.fill = GridBagConstraints.HORIZONTAL;
        _constraint.ipady = 0;       //reset to default
        _constraint.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.LAST_LINE_START; //bottom of space
        _constraint.insets = new Insets(10,0,0,0);  //top padding
        _constraint.gridx = 0;       //aligned with button 2
        //c.gridwidth = 3;   //2 columns wide
        _constraint.gridy = 8;       //third row
        this.add(jbPrevious, _constraint);

        jbPrevious.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updatePreviousContact();
            }
            
        });

        JButton jbRetunr = new JButton("Return");
        
        _constraint.fill = GridBagConstraints.HORIZONTAL;
        _constraint.ipady = 0;       //reset to default
        _constraint.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        _constraint.insets = new Insets(10,0,0,0);  //top padding
        _constraint.gridx = 1;       //aligned with button 2
        //c.gridwidth = 3;   //2 columns wide
        _constraint.gridy = 8;       //third row
        this.add(jbRetunr, _constraint);

        jbRetunr.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateMainApp();
            }
            
        });
        

        JButton jbNext = new JButton("Next");
        
        _constraint.fill = GridBagConstraints.HORIZONTAL;
        _constraint.ipady = 0;       //reset to default
        _constraint.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.LAST_LINE_END; //bottom of space
        _constraint.insets = new Insets(10,0,0,0);  //top padding
        _constraint.gridx = 2;       //aligned with button 2
        //c.gridwidth = 3;   //2 columns wide
        _constraint.gridy = 8;       //third row
        this.add(jbNext, _constraint);

        jbNext.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateNextContact();
            }
            
        });

        JButton jbdelete = new JButton("Delete");
        
        _constraint.fill = GridBagConstraints.HORIZONTAL;
        _constraint.ipady = 0;       //reset to default
        _constraint.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.LAST_LINE_END; //bottom of space
        _constraint.insets = new Insets(10,0,0,0);  //top padding
        _constraint.gridx = 1;       //aligned with button 2
        //c.gridwidth = 3;   //2 columns wide
        _constraint.gridy =7;       //third row
        this.add(jbdelete, _constraint);

        jbdelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateDeleteConctact();
                updateMainApp();              
            }
            
        });
    }

    private void createField(int indexX, int indexY, String info)
    {
        JLabel lb = new JLabel();
        _constraint.fill = GridBagConstraints.HORIZONTAL;
        _constraint.weightx = 0.5;
        _constraint.gridx = indexX;
        _constraint.gridy = indexY;
        lb.setText(info);
        this.add(lb, _constraint);
    }

    private void createFieldNote(int indexX, int indexY, String info)
    {
        JLabel lb = new JLabel();
        lb.setText(info);
        _constraint.fill = GridBagConstraints.HORIZONTAL;
        _constraint.weightx = 0.5;
        _constraint.gridx = indexX;
        _constraint.gridy = indexY;
        this.add(lb, _constraint);

    }

    private void updateMainApp()
    {
        MainApp.updateJFrame(new PanelGlobal());
    }

    private void updatePreviousContact()
    {
        PanelGlobal.displayPreviousContact();
    }

    private void updateNextContact()
    {
        PanelGlobal.displayNextContact();
    }

    private void updateDeleteConctact()
    {
        PanelGlobal.deleteContact();
    }

}
