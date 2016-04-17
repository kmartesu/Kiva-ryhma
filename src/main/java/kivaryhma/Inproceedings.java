/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma;

/**
 *
 * @author Jonas
 */
public class Inproceedings implements Entry{
    private String author;
    private String title;
    private String booktitle;
    private String year;
    private String editor;
    private String volume;
    private String series;
    private String address;
    private String edition;
    private String month;
    private String organization;
    private String publisher;
    private String note;
    private String key;
    private String pages;
    private boolean isAuthentic = true;
    
        @Override

    public String toBibtex() {
        StringBuilder sb = new StringBuilder();
        sb.append("@inproceedings{").append(this.key).append(",");
        sb.append("\nauthor = {").append(this.author).append("},");
        sb.append("\ntitle = {").append(this.title).append("},");
        if (!this.publisher.isEmpty()) {
            sb.append("\npublisher = {").append(this.publisher).append("},");
        }
        if (!this.volume.isEmpty()) {
            sb.append("\nvolume = {").append(this.volume).append("},");
        }
        if (!this.series.isEmpty()) {
            sb.append("\nseries = {").append(this.series).append("},");
        }
        if (!this.year.isEmpty()) {
            sb.append("\nyear = {").append(this.year).append("},");
        }
        if (!this.address.isEmpty()) {
            sb.append("\naddress = {").append(this.address).append("},");
        }
        if (!this.edition.isEmpty()) {
            sb.append("\nedition = {").append(this.edition).append("},");
        }
        if (!this.month.isEmpty()) {
            sb.append("\nmonth = {").append(this.month).append("},");
        }
        if (!this.note.isEmpty()) {
            sb.append("\nnote = {").append(this.note).append("},");
        }
        if (!this.key.isEmpty()) {
            sb.append("\nkey = {").append(this.key).append("},");
        }
        if (!this.organization.isEmpty()) {
            sb.append("\norganization = {").append(this.organization).append("},");
        }
        sb.append("\n}\n");
        //publisher, address?
        return sb.toString();
    }

    public String getPages() {
        return pages;
    }
    
    public void setPages(String pages) {
        this.pages = pages;
    }
    
    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.trim().length()==0) {
            isAuthentic = false;
        }
        else {
            this.author = author;
        }
    }
    
    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.trim().length()==0) {
            isAuthentic = false;
        }
        else {
            this.title = title;
        }
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        if(booktitle.trim().length()==0) {
            isAuthentic = false;
        }
        else{
            this.booktitle = booktitle;
        }
    }

    @Override
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if(year.trim().length()==0) {
            isAuthentic = false;
        }
        else {
            this.year = year;
        }
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
}
