package com.catan;

public class Echange {
    private Ressources gains;
    private int quantiteGains; //gains de joueur
    private Ressources pertes;
    private int quantitePertes; //gains de clients
    private Joueur joueur;

    public Echange(Ressources gains, int quantiteGains, Ressources pertes, int quantitePertes, Joueur joueur) {
        //TODO : ne pas créer l'objet si joueur ne possède pas asser de ressources
        this.gains = gains;
        this.quantiteGains = quantiteGains;
        this.pertes = pertes;
        this.quantitePertes = quantitePertes;
        this.joueur = joueur;
    }

    public boolean accepter(Joueur client){
        //On vérifie si l'offre est toujours valable
        //TODO : Normalement il faudrais vérifier à chaques transferts si les offres restent valables (méthode de nettoyage ?)
        if(joueur.getStockRes(pertes)>= quantitePertes){
            //On vérifie l'autre joueur
            if(client.getStockRes(gains)>= quantiteGains){

                //Transfert de joueur vers client
                joueur.consommerUneRes(pertes, quantitePertes);
                client.ajouterUneRes(pertes, quantitePertes);

                //Transfert de client vers joueur
                client.consommerUneRes(gains, quantiteGains);
                joueur.ajouterUneRes(gains, quantiteGains);

                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "Le joueur " + joueur.getNom() + " souhaite échanger " + quantitePertes + " de " + pertes + " contre " + quantiteGains + " de " + gains;
    }
}
