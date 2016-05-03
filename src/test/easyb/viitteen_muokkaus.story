import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*

description 'Käyttäjä voi muokata viitteitä'
scenario "käyttäjä lisää kunnollisen viitteen", {
    given 'lisäys on auki',{
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
    }
    when 'lisätään lomakkeeseen tiedot ja lisätään viite',{
        for(int i=0;i<form.getArticleFields().length;i++){
            form.getArticleFields()[i].setText("Text");
        }
    }
    then 'muokataan olemassaolevan viitteen tietoja ja tarkistetaan että muutos löytyy',{
        Thread apu = new Thread(){
            @Override
            public void run(){
                try {
                    form.getSubmitArticleButton().doClick();
                    form.getReferenceList().setSelectedIndex(0);
                    Thread.sleep(100);
                    form.getJButtonEdit().doClick();
                    for(int i=0;i<form.getArticleFields().length;i++){
                        form.getArticleFields()[i].setText("edit");
                    }
                    Thread.sleep(100);
                    form.getSubmitArticleButton().doClick();
                    controller.getEntries()[0].getAuthor().contains("edit").shouldBe true
                } catch (InterruptedException ex) {
                    Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
            }
        };
        apu.start();
    }
}   


