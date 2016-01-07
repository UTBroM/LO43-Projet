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

    public TypeNoeud getType() {
        return type;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public boolean ajouterRoute(Route route){

        if(route.getNoeuds()[0] == this || route.getNoeuds()[1] == this){
            routes.add(route);
            return true;
        }
        else {
            return false;
        }
    }

    public void ajouterVoisin(Noeud voisin){
        voisins.add(voisin);
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public boolean estVoisin(Noeud testNoeud){
        for (Noeud voisin:voisins
             ) {
            if(voisin == testNoeud){
                return true;
            }
        }

        return false;
    }
}
