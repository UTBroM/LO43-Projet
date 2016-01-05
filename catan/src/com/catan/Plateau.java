package com.catan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Plateau {
    private ArrayList<Joueur> joueurs;
    private ArrayList<Case> cases;
    private ArrayList<Noeud> noeuds;
    private Voleur voleur;
    private ArrayList<Echange> echanges;
    private Des des;

    public Plateau(){

        joueurs = new ArrayList<>();
        cases = new ArrayList<>();
        noeuds = new ArrayList<>();
        voleur = new Voleur();
        echanges = new ArrayList<>();
        des = new Des();

        this.generer();


        joueurs.add(new Joueur("test"));
        joueurs.get(0).setStockRes(Ressources.METAL, 10);
        System.out.println("Ressources de metal : " + joueurs.get(0).getStocRes(Ressources.METAL));
        joueurs.get(0).creerDev();
        joueurs.get(0).setStockRes(Ressources.CHEESEBURGER, 10);
        joueurs.get(0).setStockRes(Ressources.LAINE, 10);
        joueurs.get(0).setStockRes(Ressources.PIERRE, 10);
        joueurs.get(0).creerDev();

    }

    public void generer(){
        //generation des noeuds
        for (int i = 0; i < 54; i++) {
            noeuds.add(new Noeud());
        }
        //generation des cases
        for (int i = 0; i < 19; i++) {
            if(i>=0 && i<4){
                cases.add(new Case(TypeCase.REACTEUR_NUCLEAIRE));
            }
            if(i>=4 && i<7){
                cases.add(new Case(TypeCase.MONTAGNE));
            }
            if(i>=7 && i<11){
                cases.add(new Case(TypeCase.ELEVAGE));
            }
            if(i>=11 && i<15){
                cases.add(new Case(TypeCase.FAST_FOOD));
            }
            if(i>=15 && i<18){
                cases.add(new Case(TypeCase.MINE));
            }
            if(i==18){
                cases.add(new Case(TypeCase.DESERT));
            }
        }

        Collections.shuffle(cases); //Mélange des cases

        //Attribution des numéros aux cases
        int numeros[] = {4,6,9,2,5,12,4,9,8,0,8,10,3,5,10,11,3,6,11};
        for (int i = 0; i < 19; i++) {
            cases.get(i).setNumero(numeros[i]);
        }

        //Calcul les voisins de chaques noeuds
        for (int i = 0; i < 54; i++) {

            //Première ligne de noeuds
            if(i<3){
                noeuds.get(i).ajouterVoisin(noeuds.get(i+3)); //La structure de la carte étant définie on peut prédire l'emplacement des voisins
                noeuds.get(i+3).ajouterVoisin(noeuds.get(i)); //Inverse pour renseigner les voisins dans les deux cases

                noeuds.get(i).ajouterVoisin(noeuds.get(i+4)); //Les noeuds de la première cases sont reliés à deux noeuds chacun
                noeuds.get(i+4).ajouterVoisin(noeuds.get(i));
            }

            //Continue une ligne sur deux
            else if(i>=7 && i<11){
                noeuds.get(i).ajouterVoisin(noeuds.get(i+4));
                noeuds.get(i+4).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i+5));
                noeuds.get(i+5).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i-4));
                noeuds.get(i-4).ajouterVoisin(noeuds.get(i));
            }


            else if(i>=16 && i<21){
                noeuds.get(i).ajouterVoisin(noeuds.get(i+5));
                noeuds.get(i+5).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i+6));
                noeuds.get(i+6).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i-5));
                noeuds.get(i-5).ajouterVoisin(noeuds.get(i));
            }


            else if(i>=21 && i<27){
                noeuds.get(i).ajouterVoisin(noeuds.get(i+6));
            }

            else if(i>=33 && i<38){
                noeuds.get(i).ajouterVoisin(noeuds.get(i-5));
                noeuds.get(i-5).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i-6));
                noeuds.get(i-6).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i+5));
                noeuds.get(i+5).ajouterVoisin(noeuds.get(i));
            }

            else if(i>=43 && i<47){
                noeuds.get(i).ajouterVoisin(noeuds.get(i-4));
                noeuds.get(i-4).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i-5));
                noeuds.get(i-5).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i+4));
                noeuds.get(i+4).ajouterVoisin(noeuds.get(i));
            }

            else if(i>=51 && i<54){
                noeuds.get(i).ajouterVoisin(noeuds.get(i-3));
                noeuds.get(i-3).ajouterVoisin(noeuds.get(i));

                noeuds.get(i).ajouterVoisin(noeuds.get(i-4));
                noeuds.get(i-4).ajouterVoisin(noeuds.get(i));
            }
        }

        //TODO : On calcule les voisins de chaque case
        for (int i = 0; i < 19; i++) {

            if(i>=0 && i<3){
                cases.get(i).ajouterNoeud(noeuds.get(i));
                cases.get(i).ajouterNoeud(noeuds.get(i+3));
                cases.get(i).ajouterNoeud(noeuds.get(i+4));
                cases.get(i).ajouterNoeud(noeuds.get(i+7));
                cases.get(i).ajouterNoeud(noeuds.get(i+8));
                cases.get(i).ajouterNoeud(noeuds.get(i+12));
            }

            else if(i>=3 && i<7){
                cases.get(i).ajouterNoeud(noeuds.get(i+4));
                cases.get(i).ajouterNoeud(noeuds.get(i+8));
                cases.get(i).ajouterNoeud(noeuds.get(i+9));
                cases.get(i).ajouterNoeud(noeuds.get(i+13));
                cases.get(i).ajouterNoeud(noeuds.get(i+14));
                cases.get(i).ajouterNoeud(noeuds.get(i+19));
            }

            else if(i>=7 && i<12){
                cases.get(i).ajouterNoeud(noeuds.get(i+9));
                cases.get(i).ajouterNoeud(noeuds.get(i+14));
                cases.get(i).ajouterNoeud(noeuds.get(i+15));
                cases.get(i).ajouterNoeud(noeuds.get(i+20));
                cases.get(i).ajouterNoeud(noeuds.get(i+21));
                cases.get(i).ajouterNoeud(noeuds.get(i+26));
            }

            else if(i>=12 && i<16){
                cases.get(i).ajouterNoeud(noeuds.get(i+16));
                cases.get(i).ajouterNoeud(noeuds.get(i+21));
                cases.get(i).ajouterNoeud(noeuds.get(i+22));
                cases.get(i).ajouterNoeud(noeuds.get(i+26));
                cases.get(i).ajouterNoeud(noeuds.get(i+27));
                cases.get(i).ajouterNoeud(noeuds.get(i+31));
            }
            else if(i>=16 && i<19){
                cases.get(i).ajouterNoeud(noeuds.get(i+23));
                cases.get(i).ajouterNoeud(noeuds.get(i+27));
                cases.get(i).ajouterNoeud(noeuds.get(i+28));
                cases.get(i).ajouterNoeud(noeuds.get(i+31));
                cases.get(i).ajouterNoeud(noeuds.get(i+32));
                cases.get(i).ajouterNoeud(noeuds.get(i+35));
            }
        }

        System.out.println("Généré !");
    }

}
