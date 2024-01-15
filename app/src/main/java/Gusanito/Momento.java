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
    Snake snake;
    Comida comida;
    Paint paint;
    
    public Momento(Comida comida, Snake snake, Paint paint) {
        this.comida = comida;
        this.snake = snake;
        this.paint = paint;
    }

    public void actualizar() {
        snakePositions();
        checkIfSnakeCollideWithItself();
        checkIfSnakeEatComida();
        paint.repaint();
    }

    private void snakePositions(){
        snake.getPosiciones().add(0,new Point(snake.getX(),snake.getY()));
	snake.getPosiciones().remove(snake.getLarge()-1);        
    }
    
    private void checkIfSnakeCollideWithItself(){
        for (int i = 1; i < snake.getLarge(); i++) {
            Point point = snake.getPosiciones().get(i);
            if(snake.getX() == point.x && snake.getY()  == point.y) {
                Gusanito.Game.gameOver = true;
            }
        }        
    }
    
    private void checkIfSnakeEatComida(){
	if(snakeReachedComida()) {
            snake.getPosiciones().add(0,new Point(snake.getX(),snake.getY()));
            System.out.println(snake.getLarge());
            comida.generarComida();
        }
    }
    
    private boolean snakeReachedComida(){
        boolean snakeEatComidaX = (snake.getX() > (comida.getX() - paint.widthPoint) && snake.getX() < (comida.getX() + paint.widthPoint));
        boolean snakeEatComidaY = (snake.getY() > (comida.getY() - paint.heightPoint) && snake.getY() < (comida.getY() + paint.heightPoint));
        return snakeEatComidaX && snakeEatComidaY;
    }
    
    @Override
    public void run() {
        while(true) {
            if((java.lang.System.currentTimeMillis() - last) > frequency) {
                if(!Game.gameOver) {
                    snakeMovement();
                }
            actualizar();
            last = java.lang.System.currentTimeMillis();
            }
        }
    }

    private void snakeMovement(){
        switch (Controls.direccion){
            case "RIGHT":
                snake.setX(snake.getX() + paint.widthPoint);
                    if(snake.getX() > Screen.width) {
                       snake.setX(0);
                   }                           
                break;
            case "LEFT":
                snake.setX(snake.getX() - paint.widthPoint);
                if(snake.getX() < 0) {
                    snake.setX(Screen.width - paint.widthPoint);
                }                            
                break;
            case "UP":
                snake.setY(snake.getY() - paint.heightPoint);
                if(snake.getY() < paint.heightPoint) {
                    snake.setY(Screen.height);
                }                                   
                break;
            case "DOWN":
                snake.setY(snake.getY() + paint.heightPoint);
                if(snake.getY() > Screen.height) {
                    snake.setY(paint.heightPoint);
                }                            
                break;
        }
    }
    
}
    
