/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

/**
 *
 * @author Sarah Geara
 */
public class Simulation {

    static Couleur[] TheColours = {
        Couleur.YELLOW,
        Couleur.BLUE,
        Couleur.RED,
        Couleur.BLUE,
        Couleur.YELLOW,
        Couleur.BLUE
    };
    static ChameneosClass[] TheChameneos = new ChameneosClass[TheColours.length];

    public static void main(String args[]) {
        try {
            MallClass myMall = new MallClass();
            for (int i = 0; i < TheColours.length; i++) {
                TheChameneos[i] = new ChameneosClass(myMall, new IdChameneos(i), TheColours[i]);
            }
            for (int i = 0; i < TheColours.length; i++) {
                TheChameneos[i].start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
