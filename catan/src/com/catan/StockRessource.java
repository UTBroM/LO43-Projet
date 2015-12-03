package com.catan;

public class StockRessource {
    private Ressources type;
    private int quantite;

    public StockRessource(){

    }

    public Ressources getType() {
        return type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
