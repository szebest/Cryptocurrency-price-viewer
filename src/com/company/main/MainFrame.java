package com.company.main;

import com.company.cryptocurrencies.Cryptocurrency;
import com.company.cryptocurrencies.MarketDataApi;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{


    private JPanel mainPanel;
    protected JLabel cryptoType;
    protected JLabel currentPriceLabel;
    protected JLabel averagePriceLabel;
    protected JLabel change24HValueLabel;
    protected JPanel chartPanel;
    private JMenuBar mainBar = new JMenuBar();
    private JMenu chooseCryptoMenu;
    private JMenu chooseCurrencyMenu;


    protected JMenuItem bitcoinItem;
    protected JMenuItem ethereumItem;
    protected JMenuItem cardanoItem;
    protected JMenuItem xrpItem;
    protected JMenuItem litecoinItem;
    protected JMenuItem polkadotItem;
    protected JMenuItem uniswapProtocolItem;

    protected JMenuItem usdItem;
    protected JMenuItem eurItem;
    protected JMenuItem plnItem;
    protected JMenuItem chfItem;


    public MainFrame()
    {
        setScreenSize();
        setLocationRelativeTo(null);
        setMenuBar();
        addMenu();
        addCryptoMenuItems();
        addPriceMenuItems();
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
        mainBar.add(chooseCryptoMenu);
        mainBar.add(chooseCurrencyMenu);
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



}
