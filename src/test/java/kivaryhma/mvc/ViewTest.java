/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.mvc;

import kivaryhma.mvc.View;
import kivaryhma.mvc.Model;
import kivaryhma.mvc.Form;
import kivaryhma.mvc.Controller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author hyttijan
 */
public class ViewTest {
    private View view;
    private Controller controller;
    public ViewTest() {
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
        controller = new Controller(new Model(),view);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of init method, of class View.
     */
    @Test
    public void testInit() {
        Form form = new Form();
        view.setForm(form);
        view.init();
        
    }

    /**
     * Test of setForm method, of class View.
     */
    @Test
    public void testSetForm() {
        Form form = new Form();
        view.setForm(form);
        
    }

    /**
     * Test of registerController method, of class View.
     */
    @Test
    public void testRegisterController() {
        view.registerController(controller);
    }
    
}
