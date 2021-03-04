package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{


    private JPanel mainPanel;
    private JMenuBar currencyMenu = new JMenuBar();
    private JMenu chooseMenu;


    public MainFrame()
    {
        setScreenSize();
        setLocationRelativeTo(null);
        setMenuBar();
        addMenu();
        addMenuItems();
    }


    private void setScreenSize()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2+screenSize.height/6,screenSize.height/2+screenSize.height/6);
    }

    private void setMenuBar()
    {
        setJMenuBar(currencyMenu);
    }

    private void addMenu()
    {
        chooseMenu = new JMenu("Choose currency");
        currencyMenu.add(chooseMenu);
    }

    private void addMenuItems()
    {
        JMenuItem bitcoinItem = new JMenuItem("BTC");
        JMenuItem ethereumItem = new JMenuItem("ETH");
        JMenuItem cardanoItem = new JMenuItem("ADA");
        JMenuItem xrpItem = new JMenuItem("XRP");
        JMenuItem litecoinItem = new JMenuItem("LTC");
        JMenuItem polkadotItem = new JMenuItem("DOT");
        JMenuItem uniswapProtocolItem = new JMenuItem("UNI");

        chooseMenu.add(bitcoinItem);
        chooseMenu.add(ethereumItem);
        chooseMenu.add(cardanoItem);
        chooseMenu.add(xrpItem);
        chooseMenu.add(litecoinItem);
        chooseMenu.add(polkadotItem);
        chooseMenu.add(uniswapProtocolItem);

    }

}
