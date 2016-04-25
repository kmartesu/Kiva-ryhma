import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*

description 'Bibtex luodaan valituista viitteistä'

scenario "Luodaan viite, valitaan se ja luodaan bibtex", {
    given 'lisäys on auki', {
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
        for (int i = 5; i < 9; i++) {
            form.getArticleFields()[i].setText("articletest");
        }
        form.submitArticleForm();
    }
        
    when 'viite valitaan ja luodaan', {
        controller.addSelectedReferences(0)
        ArrayList<Entry> entries = new ArrayList<Entry>(controller.getSelectedEntries())
        bibtex = ""
        for (Entry entry : entries) {
            bibtex = bibtex + entry.toBibtex()
        }
    }

    then 'bibtexistä löytyy jutut',{
        bibtex.contains("@article{,").shouldBe true
        bibtex.contains("author = {author},").shouldBe true
        bibtex.contains("journal = {journal},").shouldBe true
        bibtex.contains("volume = {year},").shouldBe true
        bibtex.contains("year = {volume},").shouldBe true
        bibtex.contains("},\n}").shouldBe true
    }
}

scenario "Luodaan useampi viite, valitaan pari ja luodaan bibtex", {
    given 'lisäys on auki', {
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
    }
    and 'useampi viite lisätään', {
        for (int i = 0; i <= 4; i++) {
            form.getArticleFields()[i].setText("articletest");
        }
        form.submitArticleForm();
        for (int i = 0; i <= 3; i++) {
            form.getBookFields()[i].setText("booktest");
        }
        form.submitBookForm();
        for (int i = 0; i <= 3; i++) {
            form.getInproceedingsFields()[i].setText("inproceedingstest");
        }
        form.submitInproceedingsForm()
    }
        
    when 'viite valitaan ja luodaan', {
        int[] array = [0, 1]
        controller.addSelectedReferences(array)
        ArrayList<Entry> entries = new ArrayList<Entry>(controller.getSelectedEntries())
        bibtex = ""
        for (Entry entry : entries) {
            bibtex = bibtex + entry.toBibtex()
        }
    }

    then 'bibtexistä löytyy jutut mitä kuuluu',{
        bibtex.contains("@article").shouldBe true
        bibtex.contains("@book").shouldBe true
        bibtex.contains("@inproceedings").shouldBe false
    }
}