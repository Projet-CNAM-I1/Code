package Threads_autoroute;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Caisse {
	private int temps;
	private int tempsTotal;
	private int nbVoitureDesservies;
	
	public Caisse()
	{
		nbVoitureDesservies=0;
		tempsTotal=0;
	}
	
    public void payer()
    {
        Random r = new Random();
        temps = 1000 + r.nextInt(10000);
        nbVoitureDesservies++;
        tempsTotal += temps;
        
        try {
            Thread.sleep(temps);
        } catch (InterruptedException ex) {
            
        }
    }
    
    public int getTemps()
    {
    	return temps;
    }
    public int getNbVoitures()
    {
    	return nbVoitureDesservies;
    }
    
    public int getTempsMoyen()
    {
    	if(nbVoitureDesservies!=0)
    	{
    		return tempsTotal/nbVoitureDesservies;
    	}
    	else
    	{
    		return 0;
    	}    	
    }
}
