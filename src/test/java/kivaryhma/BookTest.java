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
 * @author Jonas
 */
public class BookTest {
    Book book;
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        book = new Book();
        book.setAddress("address");
        book.setAuthor("author");
        book.setEdition("edition");
        book.setKey("key");
        book.setMonth("month");
        book.setNote("note");
        book.setPublisher("publisher");
        book.setSeries("series");
        book.setTitle("title");
        book.setVolume("volume");
        book.setYear("year");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     * Test of toBibtex method, of class Book.
     */
    @Test
    public void testToBibtex() {
        String test = "@book{key,\nauthor = {author},\ntitle = {title},\npublisher = {publisher},\nvolume = {volume},\nseries = {series},\nyear = {year},\naddress = {address},\nedition = {edition},\nmonth = {month},\nnote = {note},\n}\n"; 
        assertEquals(test, book.toBibtex());
    }

    /**
     * Test of getPublisher method, of class Book.
     */
    @Test
    public void testGetPublisher() {
        assertEquals("publisher", book.getPublisher());
    }

    /**
     * Test of setPublisher method, of class Book.
     */
    @Test
    public void testSetPublisher() {
        assertEquals("publisher",book.getPublisher());
        book.setPublisher("publisher2");
        assertEquals("publisher2",book.getPublisher());
    }

    /**
     * Test of getVolume method, of class Book.
     */
    @Test
    public void testGetVolume() {
        assertEquals("volume", book.getVolume());
    }

    /**
     * Test of setVolume method, of class Book.
     */
    @Test
    public void testSetVolume() {
        assertEquals("volume",book.getVolume());
        book.setVolume("volume2");
        assertEquals("volume2",book.getVolume());
    }

    /**
     * Test of getSeries method, of class Book.
     */
    @Test
    public void testGetSeries() {
        assertEquals("series", book.getSeries());
    }

    /**
     * Test of setSeries method, of class Book.
     */
    @Test
    public void testSetSeries() {
        assertEquals("series",book.getSeries());
        book.setSeries("series2");
        assertEquals("series2",book.getSeries());
    }

    /**
     * Test of getAddress method, of class Book.
     */
    @Test
    public void testGetAddress() {
        assertEquals("address", book.getAddress());
    }

    /**
     * Test of setAddress method, of class Book.
     */
    @Test
    public void testSetAddress() {
        assertEquals("address",book.getAddress());
        book.setAddress("address2");
        assertEquals("address2",book.getAddress());
    }

    /**
     * Test of getEdition method, of class Book.
     */
    @Test
    public void testGetEdition() {
        assertEquals("publisher", book.getPublisher());
    }

    /**
     * Test of setEdition method, of class Book.
     */
    @Test
    public void testSetEdition() {
        assertEquals("edition",book.getEdition());
        book.setEdition("edition2");
        assertEquals("edition2",book.getEdition());
    }

    /**
     * Test of getMonth method, of class Book.
     */
    @Test
    public void testGetMonth() {
        assertEquals("month", book.getMonth());
    }

    /**
     * Test of setMonth method, of class Book.
     */
    @Test
    public void testSetMonth() {
        assertEquals("month",book.getMonth());
        book.setMonth("month2");
        assertEquals("month2",book.getMonth());
    }

    /**
     * Test of getNote method, of class Book.
     */
    @Test
    public void testGetNote() {
        assertEquals("note", book.getNote());
    }

    /**
     * Test of setNote method, of class Book.
     */
    @Test
    public void testSetNote() {
        assertEquals("note",book.getNote());
        book.setNote("note2");
        assertEquals("note2",book.getNote());
    }

    /**
     * Test of getKey method, of class Book.
     */
    @Test
    public void testGetKey() {
        assertEquals("key", book.getKey());
    }

    /**
     * Test of setKey method, of class Book.
     */
    @Test
    public void testSetKey() {
        assertEquals("key",book.getKey());
        book.setKey("key2");
        assertEquals("key2",book.getKey());
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        assertEquals("author", book.getAuthor());
    }

    /**
     * Test of setAuthor method, of class Book.
     */
    @Test
    public void testSetAuthor() {
        assertEquals("author",book.getAuthor());
        book.setAuthor("author2");
        assertEquals("author2",book.getAuthor());
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        assertEquals("title", book.getTitle());
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        assertEquals("title",book.getTitle());
        book.setTitle("title2");
        assertEquals("title2",book.getTitle());
    }

    /**
     * Test of getYear method, of class Book.
     */
    @Test
    public void testGetYear() {
        assertEquals("year", book.getYear());
    }

    /**
     * Test of setYear method, of class Book.
     */
    @Test
    public void testSetYear() {
        assertEquals("year",book.getYear());
        book.setYear("year2");
        assertEquals("year2",book.getYear());
    }
}
