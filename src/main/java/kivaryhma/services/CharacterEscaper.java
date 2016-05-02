/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.services;

/**
 *
 * @author ile
 */
public class CharacterEscaper {
    
    public static String filter(String txt){
        String text = txt;
        text = text.replace("ä", "{\\\"{a}}");
        text = text.replace("Ä", "{\\\"{A}}");
        text = text.replace("ö", "{\\\"{o}}");
        text = text.replace("Ö", "{\\\"{O}}");
        text = text.replace("å", "{\\aa}");
        text = text.replace("Å", "{\\AA}");
        text = text.replace("ß", "{\\ss}");
        text = text.replace("æ", "{\\ae}");
        text = text.replace("Æ", "{\\AE}");
        text = text.replace("ø", "{\\o}");
        text = text.replace("Ø", "{\\O}");

        // special characters {  "  and $  also need to be vetted from BibteX with extra slashes.
        text = text.replace("{", "\\{");
        text = text.replace("\"", "\\\"");
        text = text.replace("$", "\\$");
         
        //Testikommentti
        return text;
        
    }
    
}
