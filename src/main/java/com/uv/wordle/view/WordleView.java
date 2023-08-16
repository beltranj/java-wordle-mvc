 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WordleView extends JFrame {
    
    JButton botonJugar;
    JButton botonAyuda;
    JButton botonSalir;
    
    public WordleView() {
        
        Dimension dimensionBotones = new Dimension(40,80);
        
        // Configuración de la ventana
        setTitle("Wordle!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 220);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        // Agregar logo a la izquierda
        JPanel panelLogo = new JPanel();
        panelLogo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Añade margen
        panelLogo.setBackground(Color.WHITE);
        
        // Cargamos la imagen
        ImageIcon logo_ini = new ImageIcon("assets/WORDLE2.png");
        
        // Redimensionamos la imagen
        Image logo_fin = logo_ini.getImage().getScaledInstance(360, 60, Image.SCALE_SMOOTH);
        
        // Finalmente la establecemos en el JLabel
        ImageIcon logo = new ImageIcon(logo_fin);
        JLabel labelLogo = new JLabel(logo);
        
        panelLogo.add(labelLogo);
        
        // Declaración del panel donde van a ir los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setAlignmentX(JPanel.CENTER_ALIGNMENT);
       
        // Botón de Jugar
        botonJugar = new JButton("JUGAR");
        botonJugar.setBackground(new Color(56, 172, 95));
        botonJugar.setForeground(Color.WHITE);
        botonJugar.setPreferredSize(dimensionBotones);
        
        // Botón de Ayuda
        botonAyuda = new JButton("AYUDA");
        botonAyuda.setBackground(new Color(202,181,87));       
        botonAyuda.setForeground(Color.WHITE);
        botonAyuda.setPreferredSize(dimensionBotones);

        // Botón de Salir
        botonSalir = new JButton("SALIR");
        botonSalir.setBackground(new Color(121,125,127));
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setPreferredSize(dimensionBotones);

        // Añadir botones al panelBotones
        panelBotones.add(Box.createRigidArea(new Dimension(75, 0)));
        panelBotones.add(botonJugar);
        
        panelBotones.add(Box.createRigidArea(new Dimension(20, 0)));
        panelBotones.add(botonAyuda);
        
        panelBotones.add(Box.createRigidArea(new Dimension(20, 0)));
        panelBotones.add(botonSalir);
        
        // Añadir paneles al JFrame
        add(panelBotones, BorderLayout.SOUTH);
        add(panelLogo, BorderLayout.CENTER);

        setVisible(true);
        
        botonSalir.setActionCommand("botonSalir");
        botonAyuda.setActionCommand("botonAyuda1");
        botonJugar.setActionCommand("botonJugar");
    }
    
    public void setActionListener(ActionListener al){
        botonSalir.addActionListener(al);
        botonAyuda.addActionListener(al);
        botonJugar.addActionListener(al);
    }
}
