import kivaryhma.*

description 'Virheviesti ilmoittaa kenttien oikeellisuudesta'

    scenario "Virheviesti näkyy tyhjillä pakollisilla kentillä lisätessä", {
        given 'lisäys on auki', {
            view = new View();
            model = new Model();
            controller = new Controller(model,view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
        }
        
        when 'Jätetään pakollisia kenttiä täyttämättä', {
            for(int i=4;i<form.getArticleFields().length;i++){
                form.getArticleFields()[i].setText("Text");
            }
            form.submitArticleForm();
        }

        then 'viite luodaan',{
            form.getVirheViesti().getText().shouldBe "Pakollisia kenttiä täyttämättä!";
        }
    }

    scenario "Virheviesti on tyhjä, kun kaikki pakolliset kentät täytetty", {
        given 'lisäys on auki', {
            view = new View();
            model = new Model();
            controller = new Controller(model,view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
        }
        
        when 'Jätetään pakollisia kenttiä täyttämättä', {
            for(int i=0;i<form.getArticleFields().length;i++){
                form.getArticleFields()[i].setText("Text");
            }
            form.submitArticleForm();
        }

        then 'viite luodaan',{
            form.getVirheViesti().getText().shouldBe "";
        }
    }