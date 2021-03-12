package com.company.main;

import com.company.cryptocurrencies.Cryptocurrency;
import com.company.cryptocurrencies.MarketDataApi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrameListener extends MainFrame implements ActionListener {

   private Cryptocurrency cryptocurrency = new Cryptocurrency();
   private MarketDataApi api;
   private Timer timer;

   private boolean dailyChartDataRange = true;


    public MainFrameListener()
    {

        api= new MarketDataApi(cryptocurrency,chart);
        addCryptocurrencyItemsListener();
        addCurrencyItemsListener();
        addUpdateRateItemsListener();
        addButtonsActionListener();
        setInitialData();


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource()==bitcoinItem)
        {  cryptocurrency.setCurrentCryptocurrency("BTC");

        }
        if(actionEvent.getSource()==ethereumItem) {
            cryptocurrency.setCurrentCryptocurrency("ETH");
        }
        if(actionEvent.getSource()==xrpItem) {
            cryptocurrency.setCurrentCryptocurrency("XRP");
        }
        if(actionEvent.getSource()==cardanoItem) {
            cryptocurrency.setCurrentCryptocurrency("ADA");
        }
        if(actionEvent.getSource()==litecoinItem) {
            cryptocurrency.setCurrentCryptocurrency("LTC");
        }
        if(actionEvent.getSource()==polkadotItem) {
            cryptocurrency.setCurrentCryptocurrency("DOT");
        }
        if(actionEvent.getSource()==uniswapProtocolItem) {
            cryptocurrency.setCurrentCryptocurrency("UNI");
        }

        if(actionEvent.getSource()==usdItem) {
            cryptocurrency.setCurrentCurrency("USD");
        }
        if(actionEvent.getSource()==plnItem) {
            cryptocurrency.setCurrentCurrency("PLN");
        }
        if(actionEvent.getSource()==chfItem) {
            cryptocurrency.setCurrentCurrency("CHF");
        }
        if(actionEvent.getSource()==eurItem) {
            cryptocurrency.setCurrentCurrency("EUR");
        }

        if(actionEvent.getSource()==twoSeconds){
            updateTime=2000;
            timer.cancel();
            updateTimer();
        }
        if(actionEvent.getSource()==tenSeconds){
            updateTime=1000;
            timer.cancel();
            updateTimer();
        }
        if(actionEvent.getSource()==thirtySeconds){
            updateTime=30000;
            timer.cancel();
            updateTimer();
        }
        if(actionEvent.getSource()==oneMinute){
            updateTime=60000;
            timer.cancel();
            updateTimer();
        }

        setData();
        erasePreviousChartData();
        getChartData();
        createChart();

    }


    private void setData()
    {
        api.getData();
        currentPriceLabel.setText(cryptocurrency.getPrice() +" "+ cryptocurrency.getCurrentCurrency());
        averagePriceLabel.setText(cryptocurrency.getAveragePrice() +" "+ cryptocurrency.getCurrentCurrency());

        if(cryptocurrency.getChange24H()<0)
        {
            change24HValueLabel.setForeground(Color.red);
        }
        else
        {
            change24HValueLabel.setForeground(Color.green);
        }
        change24HValueLabel.setText(cryptocurrency.getChange24H() +" "+ cryptocurrency.getCurrentCurrency());

        cryptoType.setText(cryptocurrency.getCurrentCryptocurrency().toString());

    }

    private void updateTimer()
    {
        timer = new Timer();
        timer.schedule(  new TimerTask()
        {
            @Override
            public void run() {
                setData();
            }
        },0,updateTime);
    }



    private void addButtonsActionListener()
    {

        dailyDataButton.addActionListener(actionEvent -> {
            dailyChartDataRange=true;
            erasePreviousChartData();
            getChartData();
            createChart();
        });

        hourlyDataButton.addActionListener(actionEvent -> {
            dailyChartDataRange=false;
        erasePreviousChartData();
        getChartData();
        createChart();
        });
    }


    private void erasePreviousChartData()
    {
        chart.clearArray();
    }

    private void getChartData()
    {
        if(dailyChartDataRange)
        {
            api.getDailyChartData();
        }

        else
        {
            api.getHourlyChartData();
        }
    }

    private void createChart()
    {

        if(dailyChartDataRange)
        {
            chart.setDailyChartDataRange(true);
        }
        else
        {
            chart.setDailyChartDataRange(false);
        }
        chart.createChart(cryptocurrency.getCurrentCurrency());
    }


    private void addCryptocurrencyItemsListener()
    {
        bitcoinItem.addActionListener(this);
        ethereumItem.addActionListener(this);
        cardanoItem.addActionListener(this);
        xrpItem.addActionListener(this);
        litecoinItem.addActionListener(this);
        polkadotItem.addActionListener(this);
        uniswapProtocolItem.addActionListener(this);
    }

    private void addCurrencyItemsListener()
    {
        usdItem.addActionListener(this);
        plnItem.addActionListener(this);
        eurItem.addActionListener(this);
        chfItem.addActionListener(this);
    }

    private void addUpdateRateItemsListener()
    {
        twoSeconds.addActionListener(this);
        tenSeconds.addActionListener(this);
        thirtySeconds.addActionListener(this);
        oneMinute.addActionListener(this);
    }

    private void setInitialData()
    {
        setData();
        getChartData();
        createChart();
        updateTimer();
    }



}
