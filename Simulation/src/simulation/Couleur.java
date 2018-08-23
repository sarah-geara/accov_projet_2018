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

public class Couleur {

    public int internalColour;
    private static final int blueInt = 0;
    private static final int redInt = 1;
    private static final int yellowInt = 2;
    public static final Couleur BLUE = new Couleur(blueInt);
    public static final Couleur RED = new Couleur(redInt);
    public static final Couleur YELLOW = new Couleur(yellowInt);

    private Couleur(int value) {
        internalColour = value % 3;
    }

    public Couleur ComplementaryColour(Couleur C) {
        if (internalColour == C.internalColour) {
            return new Couleur(internalColour);
        } else {
            return new Couleur(3 - internalColour - C.internalColour);
        }
    }

    public String toString() {
        if (internalColour == blueInt) {
            return "blue";
        } else if (internalColour == redInt) {
            return "red";
        } else {
            return "yellow";
        }
    }

}
