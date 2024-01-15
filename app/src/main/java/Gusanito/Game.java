/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gusanito;

import javax.swing.JFrame;

/**
 *
 * @author nic_s
 */
public class Game extends JFrame{
    
    Paint paint;
    Comida comida;
    Snake snake;
    public static boolean gameOver = false;
    
   public Game() {
        initializeGameObjects(); // Inicializa objetos relacionados con el juego
        startGameThread(); // Inicia el hilo del juego
    }

    private void initializeGameObjects() {
        comida = new Comida();
        snake = new Snake();
        paint = new Paint(comida, snake);
        Screen screen = new Screen(paint);
    }

    private void startGameThread() {
        Momento momento = new Momento(comida, snake, paint);
        Thread trid = new Thread(momento);
        trid.start();
    }

    public Paint getPaint() {
        return paint;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
}
