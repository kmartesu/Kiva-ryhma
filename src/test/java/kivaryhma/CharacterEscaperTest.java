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
 * @author ile
 */
public class CharacterEscaperTest {
    
    public CharacterEscaperTest() {
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
    public void testFilter() {
        String txt = "ä Ä ö Ö ß æ Æ ø Ø å Å";
        String expResult = "{\\\"{a}} {\\\"{A}} {\\\"{o}} {\\\"{O}} {\\ss} {\\ae} {\\AE} {\\o} {\\O} {\\aa} {\\AA}";
        String result = CharacterEscaper.filter(txt);
        assertEquals(expResult, result);
     
    }
    
}
