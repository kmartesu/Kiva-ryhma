/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.entries;

import java.security.spec.ECField;
import kivaryhma.services.CharacterEscaper;

/**
 *
 * @author Jonas
 */
public class Phdthesis implements Entry {
    private String author = ""; 
    private String title = ""; 
    private String school = "";
    private String year = "";
    private String type = "";
    private String address = ""; 
    private String month = "";
    private String note = "";
    private String key = "";
    private boolean isAuthentic = true;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        if (school.trim().length() == 0) {
            isAuthentic = false;
        } else {
            this.school = school;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public String toBibtex() {
        StringBuilder sb = new StringBuilder();
        sb.append("@phdthesis{").append(this.key).append(",");
        sb.append("\nauthor = {").append(this.author).append("},");
        sb.append("\ntitle = {").append(this.title).append("},");
        if (!this.year.isEmpty()) {
            sb.append("\nyear = {").append(this.year).append("},");
        }
        if (!this.address.isEmpty()) {
            sb.append("\naddress = {").append(this.address).append("},");
        }
        if (!this.type.isEmpty()) {
            sb.append("\ntype = {").append(this.type).append("},");
        }
        if (!this.school.isEmpty()) {
            sb.append("\nschool = {").append(this.school).append("},");
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

    @Override
    public boolean isAuthentic() {
        return isAuthentic;
    }

}
