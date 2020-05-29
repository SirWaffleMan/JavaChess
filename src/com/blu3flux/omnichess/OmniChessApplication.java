package com.blu3flux.omnichess;

import com.blu3flux.omnichess.graphics.Window;
import com.blu3flux.omnichess.graphics.theme.DefaultTheme;

public class OmniChessApplication {
	
	private int WIDTH = 1280;
	private int HEIGHT = 720;
	private String TITLE = "OmniChess";
	private Window window;
	private DefaultTheme THEME = DefaultTheme.DARK_THEME;
	
	public OmniChessApplication() {
		window = new Window(WIDTH, HEIGHT, TITLE, THEME);
	}
}
