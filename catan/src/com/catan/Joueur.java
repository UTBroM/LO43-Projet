package com.catan;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {
    private String nom;
    private final ArrayList<StockRessource> stockRes;
    private final ArrayList<StockDev> stockDev;
    private int score;

    public Joueur(String nom){

        stockRes = new ArrayList<StockRessource>();
        for (Ressources type:Ressources.values()
             ) {
            stockRes.add(new StockRessource(type));
        }

        stockDev = new ArrayList<StockDev>();
        for (Developpement type:Developpement.values()
                ) {
            stockDev.add(new StockDev(type));
        }
        score = 0;
        this.nom = nom;
    }

    public int getStocRes(Ressources type){
        return stockRes.get(type.ordinal()).getStock();
    }

    public void setStockRes(Ressources type, int quantite){
        stockRes.get(type.ordinal()).setStock(quantite);
    }
    
    public boolean consommerRes(int plutonium, int metal, int pierre, int laine, int cheeseburger){
        if(this.getStocRes(Ressources.PLUTONIUM)>=plutonium &&
                this.getStocRes(Ressources.METAL)>=metal &&
                this.getStocRes(Ressources.PIERRE)>=pierre &&
                this.getStocRes(Ressources.LAINE)>=laine &&
                this.getStocRes(Ressources.CHEESEBURGER)>=cheeseburger){

            this.stockRes.get(0).remove(plutonium);
            this.stockRes.get(1).remove(metal);
            this.stockRes.get(2).remove(pierre);
            this.stockRes.get(3).remove(laine);
            this.stockRes.get(4).remove(cheeseburger);

            return true;

        }
        else{
            return false;
        }
    }

    public int getStockDev(Developpement type){
        return stockDev.get(type.ordinal()).getStock();
    }

    public boolean useDev(Developpement type){
        return stockDev.get(type.ordinal()).remove(1);
    }

    public void creerDev(){
        if(this.consommerRes(0,0,1,1,1)) {
            Random aleaNum = new Random();
            Developpement type = Developpement.values()[aleaNum.nextInt(3)];
            stockDev.get(type.ordinal()).add(1);
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Route creerRoute(Noeud a, Noeud b){
        //Vérifier si la routre est construisible (reliée à une route, une colonie ou
        //une ville de même couleur et chaque coté d'hexagone ne peut contenir qu'une seule route)
        //À compléter avec la classe Noeud qui pourrais checker tout ça
        if(this.consommerRes(1,1,0,0,0)){
            return new Route(a,b,this);
        }
        else{
            return null;
        }
    }

    public boolean creerColonie(Noeud a){
        //A compléter
        //Une colonie ne peut être construite sur un croisement que si les trois croisements adjacents ne sont pas occupés par des colonies ou villes
        //La colonie doit être reliée à une route de même couleur
        if(this.consommerRes(1,1,0,1,1)) {
            this.score += 1;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean creerVille(Noeud a){
        //Seules les colonies peuvent être transformées en ville
        if(this.consommerRes(0,0,3,0,2)) {
            this.score += 1;
            return true;
        }
        else{
            return false;
        }
    }

}
