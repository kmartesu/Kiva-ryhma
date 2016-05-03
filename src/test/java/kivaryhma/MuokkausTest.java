/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma;

import javax.swing.JTextField;
import static junit.framework.Assert.assertEquals;
import kivaryhma.entries.Article;
import kivaryhma.mvc.Controller;
import kivaryhma.mvc.Form;
import kivaryhma.mvc.Model;
import kivaryhma.mvc.View;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author toffe
 */
public class MuokkausTest {

    private Form form;
    private View view;
    private Model model;
    private Controller controller;
    Article article;

    public MuokkausTest() {
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

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testArticlenMuokkausOnnistuu() {
        for (int i = 0; i < form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("test");
        }
        form.submitArticleForm();
        form.updateList();
        assertEquals(controller.getEntries().get(0).getAuthor(), "test");

        form.getReferenceList().setSelectedIndex(0);
        form.getJButtonEdit().doClick();

        for (int i = 0; i < form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("edit");
        }
        form.submitArticleForm();
        assertEquals("edit", controller.getEntries().get(0).getAuthor());
    }

    @Test
    public void testArticlenMuokkausOnnistuuUsemmanLisäyksenJälkeen() {
        
        for (int i = 0; i < form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("test2");
        }
        form.getSubmitArticleButton().doClick();
        for (int i = 0; i < form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("test3");
        }
        form.getSubmitArticleButton().doClick();

        form.getReferenceList().setSelectedIndex(1);
        form.getJButtonEdit().doClick();
        
        for (int i = 0; i < form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("edit");
        }
        form.submitArticleForm();
        assertEquals("edit", controller.getEntries().get(1).getAuthor());
    }

}
