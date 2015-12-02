/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui.shapes;

import arsw.draw.model.ElementType;
import arsw.draw.model.LineDashed;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;

/**
 *
 * @author 2086593
 */
public class LineDashedRenderer {
    
     public void draw(Graphics2D g2, LineDashed line) {
        
        float dash1[] = {4f, 0f, 2f};
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f);
        g2.setPaint(Color.black);
        //g2.setStroke(dashed);
        g2.drawLine(line.getPoint1().getX(), line.getPoint1().getY(), line.getPoint2().getX(), line.getPoint2().getY());
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        //g2.draw(new Line2D.Double(line.getPoint1().getX(), line.getPoint1().getY(), line.getPoint2().getX(), line.getPoint2().getY()));
     }
     
}
