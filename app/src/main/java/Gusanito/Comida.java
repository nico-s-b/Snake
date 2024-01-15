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

        comida.x = (rnd.nextInt(Gusanito.Screen.width) + Paint.widthPoint/2);
        adjustComidaXposition();

        comida.y = (rnd.nextInt(Gusanito.Screen.height)) + Paint.heightPoint/2;
        adjustComidaYposition();
    }
    
    private void adjustComidaXposition() {
        if((comida.getX() % Paint.widthPoint) > 0) {
                comida.x = comida.x - (comida.x % Paint.widthPoint/2);
        }
        if(comida.getX() < Paint.widthPoint/2) {
                comida.x = comida.x + Paint.widthPoint;
        }
        if(comida.getX() > Gusanito.Screen.width) {
                comida.x = comida.x - Paint.widthPoint;
        }        
    }
    
    private void adjustComidaYposition() {
        if((comida.getY() % Paint.heightPoint/2) > 0) {
                comida.y = comida.y - (comida.y % Paint.heightPoint/2);
        }	

        if(comida.getY() > Gusanito.Screen.height) {
                comida.y = comida.y - Paint.heightPoint;
        }
        if(comida.getY() < 0) {
                comida.y = comida.y + Paint.heightPoint;
        }        
    }
    
    public int getX(){
        return comida.x;
    }
    
    public void setX(int x) {
        comida.x = x;
    }
    
    public int getY(){
        return comida.y;
    }    

    public void setY(int y) {
        comida.y = y;
    }
    
}
