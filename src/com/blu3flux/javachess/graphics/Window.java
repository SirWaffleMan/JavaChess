package com.blu3flux.javachess.graphics;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Window(int width, int height, String title) {
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
