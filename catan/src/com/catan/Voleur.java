package com.catan;

public class Voleur {
    private Case position;

    public Voleur(Case position) {
        this.position = position;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }
}
