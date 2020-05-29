package com.blu3flux.omnichess.graphics.theme;

import java.awt.Color;

// Singleton
public class ThemeManager {
	
	private static ThemeManager instance;
	private Color primaryColor;
	private Color secondaryColor;
	
	private ThemeManager() {}
	
	public static ThemeManager getInstance() {
		if(instance == null) {
			instance = new ThemeManager();
		}
		return instance;
	}
	
	public void setTheme(DefaultTheme theme) {
		switch(theme) {
		case LIGHT_THEME:
			primaryColor = Color.WHITE;
			secondaryColor = Color.LIGHT_GRAY;
			break;
		case DARK_THEME:
			primaryColor = Color.DARK_GRAY;
			secondaryColor = Color.LIGHT_GRAY;
			break;
		default:
			primaryColor = Color.WHITE;
			secondaryColor = Color.LIGHT_GRAY;
			break;
		}
	}
	
	public Color getPrimaryColor() {
		return primaryColor;
	}
	
	public Color getSecondaryColor() {
		return secondaryColor;
	}
}
