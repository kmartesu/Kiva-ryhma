/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hyttijan
 */
public class ModelTest {
    private Model model;
    public ModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.model = new Model();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addReference method, of class Model.
     */
    @Test
    public void testAddReference() {
        Article article = new Article();
        article.setAuthor("author");
        article.setJournal("journal");
        article.setNote("note");
        article.setVolume("volume");
        article.setPages("pages");
        article.setKey("key");
        article.setYear("year");
        article.setTitle("title");
        article.setMonth("month");
        article.setNumber("number");
        model.addReference(article);
        assertTrue(model.getReferences().size()==1);
        assertTrue(model.getReferences().contains(article));
    }

    /**
     * Test of getReferences method, of class Model.
     */
    @Test
    public void testGetReferences() {
        
    }
    //Toteutetaan myöhemmin kun saveToFile metodi on valmis
    /**
     * Test of saveToFile method, of class Model.
     */
    /**@Test
    public void testSaveToFile() {
       
    }**/
    
}
