/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui.shapes;

import arsw.draw.model.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author fchaves
 */
public class RectangleRenderer {

    public void draw(Graphics2D g2, Rectangle rectangle) {
        g2.setPaint(Color.blue);

        Integer width = Math.abs(rectangle.getPoint2().getX() - rectangle.getPoint1().getX());
        Integer height = Math.abs(rectangle.getPoint2().getY() - rectangle.getPoint1().getY());
        g2.drawRect(rectangle.getPoint1().getX(),rectangle.getPoint1().getY(), width, height);
    }
    
     public void fill(Graphics2D g2, Rectangle rectangle) {
        g2.setPaint(Color.blue);

        Integer width = Math.abs(rectangle.getPoint2().getX() - rectangle.getPoint1().getX());
        Integer height = Math.abs(rectangle.getPoint2().getY() - rectangle.getPoint1().getY());
        g2.fillRect(rectangle.getPoint1().getX(),rectangle.getPoint1().getY(), width, height);
    }
    
}
