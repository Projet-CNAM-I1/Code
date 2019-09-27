package Threads_autoroute;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*; 
//import fr.ipst.io.Clavier;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.text.NumberFormat;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class VueSaisie extends JFrame{
	
    private JTextField jtfNbVoiture = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JTextField jtfNbCaisses = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JTextField jtfKmMin = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JTextField jtfKmMax = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JTextField jtfVitesse = new JFormattedTextField(NumberFormat.getIntegerInstance());
    
    private JTextArea ta = new JTextArea(20,30);
    private JTextArea ta2 = new JTextArea(20,35);
    
    private JScrollPane scroll;
    private JScrollPane scroll2;

    
    private JLabel labelNbVoiture;
    private JLabel labelNbCaisses;
    private JLabel labelKmMin;
    private JLabel labelKmMax;
    private JLabel labelVitesse;
    
    //private String nb_v, nb_c, min, max, vitesse;
    
    FormAutoroute f;
    
    private JButton b = new JButton ("Valider");
        
    private JPanel cas = new JPanel(new FlowLayout());
    
    private JPanel cas2 = new JPanel(new BorderLayout());
    
	public void lire() 
	{		
		//JFrame fenetre = new JFrame ( "Formulaire" ) ;					 
	    Font police = new Font("Arial", Font.BOLD, 14);
	    
	    jtfNbVoiture.setFont(police);
	    jtfNbVoiture.setPreferredSize(new Dimension(40, 30));
	    jtfNbVoiture.setForeground(Color.BLUE);
	    
	    jtfNbCaisses.setFont(police);
	    jtfNbCaisses.setPreferredSize(new Dimension(40, 30));
	    jtfNbCaisses.setForeground(Color.BLUE);
	     
	    jtfKmMin.setFont(police);
	    jtfKmMin.setPreferredSize(new Dimension(40, 30));
	    jtfKmMin.setForeground(Color.BLUE);
	    
	    jtfKmMax.setFont(police);
	    jtfKmMax.setPreferredSize(new Dimension(40, 30));
	    jtfKmMax.setForeground(Color.BLUE);
	    
	    jtfVitesse.setFont(police);
	    jtfVitesse.setPreferredSize(new Dimension(40, 30));
	    jtfVitesse.setForeground(Color.BLUE);
		
	    
        this.labelNbVoiture = new JLabel("Nombre de voitures : ");
        this.labelNbVoiture.setHorizontalAlignment(JLabel.TRAILING);
        cas.add(labelNbVoiture);
        //nb_v = this.jtfNbVoiture.getText();
        cas.add(this.jtfNbVoiture);
        
        this.labelNbCaisses =  new JLabel("Nombre de caisses : ");
        this.labelNbCaisses.setHorizontalAlignment(JLabel.TRAILING);
        cas.add(labelNbCaisses);
        //nb_c = this.jtfNbCaisses.getText();
        cas.add(this.jtfNbCaisses);
        
        this.labelKmMin =  new JLabel("Kilométrage min : ");
       // this.labelKmMin.setHorizontalAlignment(JLabel.TRAILING);
        cas.add(labelKmMin);
        //min = this.jtfKmMin.getText();
        cas.add(this.jtfKmMin);
        
        this.labelKmMax =  new JLabel("Kilométrage max : ");
       // this.labelKmMax.setHorizontalAlignment(JLabel.TRAILING);
        //max = this.jtfKmMax.getText();
        cas.add(labelKmMax);        
        cas.add(this.jtfKmMax);
        
        this.labelVitesse =  new JLabel("Vitesse moyenne des véhicules : ");
       // this.labelVitesse.setHorizontalAlignment(JLabel.CENTER);
        cas.add(labelVitesse);
        //vitesse = this.jtfVitesse.getText();
        cas.add(this.jtfVitesse);
        

        scroll = new JScrollPane(ta);
        scroll2 = new JScrollPane(ta2);
	    //this.add(ta);
	    //this.add(ta2);
        cas2.add(scroll, BorderLayout.CENTER);
        cas2.add(scroll2, BorderLayout.EAST);
        
        
        DefaultCaret caret = (DefaultCaret)ta.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        VueListener vl = new VueListener(this, jtfNbVoiture, jtfNbCaisses, jtfKmMin, jtfKmMax, jtfVitesse, ta, ta2);
        b.addActionListener(vl);
        cas.add(b);  
        this.add(cas, BorderLayout.NORTH);   
        this.add(cas2, BorderLayout.CENTER);
        //fenetre.setContentPane(cas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); //dimensionner la fenêtre
        this.setVisible(true);      
        
    }
	

	
	public FormAutoroute getFormAutoroute()
	{
		return f;
	}
	
	/*public int getNbC()
	{
		return Integer.parseInt(nb_c);
	}
	
	public int getNbV()
	{
		return Integer.parseInt(nb_v);
	}
	
	public int getMin()
	{
		return Integer.parseInt(min);
	}
	
	public int getMax()
	{
		return Integer.parseInt(max);
	}
	
	public int getVitesse()
	{
		return Integer.parseInt(vitesse);
	}
	
	
	
	public class VueListener implements ActionListener
	{
		VueSaisie vs;
		VueListener(VueSaisie vs)
		{
			this.vs = vs;
		}
		public void actionPerformed(ActionEvent e)
		{  
			f = new FormAutoroute(Integer.parseInt(nb_v), Integer.parseInt(nb_c), Integer.parseInt(min), Integer.parseInt(max),Integer.parseInt(nb_c));		
		}
	}
	*/
}
