/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */



package zad3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstPlan implements ActionListener {

	protected JTextArea handler;

	
	public FirstPlan(JTextArea handler) {
		this.handler = handler;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		Icony icon = (Icony) item.getIcon();
		handler.setForeground(icon.getColor());
	}
}
