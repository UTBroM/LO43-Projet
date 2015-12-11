package com.catan;

public class Relation {
    private Noeud noeud;
    private Route[] route;

    public Relation(Noeud noeud) {
        this.noeud = noeud;
        this.route = new Route[]{null, null, null};
    }

    public Noeud getNoeud() {
        return noeud;
    }

    public Route[] getRoute() {
        return route;
    }

    public void setRoute(Route[] route) {
        this.route = route;
    }
}
