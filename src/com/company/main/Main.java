package com.company.main;



import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MainFrameListener frame = new MainFrameListener();
			frame.setVisible(true);
			frame.setResizable(false);

			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		});



    }
}
