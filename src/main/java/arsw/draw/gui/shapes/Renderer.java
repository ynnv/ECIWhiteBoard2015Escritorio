/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui.shapes;

/**
 *
 * @author fchaves
 */
public class Renderer {
    
    public LineRenderer createLineRenderer() {
        return new LineRenderer();
    }
    
    public LineDashedRenderer createLineDashedRenderer() {
        return new LineDashedRenderer();
    }
    
    public RectangleRenderer createRectangleRenderer() {
        return new RectangleRenderer();
    }
    
    public TextRenderer createTextRenderer() {
        return new TextRenderer();
    }

    public EllipseRenderer createEllipseRenderer() {
        return new EllipseRenderer();
    }

}
