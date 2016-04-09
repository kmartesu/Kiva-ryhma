/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma;


public class Main {
    
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Form form = new Form();
        Controller controller = new Controller(model, view);
        
        //Rekisteröidään kontrollerit ja käynnistetään näkymä
        form.registerController(controller);
        view.registerController(controller);
        view.setForm(form);
        view.init();
    }
}
