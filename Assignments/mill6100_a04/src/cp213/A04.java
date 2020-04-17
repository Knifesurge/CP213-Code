package cp213;

import javax.swing.GroupLayout;

public class A04 {

	private static int numBoxes = 0;
	
	public static void incBoxes() { A04.numBoxes++; }
	public static void decBoxes() { A04.numBoxes--; }
	
	public static void main(String[] args) {
		
		A04Frame window = new A04Frame();
		A04Panel contentPane = new A04Panel();
		A04Button addButton = new A04Button();
		A04Button removeButton = new A04Button();
		A04Label nBoxesLabel = new A04Label("Number of Boxes: " + numBoxes);
		GroupLayout layout = new GroupLayout(contentPane);
		
		
		contentPane.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		// Define the groups, add components
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(nBoxesLabel)
					.addComponent(addButton)
					.addComponent(removeButton)
		);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addComponent(nBoxesLabel)
				.addComponent(addButton)
				.addComponent(removeButton)
		);
		
		addButton.setText("Create a box");
		addButton.setActionCommand("add");
		addButton.addActionListener(new A04Listeners());
		
		removeButton.setText("Delete the newest box");
		removeButton.setActionCommand("del");
		removeButton.addActionListener(new A04Listeners());
		
		window.setContentPane(contentPane);
		window.pack();
		window.setVisible(true);
	}

}
