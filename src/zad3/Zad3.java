/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad3;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeSet;


public class Zad3 extends JFrame {

	boolean zmiana = false;
	JTextArea tekst;
	Baza baza;
	String titlePrefix = "Edytor ", titleSufix,
			titleSufixDefault = "bez tytułu";
	HashMap<Integer, String> czc;
	Hashtable<String, Color> kolory;
	

	{
		
		
		czc = new HashMap<Integer, String>();

		czc.put(8, "8 pts");
		czc.put(10, "10 pts");
		czc.put(12, "12 pts");
		czc.put(14, "14 pts");
		czc.put(16, "16 pts");
		czc.put(18, "18 pts");
		czc.put(20, "20 pts");
		czc.put(22, "22 pts");
		czc.put(24, "24 pts");
		kolory = new Hashtable<String, Color>();

		kolory.put("Blue", Color.BLUE);
		kolory.put("Yellow", Color.YELLOW);
		kolory.put("Orange", Color.ORANGE);
		kolory.put("Red", Color.RED);
		kolory.put("White", Color.WHITE);
		kolory.put("Black", Color.BLACK);
		kolory.put("Green", Color.GREEN);

		
	}

	
	Zad3() {
		uruchom();
		uruchom2();
	}

	
	protected void uruchom() {

		
		tekst = new JTextArea();
		tekst.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				zmiana = true;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}
		});
		add(new JScrollPane(tekst));

		baza = new Baza(tekst);

		
		JMenu file = new JMenu("File");

		JMenuItem fileOpen = new JMenuItem("Open");
		fileOpen.setToolTipText("Otwórz plik");
		fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		fileOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				baza.read();
				setTitleText(baza.getName());
			}
		});
		
		
		JMenuItem fileSaveas = new JMenuItem("Save As");
		fileSaveas.setToolTipText("Zapisz do nowego pliku");
		fileSaveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		fileSaveas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				baza.saveAs();
				setTitleText(baza.getName());
			}
		});

		JMenuItem fileSave = new JMenuItem("Save");
		fileSave.setToolTipText("Zapisz do pliku");
		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		fileSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				baza._zapisz();
			}
		});

		

		JMenuItem fileExit = new JMenuItem("Exit");
		fileExit.setToolTipText("Wyjście z edytora");
		fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));
		fileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (zmiana == false)
					System.exit(0);

				int choice = JOptionPane.showConfirmDialog(null,
						"Zakończyć pracę? Niezapisane zmiany zostaną utracone",
						"Wyjście z programu", 2);
				if (choice == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else {
					return;
				}
			}
		});

		file.add(fileOpen);
		file.add(fileSave);
		file.add(fileSaveas);
		file.addSeparator();
		file.add(fileExit);

		JMenu zmien = new JMenu("Edit");
		JMenu zmienAdres = new JMenu("Adresy");

		JMenuItem zmienPraca = new JMenuItem("Praca");
		zmienPraca.setToolTipText("Wstaw adres pracy");
		zmienPraca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		zmienPraca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tekst.insert("Warszawa, Połczynska 52", tekst
						.getCaretPosition());
			}
		});

		JMenuItem zmienDom = new JMenuItem("Dom");
		zmienDom.setToolTipText("Wstaw adres domu");
		zmienDom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		zmienDom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tekst.insert("Warszawa, Ponarska", tekst
						.getCaretPosition());
			}
		});

		JMenuItem zmienSzkola = new JMenuItem("Szkoła");
		zmienSzkola.setToolTipText("Wstaw adres szkoly");
		zmienSzkola.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_D, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		zmienSzkola.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tekst.insert("GDansk, Kopernika 5", tekst
						.getCaretPosition());
			}
		});

		

		
		JMenu options = new JMenu("Options");
		JMenuItem menuItem;
		
		zmienAdres.add(zmienPraca);
		zmienAdres.add(zmienDom);
		zmienAdres.add(zmienSzkola);
		zmien.add(zmienAdres);

		JMenu optionsForeground = new JMenu("Foreground");
		FirstPlan listenerForeground = new FirstPlan(tekst);
		for (String key : kolory.keySet()) {
			menuItem = new JMenuItem(key, new Icony(kolory.get(key)));
			menuItem.addActionListener(listenerForeground);
			optionsForeground.add(menuItem);
		}

		JMenu optionsBackground = new JMenu("Background");
		FirstPlan listenerBackground = new FirstPlan(tekst);
		for (String key : kolory.keySet()) {
			menuItem = new JMenuItem(key, new Icony(kolory.get(key)));
			menuItem.addActionListener(listenerBackground);
			optionsBackground.add(menuItem);
		}

		JMenu optionsFontsize = new JMenu("Font size");
		TreeSet<Integer> sortedSet = new TreeSet<Integer>(
				new ArrayList<Integer>(czc.keySet()));
		for (Object key : sortedSet.toArray()) {
			menuItem = new JMenuItem(czc.get(key));
			menuItem.addActionListener(new Fonty(tekst,
					(Integer) key));
			optionsFontsize.add(menuItem);
		}

		options.add(optionsForeground);
		options.add(optionsBackground);
		options.add(optionsFontsize);

		JMenuBar menu = new JMenuBar();
		menu.add(file);
		menu.add(zmien);
		menu.add(options);

		setJMenuBar(menu);
	}
	
	protected void setTitleText(String sufix) {
		titleSufix = sufix;
		setTitle(titlePrefix + titleSufix);
	}

	
	protected void uruchom2() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(300, 300));
		setLocationRelativeTo(null);
		setTitle(titlePrefix + titleSufixDefault);

		setVisible(true);
	}

	}

