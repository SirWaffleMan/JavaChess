package com.blu3flux.omnichess.graphics.window;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EvaluationBar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private double evaluation;
	
	public EvaluationBar() {
		evaluation = 0;
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.WHITE);
		int height = (int) (getHeight() * ((evaluation + 14) / 28.0f));
		g.fillRect(0, getHeight() - height, getWidth(), height);
		
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(evaluation), 0, getHeight());
	}
	
	public void setEvaluation(double eval) {
		this.evaluation = eval;
	}
}
