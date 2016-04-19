import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*

description 'Käyttäjänä pystyn lisäämään book-viitteen'

    scenario "Käyttäjä voi lisätä oikeellisen viitteen", {
        
        given 'book lisäys on auki', {
            view = new View();
            model = new Model();
            controller = new Controller(model, view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
        }
        
        when 'lisätään lomakkeeseen tiedot', {
            for(int i=0;i<form.getBookFields().length; i++) {
                form.getBookFields()[i].setText("Test Text");
            }
            form.submitBookForm();
        }

        then 'book-viite luodaan', {
            Book book = controller.getEntries().get(0);
            book.shouldNotBe null;
        }   
    }

    scenario "Käyttäjä ei voi lisätä book-viitteen tyhjillä pakollisilla kentillä", {
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
            controller.getEntries().size().shouldBe 0;        
        }
    }