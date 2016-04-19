package kivaryhma;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author toffe
 */
public class Article implements Entry {

    private String author="";
    private String title="";
    private String journal="";
    private String year="";
    private String volume="";
    private String number="";
    private String pages="";
    private String month="";
    private String note="";
    private String key="";
    private boolean isAuthentic = true;

    public Article() {
        //Toistaiseksi kaikki arvot Stringejä
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.trim().length() == 0) {
            isAuthentic = false;
        } else {
            this.author = author;
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.trim().length() == 0) {
            isAuthentic = false;
        } else {
            this.title = title;
        }
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        if (journal.trim().length() == 0) {
            isAuthentic = false;
        } else {
            this.journal = journal;
        }
    }

    @Override
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if (year.trim().length() == 0) {
            isAuthentic = false;
        } else {
            this.year = year;
        }
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        if (volume.trim().length() == 0) {
            isAuthentic = false;
        } else {
            this.volume = volume;
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean isAuthentic() {
        return isAuthentic;
    }

    @Override
    public String toBibtex() {
        //Tähän vois varmaan keksii jonkun paremmankin ratkasun.
        StringBuilder sb = new StringBuilder();
        sb.append("@article{").append(this.key).append(",");
        sb.append("\nauthor = {").append(this.author).append("},");
        sb.append("\njournal = {").append(this.journal).append("},");
        sb.append("\ntitle = {").append(this.title).append("},");
        sb.append("\nyear = {").append(this.year).append("},");
        sb.append("\nvolume = {").append(this.volume).append("},");
        if (!this.number.isEmpty()) {
            sb.append("\nnumber = {").append(this.number).append("},");
        }
        if (!this.pages.isEmpty()) {
            sb.append("\npages = {").append(this.pages).append("},");
        }
        if (!this.month.isEmpty()) {
            sb.append("\nmonth = {").append(this.month).append("},");
        }
        if (!this.note.isEmpty()) {
            sb.append("\nnote = {").append(this.note).append("},");
        }

        sb.append("\n}\n");
        
        return CharacterEscaper.filter(sb.toString());
    }

}
