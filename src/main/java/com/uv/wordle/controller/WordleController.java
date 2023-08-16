/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.controller;

import com.uv.wordle.model.WordleModel;
import com.uv.wordle.view.WordleView;
import com.uv.wordle.view.WordleViewP1;
import com.uv.wordle.view.WordleViewP2;
import com.uv.wordle.view.WordleViewRanking;
import com.uv.wordle.view.WordleViewResultado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

/**
 *
 * @author jordi
 */
public class WordleController {

    private WordleView view;
    private WordleViewP1 viewP1;
    private WordleViewP2 viewP2;
    private WordleViewResultado viewResultado;
    private WordleViewRanking viewRanking;
    private WordleModel model;
    private int cont;
    
    public WordleController(WordleView v, WordleModel m){
        
        this.view = v;
        this.model = m;
        cont = 1; // Variable para el control de intentos, inicializado a 1 porque los intentos empiezan de 1 y no 0
        
        // Action y Window Listeners para la Pantalla Principal
        view.addWindowListener(new WordleControllerWindowListener());
        view.setActionListener(new WordleControllerActionListener());
        
        // Action y Window Listeners para la Pantalla del Jugador 1
        viewP1 = new WordleViewP1();
        viewP1.addWindowListener(new WordleControllerWindowListenerP1());
        viewP1.setKeyListener(new WordleControllerKeyListenerP1());
        viewP1.setActionListener(new WordleControllerActionListener());
        
    }
    
