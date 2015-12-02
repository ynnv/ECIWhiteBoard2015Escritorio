/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui;

import arsw.draw.controller.ICommand;
import arsw.draw.controller.IObserver;
import arsw.draw.controller.Controller;
import arsw.draw.model.Shape;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author fchaves
 */
public final class ShapeList extends JPanel implements IObserver,ICommand{

    private final Controller controller;
    private final DefaultListModel<String> listModel;
    private JList<String> shapeList;
    private final JButton deleteButton;
    
    public ShapeList(Controller control) {
        super(new BorderLayout());
        this.controller = control;
        this.listModel = new DefaultListModel();
        this.shapeList = new JList(listModel);
        this.add(shapeList,BorderLayout.CENTER);
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.deleteButton = new JButton("Delete Shape");
        deleteButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = shapeList.getSelectedIndex();
                if (index >= 0) {
                    controller.deleteShape(index);
                }
            }
        });
        
        this.add(deleteButton,BorderLayout.SOUTH);
        this.controller.addObserver(this);
        this.controller.addCommand(this);
    }

    /**
     *
     */
    @Override
    public void update() {
        listModel.clear();
        for (Shape shape : this.controller.getShapes()) {
            listModel.addElement(shape.getElementType().name());
        }
    }

    @Override
    public void undo() {
        int index = controller.getShapes().size();
        if(index <= listModel.size() && !listModel.isEmpty()){
            //System.out.print(listModel.getSize());
            listModel.remove(index);
        }else listModel.clear();
    }

    @Override
    public void redo() {
        int index = controller.getShapes().size();
        if(index > listModel.size()){
            update();
        }
    }

    
}
