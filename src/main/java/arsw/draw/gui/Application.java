/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui;
import arsw.draw.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author fchaves
 */
public class Application {
    
    static public void main(String args[]) {
        
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = ac.getBean(Controller.class);
        GUI gui = new GUI(controller);
    }
}
