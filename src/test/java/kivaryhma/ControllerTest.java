/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma;

import java.util.ArrayList;
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
public class ControllerTest {
    private View view;
    private Model model;
    private Controller controller;
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        view.registerController(controller);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sendFormParameters method, of class Controller.
     */
    @Test
    public void testSendFormParameters() {
        String[] fields = {"Author","Title","Journal","Year","Volume","Number","Pages","Month","Note","Key"};
        controller.sendArticleFormParameters(fields);
        Article article = (Article) controller.getEntries().get(0);
        assertEquals(article.getAuthor(),fields[0]);
        assertEquals(article.getTitle(),fields[1]);
        assertEquals(article.getJournal(),fields[2]);
        assertEquals(article.getYear(),fields[3]);
        assertEquals(article.getVolume(),fields[4]);
        assertEquals(article.getNumber(),fields[5]);
        assertEquals(article.getPages(),fields[6]);
        assertEquals(article.getMonth(),fields[7]);
        assertEquals(article.getNote(),fields[8]);
        assertEquals(article.getKey(),fields[9]);
      
    }

    /**
     * Test of getArticles method, of class Controller.
     */
    @Test
    public void testGetArticles() {
        String[] fields = {"Author","Title","Journal","Year","Volume","Number","Pages","Month","Note","Key"};
        String[] fields2 = {"Author2","Title2","Journal2","Year2","Volume2","Number2","Pages2","Month2","Note2","Key2"};
        controller.sendArticleFormParameters(fields);
        controller.sendArticleFormParameters(fields2);
        ArrayList<Entry> articles = controller.getEntries();
        assertTrue(articles.size()==2);
        Article article =(Article) articles.get(0);
        Article article2 =(Article) articles.get(1);
        assertEquals(article.getAuthor(),fields[0]);
        assertEquals(article.getTitle(),fields[1]);
        assertEquals(article.getJournal(),fields[2]);
        assertEquals(article.getYear(),fields[3]);
        assertEquals(article.getVolume(),fields[4]);
        assertEquals(article.getNumber(),fields[5]);
        assertEquals(article.getPages(),fields[6]);
        assertEquals(article.getMonth(),fields[7]);
        assertEquals(article.getNote(),fields[8]);
        assertEquals(article.getKey(),fields[9]);
        assertEquals(article2.getAuthor(),fields2[0]);
        assertEquals(article2.getTitle(),fields2[1]);
        assertEquals(article2.getJournal(),fields2[2]);
        assertEquals(article2.getYear(),fields2[3]);
        assertEquals(article2.getVolume(),fields2[4]);
        assertEquals(article2.getNumber(),fields2[5]);
        assertEquals(article2.getPages(),fields2[6]);
        assertEquals(article2.getMonth(),fields2[7]);
        assertEquals(article2.getNote(),fields2[8]);
        assertEquals(article2.getKey(),fields2[9]);
       
    }
    
}
