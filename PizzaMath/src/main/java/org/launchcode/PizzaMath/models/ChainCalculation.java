package org.launchcode.PizzaMath.models;

public class ChainCalculation extends CustomCalulation {

    private String chainName;

    public ChainCalculation(String chainName) {

        this.chainName = chainName;

        switch (chainName) {
            case "pizzaHut" -> {
                this.setSmallSize(10.0);
                this.setMediumSize(12.0);
                this.setLargeSize(14.0);
                this.setxLargeSize(0.0);
            }
            case "dominos", "papaJohns" -> {
                this.setSmallSize(10.0);
                this.setMediumSize(12.0);
                this.setLargeSize(14.0);
                this.setxLargeSize(16.0);
            }
        }
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }
}
