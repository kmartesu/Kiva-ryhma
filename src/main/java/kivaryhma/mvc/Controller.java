package kivaryhma.mvc;

import java.io.FileNotFoundException;
import kivaryhma.entries.Inproceedings;
import kivaryhma.entries.Entry;
import kivaryhma.entries.Book;
import kivaryhma.entries.Article;
import java.util.ArrayList;
import kivaryhma.entries.Masterthesis;
import kivaryhma.entries.Phdthesis;
import kivaryhma.entries.Proceedings;
import org.jbibtex.ParseException;

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
    private String searchWord = "";
    
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

    public void sendPhdthesisFormParameters(String[] fields) {
        Phdthesis p = new Phdthesis();
        p.setAuthor(fields[0]);
        p.setTitle(fields[1]);
        p.setSchool(fields[2]);
        p.setYear(fields[3]);
        p.setType(fields[4]);
        p.setAddress(fields[5]);
        p.setMonth(fields[6]);
        p.setNote(fields[7]);
        p.setKey(fields[8]);

        addReferenceToModel(p);
    }

    public void sendMasterthesisFormParameters(String[] fields) {
        Masterthesis m = new Masterthesis();
        m.setAuthor(fields[0]);
        m.setTitle(fields[1]);
        m.setSchool(fields[2]);
        m.setYear(fields[3]);
        m.setType(fields[4]);
        m.setAddress(fields[5]);
        m.setMonth(fields[6]);
        m.setNote(fields[7]);
        m.setKey(fields[8]);

        addReferenceToModel(m);
    }

    public void sendProceedingsFormParameters(String[] fields) {
        Proceedings p = new Proceedings();
        p.setTitle(fields[0]);
        p.setYear(fields[1]);
        p.setEditor(fields[2]);
        p.setVolume(fields[3]);
        p.setSeries(fields[4]);
        p.setAddress(fields[5]);
        p.setMonth(fields[6]);
        p.setPublisher(fields[7]);
        p.setOrganization(fields[8]);
        p.setNote(fields[9]);
        p.setKey(fields[10]);

        addReferenceToModel(p);
    }

    public void sendBookFormParameters(String[] fields) {
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
        ArrayList<Entry> filtered = new ArrayList<Entry>();
        for(Entry e:model.getReferences()) {
            if(e.toBibtex().contains(searchWord)) filtered.add(e);
        }
        return filtered;
    }

    public ArrayList<Entry> getSelectedEntries() {
        return model.getSelectedReferences();
    }

    public void addReferenceToModel(Entry e) {
        if (!model.addReference(e)) {
            setVirhe("Pakollisia kenttiä täyttämättä!");
        } else {
            setVirhe("");
        }
    }

    public void setVirhe(String virhe) {
        view.getForm().setVirheViesti(virhe);
    }

    public void removeReferences(int array[]) {
        model.removeReferences(array);
    }

    public void addSelectedReferences(int array[]) {
        model.addSelectedReferences(array);
    }

    public void saveToFile(String fileName) throws FileNotFoundException {
   
        model.saveToFile(fileName);
    }
    public void readBiBTeXFile(String fileName) throws FileNotFoundException, ParseException {
        model.readBiBTeXFile(fileName);
    }
    
    public void setSearchWord(String word) {
        searchWord = word;
    }

    public Entry getEntry(int e) {
       return model.getEntry(e);
    }
}
