import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*

description 'Käyttäjänä pystyn hakemaan viitteitä'
    
    scenario "Käyttäjä voi hakea viitteen", {
        
        given 'listassa on viitteitä', {
            view = new View();
            model = new Model();
            controller = new Controller(model, view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);

            for(int i=0;i<form.getBookFields().length; i++) {
                form.getBookFields()[i].setText("test Text");
            }
            form.submitBookForm();
        }
        
        when 'syötetään hakusana', {
            form.getSearchBar().setText("test");
            controller.setSearchWord("test");
            form.updateList();
        }

        then 'listassa viite', {
            Book book = controller.getEntries().get(0);
            book.shouldNotBe null;
        }
    }

    scenario "Käyttäjä ei nää viitettä väärällä hakusanalla", {
        
        given 'listassa on viitteitä', {
            view = new View();
            model = new Model();
            controller = new Controller(model, view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);

            for(int i=0;i<form.getBookFields().length; i++) {
                form.getBookFields()[i].setText("test Text");
            }
            form.submitBookForm();
        }
        
        when 'syötetään väärä hakusana', {
            form.getSearchBar().setText("asd");
            controller.setSearchWord("asd");
            form.updateList();
        }

        then 'listassa viite ei näy', {
            controller.getEntries().size().shouldBe 0;
        }
    }