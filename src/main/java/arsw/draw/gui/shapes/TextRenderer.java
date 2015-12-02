/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui.shapes;


import arsw.draw.model.Text;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;

/**
 *
 * @author 2086593
 */
public class TextRenderer {
    public void draw(Graphics2D g2, Text t){
        //JPanel gui;
        //gui = new JPanel(new BorderLayout(4,4));
        //gui.setBorder(new EmptyBorder(5,3,5,3));
//        System.out.print("Add Text:");
//        String input = System.console().readLine();
        String text = "Text";
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Please enter text: ");
//        try {
//            String text = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("You entered : " + text);
        //String text = JOptionPane.showInputDialog("Text to add", "Text");
        if (text!=null) {
            g2.drawString(text, t.getPoint1().getX(), t.getPoint1().getY()); 
            //g2.dispose();
        }
         
    }
    
}
