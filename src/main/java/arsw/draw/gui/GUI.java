/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui;
import arsw.draw.controller.Controller;
import arsw.draw.model.ElementType;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import static java.lang.Compiler.command;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

/**
 *
 * @author fchaves
 */
public class GUI extends JFrame {

    private final ShapeCanvas canvas; 
    private final ShapeList shapeList;
    private final ShapeNumber shapeNumber;
    private final JSplitPane splitPane;
    private final Controller controller;
    
    public final JMenuBar menu() {
        JMenuBar result = new JMenuBar();
        JMenu shapeMenu = new JMenu("Shape");
        
        for(final ElementType elem : ElementType.values()) {
            JMenuItem shapeMenuItem = new JMenuItem(new AbstractAction(elem.name()) {
                @Override
                public void actionPerformed(ActionEvent e) {
                     controller.setSelectedElementType(elem);
                }
            });
            shapeMenu.add(shapeMenuItem);                    
        }

        JMenu styleMenu = new JMenu("View Style");
        
        JMenuItem emptyStyle = new JMenuItem(new AbstractAction("Empty Style") {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Empty Style");
                controller.setType(0);
            }
            
        });

        JMenuItem fillStyle = new JMenuItem(new AbstractAction("Fill Style") {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Fill Style");
                controller.setType(1);
            }
            
        });

        styleMenu.add(emptyStyle);
        styleMenu.add(fillStyle);
        
        JMenuItem undoMenu;
        undoMenu = new JMenuItem(new AbstractAction("Undo") {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!controller.getShapes().isEmpty())
                controller.undo();
            }
        });

        JMenuItem redoMenu = new JMenuItem(new AbstractAction("Redo") {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.redo();
            }
            
        });

        result.add(shapeMenu);
        result.add(styleMenu);
        result.add(undoMenu);
        result.add(redoMenu);
        result.setLayout(new FlowLayout(FlowLayout.LEFT));       
        return result;
    }
    
    public GUI(Controller controller) {
        super("ARSW Shape");
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.add(menu(),BorderLayout.NORTH);
        this.canvas = new ShapeCanvas(controller);
        this.shapeList = new ShapeList(controller);
        this.shapeNumber = new ShapeNumber(controller);
        this.add(shapeNumber,BorderLayout.SOUTH);
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                           canvas, shapeList);
        this.add(splitPane,BorderLayout.CENTER);
        this.setVisible(true);
        splitPane.setDividerLocation(0.80);
    }
    
}

