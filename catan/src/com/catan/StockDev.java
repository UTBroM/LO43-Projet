package com.catan;

public class StockDev {
    private Developpement type;
    private int stock;

    public StockDev(){

    }

    public Developpement getType() {
        return type;
    }

    public int getQuantite() {
        return stock;
    }

    public void setStock(int quantite) {
        this.stock = quantite;
    }
}