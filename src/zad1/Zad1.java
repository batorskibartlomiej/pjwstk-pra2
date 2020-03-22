/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad1;

import java.awt.*;
import javax.swing.*;
import static java.awt.Color.*;
import static javax.swing.SwingConstants.*;

class Zad1 extends JFrame {

  public Zad1() {
    setLayout(new BorderLayout());
    Icon i = new ImageIcon("red.gif");
    JLabel ad = creLab("Lab 1", YELLOW, BLUE);
    ad.setFont(new Font("Dialog", Font.ITALIC, 35 ));
    ad.setBorder(BorderFactory.createLineBorder(Color.blue));
    ad.setToolTipText("hello..");// i, BLACK, YELLOW, LEFT, TOP, LEFT, CENTER));
    JLabel ad2 =creLab("Lab 2", WHITE, YELLOW);
    
    ad2.setFont(new Font("Serif", Font.BOLD, 40));
    ad2.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 15, Color.blue));
    ad2.setToolTipText("...world");// i, WHITE, BLUE, CENTER, CENTER, CENTER, BOTTOM));
    JLabel ad3 =creLab("Lab 3", BLUE, BLACK);
    ad3.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 20));
    ad3.setBorder(BorderFactory.createTitledBorder("Tytuł"));
    ad3.setToolTipText("what now");// i, RED, WHITE, RIGHT, BOTTOM, RIGHT, CENTER));
    JLabel ad4 =creLab("Lab 4", BLACK, RED);
    ad4.setFont(new Font("SANS_SERIF", Font.ROMAN_BASELINE, 10));
    ad4.setBorder(BorderFactory.createLineBorder(Color.red));
    ad4.setToolTipText("podpowiedz");
    JLabel ad5 =creLab("Lab 5", RED, GRAY);
    ad5.setFont(new Font("SERIF", Font.CENTER_BASELINE, 16));
    ad5.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.yellow));
    ad5.setToolTipText("happy");// i, YELLOW, BLACK, LEFT, CENTER, CENTER, TOP));
    add(ad,BorderLayout.WEST);
    add(ad2,BorderLayout.EAST);
    add(ad3,BorderLayout.NORTH);
    add(ad4,BorderLayout.SOUTH);
    add(ad5,BorderLayout.CENTER);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }

  JLabel creLab(String txt, Color bc, Color fc ) {//, Icon icon, Color fc, Color bc, int halign,
      //int valign, int htxtpos, int vtxtpos) {
    JLabel l = new JLabel(txt);
    //l.setFont(new Font("Dialog", Font.BOLD, 24));
    l.setOpaque(true);
  //  l.setIcon(icon);
    l.setBackground(bc);
    l.setForeground(fc);
  
    return l;
  }

  
}