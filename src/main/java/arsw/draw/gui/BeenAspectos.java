/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.draw.gui;

import arsw.draw.controller.Maximo;
import arsw.draw.controller.MaximoC;
import arsw.draw.controller.Controller;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 *
 * @author 2083990
 */
public class BeenAspectos {
    
    private int elContador=0;
    Controller controller = new Controller();

    
    public void metodo_advice(JoinPoint jp, Exception ex){
           
        ex.printStackTrace();  
    }
    public int contadorEjecuciones(JoinPoint jp){
        elContador++;
        int contador = 0;
        int numFiguras = 0;
        
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();      
        contador=method.getAnnotation(Maximo.class).contadorEjecuciones();
     
        if(elContador == contador){
            JOptionPane.showMessageDialog(null, contador+" Numero de figuras permitidas");
            System.exit(0);
        }
       return contador;
    }
    
    public int contadorComandos(JoinPoint jp){
        elContador++;
        int contador = 0;
        
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();      
        contador=method.getAnnotation(MaximoC.class).contadorComandos();
        
        if(elContador == contador){
            JOptionPane.showMessageDialog(null, contador+" Comandos permitidos");
            System.exit(0);
        }
       return contador;
        
    }
    
}
