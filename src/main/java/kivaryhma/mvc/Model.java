package kivaryhma.mvc;


import kivaryhma.entries.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

    public void removeReferences(int array[]) {
        for(int i=array.length-1;i>=0;i--){
            this.references.remove(array[i]);
        }
    }
    
    
    public void saveToFile(String fileName) throws FileNotFoundException {
         
            PrintWriter writer = new PrintWriter(fileName);
            for (Entry reference : this.references) {
                writer.println(reference.toBibtex());
            }
            writer.close();
     
    }
    
}
