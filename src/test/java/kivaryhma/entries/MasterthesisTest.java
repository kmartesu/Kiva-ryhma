/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.entries;

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
public class MasterthesisTest {
    Masterthesis master;
    
    public MasterthesisTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        master = new Masterthesis();
        master.setAddress("address");
        master.setAuthor("author");
        master.setSchool("school");
        master.setType("type");
        master.setKey("key");
        master.setMonth("month");
        master.setNote("note");
        master.setTitle("title");
        master.setYear("year");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toBibtex method, of class Masterthesis.
     */
    @Test
    public void testToBibtex() {
        String test = "@masterthesis{key,\nauthor = {author},\ntitle = {title},\nyear = {year},\naddress = {address},\ntype = {type},\nschool = {school},\nmonth = {month},\nnote = {note},\n}\n"; 
        assertEquals(test, master.toBibtex());
    }

    /**
     * Test of getSchool method, of class Masterthesis.
     */
    @Test
    public void testGetSchool() {
        assertEquals("school", master.getSchool());
    }

    /**
     * Test of setSchool method, of class Masterthesis.
     */
    @Test
    public void testSetSchool() {
        assertEquals("school",master.getSchool());
        master.setSchool("school2");
        assertEquals("school2",master.getSchool());
    }

    /**
     * Test of getType method, of class Masterthesis.
     */
    @Test
    public void testGetType() {
        assertEquals("type", master.getType());
    }

    /**
     * Test of setType method, of class Masterthesis.
     */
    @Test
    public void testSetType() {
        assertEquals("type",master.getType());
        master.setType("type2");
        assertEquals("type2",master.getType());
    }


    /**
     * Test of getAddress method, of class Masterthesis.
     */
    @Test
    public void testGetAddress() {
        assertEquals("address", master.getAddress());
    }

    /**
     * Test of setAddress method, of class Masterthesis.
     */
    @Test
    public void testSetAddress() {
        assertEquals("address",master.getAddress());
        master.setAddress("address2");
        assertEquals("address2",master.getAddress());
    }

    /**
     * Test of getMonth method, of class Masterthesis.
     */
    @Test
    public void testGetMonth() {
        assertEquals("month", master.getMonth());
    }

    /**
     * Test of setMonth method, of class Masterthesis.
     */
    @Test
    public void testSetMonth() {
        assertEquals("month",master.getMonth());
        master.setMonth("month2");
        assertEquals("month2",master.getMonth());
    }

    /**
     * Test of getNote method, of class Masterthesis.
     */
    @Test
    public void testGetNote() {
        assertEquals("note", master.getNote());
    }

    /**
     * Test of setNote method, of class Masterthesis.
     */
    @Test
    public void testSetNote() {
        assertEquals("note",master.getNote());
        master.setNote("note2");
        assertEquals("note2",master.getNote());
    }

    /**
     * Test of getKey method, of class Masterthesis.
     */
    @Test
    public void testGetKey() {
        assertEquals("key", master.getKey());
    }

    /**
     * Test of setKey method, of class Masterthesis.
     */
    @Test
    public void testSetKey() {
        assertEquals("key",master.getKey());
        master.setKey("key2");
        assertEquals("key2",master.getKey());
    }

    /**
     * Test of getAuthor method, of class Masterthesis.
     */
    @Test
    public void testGetAuthor() {
        assertEquals("author", master.getAuthor());
    }

    /**
     * Test of setAuthor method, of class Masterthesis.
     */
    @Test
    public void testSetAuthor() {
        assertEquals("author",master.getAuthor());
        master.setAuthor("author2");
        assertEquals("author2",master.getAuthor());
    }

    /**
     * Test of getTitle method, of class Masterthesis.
     */
    @Test
    public void testGetTitle() {
        assertEquals("title", master.getTitle());
    }

    /**
     * Test of setTitle method, of class Masterthesis.
     */
    @Test
    public void testSetTitle() {
        assertEquals("title",master.getTitle());
        master.setTitle("title2");
        assertEquals("title2",master.getTitle());
    }

    /**
     * Test of getYear method, of class Masterthesis.
     */
    @Test
    public void testGetYear() {
        assertEquals("year", master.getYear());
    }

    /**
     * Test of setYear method, of class Masterthesis.
     */
    @Test
    public void testSetYear() {
        assertEquals("year",master.getYear());
        master.setYear("year2");
        assertEquals("year2",master.getYear());
    }
}
