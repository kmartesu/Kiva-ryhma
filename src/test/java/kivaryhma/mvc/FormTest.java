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
import kivaryhma.entries.Article;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        controller = new Controller(model, view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
        for (int i = 0; i < form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("Test");
        }

    }

    @After
    public void tearDown() {
        File delete = new File("testi.bib");
        delete.delete();
    }

    /**
     * Test of submitForm method, of class Form.
     */
    @Test
    public void testSubmitForm() {

        form.submitArticleForm();
        Article article = (Article) controller.getEntries().get(0);
        assertEquals(article.getAuthor(), "Test");
        assertEquals(article.getJournal(), "Test");
        assertEquals(article.getTitle(), "Test");
        assertEquals(article.getMonth(), "Test");
        assertEquals(article.getNote(), "Test");
        assertEquals(article.getNumber(), "Test");
        assertEquals(article.getVolume(), "Test");
        assertEquals(article.getYear(), "Test");
        assertEquals(article.getKey(), "Test");
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
        form.emptyReferenceTextFields(form.getArticleFields());
        for (int i = 0; i < form.getArticleFields().length; i++) {
            assertEquals(form.getArticleFields()[i].getText(), "");
        }
    }

    public class Apu extends Thread {

        private Robot robot;

        public Apu() {
            try {
                this.robot = new Robot();

            } catch (AWTException ex) {
                Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            if (robot != null) {
                robot.delay(500);
                robot.keyPress(KeyEvent.VK_ENTER);

                robot.keyRelease(KeyEvent.VK_ENTER);
                robot = null;
            }

        }
    }

    @Test

    public void testBibtex() {

        try {
            form.submitArticleForm();
            this.form.getFileChooser().setSelectedFile(new File("testi"));
            Apu apu = new Apu();
            apu.start();
            this.form.getJButton1().doClick();
            apu.join();
            assertTrue(new File("testi.bib").exists());
        } catch (InterruptedException ex) {
            Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testRemove() {
        Thread apu = new Thread(){
            @Override
            public void run(){
                   try {
                        form.getSubmitArticleButton().doClick();
                        Thread.sleep(1000);
                        assertEquals(model.getReferences().size(),1);
                        form.getReferenceList().setSelectedIndex(0);
                        form.getJButton2().doClick();
                        assertEquals(model.getReferences().size(),0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
            }
        };
        apu.start();
    }

}
