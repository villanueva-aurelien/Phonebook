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
        MainApp.updateJFrame(new PanelDisplayContact(PhoneBook.getBook().get(0)));
    }

    public static void displayPreviousContact()
    {
        if(_currentIndex > 0)
        {
            _currentIndex--;
            MainApp.updateJFrame(new PanelDisplayContact(PhoneBook.getBook().get(_currentIndex)));
        } 
    }

    public static void displayNextContact()
    {
        if(_currentIndex < PhoneBook.getBook().size()-1)
        {
            _currentIndex++;
            MainApp.updateJFrame(new PanelDisplayContact(PhoneBook.getBook().get(_currentIndex)));
        } 
    }

    public static void deleteContact()
    {
        PhoneBook.getBook().remove(_currentIndex);
    }


}
