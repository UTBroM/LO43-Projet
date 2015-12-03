package com.catan;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private final ArrayList<StockRessource> stockRes;
    private final ArrayList<StockDev> stockDev;
    private int score;

    public Joueur(String nom){

        stockRes = null;
        stockDev = null;
    }

    public int getStocRes(Ressources type){

        return 0;
    }

    public void setStocRes(Ressources type){

    }

    public int getStocDev(Developpement type){

        return 0;
    }

    public void setStocDev(Developpement type){

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
