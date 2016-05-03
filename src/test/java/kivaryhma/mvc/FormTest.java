/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.mvc;

import kivaryhma.entries.Article;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kivaryhma.entries.Book;
import kivaryhma.entries.Inproceedings;
import kivaryhma.entries.Masterthesis;
import kivaryhma.entries.Phdthesis;
import kivaryhma.entries.Proceedings;
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

    @Test
    public void testcheckIfBeingEdited() {
        form.checkIfBeingEdited();
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
    public void testPutProceedingsTextFields() {
        Proceedings prs = new Proceedings();
        
        prs.setTitle("test");
        prs.setYear("test");
        prs.setKey("test");
        
        form.putProceedingsTextFields(prs);
        
        assertEquals(form.getProceedingsFields()[0].getText(), "test");
        assertEquals(form.getProceedingsFields()[1].getText(), "test");
    }
    
    @Test
    public void testPutMasterthesisTextFields() {
        Masterthesis mst = new Masterthesis();
        
        mst.setAuthor("test");
        mst.setTitle("test");
        mst.setSchool("test");
        mst.setYear("test");
        mst.setKey("test");
        
        form.putMasterthesisTextFields(mst);
        
        assertEquals(form.getMasterthesisFields()[0].getText(), "test");
        assertEquals(form.getMasterthesisFields()[1].getText(), "test");
        assertEquals(form.getMasterthesisFields()[2].getText(), "test");
        assertEquals(form.getMasterthesisFields()[3].getText(), "test");
    }
    
    @Test
    public void testPutPhdThesisTextFields() {
        Phdthesis phd = new Phdthesis();
        
        phd.setAuthor("test");
        phd.setTitle("test");
        phd.setSchool("test");
        phd.setYear("test");
        phd.setKey("test");
        
        form.putPhdthesisTextFields(phd);
        
        assertEquals(form.getPhdthesisFields()[0].getText(), "test");
        assertEquals(form.getPhdthesisFields()[1].getText(), "test");
        assertEquals(form.getPhdthesisFields()[2].getText(), "test");
        assertEquals(form.getPhdthesisFields()[3].getText(), "test");
    }
    
    @Test
    public void testPutBOokTextFields() {
        Book bo = new Book();
        
        bo.setAuthor("test");
        bo.setTitle("test");
        bo.setPublisher("test");
        bo.setYear("test");
        bo.setKey("test");
        
        form.putBookTextFields(bo);
        
        assertEquals(form.getBookFields()[0].getText(), "test");
        assertEquals(form.getBookFields()[1].getText(), "test");
        assertEquals(form.getBookFields()[2].getText(), "test");
        assertEquals(form.getBookFields()[3].getText(), "test");
    }

    @Test
    public void testPutInproceedings() {
        Inproceedings in = new Inproceedings();
        in.setAddress("address");
        in.setAuthor("author");
        in.setBooktitle("booktitle");
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
    
        form.putInproceedingsTextFields(in);
        
        assertEquals(form.getInproceedingsFields()[0].getText(), in.getAuthor());
        assertEquals(form.getInproceedingsFields()[1].getText(), in.getTitle());
        assertEquals(form.getInproceedingsFields()[2].getText(), in.getBooktitle());
        assertEquals(form.getInproceedingsFields()[3].getText(), in.getYear());

    }
    
    @Test
    public void testRemove() {
        Thread apu = new Thread() {
            @Override
            public void run() {
                try {
                    form.getSubmitArticleButton().doClick();
                    Thread.sleep(1000);
                    assertEquals(model.getReferences().size(), 1);
                    form.getReferenceList().setSelectedIndex(0);
                    form.getJButton2().doClick();
                    assertEquals(model.getReferences().size(), 0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        apu.start();
    }

    @Test
    public void testOpenFile() throws FileNotFoundException {
        form.submitArticleForm();
        
        //Adding book entry
        String[] b = new String[form.getBookFields().length];
        for (int i = 0; i < form.getBookFields().length; i++) {
            b[i] = "Test";
        }
        this.controller.sendBookFormParameters(b);
        
        this.model.getSelectedReferences().add(this.model.getReferences().get(0));
        this.model.getSelectedReferences().add(this.model.getReferences().get(1));
        this.model.saveToFile("testi.bib");

        this.model = new Model();
        this.view = new View();
        this.model = new Model();
        this.controller = new Controller(model, view);
        this.form = new Form();
        this.form.registerController(controller);
        this.view.setForm(form);
        this.view.registerController(controller);

        this.form.getFileChooser().setSelectedFile(new File("testi.bib"));
        Thread apu2 = new Thread() {
            @Override
            public void run() {
                Robot robot;

                try {
                    try {

                        Thread.sleep(1000);
                        robot = new Robot();

                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(1000);

                    } catch (AWTException ex) {
                        Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        apu2.start();
        this.form.getReadBiBTex().doClick();
        assertTrue(this.form.getFileChooser().getSelectedFile().exists());
        Article article = (Article) controller.getEntries().get(0);
       // Book book = (Book) controller.getEntries().get(1);
        
        assertEquals(article.getAuthor(), "Test");
        assertEquals(article.getJournal(), "Test");
        assertEquals(article.getTitle(), "Test");
        assertEquals(article.getMonth(), "Test");
        assertEquals(article.getNote(), "Test");
        assertEquals(article.getNumber(), "Test");
        assertEquals(article.getVolume(), "Test");
        assertEquals(article.getYear(), "Test");
        assertEquals(article.getKey(), "Test");
        
       // assertEquals(book.getAuthor(), "Test");
        //assertEquals(book.getAddress(), "Test");
    }

}
