import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class Browser extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;

	public Browser() {
		setTitle("Web Browser---by V143H4V");
		
		setSize(500,300);
		setVisible(true);
		
		addressBar = new JTextField("Enter the URL Here");
		addressBar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						loadContent(e.getActionCommand());
					}
				}
			);
		
		add(addressBar,BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		
		display.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent event){
						if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED ){
							loadContent(event.getURL().toString());
						}
					}
				});
		add(new JScrollPane(display),BorderLayout.CENTER);
		
	}
	
	public void loadContent(String userURL){
		
		try{
			display.setPage(userURL);
			addressBar.setText(userURL);
			
		}catch(Exception e){
			System.out.println("Error..Please check ur entered URL.");
		}
	}

}
