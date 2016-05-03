import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

description 'Luetaan bibtex-tiedosto'

scenario "Luodaan bibtex-tiedosto suljetaan ohjelma ja avataan", {
    given 'Luodaan bibtex-tiedosto, johon tallennetaan tiedosto', {
       view = new View();
        model = new Model();
        controller = new Controller(model, view);
        form = new Form();
        form.registerController(controller);
        view.setForm(form);
        view.registerController(controller);
        for (int i = 0; i < form.getArticleFields().length; i++) {
            form.getArticleFields()[i].setText("Test");
        }
	form.submitArticleForm();
        model.getSelectedReferences().add(this.model.getReferences().get(0));
        model.saveToFile("testi.bib");

    }    
    when 'Avataan ohjelma uudestaan ja avataan tallennettu tiedosto', {
           model = new Model();
           view = new View();
           model = new Model();
           controller = new Controller(model, view);
           form = new Form();
           form.registerController(controller);
           view.setForm(form);
           view.registerController(controller);
           form.getFileChooser().setSelectedFile(new File("testi.bib"));
           apu2 = new Thread(){
            @Override
            public void run(){      
                try {
                    try {
                       
                        Thread.sleep(1000);
                        robot = new Robot();
                       
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        Thread.sleep(1000);
                        
                    } catch (AWTException ex) {
                    Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
        }
        };
        apu2.start();
        this.form.getReadBiBTex().doClick();
    }

    then 'Tiedoston viitteet avautuu ohjelmaan',{

    	Article article = (Article) controller.getEntries().get(0);
	article.getAuthor().equals("Test").shouldBe true
	article.getJournal().equals("Test").shouldBe true
	article.getTitle().equals("Test").shouldBe true
	article.getMonth().equals("Test").shouldBe true
	article.getNote().equals("Test").shouldBe true
	article.getNumber().equals("Test").shouldBe true
	article.getVolume().equals("Test").shouldBe true
	article.getYear().equals("Test").shouldBe true
	article.getKey().equals("Test").shouldBe true
	delete = new File("testi.bib")
	delete.delete()
    }
}

