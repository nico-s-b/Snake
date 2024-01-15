/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gusanito;

import java.awt.Point;

/**
 *
 * @author nic_s
 */
public class Momento extends Thread {
	
    long frequency = 50;
    private long last = 0;
		
    public Momento() {}

    public void actualizar() {
        listaPosiciones.add(0,new Point(snake.x,snake.y));
	listaPosiciones.remove(listaPosiciones.size()-1);

        for (int i = 1; i < listaPosiciones.size(); i++) {
            Point point = listaPosiciones.get(i);
            if(snake.x == point.x && snake.y  == point.y) {
                Gusanito.Game.gameOver = true;
            }
        }

	if((snake.x > (comida.x-10) && snake.x < (comida.x+10)) && (snake.y > (comida.y-10) && snake.y < (comida.y+10))) {
            listaPosiciones.add(0,new Point(snake.x,snake.y));
            System.out.println(listaPosiciones.size());
            Comida.generarComida();
        }
        pixel.repaint();
        Paint Gusanito.Game.getPixel().repaint();
    }

    public void run() {
        while(true) {
            if((java.lang.System.currentTimeMillis() - last) > frequency) {
                if(!gameOver) {
                    if(direccion == "RIGHT") {
                        snake.x = snake.x + widthPoint;
                        if(snake.x > width) {
                            snake.x = 0;
                        }
                    } else if(direccion == "LEFT") {
                        snake.x = snake.x - widthPoint;
                        if(snake.x < 0) {
                            snake.x = width - widthPoint;
                        }                        
                    } else if(direccion == "UP") {
                        snake.y = snake.y - heightPoint;
                        if(snake.y < 0) {
                            snake.y = height;
                        }                        
                    } else if(direccion == "DOWN") {
                        snake.y = snake.y + heightPoint;
                        if(snake.y > height) {
                            snake.y = 0;
                        }
                    }
                }
            actualizar();
            last = java.lang.System.currentTimeMillis();
            }
        }
    }
}
    
