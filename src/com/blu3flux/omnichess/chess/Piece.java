package com.blu3flux.omnichess.chess;

import java.awt.image.BufferedImage;

public abstract class Piece {
	
	protected BufferedImage image;
	
	private int file;
	private int rank;
	private PieceColor color;
	
	public Piece(PieceColor c, int f, int r) {
		this.color = c;
		this.file = f;
		this.rank = r;
	}
	
	public void setImage(BufferedImage img) {
		this.image = img;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setFile(int f) {
		this.file = f;
	}
	
	public void setRank(int r) {
		this.rank = r;
	}
	
	public PieceColor getColor() {
		return color;
	}
	
	public int getFile() {
		return file;
	}
	
	public int getRank() {
		return rank;
	}
}
