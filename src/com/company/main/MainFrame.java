package com.company.main;

import com.company.cryptocurrencies.Chart;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{


    private JPanel mainPanel;
    protected JLabel cryptoType;
    protected JLabel currentPriceLabel;
    protected JLabel averagePriceLabel;
    protected JLabel change24HValueLabel;
    protected JPanel chartAreaPanel;
    private JPanel pricesInfoPanel;



    private JMenuBar mainBar = new JMenuBar();


    private JMenu chooseCryptoMenu;
    protected JMenuItem bitcoinItem;
    protected JMenuItem ethereumItem;
    protected JMenuItem cardanoItem;
    protected JMenuItem xrpItem;
    protected JMenuItem litecoinItem;
    protected JMenuItem polkadotItem;
    protected JMenuItem uniswapProtocolItem;

    private JMenu chooseCurrencyMenu;
    protected JMenuItem usdItem;
    protected JMenuItem eurItem;
    protected JMenuItem plnItem;
    protected JMenuItem chfItem;

    private JMenu chooseUpdateTime;
    protected JMenuItem twoSeconds;
    protected JMenuItem tenSeconds;
    protected JMenuItem thirtySeconds;
    protected JMenuItem oneMinute;

    private ButtonGroup chartButtonsGroup;
    protected JRadioButton dailyDataButton;
    protected JRadioButton hourlyDataButton;
    protected JPanel chartPanel= new JPanel();


    protected Chart chart=new Chart();


    protected int updateTime=10000;

    public MainFrame()
    {
        setScreenSize();
        setLocationRelativeTo(null);
        setMenuBar();
        addMenu();
        addCryptoMenuItems();
        addPriceMenuItems();
        addUpdateMenuItems();
        addButtonGroup();
        add(mainPanel);

    }


    private void setScreenSize()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2+screenSize.height/6,screenSize.height/2+screenSize.height/6);
    }

    private void setMenuBar()
    {
        setJMenuBar(mainBar);
    }

    private void addMenu()
    {
        chooseCryptoMenu = new JMenu("Cryptocurrency");
        chooseCurrencyMenu = new JMenu("Currency");
        chooseUpdateTime=new JMenu("Update");
        mainBar.add(chooseCryptoMenu);
        mainBar.add(chooseCurrencyMenu);
        mainBar.add(chooseUpdateTime);
    }

    private void addCryptoMenuItems()
    {
        bitcoinItem = new JMenuItem("BTC");
        ethereumItem = new JMenuItem("ETH");
        cardanoItem = new JMenuItem("ADA");
        xrpItem = new JMenuItem("XRP");
        litecoinItem = new JMenuItem("LTC");
        polkadotItem = new JMenuItem("DOT");
        uniswapProtocolItem = new JMenuItem("UNI");

        chooseCryptoMenu.add(bitcoinItem);
        chooseCryptoMenu.add(ethereumItem);
        chooseCryptoMenu.add(cardanoItem);
        chooseCryptoMenu.add(xrpItem);
        chooseCryptoMenu.add(litecoinItem);
        chooseCryptoMenu.add(polkadotItem);
        chooseCryptoMenu.add(uniswapProtocolItem);

    }

    private void addPriceMenuItems()
    {
        usdItem = new JMenuItem("USD");
        eurItem = new JMenuItem("EUR");
        plnItem = new JMenuItem("PLN");
        chfItem = new JMenuItem("CHF");

        chooseCurrencyMenu.add(usdItem);
        chooseCurrencyMenu.add(eurItem);
        chooseCurrencyMenu.add(plnItem);
        chooseCurrencyMenu.add(chfItem);
    }


    private void addUpdateMenuItems()
    {
        twoSeconds = new JMenuItem("Per 2s");
        tenSeconds = new JMenuItem("Per 10s");
        thirtySeconds= new JMenuItem("Per 30s");
        oneMinute = new JMenuItem("Per 1min");

        chooseUpdateTime.add(twoSeconds);
        chooseUpdateTime.add(tenSeconds);
        chooseUpdateTime.add(thirtySeconds);
        chooseUpdateTime.add(oneMinute);

    }


    private void addButtonGroup()
    {
        chartButtonsGroup = new ButtonGroup();
        chartButtonsGroup.add(hourlyDataButton);
        chartButtonsGroup.add(dailyDataButton);




    }






}
