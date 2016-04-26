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

    String toBibtex();
    
    boolean isAuthentic();

    String getAuthor();

    String getYear();

    String getTitle();
}
