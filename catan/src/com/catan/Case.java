package com.catan;

import java.util.ArrayList;

public class Case {
    private TypeCase type;
    private ArrayList<Noeud> noeuds;
    private int numero;

    public Case(TypeCase type, ArrayList<Noeud> noeuds, int numero) {
        this.type = type;
        this.noeuds = noeuds;
        this.numero = numero;
    }

    public TypeCase getType() {
        return type;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }
}
