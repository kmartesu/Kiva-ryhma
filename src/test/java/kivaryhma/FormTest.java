/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
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
public class FormTest {
    private Form form;
    private View view;
    private Model model;
    private Controller controller;
    public FormTest() {
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
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
        for(int i=0;i<form.getArticleFields().length;i++){
            form.getArticleFields()[i].setText("Test");
        }
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of submitForm method, of class Form.
     */
    @Test
    public void testSubmitForm() {
     
      form.submitArticleForm();
      Article article= controller.getArticles().get(0);
      assertEquals(article.getAuthor(),"Test");
      assertEquals(article.getJournal(),"Test");
      assertEquals(article.getTitle(),"Test");
      assertEquals(article.getMonth(),"Test");
      assertEquals(article.getNote(),"Test");
      assertEquals(article.getNumber(),"Test");
      assertEquals(article.getVolume(),"Test");
      assertEquals(article.getYear(),"Test");
      assertEquals(article.getKey(),"Test");
    }

    /**
     * Test of updateList method, of class Form.
     */
    @Test
    public void testUpdateList() {
        form.submitArticleForm();
          
  
    }

    /**
     * Test of registerController method, of class Form.
     */
    @Test
    public void testRegisterController() {
       
    }

    /**
     * Test of display method, of class Form.
     */
    @Test
    public void testDisplay() {
       
    }

    /**
     * Test of actionPerformed method, of class Form.
     */
    @Test
    public void testActionPerformed() {
     
      
    }

    /**
     * Test of gatherTextFields method, of class Form.
     */
    @Test
    public void testGatherTextFields() {
     form.gatherArticleTextFields();
    }

    /**
     * Test of emptyTextFields method, of class Form.
     */
    @Test
    public void testEmptyTextFields() {
        form.emptyArticleTextFields();
        for(int i=0;i<form.getArticleFields().length;i++){
            assertEquals(form.getArticleFields()[i].getText(),"");
        }
    }
    
}
