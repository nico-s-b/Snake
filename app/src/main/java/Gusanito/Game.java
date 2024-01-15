/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gusanito;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author nic_s
 */
public class Game extends JFrame{
    
    Paint paint;
    public static boolean gameOver = false;

   public Game() {
        initializeGameObjects(); // Inicializa objetos relacionados con el juego
        startGameThread(); // Inicia el hilo del juego
    }

    private void initializeGameObjects() {
        Comida comida = new Comida();
        Snake snake = new Snake();
        paint = new Paint(comida, snake);
        Screen screen = new Screen(paint);
    }

    private void startGameThread() {
        Momento momento = new Momento();
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
