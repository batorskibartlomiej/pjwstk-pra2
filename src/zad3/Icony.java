/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */





package zad3;

import java.awt.*;


public class Icony implements javax.swing.Icon {

	protected Color kolor;
	protected int szer, wys;

	
	public Icony() {
		this(10, 10, Color.GREEN);
	}

	
	public Icony(Color kolor) {
		this(10, 10, kolor);
	}

	
	public Icony(int szer, int wys) {
		this(szer, wys, Color.GREEN);
	}

	
	public Icony(int szer, int wys, Color kolor) {
		this.szer = szer;
		this.wys = wys;
		this.kolor = kolor;
	}

	public Color getColor() {
		return kolor;
	}

	@Override
	public int getIconHeight() {
		return wys;
	}

	@Override
	public int getIconWidth() {
		return szer;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(kolor);
		g.fillOval(x, y, szer, wys);
	}
}