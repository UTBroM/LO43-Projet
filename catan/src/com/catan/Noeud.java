package com.catan;

import java.util.ArrayList;

public class Noeud {
    private TypeNoeud type;
    private ArrayList<Route> routes;
    private final ArrayList<Noeud> voisins;
    private Joueur joueur;

    public Noeud(){
        this.type = TypeNoeud.VIDE;
        routes = new ArrayList<Route>();
        voisins = new ArrayList<Noeud>();
        joueur = null;
    }

    public void changerType(TypeNoeud type){
        this.type = type;
    }

    public boolean ajouterRoute(Route route){

        return false;
    }

    public void ajouterVoisin(Noeud voisin){
        voisins.add(voisin);
    }

}
