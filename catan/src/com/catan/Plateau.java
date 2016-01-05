package com.catan;

import java.util.ArrayList;

public class Plateau {
    private ArrayList<Joueur> joueurs;
    private ArrayList<Case> cases;
    private ArrayList<Noeud> noeuds;
    private Voleur voleur;
    private ArrayList<Echange> echanges;
    private Des des;

    public Plateau(){
        joueurs = new ArrayList<Joueur>();
        joueurs.add(new Joueur("test"));
        joueurs.get(0).setStockRes(Ressources.METAL, 10);
        System.out.println("Ressources de metal : " + joueurs.get(0).getStocRes(Ressources.METAL));
        joueurs.get(0).creerDev();
        joueurs.get(0).setStockRes(Ressources.CHEESEBURGER, 10);
        joueurs.get(0).setStockRes(Ressources.LAINE, 10);
        joueurs.get(0).setStockRes(Ressources.PIERRE, 10);
        joueurs.get(0).creerDev();
    }
}
