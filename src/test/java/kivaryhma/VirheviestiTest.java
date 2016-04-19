/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma;

import kivaryhma.mvc.View;
import kivaryhma.mvc.Model;
import kivaryhma.mvc.Form;
import kivaryhma.mvc.Controller;
import kivaryhma.entries.Article;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author toffe
 */
public class VirheviestiTest {
        private Form form;
        private View view;
        private Model model;
        private Controller controller;
        Article article;
        
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
            article.setAuthor("");
            article.setJournal("");
            article.setNote("note");
            article.setVolume("volume");
            article.setPages("pages");
            article.setKey("key");
            article.setYear("year");
            article.setTitle("title");
            article.setMonth("month");
            article.setNumber("number");
        }
        
        @Test
        public void testVirheViestNakyyTayttamattomillaPakollisillaKentilla() {
            form.submitArticleForm();
            assertEquals(form.getVirheViesti().getText(), "Pakollisia kenttiä täyttämättä!");
        }
        
        @Test
        public void testVirheEiNayTaytetyillaKentilla() {
            article.setAuthor("author");
            article.setJournal("journal");
            assertEquals(form.getVirheViesti().getText(),"");
        }
}
