package com.blu3flux.omnichess.graphics.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.blu3flux.omnichess.OmniChessApplication;
import com.blu3flux.omnichess.assets.ChessSet;
import com.blu3flux.omnichess.controls.ChessMouseControl;
import com.blu3flux.omnichess.graphics.theme.ThemeManager;

public class ChessBoard extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ChessMouseControl mouse;
	
	private ChessSet set;
	
	private BufferedImage wPawn, wKnight, wBishop, wRook, wQueen, wKing;
	private BufferedImage bPawn, bKnight, bBishop, bRook, bQueen, bKing;
	
	public ChessBoard() {
		mouse = new ChessMouseControl();
		this.set = OmniChessApplication.getAssets().getSelectedChessSet();
		
		ByteArrayInputStream wPawnByteStream = new ByteArrayInputStream(set.getWPawnBytes());
		ByteArrayInputStream wKnightByteStream = new ByteArrayInputStream(set.getWKnightBytes());
		ByteArrayInputStream wBishopByteStream = new ByteArrayInputStream(set.getWBishopBytes());
		ByteArrayInputStream wRookByteStream = new ByteArrayInputStream(set.getWRookBytes());
		ByteArrayInputStream wQueenByteStream = new ByteArrayInputStream(set.getWQueenBytes());
		ByteArrayInputStream wKingByteStream = new ByteArrayInputStream(set.getWKingBytes());
		
		ByteArrayInputStream bPawnByteStream = new ByteArrayInputStream(set.getBPawnBytes());
		ByteArrayInputStream bKnightByteStream = new ByteArrayInputStream(set.getBKnightBytes());
		ByteArrayInputStream bBishopByteStream = new ByteArrayInputStream(set.getBBishopBytes());
		ByteArrayInputStream bRookByteStream = new ByteArrayInputStream(set.getBRookBytes());
		ByteArrayInputStream bQueenByteStream = new ByteArrayInputStream(set.getBQueenBytes());
		ByteArrayInputStream bKingByteStream = new ByteArrayInputStream(set.getBKingBytes());
		
		try {
			wPawn = ImageIO.read(wPawnByteStream);
			wKnight = ImageIO.read(wKnightByteStream);
			wBishop = ImageIO.read(wBishopByteStream);
			wRook = ImageIO.read(wRookByteStream);
			wQueen = ImageIO.read(wQueenByteStream);
			wKing = ImageIO.read(wKingByteStream);
			
			bPawn = ImageIO.read(bPawnByteStream);
			bKnight = ImageIO.read(bKnightByteStream);
			bBishop = ImageIO.read(bBishopByteStream);
			bRook = ImageIO.read(bRookByteStream);
			bQueen = ImageIO.read(bQueenByteStream);
			bKing = ImageIO.read(bKingByteStream);
			
			wPawnByteStream.close();
			wKnightByteStream.close();
			wBishopByteStream.close();
			wRookByteStream.close();
			wQueenByteStream.close();
			wKingByteStream.close();
			
			bPawnByteStream.close();
			bKnightByteStream.close();
			bBishopByteStream.close();
			bRookByteStream.close();
			bQueenByteStream.close();
			bKingByteStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// Draw background
		g.setColor(ThemeManager.getInstance().getPrimaryColor());
		g.fillRect(0, 0, getWidth(), getHeight());
	
		// Draw chess board
		int squareSize = getWidth() / 8;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if( (i + j) % 2 == 0)
					g.setColor(Color.WHITE);
				else
					g.setColor(new Color(118,150,86));
				
				int x = i * squareSize;
				int y = j * squareSize;
				g.fillRect(x, y, squareSize, squareSize);
			}
		}
		
		// Draw chess pieces
		drawChessPieces(g);
		
	}
	
	private void drawChessPieces(Graphics g) {
		
		int size = getWidth()/8;
		
		// 8th rank
		g.drawImage(bRook, 0 * size, 0 * size, size, size, this);
		g.drawImage(bKnight, 1 * size, 0 * size, size, size, this);
		g.drawImage(bBishop, 2 * size, 0 * size, size, size, this);
		g.drawImage(bQueen, 3 * size, 0 * size, size, size, this);
		g.drawImage(bKing, 4 * size, 0 * size, size, size, this);
		g.drawImage(bBishop, 5 * size, 0 * size, size, size, this);
		g.drawImage(bKnight, 6 * size, 0 * size, size, size, this);
		g.drawImage(bRook, 7 * size, 0 * size, size, size, this);
		
		// 7th rank
		g.drawImage(bPawn, 0 * size, 1 * size, size, size, this);
		g.drawImage(bPawn, 1 * size, 1 * size, size, size, this);
		g.drawImage(bPawn, 2 * size, 1 * size, size, size, this);
		g.drawImage(bPawn, 3 * size, 1 * size, size, size, this);
		g.drawImage(bPawn, 4 * size, 1 * size, size, size, this);
		g.drawImage(bPawn, 5 * size, 1 * size, size, size, this);
		g.drawImage(bPawn, 6 * size, 1 * size, size, size, this);
		g.drawImage(bPawn, 7 * size, 1 * size, size, size, this);
		
		// 2nd rank
		g.drawImage(wPawn, 0 * size, 6 * size, size, size, this);
		g.drawImage(wPawn, 1 * size, 6 * size, size, size, this);
		g.drawImage(wPawn, 2 * size, 6 * size, size, size, this);
		g.drawImage(wPawn, 3 * size, 6 * size, size, size, this);
		g.drawImage(wPawn, 4 * size, 6 * size, size, size, this);
		g.drawImage(wPawn, 5 * size, 6 * size, size, size, this);
		g.drawImage(wPawn, 6 * size, 6 * size, size, size, this);
		g.drawImage(wPawn, 7 * size, 6 * size, size, size, this);
		
		// 1st rank
		g.drawImage(wRook, 0 * size, 7 * size, size, size, this);
		g.drawImage(wKnight, 1 * size, 7 * size, size, size, this);
		g.drawImage(wBishop, 2 * size, 7 * size, size, size, this);
		g.drawImage(wQueen, 3 * size, 7 * size, size, size, this);
		g.drawImage(wKing, 4 * size, 7 * size, size, size, this);
		g.drawImage(wBishop, 5 * size, 7 * size, size, size, this);
		g.drawImage(wKnight, 6 * size, 7 * size, size, size, this);
		g.drawImage(wRook, 7 * size, 7 * size, size, size, this);
	}
}
