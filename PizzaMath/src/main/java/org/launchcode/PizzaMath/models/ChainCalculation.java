package org.launchcode.PizzaMath.models;
import org.launchcode.PizzaMath.data.ChainData;

public class ChainCalculation extends CustomCalulation {

    private String chainName;

    ChainData chainData;

    public ChainCalculation(String chainName) {

        this.chainName = chainName;

        switch (chainName) {
            case "pizzaHut" -> {
                this.setSmallSize(chainData.pizzaHut[0]);
                this.setMediumSize(chainData.pizzaHut[1]);
                this.setLargeSize(chainData.pizzaHut[2]);
                this.setxLargeSize(chainData.pizzaHut[3]);
            }
            case "dominos" -> {
                this.setSmallSize(chainData.dominos[0]);
                this.setMediumSize(chainData.dominos[1]);
                this.setLargeSize(chainData.dominos[2]);
                this.setxLargeSize(chainData.dominos[3]);
            }
            case "papaJohns" -> {
                this.setSmallSize(chainData.papaJohns[0]);
                this.setMediumSize(chainData.papaJohns[1]);
                this.setLargeSize(chainData.papaJohns[2]);
                this.setxLargeSize(chainData.papaJohns[3]);
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
