package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook
{
    private static ArrayList<Profil> _book = new ArrayList<>();

    public PhoneBook()
    {
        Profil p = new Profil("villa", null, "05-18-62-32-60", null, "aaa@hotmail.fr", "11/02/1982", null);
        _book.add(p);
        sortList();
    }

    private void sortList()
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
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Profil> getBook()
    {
        return _book;
    }

}
