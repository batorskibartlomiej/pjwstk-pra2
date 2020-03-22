/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad3;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
	  SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Zad3();
			}
		});
  }
}
