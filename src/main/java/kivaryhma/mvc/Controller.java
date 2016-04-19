package kivaryhma.mvc;

import kivaryhma.entries.Inproceedings;
import kivaryhma.entries.Entry;
import kivaryhma.entries.Book;
import kivaryhma.entries.Article;
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
        
        addReferenceToModel(a);
    }
    
    public void sendBookFormParameters (String[] fields) {
        Book b = new Book();
        b.setAuthor(fields[0]);
        b.setTitle(fields[1]);
        b.setPublisher(fields[2]);
        b.setYear(fields[3]);
        b.setVolume(fields[4]);
        b.setSeries(fields[5]);
        b.setAddress(fields[6]);
        b.setEdition(fields[7]);
        b.setMonth(fields[8]);
        b.setNote(fields[9]);
        b.setKey(fields[10]);
        
        addReferenceToModel(b);
    }
    
    public void sendInproceedingsFormParameters(String[] fields) {
        Inproceedings i = new Inproceedings();
        i.setAuthor(fields[0]);
        i.setTitle(fields[1]);
        i.setBooktitle(fields[2]);
        i.setYear(fields[3]);
        i.setEditor(fields[4]);
        i.setVolume(fields[5]);
        i.setSeries(fields[6]);
        i.setPages(fields[7]);
        i.setAddress(fields[8]);
        i.setMonth(fields[9]);
        i.setOrganization(fields[10]);
        i.setPublisher(fields[11]);
        i.setNote(fields[12]);
        i.setKey(fields[13]);
        
        addReferenceToModel(i);
    }
    
    public ArrayList<Entry> getEntries() {
        return model.getReferences();
    }
    
    public void addReferenceToModel(Entry e) {
        if(!model.addReference(e)) {
            setVirhe("Pakollisia kenttiä täyttämättä!");
        }
        else {
            setVirhe("");
        }
    }
    
    public void setVirhe(String virhe) {
        view.getForm().setVirheViesti(virhe);
    }
}
