import kivaryhma.*

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
        for(int i=0;i<form.getArticleFields().length;i++){
            form.getArticleFields()[i].setText("Text");
        }
        form.submitArticleForm();
    }
    then 'viite luodaan',{
        Article article= controller.getEntries().get(0);
        article.shouldNotBe null
    }
}
