package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{


    private JPanel mainPanel;
    private JMenuBar mainBar = new JMenuBar();
    private JMenu chooseCryptoMenu;
    private JMenu choosePriceMenu;


    public MainFrame()
    {
        setScreenSize();
        setLocationRelativeTo(null);
        setMenuBar();
        addMenu();
        addCryptoMenuItems();
        addPriceMenuItems();
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
        choosePriceMenu= new JMenu("Price");
        mainBar.add(chooseCryptoMenu);
        mainBar.add(choosePriceMenu);
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

        choosePriceMenu.add(usdItem);
        choosePriceMenu.add(eurItem);
        choosePriceMenu.add(plnItem);
        choosePriceMenu.add(chfItem);
    }

}
