package com.catan;


import java.util.ArrayList;

public class Route {
    private Noeud a;
    private Noeud b;
    private Joueur joueur;

    public Route(Noeud a, Noeud b, Joueur joueur) {
        this.a = a;
        this.b = b;
        this.joueur = joueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Noeud[] getNoeuds(){
        Noeud[] liste = {a, b};
        return liste;
    }

}
