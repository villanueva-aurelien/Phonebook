package mypackage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelGlobal extends JPanel
{

    static int _currentIndex = 0;

    /**
     * This constructor create JPanel with 2 JButton
     * - add Contact (create new contact in PanelFormularContat)
     * - Repertory (display contact)
     */
    public PanelGlobal()
    {
    
        this.setPreferredSize(new Dimension(400, 400));


        JButton addContact = new JButton("add Contact");
        this.add(addContact);

        addContact.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateMainApp();
            }
            
        });

        JButton repertory = new JButton("Repertory");
        this.add(repertory);

        repertory.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!PhoneBook.getBook().isEmpty())
                    updateDisplayContact();
            }
            
        });
    }

    private void updateMainApp()
    {
        MainApp.updateJFrame(new PanelFormularContact());
    }

    private void updateDisplayContact()
    {
        if(PhoneBook.getBook() == null)
            return;
        
        MainApp.updateJFrame(new PanelDisplayContact(PhoneBook.getBook().get(0)));
    }

    /**
     * This methode call new Panel and display previous contact in ArrayList<Profil>
     */
    public static void displayPreviousContact()
    {
        if(_currentIndex > 0)
        {
            _currentIndex--;
            MainApp.updateJFrame(new PanelDisplayContact(PhoneBook.getBook().get(_currentIndex)));
        } 
    }

    /**
     * This methode call new Panel and display next contact in ArrayList<Profil>
     */
    public static void displayNextContact()
    {
        if(_currentIndex < PhoneBook.getBook().size()-1)
        {
            _currentIndex++;
            MainApp.updateJFrame(new PanelDisplayContact(PhoneBook.getBook().get(_currentIndex)));
        } 
    }

    /**
     * This method remove 1 element in ArrayList
     */
    public static void deleteContact()
    {
        if(Profil.getNumberProfil() == 0)
        {
            return;
        }

        if(PhoneBook.getBook() == null)
        {
            MainApp.updateJFrame(new PanelGlobal());
        }

        PhoneBook.getBook().remove(_currentIndex);
        Profil.setNumberProfil(-1);
    }

    
    public static Profil selectFileContact()
    {        
        return PhoneBook.getBook().get(_currentIndex);
    }
}
