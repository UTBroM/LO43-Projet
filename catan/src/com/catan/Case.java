package com.catan;

import java.util.ArrayList;

public class Case {
    private final TypeCase type;
    private final ArrayList<Noeud> noeuds;
    private int numero;

    public Case(TypeCase type) {
        this.type = type;
        this.noeuds = new ArrayList<>();
    }

    public TypeCase getType() {
        return type;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) { this.numero = numero; }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

    public void ajouterNoeud(Noeud nouveau){
        noeuds.add(nouveau);
    }
}