    /**
     * Clase encargada de los eventos de la ventana del Jugador 2
     */
    class WordleControllerWindowListenerP2 extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) { // Cuando abrimos la ventana del Jugador 2 se establece el foco en el campo de texto
            viewP2.establecerFocoCampoTexto();
        }
        
        @Override
        public void windowClosing(WindowEvent e){
            System.out.println("Jugador 2: Cerrar ventana");
            System.exit(0);
        }
        
    }
    
    /**
     * Clase encargada de los eventos de ventana del Jugador 1
     */
    class WordleControllerWindowListenerP1 extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) { // Cuando abrimos la ventana del Jugador 1 se establece el foco en el campo de texto
            viewP1.establecerFocoCampoTexto();
        }
        
        @Override
        public void windowClosing(WindowEvent e){
            System.out.println("Jugador 1: Cerrar ventana");
            System.exit(0);
        }
        
    }
    
    /**
     * Clase encargada de los eventos de ventana del menú principal
     */
    class WordleControllerWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e){
            System.out.println("Ventana principal: Cerrar ventana");
            System.exit(0);
        }
    }
    
    /**
     * Clase encargada de los eventos de teclado para el Jugador 2, puedes jugar dandole al boton ENTER del teclado
     */
    class WordleControllerKeyListenerP2 extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                
                //Comprobamos si la palabra introducida tiene el numero de letras necesario
                if(viewP2.getPalabra().length() == model.getLongitudPalabra()){
                    
                    //Si las palabras coinciden, si es así, mostramos pantalla de acierto
                    if(viewP2.getPalabra().toUpperCase().equals(model.getPalabra()))
                    {
                        viewP2.dispose(); // cerrar ventana y liberar recursos
                        model.setIntento(cont); // añadir 1 al contador de intentos de la palabra
                        
                        // Abrimos el JFrame de WordleViewResultado con el JPanel de Acierto
                        viewResultado = new WordleViewResultado(model);
                        viewResultado.setActionListener(new WordleControllerActionListener());
                        viewResultado.setPanel(1);
                        viewResultado.setVisible(true);
                    }
                    else
                    {
                        //Dividimos los string en caracteres
                        char[] intento = viewP2.getPalabra().toUpperCase().toCharArray();
                        char[] correcta = model.getPalabra().toCharArray();

                        //Array que dirá si es fallo o acierto
                        int[] x = new int[intento.length];

                        //Recorremos las palabras
                        for (int i = 0; i < model.getLongitudPalabra(); i++) {
                            
                            System.out.println("INTENTO " + intento[i]);
                            System.out.println("CORRECTA " + correcta[i]);

                            //Si está en su posicion ponemos un 1 en el vector x
                            if (intento[i] == correcta[i]) {
                                x[i] = 1; //letra y posicion
                            }
                            //Si no está en su posición
                            else {
                                boolean encontrada = false;
                                boolean coincidenciaPosicion = false;
                                //Recorremos la palabra almacenada en el modelo entera de nuevo
                                for (int j = 0; j < correcta.length; j++) {
                                    //Si está en alguna posición asignamos encontrada a true
                                    if (intento[i] == correcta[j]) {
                                        encontrada = true;
                                        //Si la posición es la misma asignamos coincidencia a true
                                        if (i == j) {
                                            coincidenciaPosicion = true;
                                        }
                                    }
                                }
                                //Si está en el vector y su posicion es la misma enviamos un 1 para pintar en verde
                                if (encontrada && coincidenciaPosicion) {
                                    x[i] = 1; //letra y posicion
                                }
                                //Si solo la hemos encontrado asignamos un 2 para pintar en naranja
                                else if (encontrada) {
                                    x[i] = 2; //letra
                                } 
                                //Si no la hemos encontrado asignamos un 3 para pintar en gris
                                else {
                                    x[i] = 3; //ni letra ni posicion
                                }
                            }
                        }
                        //x vector con los resultados para pintar el fondo de cada casilla
                        //cont para pintar la fila en la que estamos
                        //intento para asignar el caracter a cada casilla
                        viewP2.pintarFila(x, cont-1, intento);
                        System.out.println("CONTADOR: "+cont);
                        //almacenamos intento
                        model.setIntento(cont);
                        //incrementamos contador para ir a la siguiente fila
                        cont++;

                        //Si hemos llegado al máximo de intentos mostramos pantalla de fallo
                        if(cont>8)
                        {
                            //cerramos ventana
                            viewP2.dispose();
                            
                            //guardamos intentos
                            model.setIntento(cont);
                            
                            //enviamos al jframe de palabra acertada
                            viewResultado = new WordleViewResultado(model);
                            viewResultado.setActionListener(new WordleControllerActionListener());
                            
                            //activar panel de fallo
                            viewResultado.setPanel(2);
                            viewResultado.setVisible(true);

                        }

                    }
                } 
                else
                {
                    JOptionPane.showMessageDialog(viewP2, "Introduce una palabra con "+model.getLongitudPalabra()+" letras.", "Wordle - Error", ERROR_MESSAGE);
                }
                viewP2.setPalabra("");
            }
        } 
    }
    
    /**
     * Clase encargada de los eventos de teclado para el Jugador 1, puedes jugar dandole al boton ENTER del teclado
     */
    class WordleControllerKeyListenerP1 extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(!viewP1.getPalabraP1().isEmpty())
                {
                    if(viewP1.getLongitudPalabraP1() == viewP1.getLongitudP1()){
                        // Le pasamos a nuestro modelo la longitud de la palabra
                        model.setLongitudPalabra(viewP1.getLongitudPalabraP1());
                        model.setPalabra(viewP1.getPalabraP1().toUpperCase());
                        viewP1.dispose(); // La ventana se oculta

                        System.out.println(model.getLongitudPalabra() + model.getPalabra()); // Comprobación de que estamos guardando la palabra en el modelo

                        // Abrimos la vista del Jugador 2.
                        viewP2 = new WordleViewP2(model);
                        viewP2.setActionListener(new WordleControllerActionListener());
                        viewP2.setKeyListener(new WordleControllerKeyListenerP2());
                        viewP2.setVisible(true);
                    }
                    else
                    {
                        // En el caso de que no concuerde el numero de letras deseado con la longitud de la palabra introducida sale error.
                        JOptionPane.showMessageDialog(viewP1, "Asegurate de introducir una palabra con el mismo número de letras que has introducido", "Wordle - Error", ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(viewP1, "Introduce una palabra para jugar", "Wordle - Error", ERROR_MESSAGE);
                }
            }
        }
    }
    /**
     * Clase encargada de los eventos de teclado para el Jugador 2 una vez ha terminado la partida
     */
    class WordleControllerKeyListenerResultado extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
            
                if(viewResultado.getNombre().equals(""))
                {
                    JOptionPane.showMessageDialog(viewResultado, "Introduce un nombre válido.", "Wordle - Error", ERROR_MESSAGE);
                }
                else
                {
                    
                    System.out.println(viewResultado.getNombre() + model.getIntento() + model.getPalabra());
                    
                    if(model.getIntentos().size()<10)
                    {
                        model.getIntentos().add(model.getIntento());
                        model.getPalabraJugada().add(model.getPalabra());
                        model.getNombresJugadores().add(viewResultado.getNombre());
                        model.quickSort(model.getIntentos(), model.getPalabraJugada(), model.getNombresJugadores(), 0, model.getIntentos().size() - 1);
                    }
                    else
                    {
                        model.getIntentos().add(model.getIntento());
                        model.getPalabraJugada().add(model.getPalabra());
                        model.getNombresJugadores().add(viewResultado.getNombre());

                        model.quickSort(model.getIntentos(), model.getPalabraJugada(), model.getNombresJugadores(), 0, model.getIntentos().size()-1);

                        model.getIntentos().remove(model.getIntentos().size()-1);
                        model.getPalabraJugada().remove(model.getPalabraJugada().size()-1);
                        model.getNombresJugadores().remove(model.getNombresJugadores().size()-1);
                    }
                    viewResultado.cambiarPaneles();
                }
            }
        }
    }
    /**
     * Clase encargada de los eventos del usuario con los diferentes elementos de la aplicacion: botones, radio buttons...
     */
    class WordleControllerActionListener implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            switch (command){
                
                // Botones - Pantalla principal
                case "botonSalir":
                    System.out.println("Wordle : Boton 'Salir'.");
                    System.exit(0);
                    break;
                    
                case "botonAyuda1":
                    System.out.println("Wordle : Boton 'Ayuda'.");
                    JOptionPane.showMessageDialog(view, "Bienvenido a Wordle! Pulse en el botón jugar y introduzca la palabra con la que quiere retar a su amigo. Seguidamente vea si su rival es capaz de acertarla :)", "Wordle - Ayuda", QUESTION_MESSAGE);
                    break;
                    
                case "botonAyuda2":
                    System.out.println("Wordle : Boton 'Ayuda'.");
                    JOptionPane.showMessageDialog(view, "Elige el número de letras y escribe la palabra a adivinar :)", "Wordle - Ayuda", QUESTION_MESSAGE);
                    break;
                    
                case "botonAyuda3":
                    System.out.println("Wordle : Boton 'Ayuda'.");
                    JOptionPane.showMessageDialog(view, "GRIS: ¡Oh, no! La letra no está.\nNARANJA: ¡CASI! La letra está en otra posición.\nVERDE: ¡Has acertado la letra!", "Wordle - Ayuda", QUESTION_MESSAGE);
                    break;
                    
                case "botonJugar":
                    System.out.println("Wordle : Boton 'Jugar'.");
                    view.dispose();
                    viewP1.setVisible(true);
                    break;
                    
                // Botones - Pantalla jugador 1
                case "longitud_3":
                    viewP1.setLongitudP1(3);
                    System.out.println("Wordle : Boton 'Longitud palabra 3'.");                    
                    break;
                    
                case "longitud_4":  
                    viewP1.setLongitudP1(4);
                    System.out.println("Wordle : Boton 'Longitud palabra 4'.");                   
                    break; 
                    
                case "longitud_5":
                    viewP1.setLongitudP1(5);
                    System.out.println("Wordle : Boton 'Longitud palabra 5'.");
                    break;
                    
                case "btn_jugarP1":
                    if(!viewP1.getPalabraP1().isEmpty())
                    {

                        if( viewP1.getLongitudPalabraP1() == viewP1.getLongitudP1() )
                        {

                            // Le pasamos a nuestro modelo la longitud de la palabra
                            model.setLongitudPalabra(viewP1.getLongitudPalabraP1());
                            model.setPalabra(viewP1.getPalabraP1().toUpperCase());
                            viewP1.dispose(); // La ventana se oculta

                            System.out.println(model.getLongitudPalabra() + model.getPalabra()); // Comprobación de que estamos guardando la palabra en el modelo

                            // Abrimos la vista del Jugador 2.
                            viewP2 = new WordleViewP2(model);
                            viewP2.setActionListener(new WordleControllerActionListener());
                            viewP2.addWindowListener(new WordleControllerWindowListenerP2());
                            viewP2.setKeyListener(new WordleControllerKeyListenerP2());
                            viewP2.setVisible(true);
                            
                        }
                        else
                        {
                            // En el caso de que no concuerde el numero de letras deseado con la longitud de la palabra introducida sale error.
                            JOptionPane.showMessageDialog(viewP1, "Asegurate de introducir una palabra con el mismo número de letras que has introducido", "Wordle - Error", ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(viewP1, "Introduce una palabra para continuar", "Wordle - Error", ERROR_MESSAGE);
                    }
                    break;
       
                // Enviar palabra - Pantalla Jugador 2
                case "botonEnviar":
                    
                    //Si la palabra introducida tiene el numero de letras necesario
                    if(viewP2.getPalabra().length() == model.getLongitudPalabra()){
                         //Vemos si las palabras coinciden, si es así, mostramos pantalla de acierto
                        if(viewP2.getPalabra().toUpperCase().equals(model.getPalabra()))
                        {
                            viewP2.dispose(); // cerrar ventana y liberar recursos
                            model.setIntento(cont); // añadir 1 al contador de intentos de la palabra
                            
                            // Abrimos el JFrame de WordleViewResultado con el JPanel de Acierto
                            viewResultado = new WordleViewResultado(model);
                            viewResultado.setActionListener(new WordleControllerActionListener());
                            viewResultado.setKeyListener(new WordleControllerKeyListenerResultado());
                            viewResultado.setPanel(1);
                            viewResultado.setVisible(true);
                        }
                        else
                        {
                            //Dividimos los string en caracteres
                            char[] intento = viewP2.getPalabra().toUpperCase().toCharArray();
                            char[] correcta = model.getPalabra().toCharArray();
                            
                            //Array que dirá si es fallo o acierto
                            int[] x=new int[intento.length];
                            
                            //Recorremos las palabras
                            for (int i = 0; i < model.getLongitudPalabra(); i++) 
                            {
                                System.out.println("INTENTO " + intento[i]);
                                System.out.println("CORRECTA " + correcta[i]);
                                
                                //Si está en su posicion ponemos un 1 en el vector x
                                if (intento[i] == correcta[i])
                                {
                                    x[i] = 1; //letra y posicion
                                }
                                //Si no está en su posición
                                else {
                                    boolean encontrada = false;
                                    boolean coincidenciaPosicion = false;
                                    
                                    //Recorremos la palabra almacenada en el modelo entera de nuevo
                                    for (int j = 0; j < correcta.length; j++) {
                                        //Si está en alguna posición asignamos encontrada a true
                                        if (intento[i] == correcta[j]) {
                                            encontrada = true;
                                            //Si la posición es la misma asignamos coincidencia a true
                                            if (i == j) {
                                                coincidenciaPosicion = true;
                                            }
                                        }
                                    }
                                    
                                    //Si está en el vector y su posicion es la misma enviamos un 1 para pintar en verde
                                    if (encontrada && coincidenciaPosicion) {
                                        x[i] = 1; //letra y posicion
                                    }
                                    //Si solo la hemos encontrado asignamos un 2 para pintar en naranja
                                    else if (encontrada) {
                                        x[i] = 2; //letra
                                    } 
                                    //Si no la hemos encontrado asignamos un 3 para pintar en gris
                                    else {
                                        x[i] = 3; //ni letra ni posicion
                                    }
                                    
                                }
                            }
                            
                            //x vector con los resultados para pintar el fondo de cada casilla
                            //cont para pintar la fila en la que estamos
                            //intento para asignar el caracter a cada casilla
                            viewP2.pintarFila(x, cont-1, intento);
                            System.out.println("CONTADOR: "+cont);
                            //almacenamos intento
                            model.setIntento(cont);
                            //incrementamos contador para ir a la siguiente fila
                            cont++;

                            //Si hemos llegado al máximo de intentos mostramos pantalla de fallo
                            if(cont>8)
                            {
                                model.setIntento(8);
                                viewP2.dispose();
                                model.setIntento(cont);
                                //enviamos al jframe de palabra acertada
                                viewResultado = new WordleViewResultado(model);
                                viewResultado.setActionListener(new WordleControllerActionListener());
                                viewResultado.setKeyListener(new WordleControllerKeyListenerResultado());
                                viewResultado.setPanel(2);
                                viewResultado.setVisible(true);
                            }

                        }
                    }else{
                        JOptionPane.showMessageDialog(viewP2, "Introduce una palabra con "+model.getLongitudPalabra()+" letras.", "Wordle - Error", ERROR_MESSAGE);

                    }
                   viewP2.setPalabra("");
                    break;
                    
                case "salir":
                    System.exit(0);
                    break;

                case "jugar":
                    viewResultado.dispose();
                    cont=1;
                    model.setIntento(0);
                    viewP1.setVisible(true);
                    break;
                
                // Botones JMenuBar
                case "botonInfo":
                    JOptionPane.showMessageDialog(view, "Proyecto final realizado por: \nJordi Beltran y Alberto Játiva", "Wordle - Autores", INFORMATION_MESSAGE);
                    break;

                case "botonRanking":
                    viewRanking = new WordleViewRanking(model);
                    viewRanking.setVisible(true);
                    break;
                    
                case "anyadeRanking":
                    if(viewResultado.getNombre().equals(""))
                    {
                        JOptionPane.showMessageDialog(viewResultado, "Introduce un nombre válido.", "Wordle - Error", ERROR_MESSAGE);
                    }
                    else
                    {
                        System.out.println(viewResultado.getNombre() + model.getIntento() + model.getPalabra());
                        if(model.getIntentos().size()<10)
                        {
                            
                            model.getIntentos().add(model.getIntento());
                            model.getPalabraJugada().add(model.getPalabra());
                            model.getNombresJugadores().add(viewResultado.getNombre());
                            model.quickSort(model.getIntentos(), model.getPalabraJugada(), model.getNombresJugadores(), 0, model.getIntentos().size() - 1);
                        
                        }
                        else
                        {
                            
                            model.getIntentos().add(model.getIntento());
                            model.getPalabraJugada().add(model.getPalabra());
                            model.getNombresJugadores().add(viewResultado.getNombre());

                            model.quickSort(model.getIntentos(), model.getPalabraJugada(), model.getNombresJugadores(), 0, model.getIntentos().size()-1);

                            model.getIntentos().remove(model.getIntentos().size()-1);
                            model.getPalabraJugada().remove(model.getPalabraJugada().size()-1);
                            model.getNombresJugadores().remove(model.getNombresJugadores().size()-1);
                            
                        }
    
                    }
                    viewResultado.cambiarPaneles();
                    break;
            }
        }
    }
}
