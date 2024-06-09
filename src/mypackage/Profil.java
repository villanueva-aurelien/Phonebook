package mypackage;

public class Profil
{
    private static int _numberProfil = 0;
    public static int _compteur = 0;
    private String _name;
    private String _pseudo;
    private String _numberPhone;
    private String _address;
    private String _email;
    private String _anniversary;
    private String _note;


    /**
     * This constructor create Profil
     * 
     * @param name
     * @param pseudo
     * @param numberPhone
     * @param address
     * @param email
     * @param anniversary
     * @param note
     */
    public Profil(String name, String pseudo, String numberPhone, String address, String email, String anniversary, String note)
    {
        _name = name;
        _pseudo = pseudo;
        _numberPhone = numberPhone;
        _address = address;
        _email = email;
        _anniversary = anniversary;
        _note = note;
        _numberProfil++;
        _compteur++;
     }

    public Profil(String name, String pseudo, String numberPhone)
    {
        this(name, pseudo, numberPhone, null, null, null, null);
    }

    public Profil(String name, String numberPhone)
    {
        this(name, null, numberPhone);
    }

    public Profil()
    {
        this(null, null);
    }


//----------------------------------------------------------------------------------------------------------------------

    public String getName()
    {
        return _name;
    }

    public String getPseudo()
    {
        return _pseudo;
    }

    public String getNumberPhone()
    {
        return _numberPhone;
    }

    public String getAddress()
    {
        return _address;
    }

    public String getEmail()
    {
        return _email;
    }

    public String getAnniversary()
    {
        return _anniversary;
    }

    public String getNote()
    {
        return _note;
    }

    protected void setName(String name)
    {
        _name = name;
    }

    protected void setEmail(String email)
    {
        _email = email;
    }

    protected void setPseudo(String pseudo)
    {
        _pseudo = pseudo;
    }

    protected void setNumberPhone(String number)
    {
        _numberPhone = number;
    }

    protected void setAddress(String address)
    {
        _address = address;
    }

    protected void setAnniversary(String anniversary)
    {
        _anniversary = anniversary;
    }

    protected void setNote(String note)
    {
        _note = note;
    }

    protected  static void setNumberProfil(int value)
    {
        _numberProfil = value;
    }

    protected static int getNumberProfil()
    {
        return _numberProfil;
    }
}
