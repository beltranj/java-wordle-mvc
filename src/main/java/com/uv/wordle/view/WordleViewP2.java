/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;

import com.uv.wordle.model.WordleModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jordi
 */
public class WordleViewP2 extends JFrame{

    WordleViewP2PanelJuego panelJuego;
    JPanel panelAcciones;
    
    JButton botonEnter;
    JTextField palabra;
    
    WordleViewMenuBar menubar;
    WordleModel m;
    
    public WordleViewP2(WordleModel mod){
        m = mod;
        panelJuego = new WordleViewP2PanelJuego(m);
        
        // Configuracion de la ventana
        setTitle("Wordle: Ventana del Jugador 2");
        setSize(300,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        // Barra de menu
        menubar = new WordleViewMenuBar();
        menubar.actionCommandAyuda(3);
        setJMenuBar(menubar);
        
        // Cargamos la imagen
        ImageIcon logo_ini = new ImageIcon("assets/WORDLE2.png");
        
        // Redimensionamos la imagen
        Image logo_fin = logo_ini.getImage().getScaledInstance(230, 38, Image.SCALE_SMOOTH);
        
        // Finalmente la establecemos en el JLabel
        ImageIcon logo = new ImageIcon(logo_fin);
        JLabel labelLogo = new JLabel(logo);
        labelLogo.setBackground(Color.WHITE);
        labelLogo.setOpaque(true);
        
        // JTextField para introducir la palabra a jugar en el intento
        palabra = new JTextField(10);
        palabra.setFont(new Font("Arial", Font.BOLD, 16));
        palabra.setHorizontalAlignment(JTextField.CENTER); // Centramos la fuente en el JTextField

        // Boton Enter
        botonEnter = new JButton("ENTER");
        botonEnter.setBackground(new Color(211, 214, 218));
        botonEnter.setBorderPainted(false);
        
        // JPanel con el JTextField para introducir la palabra, y el boton de ENTER
        panelAcciones = new JPanel();
        panelAcciones.setBackground(Color.WHITE);
        panelAcciones.add(palabra);
        panelAcciones.add(botonEnter);
        
        //Panel de juego
        labelLogo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(labelLogo, BorderLayout.NORTH);
        
        panelJuego.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panelJuego, BorderLayout.CENTER);
        
        panelAcciones.add(Box.createRigidArea(new Dimension(0, 50)));
        add(panelAcciones, BorderLayout.SOUTH);
        
        // Añadir comando para el Controlador
        botonEnter.setActionCommand("botonEnviar");
        
    }
    
    public void setActionListener(ActionListener al){
       botonEnter.addActionListener(al);
       menubar.setActionListener(al);
    }
    
    public void setKeyListener(KeyListener kl){
        palabra.addKeyListener(kl);
    }
    
    
    public String getPalabra()
    {
        return palabra.getText();
    }
    
    public void setPalabra(String s)
    {
        palabra.setText(s);
    }

    public void pintarFila(int[] x, int cont, char[] intento) {
        panelJuego.pintarFila(x, cont, intento);
    }
    
    public void establecerFocoCampoTexto() {
        palabra.requestFocus(); // Establece el foco en el campo de texto
    }
}
