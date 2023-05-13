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
    
    public static void addToPhoneBook(Profil p)
    {
        System.out.println("ajoute 1 profil");
        _book.add(p);
        sortList();
        System.out.println(_book.size());

        for(int i =0; i < _book.size(); i++)
        {
            System.out.println("bon");
            System.out.println(_book.get(i).getNumber());
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Profil> getBook()
    {
        return _book;
    }

}
