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
public class ArticleTest {
        Article article;
    public ArticleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        article = new Article();
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
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAuthor method, of class Article.
     */
    @Test
    public void testGetAuthor() {
       assertEquals("author",article.getAuthor());
    }

    /**
     * Test of setAuthor method, of class Article.
     */
    @Test
    public void testSetAuthor() {
        
        assertEquals("author",article.getAuthor());
        article.setAuthor("author2");
        assertEquals("author2",article.getAuthor());
    }

    /**
     * Test of getTitle method, of class Article.
     */
    @Test
    public void testGetTitle() {
        assertEquals("title",article.getTitle());
      
    }

    /**
     * Test of setTitle method, of class Article.
     */
    @Test
    public void testSetTitle() {
        assertEquals("title",article.getTitle());
        article.setTitle("title2");
        assertEquals("title2",article.getTitle());
    }

    /**
     * Test of getJournal method, of class Article.
     */
    @Test
    public void testGetJournal() {
        
        
        assertEquals("journal",article.getJournal());
        
    }

    /**
     * Test of setJournal method, of class Article.
     */
    @Test
    public void testSetJournal() {
        assertEquals("journal",article.getJournal());
        article.setJournal("journal2");
        assertEquals("journal2",article.getJournal());

    }

    /**
     * Test of getYear method, of class Article.
     */
    @Test
    public void testGetYear() {
        assertEquals("year",article.getYear());
    }

    /**
     * Test of setYear method, of class Article.
     */
    @Test
    public void testSetYear() {
        assertEquals("year",article.getYear());
        article.setYear("year2");
        assertEquals("year2",article.getYear());
    }

    /**
     * Test of getVolume method, of class Article.
     */
    @Test
    public void testGetVolume() {
       assertEquals("volume",article.getVolume());
    }

    /**
     * Test of setVolume method, of class Article.
     */
    @Test
    public void testSetVolume() {
       assertEquals("volume",article.getVolume());
       article.setVolume("volume2");
       assertEquals("volume2",article.getVolume());
    }

    /**
     * Test of getNumber method, of class Article.
     */
    @Test
    public void testGetNumber() {
        assertEquals("number",article.getNumber());
    }

    /**
     * Test of setNumber method, of class Article.
     */
    @Test
    public void testSetNumber() {
        assertEquals("number",article.getNumber());
        article.setNumber("number2");
        assertEquals("number2",article.getNumber());
    }

    /**
     * Test of getPages method, of class Article.
     */
    @Test
    public void testGetPages() {
       assertEquals("pages",article.getPages());
    }

    /**
     * Test of setPages method, of class Article.
     */
    @Test
    public void testSetPages() {
        assertEquals("pages",article.getPages());
        article.setPages("pages2");
        assertEquals("pages2",article.getPages());
    }

    /**
     * Test of getMonth method, of class Article.
     */
    @Test
    public void testGetMonth() {
        assertEquals("month",article.getMonth());
    }

    /**
     * Test of setMonth method, of class Article.
     */
    @Test
    public void testSetMonth() {
       assertEquals("month",article.getMonth());
       article.setMonth("month2");
       assertEquals("month2",article.getMonth());
    }

    /**
     * Test of getNote method, of class Article.
     */
    @Test
    public void testGetNote() {
        assertEquals("note",article.getNote());
        
    }

    /**
     * Test of setNote method, of class Article.
     */
    @Test
    public void testSetNote() {
        assertEquals("note",article.getNote());
        article.setNote("note2");
        assertEquals("note2",article.getNote());
    }

    /**
     * Test of getKey method, of class Article.
     */
    @Test
    public void testGetKey() {
        assertEquals("key",article.getKey());
        
    }

    /**
     * Test of setKey method, of class Article.
     */
    @Test
    public void testSetKey() {
        assertEquals("key",article.getKey());
        article.setKey("key2");
        assertEquals("key2",article.getKey());
    }
    
}
