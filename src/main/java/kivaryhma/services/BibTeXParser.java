/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;
import kivaryhma.entries.*;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.ParseException;
import org.jbibtex.Value;

/**
 *
 * @author ile
 */
public class BibTeXParser {

    public ArrayList<Entry> readBibtex(String filename) throws ParseException, FileNotFoundException {
        org.jbibtex.BibTeXParser bibtexParser = new org.jbibtex.BibTeXParser();
        Reader reader = new FileReader(filename);

        BibTeXDatabase db = bibtexParser.parse(reader);
        Map<Key, BibTeXEntry> entries = db.getEntries();
        ArrayList<Entry> entrylist = new ArrayList<Entry>();
        for (Map.Entry<Key, BibTeXEntry> entry : entries.entrySet()) {

            if (entry.getValue().getType().toString().equals("article")) {
                entrylist.add(parseArticle(entry.getValue(), entry.getKey()));
            }
            if (entry.getValue().getType().toString().equals("book")) {
                entrylist.add(parseBook(entry.getValue(), entry.getKey()));
            }
            if (entry.getValue().getType().toString().equals("inproceedings")) {
                entrylist.add(parseInproceedings(entry.getValue(), entry.getKey()));
            }
            if (entry.getValue().getType().toString().equals("masterthesis")) {
                entrylist.add(parseMasterthesis(entry.getValue(), entry.getKey()));
            }
            if (entry.getValue().getType().toString().equals("phdthesis")) {
                entrylist.add(parsePhdthesis(entry.getValue(), entry.getKey()));
            }
            if (entry.getValue().getType().toString().equals("proceedings")) {
                entrylist.add(parseProceedings(entry.getValue(), entry.getKey()));
            }
        }
        return entrylist;
    }

    public Entry parseArticle(BibTeXEntry article, Key key) {
        Map<Key, Value> fields = article.getFields();
        Article at = new Article();
        for (Map.Entry<Key, Value> entry : fields.entrySet()) {
            if (entry.getKey().toString().equals("author")) {
                at.setAuthor(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("title")) {
                at.setTitle(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("journal")) {
                at.setJournal(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("year")) {
                at.setYear(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("volume")) {
                at.setVolume(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("number")) {
                at.setNumber(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("pages")) {
                at.setPages(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("month")) {
                at.setMonth(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("note")) {
                at.setNote(entry.getValue().toUserString());
            }

        }
        at.setKey(key.toString());
        return at;
    }

    private Entry parseBook(BibTeXEntry value, Key key) {
        Map<Key, Value> fields = value.getFields();
        Book book = new Book();
        for (Map.Entry<Key, Value> entry : fields.entrySet()) {
            if (entry.getKey().toString().equals("author")) {
                book.setAuthor(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("title")) {
                book.setTitle(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("publisher")) {
                book.setPublisher(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("year")) {
                book.setYear(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("volume")) {
                book.setVolume(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("series")) {
                book.setSeries(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("address")) {
                book.setAddress(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("edition")) {
                book.setEdition(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("month")) {
                book.setMonth(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("note")) {
                book.setNote(entry.getValue().toUserString());
            }

        }
        book.setKey(key.toString());
        return book;
    }

    private Entry parseInproceedings(BibTeXEntry value, Key key) {
        Map<Key, Value> fields = value.getFields();
        Inproceedings inproceedings = new Inproceedings();
        for (Map.Entry<Key, Value> entry : fields.entrySet()) {
            if (entry.getKey().toString().equals("author")) {
                inproceedings.setAuthor(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("title")) {
                inproceedings.setTitle(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("booktitle")) {
                inproceedings.setBooktitle(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("year")) {
                inproceedings.setYear(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("editor")) {
                inproceedings.setEditor(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("volume")) {
                inproceedings.setVolume(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("series")) {
                inproceedings.setSeries(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("address")) {
                inproceedings.setAddress(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("month")) {
                inproceedings.setMonth(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("organization")) {
                inproceedings.setOrganization(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("publisher")) {
                inproceedings.setPublisher(entry.getValue().toUserString());
            }

            if (entry.getKey().toString().equals("note")) {
                inproceedings.setNote(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("pages")) {
                inproceedings.setPages(entry.getValue().toUserString());
            }

        }
        inproceedings.setKey(key.toString());
        return inproceedings;
    }

    private Entry parseMasterthesis(BibTeXEntry value, Key key) {
        Map<Key, Value> fields = value.getFields();
        Masterthesis masterthesis = new Masterthesis();
        for (Map.Entry<Key, Value> entry : fields.entrySet()) {
            if (entry.getKey().toString().equals("author")) {
                masterthesis.setAuthor(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("title")) {
                masterthesis.setTitle(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("school")) {
                masterthesis.setSchool(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("year")) {
                masterthesis.setYear(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("type")) {
                masterthesis.setType(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("address")) {
                masterthesis.setAddress(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("month")) {
                masterthesis.setMonth(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("note")) {
                masterthesis.setNote(entry.getValue().toUserString());
            }

        }
        masterthesis.setKey(key.toString());
        return masterthesis;
    }

    private Entry parsePhdthesis(BibTeXEntry value, Key key) {
        Map<Key, Value> fields = value.getFields();
        Phdthesis phdthesis = new Phdthesis();
        for (Map.Entry<Key, Value> entry : fields.entrySet()) {
            if (entry.getKey().toString().equals("author")) {
                phdthesis.setAuthor(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("title")) {
                phdthesis.setTitle(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("school")) {
                phdthesis.setSchool(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("year")) {
                phdthesis.setYear(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("type")) {
                phdthesis.setType(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("address")) {
                phdthesis.setAddress(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("month")) {
                phdthesis.setMonth(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("note")) {
                phdthesis.setNote(entry.getValue().toUserString());
            }

        }
        phdthesis.setKey(key.toString());
        return phdthesis;
    }

    private Entry parseProceedings(BibTeXEntry value, Key key) {
        Map<Key, Value> fields = value.getFields();
        Proceedings proceedings = new Proceedings();
        for (Map.Entry<Key, Value> entry : fields.entrySet()) {
            if (entry.getKey().toString().equals("title")) {
                proceedings.setTitle(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("year")) {
                proceedings.setYear(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("editor")) {
                proceedings.setEditor(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("volume")) {
                proceedings.setVolume(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("series")) {
                proceedings.setSeries(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("address")) {
                proceedings.setAddress(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("month")) {
                proceedings.setMonth(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("publisher")) {
                proceedings.setPublisher(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("organization")) {
                proceedings.setOrganization(entry.getValue().toUserString());
            }
            if (entry.getKey().toString().equals("note")) {
                proceedings.setNote(entry.getValue().toUserString());
            }

        }
        proceedings.setKey(key.toString());
        return proceedings;
    }
}
