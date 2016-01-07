package com.catan;


public class Route {
    private Noeud a;
    private Noeud b;
    private Joueur joueur;

    public Route(Noeud a, Noeud b, Joueur joueur) {
        //Vérifie si les deux points sont voisins
        //TODO : lancer une exception si ça échoue
        if(a.estVoisin(b)){
            this.a = a;
            this.b = b;
            this.joueur = joueur;

            a.ajouterRoute(this);
            b.ajouterRoute(this);
        }

    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Noeud[] getNoeuds(){
        return new Noeud[]{a, b};
    }

}
