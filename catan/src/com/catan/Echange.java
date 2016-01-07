package com.catan;

public class Echange {
    private Ressources gains;
    private int quantiteGains; //gains de joueur
    private Ressources pertes;
    private int quantitePertes; //gains de clients
    private Joueur joueur;

    public Echange(Ressources gains, int quantiteGains, Ressources pertes, int quantitePertes, Joueur joueur) throws PasAssezDeRessourcesException{
        if (joueur.getStockRes(pertes) >= quantitePertes){
            this.gains = gains;
            this.quantiteGains = quantiteGains;
            this.pertes = pertes;
            this.quantitePertes = quantitePertes;
            this.joueur = joueur;
        }
        else{
            throw new PasAssezDeRessourcesException(joueur.getNom() + " n'a pas assez de " + pertes);
        }

    }

    public void accepter(Joueur client) throws PasAssezDeRessourcesException{
        //On vérifie si l'offre est toujours valable
        if(joueur.getStockRes(pertes)>= quantitePertes){
            //On vérifie l'autre joueur
            if(client.getStockRes(gains)>= quantiteGains){

                //Transfert de joueur vers client
                joueur.consommerUneRes(pertes, quantitePertes);
                client.ajouterUneRes(pertes, quantitePertes);

                //Transfert de client vers joueur
                client.consommerUneRes(gains, quantiteGains);
                joueur.ajouterUneRes(gains, quantiteGains);

            }
            else{
                throw new PasAssezDeRessourcesException(client.getNom() + " n'a pas assez de " + gains);
            }
        }
        else{
            throw new PasAssezDeRessourcesException(joueur.getNom() + " n'a pas assez de " + pertes);
        }
    }

    @Override
    public String toString(){
        return "Le joueur " + joueur.getNom() + " souhaite échanger " + quantitePertes + " de " + pertes + " contre " + quantiteGains + " de " + gains;
    }
}
