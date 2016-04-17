package kivaryhma;


import java.io.File;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author toffe
 */
public class Model {
    
    private ArrayList<Entry> references = new ArrayList<Entry>();
    private File referenceFile;
    
    public Model() {}
    
    public boolean addReference(Entry entry) {
        if(entry.isAuthentic()) {
            references.add(entry);
            return true;
        }
        else {
            return false;
        }
    }
    
    public ArrayList<Entry> getReferences() {
        return references;
    }
    
    /**
    public void saveToFile() {
        //Ei toteutettu vielä
    }
    **/
}
