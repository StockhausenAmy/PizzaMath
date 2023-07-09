package org.launchcode.PizzaMath.data;

public class ChainData {

    public double[] pizzaHut = {10.0, 12.0, 14.0, 0.0};

    public double[] dominos = {10.0, 12.0, 14.0, 16.0};

    public double[] papaJohns = {9.5, 11.5, 13.5, 15.5};

    public ChainData(double[] pizzaHut) {
        this.pizzaHut = pizzaHut;
    }

    public double[] getPizzaHut() {
        return pizzaHut;
    }

    public void setPizzaHut(double[] pizzaHut) {
        this.pizzaHut = pizzaHut;
    }
}
