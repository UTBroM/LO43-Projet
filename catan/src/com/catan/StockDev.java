package com.catan;

public class StockDev extends Stock{
    private Developpement type;

    public StockDev(Developpement type){
        super();
        this.type = type;
    }

    public Developpement getType() {
        return type;
    }

}