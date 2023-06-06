package mypackage;

import java.awt.Color;
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
import javax.swing.text.JTextComponent;


public class PanelFormularContact extends JPanel
{
    private JLabel _jlName = new JLabel(), _jlPseudo = new JLabel(), _jlNumber = new JLabel(), _jlAddress = new JLabel(), _jlEmail = new JLabel(), _jlAnniversary = new JLabel(), _jlNote = new JLabel();
    public JTextField _jtName = new JTextField(), _jtPseudo = new JTextField(), _jtNumber = new JTextField(), _jtAddress = new JTextField(), _jtEmail = new JTextField(), _jtAnniversary = new JTextField();
    private JTextArea _jtNote = new JTextArea();
    private GridBagConstraints _consttraints = new GridBagConstraints();
    private String _name, _pseudo, _number, _address, _email, _anniversary, _note;
    private Profil _currentProfil;
    private int _occurenceError = 0;

    /**
     * This interface content 1 method
     */
    public interface Command
    {
        public boolean execute();
    }

    /**
     * This constructor create Panel
     * - field JTextField and JTextArea
     * - Jbutton for create contact
     * - verify the information entered by user
     * - add this contact at PhoneBook 
     */
    public PanelFormularContact()
    {
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridBagLayout());        

        createField(_jlName, _jtName, "Name", 1, 0);
        
        createField( _jlPseudo, _jtPseudo, "Pseudo", 1, 1);

        createField( _jlNumber, _jtNumber, "Phone", 1, 2);

        createField( _jlAddress, _jtAddress, "Address", 1, 3);

        createField( _jlEmail, _jtEmail, "Email", 1, 4);

        createField( _jlAnniversary, _jtAnniversary, "Anniversary", 1, 5);

        createFieldNote(_jlNote, _jtNote, "Note", 1, 6);

        

        JButton jbValidate = new JButton("Validate");
        
        _consttraints.fill = GridBagConstraints.HORIZONTAL;
        _consttraints.ipady = 0;       //reset to default
        _consttraints.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        _consttraints.insets = new Insets(10,0,0,0);  //top padding
        _consttraints.gridx = 1;       //aligned with button 2
        //c.gridwidth = 2;   //2 columns wide
        _consttraints.gridy = 8;       //third row
        this.add(jbValidate, _consttraints);
        
        jbValidate.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                _name = _jtName.getText();
                _pseudo = _jtPseudo.getText();
                _number = _jtNumber.getText();
                _address =_jtAddress.getText();
                _email = _jtEmail.getText();
                _anniversary = _jtAnniversary.getText();
                _note = _jtNote.getText();

                _occurenceError = 0;
                checkField(_jtName, ()->isValidName(_jtName.getText()), false);
                checkField(_jtPseudo, ()->isValidPseudo(_jtPseudo.getText()), true);
                checkField(_jtNumber, ()->isValidNumberPhone(_jtNumber.getText()), false);
                checkField(_jtAddress, ()->isValidAddress(_jtAddress.getText()), true);
                checkField(_jtEmail, ()->isValidEmail(_jtEmail.getText()), true);
                checkField(_jtAnniversary, ()->isValidAnniversary(_jtAnniversary.getText()), true);
                
