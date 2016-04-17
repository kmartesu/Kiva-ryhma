import kivaryhma.*

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