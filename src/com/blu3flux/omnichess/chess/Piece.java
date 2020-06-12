package com.blu3flux.omnichess.chess;

import java.awt.image.BufferedImage;

public abstract class Piece {
	
	protected BufferedImage image;
	
	private int file;
	private int rank;
	private PieceColor color;
	
	// These coordinates are only used if piece
	// is selected piece
	private int x;
	private int y;
	
	// Used to restore previous location
	private int saved_file;
	private int saved_rank;
	
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
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void saveLocation() {
		this.saved_file = file;
		this.saved_rank = rank;
	}
	
	public void restoreLocation() {
		this.file = this.saved_file;
		this.rank = this.saved_rank;
	}
	
}
