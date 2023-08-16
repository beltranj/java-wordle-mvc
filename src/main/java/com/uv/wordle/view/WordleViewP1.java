/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class WordleViewP1 extends JFrame{

    JRadioButton tres, cuatro, cinco;
    ButtonGroup longitudPalabra;
    JTextField word;
    JPanel radioPanel, textPanel;
    JButton play;
    WordleViewMenuBar menubar;
    
    int longitud_palabra;

    public WordleViewP1(){
        
        //Configuración de la ventana
        setTitle("Wordle: Ventana del Jugador 1");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        // Barra de menú
        menubar = new WordleViewMenuBar();
        this.setJMenuBar(menubar);
        menubar.visibleMenu(true);
        menubar.actionCommandAyuda(2);
        
        //Configuración del contenido
        tres = new JRadioButton("3 letras");
        tres.setBackground(Color.WHITE);
        
        cuatro = new JRadioButton("4 letras");
        cuatro.setBackground(Color.WHITE);
        
        cinco = new JRadioButton("5 letras");
        cinco.setBackground(Color.WHITE);
        word = new JTextField("",20);
        
        // Agrupamos los botones de radio
        longitudPalabra = new ButtonGroup();
        longitudPalabra.add(tres);
        longitudPalabra.add(cuatro);
        longitudPalabra.add(cinco);
        
        
        // Añadimos los botones de radio a un JPanel
        radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(1,3));
        radioPanel.setBackground(Color.WHITE);
        
        radioPanel.add(tres);
        radioPanel.add(cuatro);
        radioPanel.add(cinco);
        
        radioPanel.setAlignmentX(CENTER_ALIGNMENT);
        radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Longitud de la palabra?"));
        
        
        // Añadimos el panel para introducir el texto
        textPanel = new JPanel();
        textPanel.add(word);
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        textPanel.setBackground(Color.WHITE);

        // Añadimos un panel para los botones de acción
        play = new JButton("JUGAR"); 
        play.setBackground(new Color(121,125,127));
        play.setForeground(Color.WHITE);
        play.setBorderPainted(false);
        
        // Agregamos los paneles a la ventana
        add(radioPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(play, BorderLayout.SOUTH);
       
        // Establecer los action commands de los botones de radio y del boton de jugar
        tres.setActionCommand("longitud_3");
        cuatro.setActionCommand("longitud_4");
        cinco.setActionCommand("longitud_5");
        play.setActionCommand("btn_jugarP1");
             
    }
    
    public void setActionListener(ActionListener al){
        tres.addActionListener(al);
        cuatro.addActionListener(al);
        cinco.addActionListener(al);
        play.addActionListener(al);
        menubar.setActionListener(al);
    }
    
    public void setKeyListener(KeyListener kl){
        word.addKeyListener(kl);
    }
    
    public String getPalabraP1(){
        
        return word.getText();
    }
    
    public int getLongitudPalabraP1(){
        return word.getText().length();
    }
    
    public void setLongitudP1(int i){
        longitud_palabra = i;
    }
    
    public int getLongitudP1(){
        return longitud_palabra;
    }

    public void establecerFocoCampoTexto() {
        word.requestFocus(); // Establece el foco en el campo de texto
    }
}
