package Threads_autoroute;
import java.util.Scanner;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class VueSaisie {

    public FormAutoroute lire() {
        Scanner sc = new Scanner(System.in);
    	System.out.print("Nombre de voitures : ");
        int nb_v = sc.nextInt();
        System.out.print("Nombre de caisses : ");
        int nb_c = sc.nextInt();
        System.out.print("Kilom�trage min : ");
        int min = sc.nextInt();
        System.out.print("Kilom�trage max : ");
        int max = sc.nextInt(); 
        System.out.print("Vitesse moyenne des v�hicules : ");
        int vitesse = sc.nextInt();
        FormAutoroute f = new FormAutoroute(nb_v, nb_c, min, max, vitesse);
        return f;
    }
}
