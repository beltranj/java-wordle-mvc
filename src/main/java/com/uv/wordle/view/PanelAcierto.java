/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;

import com.uv.wordle.model.WordleModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alber
 */
public class PanelAcierto extends JPanel{
    
    JLabel intentos, palabra, enhorabuena, nom, guardado;
    
    JTextField nombre_ganador;
    
    JButton ranking_add;
    
    WordleModel m;
    
    JPanel guardar;
    
    public PanelAcierto(WordleModel m) {
        
        this.m = m;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // ImagePanel que contiene el GIF correspondiente con fallo
        ImagePanel p = new ImagePanel();
        
        // Declaración de los textos a mostrar
        enhorabuena= new JLabel("¡ENHORABUENA, Has acertado! :)");
        palabra = new JLabel("La palabra correcta era: " + m.getPalabra());
        intentos = new JLabel("Intentos: " + m.getIntento());
        nom = new JLabel("Introduce tu nombre para guardar la partida");
        
        // Declaración del JTextField para introducir el nombre del jugador que acaba de realizar la partida
        nombre_ganador = new JTextField(20);
        nombre_ganador.setHorizontalAlignment(JTextField.CENTER); // Centramos la fuente en el JTextField
        
        // Declaración del JButton para añadir el nombre en el ranking
        ranking_add = new JButton("Añadir al ranking");
        ranking_add.setBackground(new Color(121,125,127));
        ranking_add.setForeground(Color.WHITE);
        ranking_add.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Declaración de un JPanel con el campo de texto para introducir el nombre del ganador y el boton de añadir al ranking
        guardar = new JPanel();
        guardar.setBackground(Color.WHITE);
        guardar.add(nombre_ganador);
        guardar.add(ranking_add);
        
        // Texto que se hará visible una vez ya se haya añadido al ranking
        guardado = new JLabel("¡GUARDADO!");
        guardado.setVisible(false);
        
        // Centrar en X todos los componentes al centro
        nom.setAlignmentX(Component.CENTER_ALIGNMENT);
        guardar.setAlignmentX(Component.CENTER_ALIGNMENT);
        guardado.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(nom);
        this.add(guardado);
        this.add(guardar);
        this.add(Box.createRigidArea(new Dimension(0, -200)));
        
        // Añadir comando para el controlador
        ranking_add.setActionCommand("anyadeRanking");
    }
    
    public void setActionListener(ActionListener al){
        ranking_add.addActionListener(al);
    }
    
    public void setKeyListener(KeyListener kl) {
        nombre_ganador.addKeyListener(kl);
    }    
    
    // Métodos para obtener los valores para añadir al ranking
    public String getNombreJugador(){
        return nombre_ganador.getText();
    }
    
    public int getIntentosJugador(){
        return m.getIntento();
    }
    
    public String getPalabraJugador(){
        return m.getPalabra();
    }
    
    /**
     * Una vez introducido el nombre, aparecerá el mensaje como que se ha guardado en el ranking
     */
    public void cambiarPaneles(){
        guardado.setVisible(true);
        nom.setVisible(false);
        guardar.setVisible(false);
        this.add(Box.createRigidArea(new Dimension(0, 250)));
    }  
}
