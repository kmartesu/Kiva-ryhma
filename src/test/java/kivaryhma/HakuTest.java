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
public class HakuTest {
    private Form form;
    private View view;
    private Model model;
    private Controller controller;
    Article article;
    
    public HakuTest() {
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

        article = new Article();
        article.setAuthor("LEL");
        article.setJournal("Journal");
        article.setNote("note");
        article.setVolume("volume");
        article.setPages("pages");
        article.setKey("key");
        article.setYear("year");
        article.setTitle("title");
        article.setMonth("month");
        article.setNumber("number");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testHakuSanallaArticleListassa() {        
        for(int i = 0; i<form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("LEL");
        }
        form.submitArticleForm();
        form.updateList();
        assertEquals(form.getReferenceList().getModel().getSize(), 1);
        
        form.getSearchBar().setText("LEL");
        controller.setSearchWord("LEL");
        form.updateList();
        
        assertEquals(form.getReferenceList().getModel().getSize(), 1);
    }
    
    @Test
    public void testVaaraHakusanaArticleEiListassa() {
        for(int i = 0; i<form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("LEL");
        }
        form.submitArticleForm();
        form.updateList();
        assertEquals(form.getReferenceList().getModel().getSize(), 1);
        
        form.getSearchBar().setText("asd");
        controller.setSearchWord("asd");
        form.updateList();
        assertEquals(form.getReferenceList().getModel().getSize(), 0);
    }
}
