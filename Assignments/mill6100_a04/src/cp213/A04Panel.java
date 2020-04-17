package cp213;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class A04Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private List<A04Square> squares;
	private int leftBound;
	private int horizSpace;
	
	public A04Panel() {
		super();
		squares = new ArrayList<A04Square>();
		leftBound = 50;
		horizSpace = 10;
	}

	public A04Panel(LayoutManager lManager) {
		super(lManager);
	}

	public void addBox()
	{
		squares.add(new A04Square());
		A04.incBoxes();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		int offset = 0;
		for (A04Square s : squares)
		{
			s.paint(g, leftBound + offset, 100);
			offset += A04Square.getWidth() + horizSpace;
		}
	}
}