                if(_occurenceError == 0)
                {
                    createProfil();
                    PhoneBook.addToPhoneBook(_currentProfil);
                    updateMainApp();
                    //SaveToFile s = new SaveToFile(_name, _name, _pseudo, _number, _address, _email, _anniversary, _note);
                    //SaveToJson save = new SaveToJson(_currentProfil);
                }
                              
            }    
        });

        JButton jbReturn = new JButton("Return");
        
        _consttraints.fill = GridBagConstraints.HORIZONTAL;
        _consttraints.ipady = 0;       //reset to default
        _consttraints.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        _consttraints.insets = new Insets(10,0,0,0);  //top padding
        _consttraints.gridx = 2;       //aligned with button 2
        //c.gridwidth = 2;   //2 columns wide
        _consttraints.gridy = 8;       //third row
        this.add(jbReturn, _consttraints);

        jbReturn.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateMainApp();
            }
            
        });
    }


    private void createField(JLabel lb, JTextField jt, String text, int indexX, int indexY)
    {
        
        lb.setText(text);
        _consttraints.fill = GridBagConstraints.HORIZONTAL;
        _consttraints.weightx = 0.5;
        _consttraints.gridx = indexX;
        _consttraints.gridy = indexY;
        this.add(lb, _consttraints);

        
        jt.setPreferredSize(new Dimension(100, 30));
        _consttraints.fill = GridBagConstraints.HORIZONTAL;
        _consttraints.weightx = 0.5;
        _consttraints.gridx = indexX+1;
        _consttraints.gridy = indexY;
        this.add(jt, _consttraints);

    }

    private void createFieldNote(JLabel lb, JTextArea jt, String text, int indexX, int indexY)
    {
        lb.setText(text);
        _consttraints.fill = GridBagConstraints.HORIZONTAL;
        _consttraints.weightx = 0.5;
        _consttraints.gridx = indexX;
        _consttraints.gridy = indexY;
        this.add(lb, _consttraints);

        jt.setPreferredSize(new Dimension(100, 60));
        _consttraints.fill = GridBagConstraints.HORIZONTAL;
        _consttraints.weightx = 0.5;
        _consttraints.gridx = indexX+1;
        _consttraints.gridy = indexY;
        this.add(jt, _consttraints);

    }

    private void updateMainApp()
    {
        MainApp.updateJFrame(new PanelGlobal());
    }

    private void createProfil()
    {
        _currentProfil = new Profil(_name, _pseudo, _number, _address, _email, _anniversary, _note);
    }

    private boolean isValidName(String name)
    {
        //String regExp = "^[A-Za-z._-|\s]+[A-Za-z._-|\s]?$";                                 // Verifie le nom et prenom, prenom non obligatoire
        String regExp = "^[a-zA-Z._-]+(\\s[a-zA-Z._-]+)?$";
        return name.matches(regExp);
    }

    private boolean isValidAnniversary(String anniversary)
    {
        String regExp = "^(0[0-9]|[12][0-9]|3[01])/(0[0-9]|1[0-2])/(19|20)?([0-9]{2})$";      // Verifie que le jour, mois et année commence bien comme il se doit, mais ne permet pas de verifier q'on entre une date erroné comme 30/02/2999.
        return anniversary.matches(regExp);
    }

    private boolean isValidNumberPhone(String phone)
    {
        //String regExp = "^(0[0-9])-[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{2}$";                   // Verifie le numero de telephone.
        String regExp = "^(0[0-9])[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}$"; 
        return phone.matches(regExp);
    }

    private boolean isValidPseudo(String pseudo)
    {
        String regExp = "^[A-Za-z._-]+(\\s[a-zA-Z._-]+)?$";                                 
        return pseudo.matches(regExp);
    }

    private boolean isValidEmail(String email)
    {
        //String regExp = "^.+@.+\\..+$";                                       // expression pas assé fine.
        //String regExp = "^[A-Za-z0-9._-]@[A-Za-z0-9._-]+\\.[a-z]{2,}$";       // Bonne expression reguliere
        //String regExp = "^[\\w.-]@\\w.-]+\\.[a-z]{2,}$";                      // meme expression en plus cour \\w remplace "A-Za-z0-9_", toute fois la fin de l'expression n'accepte pas les adresses autres aue le format latin
                                                                                // pour ce faire il faut enlever le "[a-z]" et rester sur le "."
        String regExp = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$"; 
        return email.matches(regExp);
    }

    private boolean isValidAddress(String address)
    {
        String regExp = "^[\\d]+(\\s[a-zA-Z0-9._-]+)*$";
        return address.matches(regExp);
    }

    private void checkField(JTextComponent c, Command co, boolean optionnal)
    {
        if(c.getText().isEmpty() && optionnal == true)
        {
            c.setBackground(Color.white);
            return;
        }
        if(!co.execute())
        {
            c.setBackground(Color.red);
            _occurenceError++;
        }
        else
        {
            c.setBackground(Color.white);
        }        
    }
}
