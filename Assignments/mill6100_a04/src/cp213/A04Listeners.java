package cp213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A04Listeners implements ActionListener {

	public A04Listeners()
	{
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		String cmd = e.getActionCommand();
		
		if (cmd.equals("add"))
		{
			((A04Panel)((A04Button) e.getSource()).getParent()).addBox();
		}
		else if (cmd.equals("del"))
		{
			
		}
	}

}
