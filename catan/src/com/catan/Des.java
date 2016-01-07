package com.catan;

import java.util.Random;

public class Des {
    //Classe qui simule un jet de deux dés
    private int valeur; //Pour garder la valeur du dernier lancer
    private final Random aleaNum;

    public Des(){
        aleaNum = new Random();
        valeur = 0;
    }

    public int lancer() {
        //Simuler un lancer de deux dés
        int a = aleaNum.nextInt(6)+1;
        int b = aleaNum.nextInt(6)+1;
        valeur = a + b;
        return valeur;
    }

    public int getValeur() {
        return valeur;
    }
}
