package com.catan;

import java.util.ArrayList;

public class Noeud {
    private TypeNoeud type;
    private ArrayList<Route> routes;
    private final ArrayList<Noeud> voisins;
    private Joueur joueur;

    public Noeud(TypeNoeud type){
        this.type = type;
        voisins = null;
        joueur = null;
    }
}
