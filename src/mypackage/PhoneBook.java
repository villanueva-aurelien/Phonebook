package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook
{
    private static ArrayList<Profil> _book = new ArrayList<>();

    public PhoneBook()
    {

    }

    private static void sortList()
    {
        Collections.sort(_book, new Comparator<Profil>()
        {
            @Override
            public int compare(Profil p1, Profil p2)
            {
                return p1.getName().compareTo(p2.getName());
            }       
        });
    }
    
    /**
     * This method add Profil to ArrayList<Profil>
     * @param p     is Profil
     */
    public static void addToPhoneBook(Profil p)
    {
        _book.add(p);
        if(_book.size() >= 2)
            sortList();
    }

    /**
     * This method add to ArrayList<Profil> this ArrayList<Profil>
     * @param list     is ArrayList<Profil>
     */
    public static void transfertList(ArrayList<Profil> list)
    {
        if(list.isEmpty())
        {
            return;
        }
        
        _book.addAll(list);
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Profil> getBook()
    {
        return _book;
    }

}
