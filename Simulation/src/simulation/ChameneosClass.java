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
public class ChameneosClass extends Thread {

    private MallClass mall;
    private IdChameneos id;
    private Couleur myColour, otherColour;

    public ChameneosClass(MallClass m, IdChameneos id, Couleur c) {
        this.mall = m;
        this.id = id;
        this.myColour = c;
    }

    private void Message(String Mess) {
        System.out.println("(" + id.toString() + ") I am " + myColour.toString() + " and " + Mess);
    }

    private void EatingHoneysuckleAndTraining() {
        Message("I am Eating Honey suckle and Training");
    }

    private void GoingToTheMall() {
        Message("I am going to the mall");
    }

    private void Mutating() {
        Message("I am going to mute");
        otherColour = mall.Cooperation(id, myColour);
        myColour = myColour.ComplementaryColour(otherColour);
        Message("I have done a mutation");
    }

    public void run() {
        while (true) {
            EatingHoneysuckleAndTraining();
            GoingToTheMall();
            Mutating();
        }

    }
}

