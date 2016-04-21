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
public class ProceedingsTest {
    Proceedings proc;
    
    public ProceedingsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        proc = new Proceedings();
        proc.setAddress("address");
        proc.setEditor("editor");
        proc.setKey("key");
        proc.setMonth("month");
        proc.setNote("note");
        proc.setOrganization("organization");
        proc.setPublisher("publisher");
        proc.setSeries("series");
        proc.setTitle("title");
        proc.setVolume("volume");
        proc.setYear("year");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testToBibtex() {
        String test = "@proceedings{key,\ntitle = {title},\npublisher = {publisher},\nvolume = {volume},\nseries = {series},\nyear = {year},\naddress = {address},\nmonth = {month},\nnote = {note},\neditor = {editor},\norganization = {organization},\n}\n";
        assertEquals(test, proc.toBibtex());
    }

    /**
     * Test of getTitle method, of class Proceedings.
     */
    @Test
    public void testGetTitle() {
        assertEquals("title", proc.getTitle());
    }

    /**
     * Test of setTitle method, of class Proceedings.
     */
    @Test
    public void testSetTitle() {
        assertEquals("title",proc.getTitle());
        proc.setTitle("title2");
        assertEquals("title2",proc.getTitle());
    }


    /**
     * Test of getYear method, of class Proceedings.
     */
    @Test
    public void testGetYear() {
        assertEquals("year", proc.getYear());
    }

    /**
     * Test of setYear method, of class Proceedings.
     */
    @Test
    public void testSetYear() {
        assertEquals("year",proc.getYear());
        proc.setYear("year2");
        assertEquals("year2",proc.getYear());
    }

    /**
     * Test of getEditor method, of class Proceedings.
     */
    @Test
    public void testGetEditor() {
        assertEquals("editor", proc.getEditor());
    }

    /**
     * Test of setEditor method, of class Proceedings.
     */
    @Test
    public void testSetEditor() {
        assertEquals("editor",proc.getEditor());
        proc.setEditor("editor2");
        assertEquals("editor2",proc.getEditor());
    }

    /**
     * Test of getVolume method, of class Proceedings.
     */
    @Test
    public void testGetVolume() {
        assertEquals("volume", proc.getVolume());
    }

    /**
     * Test of setVolume method, of class Proceedings.
     */
    @Test
    public void testSetVolume() {
        assertEquals("volume",proc.getVolume());
        proc.setVolume("volume2");
        assertEquals("volume2",proc.getVolume());
    }

    /**
     * Test of getSeries method, of class Proceedings.
     */
    @Test
    public void testGetSeries() {
        assertEquals("series", proc.getSeries());
    }

    /**
     * Test of setSeries method, of class Proceedings.
     */
    @Test
    public void testSetSeries() {
        assertEquals("series",proc.getSeries());
        proc.setSeries("series2");
        assertEquals("series2",proc.getSeries());
    }

    /**
     * Test of getAddress method, of class Proceedings.
     */
    @Test
    public void testGetAddress() {
        assertEquals("address", proc.getAddress());
    }

    /**
     * Test of setAddress method, of class Proceedings.
     */
    @Test
    public void testSetAddress() {
        assertEquals("address",proc.getAddress());
        proc.setAddress("address2");
        assertEquals("address2",proc.getAddress());
    }

    /**
     * Test of getMonth method, of class Proceedings.
     */
    @Test
    public void testGetMonth() {
        assertEquals("month", proc.getMonth());
    }

    /**
     * Test of setMonth method, of class Proceedings.
     */
    @Test
    public void testSetMonth() {
        assertEquals("month",proc.getMonth());
        proc.setMonth("month2");
        assertEquals("month2",proc.getMonth());
    }

    /**
     * Test of getOrganization method, of class Proceedings.
     */
    @Test
    public void testGetOrganization() {
        assertEquals("organization", proc.getOrganization());
    }

    /**
     * Test of setOrganization method, of class Proceedings.
     */
    @Test
    public void testSetOrganization() {
        assertEquals("organization",proc.getOrganization());
        proc.setOrganization("organization2");
        assertEquals("organization2",proc.getOrganization());
    }

    /**
     * Test of getPublisher method, of class Proceedings.
     */
    @Test
    public void testGetPublisher() {
        assertEquals("publisher", proc.getPublisher());
    }

    /**
     * Test of setPublisher method, of class Proceedings.
     */
    @Test
    public void testSetPublisher() {
        assertEquals("publisher",proc.getPublisher());
        proc.setPublisher("publisher2");
        assertEquals("publisher2",proc.getPublisher());
    }

    /**
     * Test of getNote method, of class Proceedings.
     */
    @Test
    public void testGetNote() {
        assertEquals("note", proc.getNote());
    }

    /**
     * Test of setNote method, of class Proceedings.
     */
    @Test
    public void testSetNote() {
        assertEquals("note",proc.getNote());
        proc.setNote("note2");
        assertEquals("note2",proc.getNote());
    }

    /**
     * Test of getKey method, of class Proceedings.
     */
    @Test
    public void testGetKey() {
        assertEquals("key", proc.getKey());
    }

    /**
     * Test of setKey method, of class Proceedings.
     */
    @Test
    public void testSetKey() {
        assertEquals("key",proc.getKey());
        proc.setKey("key2");
        assertEquals("key2",proc.getKey());
    }
}
