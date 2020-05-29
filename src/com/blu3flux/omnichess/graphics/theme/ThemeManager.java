package com.blu3flux.omnichess.graphics.theme;

import java.awt.Color;

public class ThemeManager {
	private Color primaryColor;
	private Color secondaryColor;
	
	public ThemeManager(DefaultTheme theme) {
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
