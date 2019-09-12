package Threads_autoroute;
import javax.swing.*;
import java.awt.*;
//import fr.ipst.io.Clavier;

import java.text.NumberFormat;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class VueSaisie{
	
    private JTextField jtf1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JTextField jtf2 = new JFormattedTextField(NumberFormat.getPercentInstance());
    private JTextField jtf3 = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JTextField jtf4 = new JFormattedTextField(NumberFormat.getPercentInstance());
    private JTextField jtf5 = new JFormattedTextField(NumberFormat.getIntegerInstance());

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    
    private JButton b = new JButton ("Valider");
    
    private JPanel cas = new JPanel();
    
	public FormAutoroute lire() {
		
		JFrame fenetre = new JFrame ( "Formulaire" ) ;
		Container contenu = fenetre.getContentPane();
		contenu . setLayout (new FlowLayout()) ;
		contenu.setSize(100, 50);
		contenu.add(cas, BorderLayout.CENTER);
		 
	    Font police = new Font("Arial", Font.BOLD, 14);
	    
	    jtf1.setFont(police);
	    jtf1.setPreferredSize(new Dimension(150, 30));
	    //jtf1.setHorizontalAlignment(JLabel.CENTER);
	    jtf1.setForeground(Color.BLUE);
	    
	    jtf2.setFont(police);
	    jtf2.setPreferredSize(new Dimension(150, 30));
	    jtf2.setForeground(Color.BLUE);
	     
	    jtf3.setFont(police);
	    jtf3.setPreferredSize(new Dimension(150, 30));
	    jtf3.setForeground(Color.BLUE);
	    
	    jtf4.setFont(police);
	    jtf4.setPreferredSize(new Dimension(150, 30));
	    jtf4.setForeground(Color.BLUE);
	    
	    jtf5.setFont(police);
	    jtf5.setPreferredSize(new Dimension(150, 30));
	    jtf5.setForeground(Color.BLUE);
		
	    
        this.label1 = new JLabel("Nombre de voitures : ");
        this.label1.setHorizontalAlignment(JLabel.TRAILING);
        cas.add(label1);
        String nb_v = this.jtf1.getText();
        cas.add(this.jtf1);
        
        this.label2 =  new JLabel("Nombre de caisses : ");
        this.label2.setHorizontalAlignment(JLabel.TRAILING);
        cas.add(label2);
        String nb_c = this.jtf2.getText();
        cas.add(this.jtf2);
        
        this.label3 =  new JLabel("Kilométrage min : ");
        this.label3.setHorizontalAlignment(JLabel.TRAILING);
        cas.add(label3);
        String min = this.jtf3.getText();
        cas.add(this.jtf3);
        
        this.label4 =  new JLabel("Kilométrage max : ");
        this.label4.setHorizontalAlignment(JLabel.TRAILING);
        cas.add(label4);
        String max = this.jtf4.getText();
        contenu.add(this.jtf4);
        
        this.label5 =  new JLabel("Vitesse moyenne des véhicules : ");
        this.label5.setHorizontalAlignment(JLabel.CENTER);
        cas.add(label5);
        String vitesse = this.jtf5.getText();
        cas.add(this.jtf5);
        

        contenu.add(cas);
        fenetre.getContentPane().add(b);
        fenetre.setContentPane(contenu);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.pack(); //dimmensionner la fenêtre
        fenetre.setVisible(true);  
		b.addActionListener(bt -> {
		        	
		});
		FormAutoroute f = new FormAutoroute(Integer.parseInt(nb_v), Integer.parseInt(nb_c), Integer.parseInt(min), Integer.parseInt(max), Integer.parseInt(vitesse));
        return f;
    }
}
