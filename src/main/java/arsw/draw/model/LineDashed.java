/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.model;

/**
 *
 * @author fchaves
 */
public class LineDashed extends Shape {
    
    @Override
    public ElementType getElementType() {
        return ElementType.LineDashed;
    }

    private LineDashed(Point p1, Point p2) {
        super(p1,p2);        
    }
    
    static public LineDashed newLineDashed(Point p1,Point p2) {
        return new LineDashed(p1,p2);
    }
}
