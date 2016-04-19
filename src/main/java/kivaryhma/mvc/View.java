package kivaryhma.mvc;

import kivaryhma.mvc.Form;
import kivaryhma.mvc.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author toffe
 */
public class View {
    
    private Controller controller;
    private Form form;
    
    public View() {}
    
    public void init() {
        form.display();
    }
    
    public void setForm(Form form) {
        this.form = form;
    }
    
    public void registerController(Controller controller) {
        this.controller = controller;
    }
    
    public Form getForm() {
        return form;
    }
    
    
}
