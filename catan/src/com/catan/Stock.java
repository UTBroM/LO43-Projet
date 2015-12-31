package com.catan;

public class Stock {
    private int stock;

    public Stock(){
        stock = 0;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int quantite) {
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
