/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.services;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kivaryhma.entries.Entry;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ile
 */
public class BibTeXParserTest {

    

    public BibTeXParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void parsesTestFileCorrectly() {
        BibTeXParser parser = new BibTeXParser();
        ArrayList<Entry> entries = new ArrayList<Entry>();
        
        try {
            entries = parser.readBibtex("src/test/resources/testibib.bib");
        } catch (Exception ex) {
            System.out.println("Tiedostoa ei saatu auki");
        }
        assertEquals(6, entries.size());
    }

}
