import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JPanel {
	public void init() {
		JFrame window = new JFrame("Space Cadets");
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        window.setSize(400,150);
        Container pane = window.getContentPane();
    	//set the layout as a grid of 3 by 1
    	pane.setLayout(new GridLayout(3,1));

            JButton b1 = new JButton("Find Name");
            JTextField search = new JTextField(20);
            JTextField result = new JTextField(20);
           
            //create the listener for the button
            b1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//fill the id variable with the text from the textfield
					Main.id = search.getText();
					try {
						//fetch the info from the webpage by the url created with the written id
						Main.fetch();
					} catch (MalformedURLException e1) {

						e1.printStackTrace();
					}
					//show the found name in the textfield
					result.setText(Main.name);
					//reset the name so the new one doesn't concatenate with the old one
					Main.name = "";
				}
			});
            pane.add(search, BorderLayout.NORTH);
            pane.add(b1, BorderLayout.CENTER);
            pane.add(result, BorderLayout.SOUTH);
            
    	
        
       	window.setVisible(true);
	}

	
	
	

}
