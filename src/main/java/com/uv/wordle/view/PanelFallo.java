/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;

import com.uv.wordle.model.WordleModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alber
 */
public class PanelFallo extends JPanel{
    
    JLabel intentos, palabra, enhorabuena;
    
    WordleModel m;
    
    public PanelFallo(WordleModel m) {
        
        this.m = m;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // ImagePanel que contiene el GIF correspondiente con fallo
        ImagePanel2 p = new ImagePanel2();
        
        // Declaración de los textos a mostrar
        enhorabuena=new JLabel("¡LO SIENTO, Has fallado! :(");
        palabra = new JLabel("La palabra correcta era: "+m.getPalabra());
        intentos = new JLabel("Tendrás más suerte la próxima vez");
        
        // Centrar en X todos los componentes al centro
        p.setAlignmentX(Component.CENTER_ALIGNMENT);
        enhorabuena.setAlignmentX(Component.CENTER_ALIGNMENT);
        palabra.setAlignmentX(Component.CENTER_ALIGNMENT);
        intentos.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Establecer el fondo del JPanel a WHITE para que concuerde con el fondo del JFrame
        this.setBackground(Color.WHITE);
        
        // Añadir todos los componentes al JPanel
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(enhorabuena);
        this.add(p);
        this.add(palabra);
        this.add(intentos);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        
    }
    
}
