/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.model;

/**
 *
 * 
 */
public class Text extends Shape {
    
    @Override
    public ElementType getElementType() {
        return ElementType.Text;
    }

    private Text(Point p1, Point p2) {
        super(p1,p2);        
    }
    
    static public Text newText(Point p1,Point p2) {
        return new Text(p1,p2);
    }
}
