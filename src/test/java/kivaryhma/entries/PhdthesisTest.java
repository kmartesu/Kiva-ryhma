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
public class PhdthesisTest {
    Phdthesis phd;
    
    public PhdthesisTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        phd = new Phdthesis();
        phd.setAddress("address");
        phd.setAuthor("author");
        phd.setSchool("school");
        phd.setType("type");
        phd.setKey("key");
        phd.setMonth("month");
        phd.setNote("note");
        phd.setTitle("title");
        phd.setYear("year");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toBibtex method, of class Phdthesis.
     */
    @Test
    public void testToBibtex() {
        String test = "@phdthesis{key,\nauthor = {author},\ntitle = {title},\nyear = {year},\naddress = {address},\ntype = {type},\nschool = {school},\nmonth = {month},\nnote = {note},\n}\n"; 
        assertEquals(test, phd.toBibtex());
    }

    /**
     * Test of getSchool method, of class Phdthesis.
     */
    @Test
    public void testGetSchool() {
        assertEquals("school", phd.getSchool());
    }

    /**
     * Test of setSchool method, of class Phdthesis.
     */
    @Test
    public void testSetSchool() {
        assertEquals("school",phd.getSchool());
        phd.setSchool("school2");
        assertEquals("school2",phd.getSchool());
    }

    /**
     * Test of getType method, of class Phdthesis.
     */
    @Test
    public void testGetType() {
        assertEquals("type", phd.getType());
    }

    /**
     * Test of setType method, of class Phdthesis.
     */
    @Test
    public void testSetType() {
        assertEquals("type",phd.getType());
        phd.setType("type2");
        assertEquals("type2",phd.getType());
    }


    /**
     * Test of getAddress method, of class Phdthesis.
     */
    @Test
    public void testGetAddress() {
        assertEquals("address", phd.getAddress());
    }

    /**
     * Test of setAddress method, of class Phdthesis.
     */
    @Test
    public void testSetAddress() {
        assertEquals("address",phd.getAddress());
        phd.setAddress("address2");
        assertEquals("address2",phd.getAddress());
    }

    /**
     * Test of getMonth method, of class Phdthesis.
     */
    @Test
    public void testGetMonth() {
        assertEquals("month", phd.getMonth());
    }

    /**
     * Test of setMonth method, of class Phdthesis.
     */
    @Test
    public void testSetMonth() {
        assertEquals("month",phd.getMonth());
        phd.setMonth("month2");
        assertEquals("month2",phd.getMonth());
    }

    /**
     * Test of getNote method, of class Phdthesis.
     */
    @Test
    public void testGetNote() {
        assertEquals("note", phd.getNote());
    }

    /**
     * Test of setNote method, of class Phdthesis.
     */
    @Test
    public void testSetNote() {
        assertEquals("note",phd.getNote());
        phd.setNote("note2");
        assertEquals("note2",phd.getNote());
    }

    /**
     * Test of getKey method, of class Phdthesis.
     */
    @Test
    public void testGetKey() {
        assertEquals("key", phd.getKey());
    }

    /**
     * Test of setKey method, of class Phdthesis.
     */
    @Test
    public void testSetKey() {
        assertEquals("key",phd.getKey());
        phd.setKey("key2");
        assertEquals("key2",phd.getKey());
    }

    /**
     * Test of getAuthor method, of class Phdthesis.
     */
    @Test
    public void testGetAuthor() {
        assertEquals("author", phd.getAuthor());
    }

    /**
     * Test of setAuthor method, of class Phdthesis.
     */
    @Test
    public void testSetAuthor() {
        assertEquals("author",phd.getAuthor());
        phd.setAuthor("author2");
        assertEquals("author2",phd.getAuthor());
    }

    /**
     * Test of getTitle method, of class Phdthesis.
     */
    @Test
    public void testGetTitle() {
        assertEquals("title", phd.getTitle());
    }

    /**
     * Test of setTitle method, of class Phdthesis.
     */
    @Test
    public void testSetTitle() {
        assertEquals("title",phd.getTitle());
        phd.setTitle("title2");
        assertEquals("title2",phd.getTitle());
    }

    /**
     * Test of getYear method, of class Phdthesis.
     */
    @Test
    public void testGetYear() {
        assertEquals("year", phd.getYear());
    }

    /**
     * Test of setYear method, of class Phdthesis.
     */
    @Test
    public void testSetYear() {
        assertEquals("year",phd.getYear());
        phd.setYear("year2");
        assertEquals("year2",phd.getYear());
    }
    

}
