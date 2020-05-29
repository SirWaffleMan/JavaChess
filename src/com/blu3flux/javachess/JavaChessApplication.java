package com.blu3flux.javachess;

import com.blu3flux.javachess.graphics.Window;

public class JavaChessApplication {
	
	private int WIDTH = 1280;
	private int HEIGHT = 720;
	private String TITLE = "JavaChess";
	private Window window;
	
	public JavaChessApplication() {
		window = new Window(WIDTH, HEIGHT, TITLE);
	}
}
