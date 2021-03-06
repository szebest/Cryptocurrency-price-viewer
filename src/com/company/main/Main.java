package com.company.main;



import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MyListener frame = new MyListener();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		});



    }
}
