import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import kivaryhma.*
import kivaryhma.entries.*
import kivaryhma.mvc.*
import kivaryhma.services.*


description 'Käyttäjänä pystyn tallentamaan tiedoston ja valitsemaan sille nimen'

    scenario "Käyttäjä voi tallentaa tiedostoon", {
        
        given 'book lisäys on auki', {
	    robot = new Robot();
            view = new View();
            model = new Model();
            controller = new Controller(model, view);
            form = new Form();
            form.registerController(controller);
            view.setForm(form);
            view.registerController(controller);
	    
        }
        
        when 'tallennetaan tiedostoon', {
            form.getFileChooser().setSelectedFile(new File("testi"));
	
	       apu = new Thread(){
                @Override
                public void run() {
                    Robot robot;
                    try {
                    robot = new Robot();
                    robot.delay(500);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                     } catch (AWTException ex) {
                        Logger.getLogger(FormTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
            };
	    apu.start();
            this.form.getJButton1().doClick();
        }

        then 'uusi tiedosto syntyy', {
            new File("testi.bib").exists().shouldBe true;
	    new File("testi.bib").delete();
        }   
    }
