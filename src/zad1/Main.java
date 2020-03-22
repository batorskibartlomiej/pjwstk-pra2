/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad1;

import javax.swing.SwingUtilities;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Zad1();
			}
		});
	}
}