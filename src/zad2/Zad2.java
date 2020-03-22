/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Zad2 extends JFrame {

	JButton przycisk;
	int klik = 0;
	protected Color[] kolory = new Color[]{Color.BLACK, Color.WHITE, Color.GREEN,
			Color.RED, Color.YELLOW };

	Zad2() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 400));
		setLocation(400, 200);

		przycisk = new JButton("Przycisk");
		przycisk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (klik >= kolory.length) {
					klik = 0;
				}

				przycisk.setBackground(kolory[klik]);
				klik++;
			}
		});
		add(przycisk);

		pack();
		setVisible(true);
	}}