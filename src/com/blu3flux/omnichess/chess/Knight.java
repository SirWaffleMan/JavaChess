package com.blu3flux.omnichess.chess;

public class Knight extends Piece {

	public Knight(PieceColor c, int f, int r) {
		super(c, f, r);
		this.letter = "N";
	}

	public Knight(PieceColor c) {
		super(c);
		this.letter = "N";
	}

}
