/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.wordle.model;

import java.util.ArrayList;

/**
 *
 * @author jordi
 */
public class WordleModel {
    
    // Variables de juego
    int longitudPalabra;
    String palabra;
    int intento;
    
    // Variables que almacenan el ranking
    ArrayList<Integer> intentos = new ArrayList<>();
    ArrayList<String> nombresJugadores  = new ArrayList<>();
    ArrayList<String> palabraJugada = new ArrayList<>();
    int contador = 0;
    
    /**
     * Método que devuelve la longitud de la palabra almacenada en el modelo
     * @return longitud de la palabra (int)
     */
    public int getLongitudPalabra() {
        return palabra.length();
    }

    /**
     * Método que establece la longitud que tiene la palabra a almacenar en el modelo
     * @param longitudPalabra 
     */
    public void setLongitudPalabra(int longitudPalabra) {
        this.longitudPalabra = longitudPalabra;
    }
    
    /**
     * Método que devuelve la palabra almacenada en el modelo
     * @return 
     */
    public String getPalabra() {
        return palabra;
    }
    /**
     * Método que establece la palabra en el modelo
     * @param palabra 
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * Método relacionado con el ranking
     * Obtiene el número de intentos con el que se resuelve el Wordle
     * @return intento (int)
     */
    public int getIntento() {
        return intento;
    }

    /**
     * Método relacionado con el ranking
     * Establece el contador de intentos (útil para reestablecer a 0 tras cada partida)
     * @param intento
     */
    public void setIntento(int intento) {
        this.intento = intento;
    }

    /**
     * Método relacionado con el ranking
     * Devuelve un array donde se almacenan los intentos de las 10 mejores partidas
     * @return array con los intentos de cada jugador
     */
    public ArrayList<Integer> getIntentos() {
        return intentos;
    }

    /**
     * Método relacionado con el ranking
     * Establece el array donde se almacenan los intentos de las 10 mejores partidas
     * @param intentos 
     */
    public void setIntentos(ArrayList<Integer> intentos) {
        this.intentos = intentos;
    }

    /**
     * Método relacionado con el ranking
     * Devuelve un array donde se almacenan los jugadores de las 10 mejores partidas
     * @return array de nombres de Jugadores
     */
    public ArrayList<String> getNombresJugadores() {
        return nombresJugadores;
    }
    /**
     * Método relacionado con el ranking
     * Establece el array donde se almacenan los nombres de los jugadores de las 10 mejores partidas
     * @param nombresJugadores 
     */
    public void setNombresJugadores(ArrayList<String> nombresJugadores) {
        this.nombresJugadores = nombresJugadores;
    }

    /**
     * Método relacionado con el ranking
     * Devuelve un array donde se almacenan las palabras jugadas de las 10 mejores partidas
     * @return array con las palabras jugadas en las distintas partidas
     */
    public ArrayList<String> getPalabraJugada() {
        return palabraJugada;
    }

    /**
     * Método relacionado con el ranking
     * Establece el array donde se almacenan las palabras jugadas en las 10 mejores partidas
     * @param palabraJugada 
     */
    public void setPalabraJugada(ArrayList<String> palabraJugada) {
        this.palabraJugada = palabraJugada;
    }
    
    
    /* Implementación de un algoritmo de ordenación para el ranking (Quicksort)*/
    
    public void quickSort(ArrayList<Integer> arr, ArrayList<String> arr1, ArrayList<String> arr2, int low, int high) {
        if (low < high) {
            int pi = partition(arr, arr1, arr2, low, high);
            quickSort(arr, arr1, arr2, low, pi - 1);
            quickSort(arr, arr1, arr2, pi + 1, high);
        }
    }

    public int partition(ArrayList<Integer> arr, ArrayList<String> arr1, ArrayList<String> arr2, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                swap(arr, i, j);
                swap2(arr1, i, j);
                swap2(arr2, i, j);
            }
        }
        swap(arr, i + 1, high);
        swap2(arr1, i + 1, high);
        swap2(arr2, i + 1, high);
        return i + 1;
    }

    public void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public void swap2(ArrayList<String> arr, int i, int j) {
        String temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }    
}
