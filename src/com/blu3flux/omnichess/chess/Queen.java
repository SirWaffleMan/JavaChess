package com.blu3flux.omnichess.chess;

public class Queen extends Piece {

	public Queen(PieceColor c, int f, int r) {
		super(c, f, r);
		this.letter = "Q";
	}

	public Queen(PieceColor c){
		super(c);
		this.letter = "Q";
	}


}
