package Threads_autoroute;
import java.util.Timer;

import javax.swing.JTextArea;

import java.awt.event.*;  

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Controleur extends Thread{

	JTextArea tabNbRestant;
    private int voitures_restantes;//coiture restant sur l'autoroute
    private Timer timer;
    private Gare gare;

    public Controleur(int voitures_restantes, Timer t, JTextArea tabNbRestant, Gare gare) {
        this.voitures_restantes = voitures_restantes;//initaliser le nombre de voiture restante
        timer = t;
        this.tabNbRestant = tabNbRestant;
        this.gare = gare;
    }

    public synchronized void decrement() {//quand une voiture sort, on décrémente le nombre de voiture restantes dans l'autoroute
        voitures_restantes--;
        tabNbRestant.setText(voitures_restantes + " voitures restantes \n");
    }

    @Override
    public void run() {
        int i = 0;
        while (voitures_restantes != 0){//on vérifie s'il reste encore des voiture dans l'autoroute
            System.out.print("");
        }
        timer.cancel();//on arrete le timer
        tabNbRestant.setText("");
        String s;
        for (Caisse c : gare)
        {
        	i++;
        	s="La caisse "+ i + ": temps moyen: " + (float)c.getTempsMoyen()/1000 + "s; nombre de voitures: " +c.getNbVoitures();
        	tabNbRestant.append(s + "\n");
        }
    }
}     

