/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.view;

import com.uv.wordle.model.WordleModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jordi
 */
public class WordleViewP2PanelJuego extends JPanel{
    
    JTextField[][] letras;
    int n; //Para almacenar la longitud de la palabra
    WordleModel m;
    
    public WordleViewP2PanelJuego(WordleModel mod){
        
        this.m = mod;
        n = m.getLongitudPalabra();
        
        // Establecer Layout y Background al JPanel
        GridLayout panelJuegoLayout = new GridLayout(8,n);
        panelJuegoLayout.setHgap(5); // Espacio horizontal entre componentes
        panelJuegoLayout.setVgap(5); // Espacio vertical entre componentes
        setLayout(panelJuegoLayout);
        setBackground(Color.WHITE);
        
        // Declaracion de la matriz de JTextField con 8 intentos y una palabra con longitud n
        letras = new JTextField[8][n];
        
        System.out.println(n);
        
        Dimension dim = new Dimension(20, 20); // Dimension cuadrada de 20x20
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < n; j++)
            {
                // Establecemos las propiedades de cada uno de los JTextField (correspondencia a cada letra)
                letras[i][j] = new JTextField();
                letras[i][j].setFont(new Font("Arial", Font.BOLD, 20)); // Configuramos el tamaño de la fuente
                letras[i][j].setHorizontalAlignment(JTextField.CENTER); // Centramos la fuente en el JTextField
                letras[i][j].setPreferredSize(dim);
                letras[i][j].setBackground(Color.WHITE);
                letras[i][j].setForeground(Color.WHITE);
                letras[i][j].setEditable(false);
                letras[i][j].setBorder(BorderFactory.createLineBorder(new Color(211,214,218), 1));
                add(letras[i][j]);
            }
        }
    }

    /**
     * Método para cambiar el color del JTextField en función de 
     * si la palabra esta en su posición,
     * esta en la palabra pero no en la posición correcta, 
     * o si directamente no se encuentra en la palabra
     * @param x array de int, segun si el valor es 1,2 o 3 se pintara de un color u otro
     * @param cont fila del array de JTextField
     * @param intento añadir la letra a cada JTextField
     */
    void pintarFila(int[] x, int cont, char[]intento) {
        for(int i = 0; i < letras[cont].length; i++)
        {
            System.out.println(x[i]+"  ");
            switch (x[i]) {
                case 1 -> letras[cont][i].setBackground(new Color(106,170,100));
                case 2 -> letras[cont][i].setBackground(new Color(202,181,87));
                case 3 -> letras[cont][i].setBackground(new Color(121,125,127));
            }
            
            letras[cont][i].setText(Character.toString(intento[i]));
        }
    }
    
    
}
