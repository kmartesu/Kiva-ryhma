/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.entries;

import kivaryhma.services.CharacterEscaper;

/**
 *
 * @author Jonas
 */

public class Book implements Entry{
    private String author="";
    private String title="";
    private String publisher="";
    private String year="";
    private String volume="";
    private String series="";
    private String address="";
    private String edition="";
    private String month="";
    private String note="";
    private String key="";
    private boolean isAuthentic = true;

    @Override
    public String toBibtex() {
        StringBuilder sb = new StringBuilder();
        sb.append("@book{").append(this.key).append(",");
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
        sb.append("\n}\n");
        return CharacterEscaper.filter(sb.toString());
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher.trim().length() == 0) {
            isAuthentic = false;
        } else {
            this.publisher = publisher;
        }
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

    @Override
    public boolean isAuthentic() {
        return isAuthentic;
    }
}
