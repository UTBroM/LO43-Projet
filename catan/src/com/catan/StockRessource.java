package com.catan;

public class StockRessource extends Stock{
    private Ressources type;

    public StockRessource(Ressources type){
        super();
        this.type = type;
    }

    public Ressources getType() {
        return type;
    }
}
