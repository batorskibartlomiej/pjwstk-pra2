/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad3;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;


public class Baza {

	JFileChooser wybor;
	JPanel tool;
	JTextArea tekst;
	String nazwa;
	File file;

	
	public Baza(JTextArea textArea) {

		this.tekst = textArea;

		wybor = new JFileChooser();
		wybor.addChoosableFileFilter(new FileNameExtensionFilter(
				"pliki tekstowe", "txt"));
		tool = new JPanel();
	}

	public String getName() {
		return file.getName();
	}
	

	private void zapisz(File file) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(tekst.getText());
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void read() {

		int ret = wybor.showDialog(tool, "Otwórz plik");
		if (ret == JFileChooser.APPROVE_OPTION) {
			try {
				file = wybor.getSelectedFile();

				BufferedReader br = new BufferedReader(new FileReader(wybor
						.getSelectedFile()));
				String line;
				tekst.setText("");

				while ((line = br.readLine()) != null) {
					tekst.append(line + "\n");
				}

				br.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public void saveAs() {

		int ret = wybor.showDialog(tool, "Zapisz jako");
		if (ret == JFileChooser.APPROVE_OPTION) {
			file = wybor.getSelectedFile();
			zapisz(wybor.getSelectedFile());
		}
	}

	
	public void _zapisz() {

		if (file == null) {
			this.saveAs();
			return;
		} else {
			zapisz(file);
		}
	}

	
	
	
}