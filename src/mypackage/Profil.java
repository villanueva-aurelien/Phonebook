package mypackage;

public class Profil
{
    private String _name;
    private String _pseudo;
    private String _numberPhone;
    private String _address;
    private String _email;
    private String _anniversary;
    private String _note;


    public Profil(String name, String pseudo, String numberPhone, String address, String email, String anniversary, String note)
    {
        _name = name;
        _pseudo = pseudo;
        _numberPhone = numberPhone;
        _address = address;
        _email = email;
        _anniversary = anniversary;
        _note = note;
 
        verifyInfosNotNull();
        PhoneBook.addToPhoneBook(this);

    }

    public Profil(String name, String pseudo, String numberPhone)
    {
        super();
        _name = name;
        _pseudo = pseudo;
        _numberPhone = numberPhone;

    }

    public Profil(String name, String numberPhone)
    {
        super();
        _name = name;
        _numberPhone = numberPhone;
    }


    private void verifyInfosNotNull()
    {
        if(_name !=null)
            if(isValidName(_name) == false)
                return;
        if(_pseudo != null)
            if(isValidPseudo(_pseudo) == false)
                return;
        if(_numberPhone != null)
            if(isValidNumberPhone(_numberPhone) == false)
                return;
        if(_address != null)
            if(isValidAddress(_address) == false)
                return;
        if(_email != null)
            if(isValidEmail(_email) == false)
                return;
        if(_anniversary != null)
            if(isValideAnniversary(_anniversary) == false)
                return;
    }

    private boolean isValideAnniversary(String anniversary)
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

    private boolean isValidName(String name)
    {
        //String regExp = "^[A-Za-z._-|\s]+[A-Za-z._-|\s]?$";                                 // Verifie le nom et prenom, prenom non obligatoire
        String regExp = "^[a-zA-Z._-]+(\\s[a-zA-Z._-]+)?$";
        return name.matches(regExp);
    }

    private boolean isValidPseudo(String pseudo)
    {
        String regExp = "^[A-Za-z._-|\s]+$";                                 
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
        String regExp = "^[\\d.|\s]+[\\w.-|\s]+.[\\d{2,8|\s}]+[\\w-].+$";
        return address.matches(regExp);
    }
//----------------------------------------------------------------------------------------------------------------------

    public String getName()
    {
        return _name;
    }

    public String getNumber()
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
}
