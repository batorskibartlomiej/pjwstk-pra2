/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */





package zad3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






public class Tlo implements ActionListener {

	protected JTextArea handler;

	
	public Tlo(JTextArea handler) {
		this.handler = handler;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		Icony icon = (Icony) item.getIcon();
		handler.setBackground(icon.getColor());
	}
}