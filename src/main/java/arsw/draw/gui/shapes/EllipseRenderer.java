/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui.shapes;

import arsw.draw.model.Ellipse;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author fchaves
 */
public class EllipseRenderer {

    public void draw(Graphics2D g2, Ellipse ellipse) {
        g2.setPaint(Color.red);

        Integer width = Math.abs(ellipse.getPoint2().getX() - ellipse.getPoint1().getX());
        Integer height = Math.abs(ellipse.getPoint2().getY() - ellipse.getPoint1().getY());
        g2.drawOval(ellipse.getPoint1().getX(),ellipse.getPoint1().getY(), width, height);
    }
    
    public void fill(Graphics2D g2, Ellipse ellipse) {
        g2.setPaint(Color.red);

        Integer width = Math.abs(ellipse.getPoint2().getX() - ellipse.getPoint1().getX());
        Integer height = Math.abs(ellipse.getPoint2().getY() - ellipse.getPoint1().getY());
        g2.fillOval(ellipse.getPoint1().getX(),ellipse.getPoint1().getY(), width, height);
    }
    
}
