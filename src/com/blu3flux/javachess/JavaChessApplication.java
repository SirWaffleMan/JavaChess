package com.blu3flux.javachess;

import com.blu3flux.javachess.graphics.Window;
import com.blu3flux.javachess.graphics.theme.DefaultTheme;

public class JavaChessApplication {
	
	private int WIDTH = 1280;
	private int HEIGHT = 720;
	private String TITLE = "JavaChess";
	private Window window;
	private DefaultTheme THEME = DefaultTheme.DARK_THEME;
	
	public JavaChessApplication() {
		window = new Window(WIDTH, HEIGHT, TITLE, THEME);
	}
}
