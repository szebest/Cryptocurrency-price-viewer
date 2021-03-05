package com.company.cryptocurrencies;

public class Cryptocurrency {


    private String currentCryptocurrency;
    private String currentCurrency;
    private int price;
    private int averagePrice;
    private int change24H;



    public Cryptocurrency(){

    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(int averagePrice) {
        this.averagePrice = averagePrice;
    }

    public int getChange24H() {
        return change24H;
    }

    public void setChange24H(int change24H) {
        this.change24H = change24H;
    }


    public String getCurrentCryptocurrency() {
        return currentCryptocurrency;
    }

    public void setCurrentCryptocurrency(String currentCryptocurrency) {
        this.currentCryptocurrency = currentCryptocurrency;
    }

    public String getCurrentCurrency() {
        return currentCurrency;
    }

    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }



}
