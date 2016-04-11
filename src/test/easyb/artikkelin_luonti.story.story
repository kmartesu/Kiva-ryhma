description 'Käyttäjä voi lisätä artikkeliviitteen'
 scenario "käyttäjä voi lisätä kunnollisen viitteen", {
    given 'lisäys on auki',{
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
    }
    when 'lisätään lomakkeeseen tiedot',{
        for(int i=0;i<form.getFields().length;i++){
            form.getFields()[i].setText("Text");
        }
        form.submitForm();
    }
    then 'viite luodaan',{
        Article article= controller.getArticles().get(0);
        article.shouldNotBe null
    }
}
