/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gusanito;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author nic_s
 */
public class Snake {
    Point snake;
    ArrayList<Point> listaPosiciones = new ArrayList<>();
    
    public Snake(){
        snake = new Point(320,240);
	listaPosiciones = new ArrayList<>();
        listaPosiciones.add(snake);

        listaPosiciones.size();   
    }
    
    public ArrayList<Point> getPosiciones(){
        return this.listaPosiciones;
    }
    
    public int getPoints(){
        return this.listaPosiciones.size()-1;
    }
    
}
    
