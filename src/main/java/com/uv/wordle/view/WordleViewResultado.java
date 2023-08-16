/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;

import com.uv.wordle.model.WordleModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jordi
 */
public class WordleViewResultado extends JFrame{
    WordleModel m;
    PanelAcierto p1;
    PanelFallo p2;
    JButton jugar, salir;
    WordleViewMenuBar menubar;
    
    public WordleViewResultado(WordleModel mod){
        
        // Accion que ocurrirá al darle al boton de cerrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Declaración del modelo, paneles y la barra de menús
        this.m = mod;
        this.p1 = new PanelAcierto(m);
        this.p2 = new PanelFallo(m);
        this.menubar = new WordleViewMenuBar();
        this.menubar.visibleMenu(false);
        this.setJMenuBar(menubar);

        // Botón Jugar con sus propiedades
        jugar=new JButton("Jugar de nuevo");
        jugar.setBackground(new Color(121,125,127)); 
        jugar.setForeground(Color.WHITE);
        jugar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Botón Salir con sus propiedades
        salir=new JButton("Salir");
        salir.setBackground(new Color(121,125,127));
        salir.setForeground(Color.WHITE);
        salir.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Declaración de un JPanel que aparecerá en el Sur del BorderLayout con los botones de Salir y Jugar de nuevo
        JPanel botones = new JPanel();
        botones.setBackground(Color.WHITE);
        botones.add(jugar);
        botones.add(Box.createRigidArea(new Dimension(50, 0)));
        botones.add(salir);
        
        // ActionCommand de los botones
        jugar.setActionCommand("jugar");
        salir.setActionCommand("salir");
        
        // Añadir los elementos al JFrame y establecer sus propiedades
        this.add(botones, BorderLayout.SOUTH);
        this.setVisible(true);
        this.setSize(300,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    public void setActionListener(ActionListener al)
    {
        jugar.addActionListener(al);
        salir.addActionListener(al);
        p1.setActionListener(al);
        menubar.setActionListener(al);
    }
    
    public void setKeyListener(KeyListener kl){
        p1.setKeyListener(kl);
    }
    
    /**
     * Establecer el panel según se adivine la palabra o no
     * 
     * @param x [si x = 1 -> PanelAcierto // si x = 2 -> PanelFallo]
     */
    public void setPanel(int x)
    {
        if(x == 1)
        {
            add(p1, BorderLayout.CENTER);
        }
        else if(x==2)
        {
            add(p2, BorderLayout.CENTER);
        }
    }
    
    public String getNombre(){
        
        return p1.getNombreJugador();
        
    }
    
    /**
     * Llama a cambiarPaneles en el caso de que nos encontremos en el PanelAcierto
     * una vez introduzcamos el nombre cambiaremos el panel.
     */
    public void cambiarPaneles(){
        p1.cambiarPaneles();
    }
}
