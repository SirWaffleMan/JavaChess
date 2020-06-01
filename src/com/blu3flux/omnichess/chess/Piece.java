package com.blu3flux.omnichess.chess;

import java.awt.image.BufferedImage;

public abstract class Piece {
	
	protected BufferedImage image;
	
	public void setImage(BufferedImage img) {
		this.image = img;
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
