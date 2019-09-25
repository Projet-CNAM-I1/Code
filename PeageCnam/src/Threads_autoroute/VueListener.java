package Threads_autoroute;
import java.awt.TextArea;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;  

public class VueListener implements ActionListener
{
	private static HashSet<Voiture> voitures = new HashSet<Voiture>();

	VueSaisie vs;
	JTextField jtfNbVoiture;
    JTextField jtfNbCaisses ;
    JTextField jtfKmMin;
    JTextField jtfKmMax;
    JTextField jtfVitesse;
    JTextArea ta;
    JTextArea tabNbRestant;
	
    VueListener(VueSaisie vs, JTextField jtfNbVoiture, JTextField jtfNbCaisses, JTextField jtfKmMin, JTextField jtfKmMax, JTextField jtfVitesse, JTextArea ta, JTextArea taNbRestant)
	{
		this.vs = vs;
		this.jtfNbVoiture = jtfNbVoiture;
		this.jtfNbCaisses = jtfNbCaisses;
		this.jtfKmMin = jtfKmMin;
		this.jtfKmMax = jtfKmMax;
		this.jtfVitesse = jtfVitesse;		
		this.ta = ta;
		this.tabNbRestant = taNbRestant;
	}
    
	public void actionPerformed(ActionEvent e)
	{  
		/*JTextField jtfNbVoiture = (JTextField) e.getSource();
	    JTextField jtfNbCaisses = (JTextField) e.getSource();
	    JTextField jtfKmMin = (JTextField) e.getSource();
	    JTextField jtfKmMax = (JTextField) e.getSource();
	    JTextField jtfVitesse = (JTextField) e.getSource();*/

		vs.f = new FormAutoroute(Integer.parseInt(jtfNbVoiture.getText()), Integer.parseInt(jtfNbCaisses.getText()), Integer.parseInt(jtfKmMin.getText()), Integer.parseInt(jtfKmMax.getText()), Integer.parseInt(jtfVitesse.getText()));	
				
		//ConsoleRedirect cr = new ConsoleRedirect(in, ta);		
		//cr.start();
		
		Observateur obs = new Observateur();
		Gare gare = new Gare(vs.f.getNb_caisses());

		// Lancer le timer
		Timer t = new Timer(true); // timer deamon
		t.schedule(obs, 1000, 1000);
		// Créer le controleur qui terminera le timer
		Controleur controleur = new Controleur(vs.f.getNb_voitures(), t, tabNbRestant, gare);
		controleur.start();

		// création de la barriere de d�part
		CountDownLatch barriere = new CountDownLatch(vs.f.getNb_voitures());
		for (int i = 0; i < vs.f.getNb_voitures(); i++) {
			Voiture v = new Voiture(i, vs.f.getVitesse(), gare, obs, vs.f.getKm_min(), vs.f.getKm_max(), barriere, controleur, ta);
			voitures.add(v);
			v.start();
		}

		System.out.print("Fin Main");
	}
}

