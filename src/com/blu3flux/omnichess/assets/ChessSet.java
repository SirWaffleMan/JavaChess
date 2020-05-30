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
	
	public byte[] getWPawnBytes() {
		return wPawn;
	}
	public byte[] getWKnightBytes() {
		return wKnight;
	}
	public byte[] getWBishopBytes() {
		return wBishop;
	}
	public byte[] getWRookBytes() {
		return wRook;
	}
	public byte[] getWQueenBytes() {
		return wQueen;
	}
	public byte[] getWKingBytes() {
		return wKing;
	}
	
	public byte[] getBPawnBytes() {
		return bPawn;
	}
	public byte[] getBKnightBytes() {
		return bKnight;
	}
	public byte[] getBBishopBytes() {
		return bBishop;
	}
	public byte[] getBRookBytes() {
		return bRook;
	}
	public byte[] getBQueenBytes() {
		return bQueen;
	}
	public byte[] getBKingBytes() {
		return bKing;
	}
}
