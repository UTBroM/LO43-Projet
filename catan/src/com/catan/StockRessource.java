package com.catan;

public class StockRessource {
    private Ressources type;
    private int stock;

    public StockRessource(Ressources type){
        this.type = type;
        stock = 0;
    }

    public Ressources getType() {
        return type;
    }

    public int getQuantite() {
        return stock;
    }

    public void setQuantite(int quantite) {
        this.stock = quantite;
    }

    public void add(int quantite){
        this.stock += quantite;
    }

    public boolean remove(int quantite){
        if(quantite > this.stock){
            return false;
        }
        else{
            this.stock -= quantite;
            return true;
        }
    }
}
