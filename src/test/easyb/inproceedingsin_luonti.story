import kivaryhma.*

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