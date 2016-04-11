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
    
    private ArrayList<Article> references = new ArrayList<Article>();
    private File referenceFile;
    
    public Model() {}
    
    public void addReference(Article article) {
        references.add(article);
    }
    
    public ArrayList<Article> getReferences() {
        return references;
    }
    /**
    public void saveToFile() {
        //Ei toteutettu vielä
    }
    **/
}
