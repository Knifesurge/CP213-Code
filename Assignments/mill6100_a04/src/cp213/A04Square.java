package cp213;

import java.awt.Graphics;

public class A04Square {

	private static final int WIDTH = 75;
	private static final int HEIGHT = 100;
	
	public A04Square()
	{
		
	}
	
	
	public void paint(Graphics g, int x, int y)
	{
		g.drawRect(x, y, WIDTH, HEIGHT);
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

}
