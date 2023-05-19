package mypackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile
{
    private static String _addressFile = "C:"+File.separator+"Users"+File.separator+"D3FfS"+File.separator+"OneDrive"+File.separator+"Bureau"+File.separator+"prog"+File.separator+"Java"+File.separator+
    "projet"+File.separator+"Annuaire"+File.separator+"src"+File.separator+"mypackage"+File.separator+"save"+File.separator;

    /**
     * 
     * @param nameFile
     * @param name
     * @param pseudo
     * @param number
     * @param address
     * @param email
     * @param anniversary
     * @param note
     */
    public SaveToFile(String nameFile, String name, String pseudo, String number, String address, String email, String anniversary, String note)
    {
        callWritter(PhoneBook.getBook().get(PanelGlobal._currentIndex));
        writterFile(nameFile ,name, pseudo, number, address, email, anniversary, note);

    }

    private void callWritter(Profil p)
    {        
        writterFile(p.getName(), p.getName(), p.getPseudo(), p.getNumber(), p.getAddress(),
        p.getEmail(), p.getAnniversary(), p.getNote());
    }

        /**
     * This method file and writes in file.txt the contents of the array
     * @param nameFile
     * @param name
     * @param pseudo
     * @param number
     * @param address
     * @param email
     * @param anniversary
     * @param note
     */
    private void writterFile(String nameFile, String name, String pseudo, String number, String address, String email, String anniversary, String note)
    {
        File file = new File(_addressFile+ nameFile+".txt");

        // créer le fichier s'il n'existe pas
        
        try
        {
            if (!file.exists()) 
                file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(name+"\n");
            bw.write(pseudo+"\n");
            bw.write(number+"\n");
            bw.write(address+"\n");
            bw.write(email+"\n");
            bw.write(anniversary+"\n");
            bw.write(note+"\n");
            bw.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public static void deleteFile(String nameFile)
    {
        File file = new File(_addressFile+nameFile+".txt");

        if(file.exists() && file.isFile())
            file.delete();
    }
}
