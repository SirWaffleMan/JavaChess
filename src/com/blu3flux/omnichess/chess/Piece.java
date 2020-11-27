package com.blu3flux.omnichess.chess;

import java.awt.image.BufferedImage;

public abstract class Piece {
	
	protected BufferedImage image;
	protected PieceColor color;
	protected String letter;

	public Piece(PieceColor c){
		this.color = c;
	}
	
	public void setImage(BufferedImage img) {
		this.image = img;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public PieceColor getColor() {
		return color;
	}
	
	public String getLetter(){
		return letter;
	}
	
}
