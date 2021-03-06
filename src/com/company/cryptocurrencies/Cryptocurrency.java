package com.company.cryptocurrencies;

public class Cryptocurrency {


    private String currentCryptocurrency;
    private String currentCurrency;
    private float price;
    private float averagePrice;
    private float change24H;


    public Cryptocurrency(){

    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public float getChange24H() {
        return change24H;
    }

    public void setChange24H(float change24H) {
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
