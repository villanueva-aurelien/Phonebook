package mypackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mypackage.SaveProfilJson.JsonLoader;

public class LoadProfilJson
{
 
    ObjectMapper _objectMapper = new ObjectMapper();
    private ArrayList<Profil> _listeObjets;

    public LoadProfilJson()
    {

    }
    
    /**
     * This method load this content of file.JSON
     * And call method transfertList of PhoneBook class
     * To add Profil
     */
    public void chargerContenuJSON()
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            File file = new File("PhoneBook.json");
            if(!file.exists())
                return;
            
            
            _listeObjets = mapper.readValue(file, new TypeReference<ArrayList<Profil>>() {});
            PhoneBook.transfertList(_listeObjets);
            // Vous pouvez remplacer cette ligne par votre propre code pour traiter la liste d'objets.
        }
        catch (IOException e)
        {
            System.out.println("Erreur lors du chargement du fichier JSON : " + e.getMessage());
        }
    }
}
