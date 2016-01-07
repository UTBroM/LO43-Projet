package com.catan;

import java.util.ArrayList;
import java.util.Collections;

public class Plateau {
    private ArrayList<Joueur> joueurs;
    private ArrayList<Case> cases;
    private ArrayList<Noeud> noeuds;
    private ArrayList<Route> routes;
    private Voleur voleur;
    private ArrayList<Echange> echanges;
    private Des des;

    public Plateau(){

        joueurs = new ArrayList<>();
        cases = new ArrayList<>();
        noeuds = new ArrayList<>();
        echanges = new ArrayList<>();
        routes = new ArrayList<>();
        des = new Des();

        this.generer();

        //Le voleur est placé sur la case désert
        for (Case curcase:cases
             ) {
            if(curcase.getType() == TypeCase.DESERT){
                voleur = new Voleur(curcase);
            }
        }


    }

    private void generer(){
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

    private void debutTour(){

        final int lancer = des.lancer(); //On lance les dés
        for (Case curcase:cases
             ) {
            if(curcase.getType() != TypeCase.DESERT && curcase != voleur.getPosition() && curcase.getNumero() == lancer) {
                for (Noeud curnoeud : curcase.getNoeuds()
                        ) {
                    if (curnoeud.getType() == TypeNoeud.COLONIE) {
                        //On attribue 1 ressource de la case au joueur
                        curnoeud.getJoueur().ajouterUneRes(Ressources.values()[curcase.getType().ordinal()], 1); //Fait le parallele entre l'enum Ressource et TypeCase
                    }
                    else if (curnoeud.getType() == TypeNoeud.VILLE) {
                        curnoeud.getJoueur().ajouterUneRes(Ressources.values()[curcase.getType().ordinal()], 1);
                    }
                }
            }
        }
    }

    private String afficherOffres(){
        String out = "";
        for (Echange echange:echanges
             ) {
            out = out + echange + "\n";
        }

        return out;
    }
    
    public boolean partieTermine(){
        boolean out = false;

        for (Joueur joueur:joueurs
             ) {
            out = joueur.getScore() == 10 || out;
        }

        return out;
    }

    public void partieTest(){
        //Tests d'attributions et dépenses de ressources
        joueurs.add(new Joueur("Paul"));
        joueurs.add(new Joueur("SomeGuy"));
        joueurs.add(new Joueur("NyanCat"));
        joueurs.get(0).setStockRes(Ressources.METAL, 10);
        System.out.println("Ressources de metal : " + joueurs.get(0).getStockRes(Ressources.METAL));
        joueurs.get(0).creerDev(); //Ne crée rien car pas assez de ressources
        joueurs.get(0).setStockRes(Ressources.CHEESEBURGER, 10);
        joueurs.get(0).setStockRes(Ressources.LAINE, 10);
        joueurs.get(0).setStockRes(Ressources.PIERRE, 10);
        joueurs.get(0).creerDev(); //Ici crée une carte aléatoire

        for (int i = 0; i < 10; i++) {
            System.out.println("Lance les dés : " + des.lancer());
        }


        //Simulations d'échanges
        joueurs.get(1).setStockRes(Ressources.CHEESEBURGER, 10);

        try {
            echanges.add(new Echange(Ressources.CHEESEBURGER, 1, Ressources.METAL, 1, joueurs.get(0)));
            echanges.add(new Echange(Ressources.CHEESEBURGER, 3, Ressources.METAL, 20, joueurs.get(0)));
        }
        catch (PasAssezDeRessourcesException e){
            System.out.println("Erreur " + e);
        }

        System.out.println(afficherOffres());

        try {
            echanges.get(0).accepter(joueurs.get(2)); //Ne fonctionne pas car NyanCat n'a pas de ressources
            echanges.remove(0);
            System.out.println("Echange OK");
        } catch (PasAssezDeRessourcesException e) {
            System.out.println("Erreur " + e);
        }

        try {
            echanges.get(0).accepter(joueurs.get(1)); //Fonctionne car tout le monde à asser
            echanges.remove(0);
            System.out.println("Echange OK");
        } catch (PasAssezDeRessourcesException e) {
            System.out.println("Erreur " + e);
        }



        System.out.println(afficherOffres());


        //Crée une colonie sur le noeud 23 et l'attribue au joueur 0
        noeuds.get(23).changerType(TypeNoeud.COLONIE);
        noeuds.get(23).setJoueur(joueurs.get(0));

        //Crée une route entre le noeud 23 et 29 et l'attribue au joueur 0
        try {
            routes.add(new Route(noeuds.get(23), noeuds.get(29), joueurs.get(0)));
        } catch (RouteNonValide routeNonValide) {
            System.out.println("Erreur " + routeNonValide);
        }


        //Simule 30 tours pour voir si les ressources fonctionnent
        for (int i = 0; i < 30; i++) {
            this.debutTour();
        }

        //Test d'achat d'une route puis d'une colonie
        //On vérifie d'abord le respect des règles reliée à une route, une colonie ou
        //une ville de même couleur et chaque coté d'hexagone ne peut contenir qu'une seule route
        //Ceci est fait par la methode connectable de Noeud

        try {
            routes.add(joueurs.get(0).creerRoute(noeuds.get(29), noeuds.get(34)));
        } catch (RouteNonValide routeNonValide) {
            System.out.println("Erreur " + routeNonValide); //Cette erreur va apparaitre aléatoirement suivant la disposition du plateau et donc des ressources qu'aura généré le joueur.
        }


        //De la même manière on construit une colonie au bout de cette route
        try {
            joueurs.get(0).creerColonie(noeuds.get(34));
        } catch (ConstructionBatimentException e) {
            System.out.println("Erreur " + e);
        } catch (PasAssezDeRessourcesException e) {
            System.out.println("Erreur " + e);
        }

        try {
            joueurs.get(0).creerVille(noeuds.get(34));
        } catch (ConstructionBatimentException e) {
            System.out.println("Erreur " + e);
        } catch (PasAssezDeRessourcesException e) {
            System.out.println("Erreur " + e);
        }


        System.out.println("terminé");
    }

}
