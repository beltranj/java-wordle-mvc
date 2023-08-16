/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author jordi
 */
public class WordleViewMenuBar extends JMenuBar{
    
    private JMenu opciones;
    private JMenuItem ranking, info , ayuda, salir;
    public WordleViewMenuBar(){
        
        this.setBackground(new Color(211, 214, 218));
        
        // Declaración de un JMenu
        opciones = new JMenu("Más opciones");
        ranking = new JMenuItem("Ranking");
        
        // Declaración de las opciones dentro de "Más opciones"
        ranking = new JMenuItem("Ranking");
        ayuda = new JMenuItem("Ayuda");
        info = new JMenuItem("Info");
        salir = new JMenuItem("Salir");
        
        // Añadir todos los componentes a la barra de Menu
        opciones.add(ayuda);
        opciones.add(info);
        opciones.add(salir);
        this.add(ranking);
        this.add(opciones);
        
        // Añadir comandos para el controlador
        ranking.setActionCommand("botonRanking");
        info.setActionCommand("botonInfo");
        salir.setActionCommand("botonSalir");
        
    }
    
    public void setActionListener(ActionListener al){
        ranking.addActionListener(al);
        ayuda.addActionListener(al);
        info.addActionListener(al);
        salir.addActionListener(al);
    }
    
    /**
     * Con tal de poder reutilizar la misma JMenuBar en las diferentes ventanas
     * según la ventana en la que estemos, con el parámetro i, cambiaremos la ayuda
     * @param i 
     */
    public void actionCommandAyuda(int i){
         ayuda.setActionCommand("botonAyuda"+i);
    }
     
    public void visibleMenu(boolean x){
         opciones.setVisible(x);
    }

}
