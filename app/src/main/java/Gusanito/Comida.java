/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gusanito;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author nic_s
 */
public class Comida {

    Point comida;
    
    public Comida(){
        comida = new Point(200,100);
    }
    
    public void generarComida() {
        Random rnd = new Random();

        comida.x = (rnd.nextInt(Gusanito.Screen.width)) + 5;
        if((comida.x % 5) > 0) {
                comida.x = comida.x - (comida.x % 5);
        }

        if(comida.x < 5) {
                comida.x = comida.x + 10;
        }
        if(comida.x > Gusanito.Screen.width) {
                comida.x = comida.x - 10;
        }

        comida.y = (rnd.nextInt(Gusanito.Screen.height)) + 5;
        if((comida.y % 5) > 0) {
                comida.y = comida.y - (comida.y % 5);
        }	

        if(comida.y > Gusanito.Screen.height) {
                comida.y = comida.y - 10;
        }
        if(comida.y < 0) {
                comida.y = comida.y + 10;
        }
    }
    
    public int getX(){
        return comida.x;
    }
    
    public int getY(){
        return comida.y;
    }    
    
}
