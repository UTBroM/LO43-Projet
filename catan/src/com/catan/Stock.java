package com.catan;

public class Stock<T> {
    private int stock;
    private final T type;

    public Stock(T type){
        this.type = type;
        stock = 0;
    }

    public T getType() {
        return type;
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

    public boolean remove(int quantite) throws PasAssezDeRessourcesException{
        if(quantite > this.stock){
            throw new PasAssezDeRessourcesException("Pas assez de " + this.type);
        }
        else{
            this.stock -= quantite;
            return true;
        }
    }
}
