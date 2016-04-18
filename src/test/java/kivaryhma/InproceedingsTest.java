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
public class InproceedingsTest {
    Inproceedings in;
    
    public InproceedingsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        in = new Inproceedings();
        in.setAddress("address");
        in.setAuthor("author");
        in.setBooktitle("booktitle");
//        in.setEdition("edition");
        in.setEditor("editor");
        in.setKey("key");
        in.setMonth("month");
        in.setNote("note");
        in.setOrganization("organization");
        in.setPages("pages");
        in.setPublisher("publisher");
        in.setSeries("series");
        in.setTitle("title");
        in.setVolume("volume");
        in.setYear("year");
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
     * Test of toBibtex method, of class Inproceedings.
     */
    @Test
    public void testToBibtex() {
        String test = "@inproceedings{key,\nauthor = {author},\ntitle = {title},\npublisher = {publisher},\nvolume = {volume},\nseries = {series},\nyear = {year},\naddress = {address},\nbooktitle = {booktitle},\nmonth = {month},\nnote = {note},\npages = {pages},\neditor = {editor},\norganization = {organization},\n}\n";
        assertEquals(test, in.toBibtex());
    }

    /**
     * Test of getPages method, of class Inproceedings.
     */
    @Test
    public void testGetPages() {
        assertEquals("pages", in.getPages());
    }

    /**
     * Test of setPages method, of class Inproceedings.
     */
    @Test
    public void testSetPages() {
        assertEquals("pages",in.getPages());
        in.setPages("pages2");
        assertEquals("pages2",in.getPages());
    }

    /**
     * Test of getAuthor method, of class Inproceedings.
     */
    @Test
    public void testGetAuthor() {
        assertEquals("author", in.getAuthor());
    }

    /**
     * Test of setAuthor method, of class Inproceedings.
     */
    @Test
    public void testSetAuthor() {
        assertEquals("author",in.getAuthor());
        in.setAuthor("author2");
        assertEquals("author2",in.getAuthor());
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        assertEquals("title", in.getTitle());
    }

    /**
     * Test of setTitle method, of class Inproceedings.
     */
    @Test
    public void testSetTitle() {
        assertEquals("title",in.getTitle());
        in.setTitle("title2");
        assertEquals("title2",in.getTitle());
    }

    /**
     * Test of getBooktitle method, of class Inproceedings.
     */
    @Test
    public void testGetBooktitle() {
        assertEquals("booktitle", in.getBooktitle());
    }

    /**
     * Test of setBooktitle method, of class Inproceedings.
     */
    @Test
    public void testSetBooktitle() {
        assertEquals("booktitle",in.getBooktitle());
        in.setBooktitle("booktitle2");
        assertEquals("booktitle2",in.getBooktitle());
    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {
        assertEquals("year", in.getYear());
    }

    /**
     * Test of setYear method, of class Inproceedings.
     */
    @Test
    public void testSetYear() {
        assertEquals("year",in.getYear());
        in.setYear("year2");
        assertEquals("year2",in.getYear());
    }

    /**
     * Test of getEditor method, of class Inproceedings.
     */
    @Test
    public void testGetEditor() {
        assertEquals("editor", in.getEditor());
    }

    /**
     * Test of setEditor method, of class Inproceedings.
     */
    @Test
    public void testSetEditor() {
        assertEquals("editor",in.getEditor());
        in.setEditor("editor2");
        assertEquals("editor2",in.getEditor());
    }

    /**
     * Test of getVolume method, of class Inproceedings.
     */
    @Test
    public void testGetVolume() {
        assertEquals("volume", in.getVolume());
    }

    /**
     * Test of setVolume method, of class Inproceedings.
     */
    @Test
    public void testSetVolume() {
        assertEquals("volume",in.getVolume());
        in.setVolume("volume2");
        assertEquals("volume2",in.getVolume());
    }

    /**
     * Test of getSeries method, of class Inproceedings.
     */
    @Test
    public void testGetSeries() {
        assertEquals("series", in.getSeries());
    }

    /**
     * Test of setSeries method, of class Inproceedings.
     */
    @Test
    public void testSetSeries() {
        assertEquals("series",in.getSeries());
        in.setSeries("series2");
        assertEquals("series2",in.getSeries());
    }

    /**
     * Test of getAddress method, of class Inproceedings.
     */
    @Test
    public void testGetAddress() {
        assertEquals("address", in.getAddress());
    }

    /**
     * Test of setAddress method, of class Inproceedings.
     */
    @Test
    public void testSetAddress() {
        assertEquals("address",in.getAddress());
        in.setAddress("address2");
        assertEquals("address2",in.getAddress());
    }

    /**
     * Test of getEdition method, of class Inproceedings.
     */
//    @Test
//    public void testGetEdition() {
//       assertEquals("edition", in.getEdition());
//    }

    /**
     * Test of setEdition method, of class Inproceedings.
     */
//    @Test
//    public void testSetEdition() {
//        assertEquals("edition",in.getEdition());
//        in.setEdition("edition2");
//        assertEquals("edition2",in.getEdition());
//    }

    /**
     * Test of getMonth method, of class Inproceedings.
     */
    @Test
    public void testGetMonth() {
        assertEquals("month", in.getMonth());
    }

    /**
     * Test of setMonth method, of class Inproceedings.
     */
    @Test
    public void testSetMonth() {
        assertEquals("month",in.getMonth());
        in.setMonth("month2");
        assertEquals("month2",in.getMonth());
    }

    /**
     * Test of getOrganization method, of class Inproceedings.
     */
    @Test
    public void testGetOrganization() {
        assertEquals("organization", in.getOrganization());
    }

    /**
     * Test of setOrganization method, of class Inproceedings.
     */
    @Test
    public void testSetOrganization() {
        assertEquals("organization",in.getOrganization());
        in.setOrganization("organization2");
        assertEquals("organization2",in.getOrganization());
    }

    /**
     * Test of getPublisher method, of class Inproceedings.
     */
    @Test
    public void testGetPublisher() {
        assertEquals("publisher", in.getPublisher());
    }

    /**
     * Test of setPublisher method, of class Inproceedings.
     */
    @Test
    public void testSetPublisher() {
        assertEquals("publisher",in.getPublisher());
        in.setPublisher("publisher2");
        assertEquals("publisher2",in.getPublisher());
    }

    /**
     * Test of getNote method, of class Inproceedings.
     */
    @Test
    public void testGetNote() {
        assertEquals("note", in.getNote());
    }

    /**
     * Test of setNote method, of class Inproceedings.
     */
    @Test
    public void testSetNote() {
        assertEquals("note",in.getNote());
        in.setNote("note2");
        assertEquals("note2",in.getNote());
    }

    /**
     * Test of getKey method, of class Inproceedings.
     */
    @Test
    public void testGetKey() {
        assertEquals("key", in.getKey());
    }

    /**
     * Test of setKey method, of class Inproceedings.
     */
    @Test
    public void testSetKey() {
        assertEquals("key",in.getKey());
        in.setKey("key2");
        assertEquals("key2",in.getKey());
    }
}
