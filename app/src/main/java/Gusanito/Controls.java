/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gusanito;

import java.awt.event.KeyEvent;

/**
 *
 * @author nic_s
 */

public class Controls extends java.awt.event.KeyAdapter {
    
    String direccion = "RIGHT";
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
            case KeyEvent.VK_RIGHT:
                if(!"LEFT".equals(direccion)) {
                    direccion = "RIGHT";
                }   break;
            case KeyEvent.VK_LEFT:
                if(!"RIGHT".equals(direccion)) {
                    direccion = "LEFT";
                }   break;
            case KeyEvent.VK_UP:
                if(!"DOWN".equals(direccion)) {
                    direccion = "UP";
                }   break;
            case KeyEvent.VK_DOWN:
                if(!"UP".equals(direccion)) {
                    direccion = "DOWN";
                }   break;
            case KeyEvent.VK_N:
                Gusanito.Game.gameOver = false;
                Gusanito.Game();
                break;
            default:
                break;				
        }
    }

	}
    
