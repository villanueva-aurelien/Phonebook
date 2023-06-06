package mypackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveProfilJson
{
    ObjectMapper _objectMapper = new ObjectMapper();
    private ArrayList<Profil> _listeObjets;
  
  
    public SaveProfilJson()
    {

    }

    /**
     * This method save the content to ArrayList<Profil> of class PhoneBook
     * To file.JSON
     */
    public void saveJson()
    {
        try
        {
            //objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            _objectMapper.writeValue(new File("PhoneBook.json"), PhoneBook.getBook());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
