package com.blu3flux.omnichess.assets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;

public class AssetManager {
	
	String resPath = "res";
	
	ArrayList<ChessSet> chessSets;
	
	public AssetManager() {
		chessSets = new ArrayList<ChessSet>();
	}
	
	public void loadAssets() {
		loadChessSets();
	}
	
	private void loadChessSets() {
		String chessSetsPath = resPath + "/chessSets";
		try {
			Files.walk(Paths.get(chessSetsPath))
			 .filter(Files::isRegularFile)
			 .forEach((param)->{
				 	ChessSet set = new ChessSet(param);
				 	
				 	String b64Content[]; // Stores b64 for every chess piece
				 	
				 	byte[] wPawn, wKnight, wBishop, wRook, wQueen, wKing;
				 	byte[] bPawn, bKnight, bBishop, bRook, bQueen, bKing;
				 	
				 	try {
						b64Content = Files.readString(param).split("\\r?\\n");
						
						wPawn = Base64.getDecoder().decode(b64Content[0]);
						wKnight = Base64.getDecoder().decode(b64Content[1]);
						wBishop = Base64.getDecoder().decode(b64Content[2]);
						wRook = Base64.getDecoder().decode(b64Content[3]);
						wQueen = Base64.getDecoder().decode(b64Content[4]);
						wKing = Base64.getDecoder().decode(b64Content[5]);
						
						bPawn = Base64.getDecoder().decode(b64Content[6]);
						bKnight = Base64.getDecoder().decode(b64Content[7]);
						bBishop = Base64.getDecoder().decode(b64Content[8]);
						bRook = Base64.getDecoder().decode(b64Content[9]);
						bQueen = Base64.getDecoder().decode(b64Content[10]);
						bKing = Base64.getDecoder().decode(b64Content[11]);
						
						set.setWhite(wPawn, wKnight, wBishop, wRook, wQueen, wKing);
						set.setBlack(bPawn, bKnight, bBishop, bRook, bQueen, bKing);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				 	
					chessSets.add(set);
			 });
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ChessSet getSelectedChessSet() {
		return chessSets.get(1);
	}
}
