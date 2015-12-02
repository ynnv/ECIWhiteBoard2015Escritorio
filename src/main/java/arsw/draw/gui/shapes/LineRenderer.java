package arsw.draw.gui.shapes;

import arsw.draw.model.Line;
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fchaves
 */
public class LineRenderer {

    public void draw(Graphics2D g2, Line line) {
        g2.setPaint(Color.black);
        g2.drawLine(line.getPoint1().getX(), line.getPoint1().getY(), line.getPoint2().getX(), line.getPoint2().getY());
        int x1= line.getPoint1().getX();
        int x2= line.getPoint2().getX(); 
        int y1= line.getPoint1().getY(); 
        int y2= line.getPoint2().getY(); 
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - 25, xn = xm, ym = 7, yn = -7, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g2.drawLine(x1, y1, x2, y2);
        g2.fillPolygon(xpoints, ypoints, 3);
        
    }
    
}
