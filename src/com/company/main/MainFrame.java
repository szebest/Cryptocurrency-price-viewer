package com.company.main;

import com.company.cryptocurrencies.Cryptocurrency;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{


    private JPanel mainPanel;
    private JLabel cryptoType;
    private JLabel currentValue;
    private JLabel averageValue;
    private JLabel chaneAmount;
    private JPanel chartPanel;
    private JMenuBar mainBar = new JMenuBar();
    private JMenu chooseCryptoMenu;
    private JMenu chooseCurrencyMenu;


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
        JMenuItem bitcoinItem = new JMenuItem("BTC");
        JMenuItem ethereumItem = new JMenuItem("ETH");
        JMenuItem cardanoItem = new JMenuItem("ADA");
        JMenuItem xrpItem = new JMenuItem("XRP");
        JMenuItem litecoinItem = new JMenuItem("LTC");
        JMenuItem polkadotItem = new JMenuItem("DOT");
        JMenuItem uniswapProtocolItem = new JMenuItem("UNI");

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
        JMenuItem usdItem = new JMenuItem("USD");
        JMenuItem eurItem = new JMenuItem("EUR");
        JMenuItem plnItem = new JMenuItem("PLN");
        JMenuItem chfItem = new JMenuItem("CHF");

        chooseCurrencyMenu.add(usdItem);
        chooseCurrencyMenu.add(eurItem);
        chooseCurrencyMenu.add(plnItem);
        chooseCurrencyMenu.add(chfItem);
    }



}
