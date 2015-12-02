/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.controller;


import arsw.draw.model.ElementType;
import arsw.draw.model.ShapeFactory;
import arsw.draw.model.Point;
import arsw.draw.model.Shape;
import com.lasc.compb.DataProcessor;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author fchaves
 */
public class Controller {
    private ElementType selectedElement = ElementType.Line;
    
    private final ShapeFactory shapeFactory = new ShapeFactory();
    private final List<Shape> shapes = new ArrayList();
    private final ArrayList<IObserver> observers = new ArrayList<>();
    private final ArrayList<ICommand> commands = new ArrayList<>();
    private int typeRenderer ;

    public Controller(){
        super();
    }
        
    @Maximo(contadorEjecuciones = 5)
    @MaximoC(contadorComandos = 5)
    public void addShape(java.awt.Point ap1,java.awt.Point ap2) {
        Point p1 = Point.newPoint(ap1.x, ap1.y);
        Point p2 = Point.newPoint(ap2.x, ap2.y);
        
        shapes.add(shapeFactory.createShape(selectedElement, p1, p2));
        this.notifyObservers();
    }
    
    @MaximoC(contadorComandos = 5)
    @Maximo(contadorEjecuciones = 5)
    public void addShape(Integer index, Shape shape) {
        shapes.add(index,shape);
        this.notifyObservers();

    }   
    
    @MaximoC(contadorComandos = 5)
    public void deleteShape(Integer index) {
        int idx = index;
        shapes.remove(idx);
        this.notifyObservers();
    }
    
    public List<Shape> getShapes() {
        return shapes;
    }
    
    public void setSelectedElementType(ElementType elementType) {
        this.selectedElement = elementType;
    }  
    
    public ElementType getSelectedElementType() {
        return this.selectedElement;
    }
    
    public int getType() {
        return this.typeRenderer;    
    }

    public void setType(int i) {
        this.typeRenderer = i;    
    }

    
    
    public void addObserver(IObserver Observer) {
        observers.add(Observer);

    }

    
    public void removeObserver(IObserver Observer) {
        int i = observers.indexOf(Observer);
        if (i >= 0) {
            observers.remove(Observer);
        }
    }
    
    
    
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }
    
    
    public void addCommand(ICommand command) {
        commands.add(command);
    }
    
    @MaximoC(contadorComandos = 5)
    public void undo() {
        for (ICommand command : commands) {
            command.undo();
        }
        
    }

    @MaximoC(contadorComandos = 5)
    public void redo() {
        for (ICommand command : commands) {
            command.redo();
        }
    }
 
}
