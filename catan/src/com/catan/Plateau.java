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
        System.out.println(joueurs.get(0).getStocRes(Ressources.METAL));
    }
}
