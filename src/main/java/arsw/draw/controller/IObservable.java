package arsw.draw.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yenny Varón y Cristian Medina
 */
public interface IObservable {
   
    void addObserver(IObserver Observer);
    
    void removeObserver(IObserver Observer);
   
    void notifyObservers();
    
}
