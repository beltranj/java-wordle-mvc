/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;

import com.uv.wordle.model.WordleModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jordi
 */
public class WordleViewRanking extends JFrame{

    WordleModel model;
    JLabel[] lista;
    JLabel titulo;
    
    public WordleViewRanking(WordleModel m){
        
        this.model=m;
        
        // Añadir las propiedades del JFrame
        this.setSize(300,600);
        this.setTitle("Ranking");
        this.setResizable(false);
        this.setType(Window.Type.UTILITY);
        this.setLocationRelativeTo(null);
        
        // JLabel con sus propiedades
        titulo = new JLabel("RANKING!");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.ORANGE);
        
        // JPanel panelTitulo donde añadimos el JLabel titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(titulo);
        panelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // JPanel p para mostrar los resultados del ranking y sus propiedades
        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        BoxLayout layout = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(layout);
        
        if(!model.getIntentos().isEmpty())
        {
            lista = new JLabel[model.getIntentos().size()];
            for(int i =0; i < lista.length; i++)
            {
                int cont = i+1;

                lista[i] = new JLabel("#"+cont+".    "+model.getNombresJugadores().get(i)+"    -    "+model.getIntentos().get(i)+"    -    "+model.getPalabraJugada().get(i));
                p.add(Box.createRigidArea(new Dimension(0, 30)));
                p.add(lista[i]);
            }    
        }
        else
        {
            // Si no se encuentran resultados
            JLabel no_results = new JLabel("NO hay ranking guardado");
            p.add(Box.createRigidArea(new Dimension(0, 30)));
            p.add(no_results);
            p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

            no_results.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        
        // Añadir los elementos al JFrame
        this.add(panelTitulo, BorderLayout.NORTH);   
        this.add(p, BorderLayout.CENTER);
        this.setVisible(true);
    }
    
}
