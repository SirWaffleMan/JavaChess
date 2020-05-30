package com.blu3flux.omnichess.graphics.theme;

import java.awt.Color;

// Singleton
public class ThemeManager {
	
	private static ThemeManager instance;
	private Color primaryColor;
	private Color secondaryColor;
	private Color fontColor;
	
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
			fontColor = Color.BLACK;
			break;
		case DARK_THEME:
			primaryColor = Color.DARK_GRAY;
			secondaryColor = new Color(40, 40, 40);
			fontColor = Color.WHITE;
			break;
		default:
			primaryColor = Color.WHITE;
			secondaryColor = Color.LIGHT_GRAY;
			fontColor = Color.BLACK;
			break;
		}
	}
	
	public Color getPrimaryColor() {
		return primaryColor;
	}
	
	public Color getSecondaryColor() {
		return secondaryColor;
	}
	
	public Color getFontColor() {
		return fontColor;
	}
}
