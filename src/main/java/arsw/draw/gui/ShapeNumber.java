/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui;
import arsw.draw.controller.ICommand;
import arsw.draw.controller.IObserver;
import arsw.draw.controller.Controller;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;


/**
 *
 * @author fchaves
 */
public final class ShapeNumber extends JLabel implements IObserver,ICommand{

    private final Controller controller;
    
    public ShapeNumber(Controller controller) {
        
        this.controller = controller; 
        this.controller.addObserver(this);
        this.controller.addCommand(this);
    }
    
    @Override
    public void update() {
        this.setText("Numero de figuras: "+ ( controller.getShapes().size() ));
    }
    @Override
    public void undo() {
        
        this.setText("Numero de figuras: "+ ( controller.getShapes().size() ));
    }

    @Override
    public void redo() {
        this.setText("Numero de figuras: "+ ( controller.getShapes().size() ));
    }
    
}
