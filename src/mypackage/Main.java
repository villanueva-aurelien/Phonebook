package mypackage;

import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        MainApp m = new MainApp();
        PhoneBook p = new PhoneBook();
        LoadProfilJson l = new LoadProfilJson();
        l.chargerContenuJSON();
        
        // ScannFile s = new ScannFile("C:"+File.separator+"Users"+File.separator+"D3FfS"+File.separator+"OneDrive"
        // +File.separator+"Bureau"+File.separator+"prog"+File.separator+"Java"+File.separator+"projet"+File.separator+"Annuaire"
        // +File.separator+"src"+File.separator+"mypackage"+File.separator+"save"+File.separator);
        
    }
    
}