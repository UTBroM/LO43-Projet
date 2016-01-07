package com.catan;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {
    private final String nom;
    private final ArrayList<Stock<Ressources>> stockRes;
    private final ArrayList<Stock<Developpement>> stockDev;
    private int score;

    public Joueur(String nom){

        stockRes = new ArrayList<>();
        for (Ressources type:Ressources.values()
             ) {
            stockRes.add(new Stock<>(type));
        }

        stockDev = new ArrayList<>();
        for (Developpement type:Developpement.values()
                ) {
            stockDev.add(new Stock<>(type));
        }
        score = 0;
        this.nom = nom;
    }

    public int getStockRes(Ressources type){
        return stockRes.get(type.ordinal()).getStock();
    }

    public void setStockRes(Ressources type, int quantite){
        stockRes.get(type.ordinal()).setStock(quantite);
    }
    
    public boolean consommerRes(int plutonium, int metal, int pierre, int laine, int cheeseburger){
        if(this.getStockRes(Ressources.PLUTONIUM)>=plutonium &&
                this.getStockRes(Ressources.METAL)>=metal &&
                this.getStockRes(Ressources.PIERRE)>=pierre &&
                this.getStockRes(Ressources.LAINE)>=laine &&
                this.getStockRes(Ressources.CHEESEBURGER)>=cheeseburger){

            try {
                this.consommerUneRes(Ressources.PLUTONIUM, plutonium);
                this.consommerUneRes(Ressources.METAL, metal);
                this.consommerUneRes(Ressources.PIERRE, pierre);
                this.consommerUneRes(Ressources.LAINE, laine);
                this.consommerUneRes(Ressources.CHEESEBURGER, cheeseburger);
            } catch (PasAssezDeRessourcesException e) {
                System.out.println("Erreur " + e);
                return false;
            }

            return true;

        }
        else{
            return false;
        }
    }

    public void consommerUneRes(Ressources type, int quantite) throws PasAssezDeRessourcesException{
        try{
            this.stockRes.get(type.ordinal()).remove(quantite);
        }
        catch (PasAssezDeRessourcesException e){
            throw new PasAssezDeRessourcesException(this.nom + " : " + e);
        }
    }

    public void ajouterUneRes(Ressources type, int quantite){
        this.stockRes.get(type.ordinal()).add(quantite);

    }

    public int getStockDev(Developpement type){
        return stockDev.get(type.ordinal()).getStock();
    }

    public boolean useDev(Developpement type) throws PasAssezDeRessourcesException{
        try {
            return stockDev.get(type.ordinal()).remove(1);
        } catch (PasAssezDeRessourcesException e) {
            throw e;
        }
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

    public String getNom() {
        return nom;
    }

    public Route creerRoute(Noeud a, Noeud b) throws RouteNonValide{
        if((a.connectable(this, b) || b.connectable(this, a)) && this.consommerRes(1,1,0,0,0)){
            try {
                return new Route(a,b,this);
            } catch (RouteNonValide routeNonValide) {
                routeNonValide.printStackTrace();
            }
        }
        else{
            throw new RouteNonValide("Il est interdit de placer une route ici ou "+ this.nom +" n'a pas assez de ressources");
        }
        return null;

    }

    public void creerColonie(Noeud a) throws ConstructionBatimentException, PasAssezDeRessourcesException{
        //Une colonie ne peut être construite sur un croisement que si les trois croisements adjacents ne sont pas occupés par des colonies ou villes
        //La colonie doit être reliée à une route de même couleur
        if(a.coloniePossible(this)) {
            if(this.consommerRes(1,1,0,1,1)) {
                a.changerType(TypeNoeud.COLONIE);
                a.setJoueur(this);
                this.score += 1;
            }
            else{
                throw new PasAssezDeRessourcesException(this.nom + " n'a pas assez de ressources pour construire une colonie");
            }
        }
        else{
            throw new ConstructionBatimentException("Interdit de construire une colonie ici");
        }
    }

    public void creerVille(Noeud a) throws ConstructionBatimentException, PasAssezDeRessourcesException{
        //Seules les colonies peuvent être transformées en ville
        if(a.villePosssible(this)) {
            if(this.consommerRes(0,0,3,0,2)) {
                a.changerType(TypeNoeud.VILLE);
                this.score += 1;
            }
            else {
                throw new PasAssezDeRessourcesException(this.nom + " n'a pas assez de ressources pour construire une ville");
            }
        }
        else{
            throw new ConstructionBatimentException("Interdit de construire une ville ici");
        }
    }

}
