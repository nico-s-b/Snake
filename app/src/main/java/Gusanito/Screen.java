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
public class Screen extends JFrame{
    public static int width;
    public static int height;
    
    public Screen(Paint paint){
        
        this.getContentPane().add(paint);

        width = 640;
        height = 480;
        
        setTitle("Snake");
        
        setSize(width,height);

        this.addKeyListener(new Controls());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(false);
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        setVisible(true);       
    }
}
