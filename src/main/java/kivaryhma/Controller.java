package kivaryhma;

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
public class Controller {
    
    private Model model;
    private View view;
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
    //Voisiko tämän toteutta kauniimmin?
    public void sendArticleFormParameters(String[] fields) {
        Article a = new Article();
        a.setAuthor(fields[0]);
        a.setTitle(fields[1]);
        a.setJournal(fields[2]);
        a.setYear(fields[3]);
        a.setVolume(fields[4]);
        a.setNumber(fields[5]);
        a.setPages(fields[6]);
        a.setMonth(fields[7]);
        a.setNote(fields[8]);
        a.setKey(fields[9]);
        
        model.addReference(a);
    }
    
    public ArrayList<Article> getArticles() {
        return model.getReferences();
    }
}
