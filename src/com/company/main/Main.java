package com.company.main;



import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		});



    }
}
