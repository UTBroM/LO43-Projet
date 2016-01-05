package com.catan;

public class Echange {
    private Ressources gains;
    private int quantiteGains;
    private Ressources pertes;
    private int quantitePertes;
    private Joueur joueur;

    public Echange(Ressources gains, int quantiteGains, Ressources pertes, int quantitePertes, Joueur joueur) {
        this.gains = gains;
        this.quantiteGains = quantiteGains;
        this.pertes = pertes;
        this.quantitePertes = quantitePertes;
        this.joueur = joueur;
    }

    public boolean accepter(Joueur client){

        return false;
    }

    public String toString(){

        return null;
    }
}
