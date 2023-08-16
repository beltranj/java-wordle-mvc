/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.uv.wordle;

import com.uv.wordle.controller.WordleController;
import com.uv.wordle.model.WordleModel;
import com.uv.wordle.view.WordleView;

/**
 *
 * @author jordi
 */
public class Wordle {
    
    
    public static void main(String[] args) {
        WordleView v = new WordleView();
        WordleModel m = new WordleModel();
        
        WordleController c = new WordleController(v, m);
        
    }
}
