package com.company.main;

import com.company.cryptocurrencies.Cryptocurrency;
import com.company.cryptocurrencies.MarketDataApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener extends MainFrame implements ActionListener {

   private Cryptocurrency crypto = new Cryptocurrency();
   private MarketDataApi api = new MarketDataApi();

    public MyListener()
    {
        bitcoinItem.addActionListener(this);
        ethereumItem.addActionListener(this);
        cardanoItem.addActionListener(this);
        xrpItem.addActionListener(this);
        litecoinItem.addActionListener(this);
        polkadotItem.addActionListener(this);
        uniswapProtocolItem.addActionListener(this);

        usdItem.addActionListener(this);
        plnItem.addActionListener(this);
        eurItem.addActionListener(this);
        chfItem.addActionListener(this);
        setData();


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource()==bitcoinItem)
        {  crypto.setCurrentCryptocurrency("BTC");

        }
        if(actionEvent.getSource()==ethereumItem) {
            crypto.setCurrentCryptocurrency("ETH");
        }
        if(actionEvent.getSource()==xrpItem) {
            crypto.setCurrentCryptocurrency("XRP");
        }
        if(actionEvent.getSource()==cardanoItem) {
            crypto.setCurrentCryptocurrency("ADA");
        }
        if(actionEvent.getSource()==litecoinItem) {
            crypto.setCurrentCryptocurrency("LTC");
        }
        if(actionEvent.getSource()==polkadotItem) {
            crypto.setCurrentCryptocurrency("DOT");
        }
        if(actionEvent.getSource()==uniswapProtocolItem) {
            crypto.setCurrentCryptocurrency("UNI");
        }

        if(actionEvent.getSource()==usdItem) {
            crypto.setCurrentCurrency("USD");
        }
        if(actionEvent.getSource()==plnItem) {
            crypto.setCurrentCurrency("PLN");
        }
        if(actionEvent.getSource()==chfItem) {
            crypto.setCurrentCurrency("CHF");
        }
        if(actionEvent.getSource()==eurItem) {
            crypto.setCurrentCurrency("EUR");
        }

        setData();

    }

    private void setData()
    {
        api.getData(crypto);
        currentPriceLabel.setText(crypto.getPrice() +" "+ crypto.getCurrentCurrency());
        averagePriceLabel.setText(crypto.getAveragePrice() +" "+ crypto.getCurrentCurrency());
        change24HValueLabel.setText(crypto.getChange24H() +" "+ crypto.getCurrentCurrency());
        cryptoType.setText(crypto.getCurrentCryptocurrency().toString());
    }
}
