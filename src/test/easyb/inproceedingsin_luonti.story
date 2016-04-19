import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*

description 'Käyttäjä voi lisätä inproceedings-viitteen'
    
    scenario "Käyttäjä voi lisätä oikeellisen inproceedings-viitteen", {
        
        given 'lisäys on auki', {
            view = new View();
            model = new Model();
            controller = new Controller(model, view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
        }

        when 'lisätään lomakkeeseen tiedot', {
            for(int i=0;i<form.getInproceedingsFields().length;i++) {
                form.getInproceedingsFields()[i].setText("Test text");
            }
            form.submitInproceedingsForm();
        }

        then 'inproceedings-viite luodaan', {
            Inproceedings inproceedings = controller.getEntries().get(0);
            inproceedings.shouldNotBe null;
        }
    }

    scenario "Käyttäjä ei voi lisätä inproceedings-viitteen tyhjillä pakollisilla kentillä", {
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
            for(int i=3;i<form.getInproceedingsFields().length;i++){
                form.getInproceedingsFields()[i].setText("Text");
            }
            form.submitInproceedingsForm();
        }
        then 'viite luodaan',{
            controller.getEntries().size().shouldBe 0;        
        }
    }