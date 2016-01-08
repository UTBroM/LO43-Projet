package com.catan;

import java.util.ArrayList;

public class Noeud {
    private TypeNoeud type;
    private final ArrayList<Route> routes;
    private final ArrayList<Noeud> voisins;
    private Joueur joueur;

    public Noeud(){
        this.type = TypeNoeud.VIDE;
        routes = new ArrayList<>();
        voisins = new ArrayList<>();
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

    public void ajouterRoute(Route route) throws RouteNonValide{

        if(route.getNoeuds()[0] == this || route.getNoeuds()[1] == this){
            routes.add(route);
        }
        else {
            throw new RouteNonValide("Cette route n'est pas connectée à ce point");
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

    public boolean connectable(Joueur joueur, Noeud destination){
        boolean bonneRouteConnecte = false;
        boolean unique = true;
        for (Route route:routes
             ) {
            bonneRouteConnecte = route.getJoueur() == joueur || bonneRouteConnecte; //Vérifie qu'au moins une route est de la bonne couleur
            unique = !(route.getNoeuds()[0] == destination || route.getNoeuds()[1] == destination) && unique; //Vérifie que la route n'est pas en double
        }
        return (this.joueur == joueur || bonneRouteConnecte) && unique;
    }

    public boolean coloniePossible(Joueur joueur){

        if (this.type != TypeNoeud.VIDE){
            return false;
        }
        else {
            boolean voisinsOK = true;
            boolean routesOK = false;

            for (Noeud noeud : voisins
                    ) {
                voisinsOK = noeud.getType() == TypeNoeud.VIDE && voisinsOK; //Les cases adjacentes doivent être vides
            }
            for (Route route : routes
                    ) {
                routesOK = route.getJoueur() == joueur || routesOK; //Une route doit être du bon joueur
            }
            return voisinsOK && routesOK;
        }
    }

    public boolean villePosssible(Joueur joueur){
        return this.type == TypeNoeud.COLONIE && this.joueur == joueur;
    }
}
