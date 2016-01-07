package com.catan;

public class RouteNonValide extends Exception{
    public RouteNonValide() {
    }

    public RouteNonValide(String message) {
        super(message);
    }
}
