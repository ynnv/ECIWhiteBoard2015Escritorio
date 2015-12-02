/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui;
import arsw.draw.controller.ICommand;
import arsw.draw.controller.IObserver;
import arsw.draw.controller.Controller;
import arsw.draw.gui.shapes.EllipseRenderer;
import arsw.draw.gui.shapes.LineRenderer;
import arsw.draw.gui.shapes.RectangleRenderer;
import arsw.draw.gui.shapes.LineDashedRenderer;
import arsw.draw.gui.shapes.TextRenderer;
import arsw.draw.gui.shapes.Renderer;
import arsw.draw.model.ElementType;
import arsw.draw.model.Line;
import arsw.draw.model.Rectangle;
import arsw.draw.model.Ellipse;
import arsw.draw.model.LineDashed;
import arsw.draw.model.Shape;
import arsw.draw.model.Text;
import com.lasc.compb.DataProcessor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JPanel;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fchaves
 */
public class ShapeCanvas extends JPanel implements IObserver,ICommand {
   
    Controller controller; 
    Renderer renderer;
    Stack<Shape> listShapesUndo;
    Stack<Shape> listShapesRedo;
    Shape ultima; 
    public ShapeCanvas(Controller controller) {
        this.renderer = new Renderer();
        this.controller = controller;
        this.controller.addObserver(this);
        this.controller.addCommand(this);
        listShapesUndo = new Stack<>();
        listShapesRedo = new Stack<>();
        mouseControl();
    }
        
    private void mouseControl() {
        
        addMouseListener(new MouseAdapter() {
            Point startDrag, endDrag;

            @Override
            public void mousePressed(MouseEvent e) {
               startDrag = new Point(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endDrag = new Point(e.getX(), e.getY());
                if (Math.abs(endDrag.x - startDrag.x) > 2 && Math.abs(endDrag.y - startDrag.y) > 2) {
                    controller.addShape(startDrag, endDrag);
                }
                startDrag = null;
                endDrag = null;
            }
        });
    }
   
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        List<Shape> list = controller.getShapes();        
        
        LineRenderer lineRenderer = renderer.createLineRenderer();
        RectangleRenderer rectangleRenderer = renderer.createRectangleRenderer();
        EllipseRenderer ellipseRenderer = renderer.createEllipseRenderer();
        LineDashedRenderer lineDashedRenderer = renderer.createLineDashedRenderer();
        TextRenderer textRenderer = renderer.createTextRenderer();
        
        
        for(Shape shape : list) {
            switch(shape.getElementType()) {
                case Line:
                       lineRenderer.draw(g2, (Line)shape); 
                    break;
                case LineDashed:
                        lineDashedRenderer.draw(g2, (LineDashed)shape);
                    break;
                case Text:
                    textRenderer.draw(g2, (Text)shape);
                    break;
                case Rectangle:
                    if (controller.getType()==0) {
                        rectangleRenderer.draw(g2, (Rectangle)shape);
                    }else{
                        rectangleRenderer.fill(g2, (Rectangle)shape);
                    }    
                    break;
                case Ellipse:
                    if (controller.getType()==0) {
                        ellipseRenderer.draw(g2, (Ellipse)shape);
                    }else{
                         ellipseRenderer.fill(g2, (Ellipse)shape);
                    }                       
                    break;
            }
        }
        //System.out.print(true);
    } 

    @Override
    public void update() {
        repaint();
    }

    @Override
    public void undo() {
        List<Shape> list1 = controller.getShapes();
        for(Shape shape : list1) {
            listShapesUndo.push(shape);
        }
        
        if(!listShapesUndo.isEmpty()){
            ultima =  listShapesUndo.pop();
            listShapesRedo.push(ultima);
            list1.remove(ultima);
        }
        repaint();
    }

    @Override
    public void redo() {
        List<Shape> list2 = controller.getShapes();
        if(!listShapesRedo.isEmpty()){
            ultima =  listShapesRedo.pop();
            list2.add(ultima);
            //System.out.println("Hola");
            repaint();
        }
    }
 
}