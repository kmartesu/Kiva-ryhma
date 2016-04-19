import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*

description 'Käyttäjä näkee viitteen listassa lisäämisen jälkeen'

    scenario "Käyttäjä näkee viitteen lisättyään oikeellisen viitteen", {
        given 'lisäys on auki', {
            view = new View();
            model = new Model();
            controller = new Controller(model, view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
        }

        when 'lisätään lomakkeeseen tiedot ja submitataan', {
            for(int i=0; i<form.getArticleFields().length;i++) {
                form.getArticleFields()[i].setText("Test text");
            }
            form.actionPerformed();
        }   
        
        then 'viite luodaan ja se on näkymässä', {
            Article article = controller.getEntries().get(0);
            article.shouldNotBe null;
            form.getReferenceList().getModel().getElementAt(0).shouldNotBe null;
        }
    }

    scenario "Käyttäjä ei näe lisättyä viitettä, joka lisätään tyhjillä pakollisilla kentillä", {
            given 'lisäys on auki',{
            view = new View();
            model = new Model();
            controller = new Controller(model,view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
        }
        when 'Jätetään vaadittavia kenttiä tyhjiksi',{
            for(int i=3;i<form.getBookFields().length;i++){
                form.getBookFields()[i].setText("Text");
            }
            form.submitBookForm();
        }
        then 'viite luodaan',{    
            form.getReferenceList().getModel().size().shouldBe 0;
        }
    }    