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
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PanelFormularContact extends JPanel
{
    private JLabel jlName = new JLabel(), jlPseudo = new JLabel(), jlNumber = new JLabel(), jlAddress = new JLabel(), jlEmail = new JLabel(), jlAnniversary = new JLabel(), jlNote = new JLabel();
    private JTextField jtName = new JTextField(), jtPseudo = new JTextField(), jtNumber = new JTextField(), jtAddress = new JTextField(), jtEmail = new JTextField(), jtAnniversary = new JTextField();
    private JTextArea jtNote = new JTextArea();
    private GridBagConstraints c = new GridBagConstraints();
    private String name, pseudo, number, address, email, anniversary, note;

    public PanelFormularContact()
    {
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridBagLayout());        

        createField(jlName, jtName, "Name", 1, 0);
        
        createField( jlPseudo, jtPseudo, "Pseudo", 1, 1);

        createField( jlNumber, jtNumber, "Phone", 1, 2);

        createField( jlAddress, jtAddress, "Address", 1, 3);

        createField( jlEmail, jtEmail, "Email", 1, 4);

        createField( jlAnniversary, jtAnniversary, "Anniversary", 1, 5);

        createFieldNote(jlNote, jtNote, "Note", 1, 6);

        

        JButton jbValidate = new JButton("Validate");
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 8;       //third row
        this.add(jbValidate, c);
        
        jbValidate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                name = jtName.getText();
                pseudo = jtPseudo.getText();
                number = jtNumber.getText();
                address = jtAddress.getText();
                email = jtEmail.getText();
                anniversary = jtAnniversary.getText();
                note = jtNote.getText();
                addFormularAtPhoneBook();
                updateMainApp();
            }    
        });
    }


    private void createField(JLabel lb, JTextField jt, String text, int indexX, int indexY)
    {
        
        lb.setText(text);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = indexX;
        c.gridy = indexY;
        this.add(lb, c);

        
        jt.setPreferredSize(new Dimension(100, 30));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = indexX+1;
        c.gridy = indexY;
        System.out.println(jt == jtName);
        this.add(jt, c);

    }

    private void createFieldNote(JLabel lb, JTextArea jt, String text, int indexX, int indexY)
    {
        lb.setText(text);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = indexX;
        c.gridy = indexY;
        this.add(lb, c);

        jt.setPreferredSize(new Dimension(100, 60));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = indexX+1;
        c.gridy = indexY;
        this.add(jt, c);

    }

    private void updateMainApp()
    {
        MainApp.updateJFrame(new PanelAddContact());
    }

    private void addFormularAtPhoneBook()
    {
        Profil p = new Profil(name, pseudo, number, address, email, anniversary, note);
    }
}
