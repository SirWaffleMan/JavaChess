package com.blu3flux.omnichess.assets;

import java.nio.file.Path;

public class ChessSet {
	
	String name;
	
	byte[] wPawn, wKnight, wBishop, wRook, wQueen, wKing;
	byte[] bPawn, bKnight, bBishop, bRook, bQueen, bKing;
	
	public ChessSet(Path path) {
		this.name = path.getFileName().toString().split("\\.")[0];
	}
	
	public void setWhite(byte[] p, byte[] n, byte[] b, byte[] r, byte[] q, byte[] k) {
		this.wPawn = p;
		this.wKnight = n;
		this.wBishop = b;
		this.wRook = r;
		this.wQueen = q;
		this.wKing = k;
	}
	
	public void setBlack(byte[] p, byte[] n, byte[] b, byte[] r, byte[] q, byte[] k) {
		this.bPawn = p;
		this.bKnight = n;
		this.bBishop = b;
		this.bRook = r;
		this.bQueen = q;
		this.bKing = k;
	}
}
