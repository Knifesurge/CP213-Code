package cp213;

import java.awt.Dimension;

import javax.swing.JFrame;

public class A04Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	
	public A04Frame()
	{
		super();
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public A04Frame(Dimension size)
	{
		super();
		this.setSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
