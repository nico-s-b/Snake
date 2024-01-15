/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gusanito;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author nic_s
 */
public class Paint extends JPanel {
    
    int widthPoint = 10;
    int heightPoint = 10;
    
    private Comida comida;
    private Snake snake;
    
    public Paint(Comida comida, Snake snake){
        this.comida = comida;
        this.snake = snake;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        paintScreen(g);
        paintComida(g);
        paintSnake(g);
    }
    
    private void paintScreen(Graphics g){
        if(Gusanito.Game.gameOver) {
            g.setColor(new Color(0,0,0));
            paintGameOver(g);
        } else {
            g.setColor(new Color(255,255,255));
        }
        g.fillRect(0,0, Gusanito.Screen.width, Gusanito.Screen.height);
    }
    
    private void paintComida(Graphics g){
        g.setColor(new Color(255,0,0));
        g.fillRect(comida.getX(),comida.getY(),widthPoint,heightPoint);           
    }
    
    private void paintSnake(Graphics g){
        g.setColor(new Color(0,0,255));
        if(!snake.getPosiciones().isEmpty()) {
            for(int i = 0; i < snake.getPosiciones().size(); i++) {
                Point p = (Point)snake.getPosiciones().get(i);
                g.fillRect(p.x,p.y,widthPoint,heightPoint);
            }
        }
    }
    
    private void paintGameOver(Graphics g) {
        
        g.setFont(new Font("TimesRoman", Font.BOLD, 40));
        g.drawString("GAME OVER", 300, 200);
        g.drawString("SCORE "+ snake.getPoints(), 300, 240);

        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString("N to Start New Game", 100, 320);
        g.drawString("ESC to Exit", 100, 340);
    }
        
}
