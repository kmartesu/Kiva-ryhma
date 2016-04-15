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
public interface Entry {

    String toBibtex();
    
    public String getYear();
    
    public String getAuthor();
    
    public String getTitle();
    
}
