import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*
import gui.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

description 'Käyttäjänä pystyn generoimaan toimivan bibtex-tiedoston'
    
scenario "Käyttäjä voi generoida toimivan bibtex-tiedoston lisätystä article-viitteestä", {
    given 'lisäysikkuna on auki', {
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
    }
    and 'oikeellinen article-viite lisätään', {
        form.getArticleFields()[0].setText("author");
        form.getArticleFields()[1].setText("title");
        form.getArticleFields()[2].setText("journal");
        form.getArticleFields()[3].setText("volume");
        form.getArticleFields()[4].setText("year");
        form.getArticleFields()[9].setText("key");
        for (int i = 5; i < 9; i++) {
            form.getArticleFields()[i].setText("articletest");
        }
        form.submitArticleForm();
    }
    when 'bibtex-tiedosto luodaan', {
        ArrayList<Entry> entries = new ArrayList<Entry>(controller.getEntries())
        bibtex = ""
        for (Entry entry : entries) {
            bibtex = bibtex + entry.toBibtex()
        }
    }
    then 'kaikki löytyy bibtex-tiedostosta', {
        bibtex.contains("@article{key,").shouldBe true
        bibtex.contains("author = {author},").shouldBe true
        bibtex.contains("journal = {journal},").shouldBe true
        bibtex.contains("volume = {year},").shouldBe true
        bibtex.contains("year = {volume},").shouldBe true
        bibtex.contains("},\n}").shouldBe true
    }
}

scenario "Käyttäjä voi generoida toimivan bibtex-tiedoston lisätystä book-viitteestä", {
    given 'lisäysikkuna on auki', {
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
    }
    and 'oikeellinen book-viite lisätään', {
        form.getBookFields()[0].setText("author");
        form.getBookFields()[1].setText("title");
        form.getBookFields()[2].setText("publisher");
        form.getBookFields()[3].setText("year");
        for (int i = 5; i <= 10; i++) {
            form.getBookFields()[i].setText("booktest");
        }
        form.submitBookForm();
    }
    when 'bibtex-tiedosto luodaan', {
        ArrayList<Entry> entries = new ArrayList<Entry>(controller.getEntries())
        bibtex = ""
        for (Entry entry : entries) {
            bibtex = bibtex + entry.toBibtex()
        }
    }
    then 'kaikki löytyy bibtex-tiedostosta', {
        bibtex.contains("@book{booktest,").shouldBe true
        bibtex.contains("title = {title},").shouldBe true
        bibtex.contains("publisher = {publisher},").shouldBe true
        bibtex.contains("year = {year},").shouldBe true
        bibtex.contains("author = {author},").shouldBe true
        bibtex.contains("},\n}").shouldBe true
    }
}

scenario "Käyttäjä voi generoida toimivan bibtex-tiedoston lisätystä inproceedings-viitteestä", {
    given 'lisäysikkuna on auki', {
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
    }
    and 'oikeellinen inproceedings-viite lisätään', {
        for (int i = 0; i < form.getInproceedingsFields().length; i++) {
            form.getInproceedingsFields()[i].setText("inproceedingstest");
        }
        form.submitInproceedingsForm()
    }
    when 'bibtex-tiedosto luodaan', {
        ArrayList<Entry> entries = new ArrayList<Entry>(controller.getEntries())
        bibtex = ""
        for (Entry entry : entries) {
            bibtex = bibtex + entry.toBibtex()
        }
    }
    then 'kaikki löytyy bibtex-tiedostosta', {
        bibtex.contains("@inproceedings{inproceedingstest,").shouldBe true
        bibtex.contains("title = {inproceedingstest},").shouldBe true
        bibtex.contains("publisher = {inproceedingstest},").shouldBe true
        bibtex.contains("year = {inproceedingstest},").shouldBe true
        bibtex.contains("author = {inproceedingstest},").shouldBe true
        bibtex.contains("},\n}").shouldBe true
    }
}

scenario "Käyttäjä voi generoida toimivan bibtex-tiedoston useammasta article-viitteestä", {
    given 'lisäysikkuna on auki', {
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
    }
    and 'kaksi article-viitettä lisätään', {
        for (int i = 0; i <= 4; i++) {
            form.getArticleFields()[i].setText("test");
        }
        form.getArticleFields()[9].setText("test1");
        form.submitArticleForm();
        for (int i = 0; i <= 4; i++) {
            form.getArticleFields()[i].setText("test2");
        }
        form.getArticleFields()[9].setText("test2");
        form.submitArticleForm();
    }

    when 'bibtex-tiedosto luodaan', {
        ArrayList<Entry> entries = new ArrayList<Entry>(controller.getEntries())
        bibtex = ""
        for (Entry entry : entries) {
            bibtex = bibtex + entry.toBibtex()
        }
    }
    then 'kummatkin artikkeliviitteet löytyvät bibtex-tiedostosta', {
        bibtex.contains("@article{test1,").shouldBe true
        bibtex.contains("author = {test}").shouldBe true
        bibtex.contains("title = {test}").shouldBe true
        bibtex.contains("year = {test}").shouldBe true
        
        bibtex.contains("@article{test2,").shouldBe true
        bibtex.contains("author = {test2}").shouldBe true
        bibtex.contains("journal = {test2}").shouldBe true
        bibtex.contains("volume = {test2}").shouldBe true
    }
    
    scenario "Käyttäjä voi generoida toimivan bibtex-tiedoston useammasta eri viitetyypistä", {
        given 'lisäysikkuna on auki', {
            view = new View();
            model = new Model();
            controller = new Controller(model,view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
        }
        and 'inproceedings-, book- ja article-viitteet lisätään', {
            for (int i = 0; i <= 4; i++) {
                form.getArticleFields()[i].setText("articletest");
            }
            form.getArticleFields()[9].setText("articletest");
            form.submitArticleForm();
            for (int i = 0; i <= 3; i++) {
                form.getBookFields()[i].setText("booktest");
            }
            form.getBookFields()[10].setText("booktest");
            form.submitBookForm();
            for (int i = 0; i < form.getInproceedingsFields().length; i++) {
                form.getInproceedingsFields()[i].setText("inproceedingstest");
            }
            form.submitInproceedingsForm()
        }
        when 'bibtex-tiedosto luodaan', {
            ArrayList<Entry> entries = new ArrayList<Entry>(controller.getEntries())
            bibtex = ""
            for (Entry entry : entries) {
                bibtex = bibtex + entry.toBibtex()
            }
        }
        then 'book- ja article-viitteet löytyvät bibtex-tiedostosta', {
            bibtex.contains("@article{articletest,").shouldBe true
            bibtex.contains("title = {articletest},").shouldBe true
            bibtex.contains("@book{booktest,").shouldBe true
            bibtex.contains("title = {booktest},").shouldBe true
            bibtex.contains("@inproceedings{inproceedingstest,").shouldBe true
            bibtex.contains("title = {inproceedingstest},").shouldBe true
        }
    }
}



