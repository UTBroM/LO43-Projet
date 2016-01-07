package com.catan;


public class Route {
    private Noeud a;
    private Noeud b;
    private Joueur joueur;

    public Route(Noeud a, Noeud b, Joueur joueur) throws RouteNonValide{
        //Vérifie si les deux points sont voisins
        if(a.estVoisin(b)){
            this.a = a;
            this.b = b;
            this.joueur = joueur;

            a.ajouterRoute(this);
            b.ajouterRoute(this);
        }
        else {
            throw new RouteNonValide();
        }

    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Noeud[] getNoeuds(){
        return new Noeud[]{a, b};
    }

}
