import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*

description 'Käyttäjä voi poistaa viitteen listasta'

    scenario "Käyttäjä voi poistaa valitsemansa viitteen", {
        given 'Alussa käyttäjä täyttää kentät', {
            view = new View();
            model = new Model();
            controller = new Controller(model, view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
             for(int i=0; i<form.getArticleFields().length;i++) {
                form.getArticleFields()[i].setText("Test text");
            }
           
        }

        when 'Käyttäjä lisää viitteen. Tämän jälkeen käyttäjä valitsee viitteen ja painaa poista-nappia', {
           Thread apu = new Thread(){
            @Override
            public void run(){
                   try {
                        form.getSubmitArticleButton.doClick();
			Thread.sleep(100);
                        form.getReferenceList().setSelectedIndex(0);
                        form.getJButton2().doClick();
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
            }
        };
        apu.start();
        }   
        
        then 'Viiteitä ei ole listassa', {
            
            model.getReferences().size().shouldBe 0;
        }
    }
    
