/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.entries;

/**
 *
 * @author Jonas
 */
public interface Entry {
    public String getEntrytype();

    String toBibtex();
    
    public boolean isAuthentic();

    public String getAuthor();

    public String getYear();

    public String getTitle();
}
