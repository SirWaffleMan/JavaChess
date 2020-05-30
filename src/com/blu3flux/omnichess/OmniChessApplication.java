package com.blu3flux.omnichess;

import com.blu3flux.omnichess.assets.AssetManager;
import com.blu3flux.omnichess.graphics.theme.DefaultTheme;
import com.blu3flux.omnichess.graphics.window.Window;

public class OmniChessApplication {
	
	private int WIDTH = 1280;
	private int HEIGHT = 720;
	private String TITLE = "OmniChess";
	private Window window;
	private DefaultTheme THEME = DefaultTheme.DARK_THEME;
	
	private static AssetManager assetMan;
	
	public OmniChessApplication() {
		assetMan = new AssetManager();
		assetMan.loadAssets();
		window = new Window(WIDTH, HEIGHT, TITLE, THEME);
	}
	
	public static AssetManager getAssets() {
		return assetMan;
	}
}
