package Threads_autoroute;

import java.awt.TextArea;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextArea;
//
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class Voiture extends Thread {

    private int num;
    private Gare gare;
    private Observateur obs;
    private int parcours;
    private int vitesse; 
    private int km_min;
    private int km_max;
    private CountDownLatch barriere;
    private Controleur controleur;
    private JTextArea ta;

    public Voiture(int num, int v, Gare gare, Observateur obs, int min, int max, CountDownLatch b, Controleur ctrl, JTextArea ta) {
        super();
        this.num = num;
        this.gare = gare;
        this.obs = obs;
        vitesse = v;
        km_min = min;
        km_max = max;
        barriere = b;
        controleur = ctrl;
        this.ta = ta;
    }

    @Override
    public void run() {
        try {
            barriere.countDown();//décrémenter le verrou  
            barriere.await();// attendre que toutes les autres voitures soient à ce même point
            entrer();
            rouler();
            sortir();
            controleur.decrement();//signaler au controleur qu'on est sortie pour décrémenter le nombre de vpoitures restantes dans l'autoroute
        } catch (InterruptedException ex) {
        }
    }

    private void entrer() {
        Random r = new Random();
        parcours = km_min + r.nextInt(km_max - km_min);//g�n�rer al�atoirement la longueur du parcours de cette voiture

    }

    private void rouler() {
        while (parcours > 0) {//tant que le parcours n'est pas fini
            try {
                parcours--;//avancer d'un cran
                Thread.sleep(vitesse);//à la vitesse choisie
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
    private void sortir() {
    	//InputStream result;
    	//result = System.in;
        try 
        {
            obs.increment(); //signaler � l'observateur qu'on attend une caisse
            Caisse c = gare.take();//demander une caisse, dès qu'une caisse est libre elle sera affecter � cette voiture et elle sortira du pool de caisses libres
            c.payer();//payer
            int tps = c.getTemps();
            System.out.println("Voiture " + num + " : sortie");
            ta.append("Voiture " + num + " : sortie ; temps :" +tps +"\n");
           
            //String name = ("Voiture " + num + " : sortie");
            
            gare.put(c);//libérer la caisse en la remettant dans le pool de caisses libres
            obs.decrement();//signaler à l'observateur qu'on est sorti de la file d'attente d'une caisse
            
            //result = new ByteArrayInputStream(name.getBytes(StandardCharsets.UTF_8));   
        } 
        catch (InterruptedException ex) 
        {
        	
        }
        //return result;
    }
    
}
