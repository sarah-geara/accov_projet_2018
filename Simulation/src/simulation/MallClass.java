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
public class MallClass {

    private Couleur AColour, BColour;
    private boolean FirstCall = true;
    private boolean MustWait = false;

    public synchronized Couleur Cooperation(IdChameneos x, Couleur C) {
        Couleur result ;
        while (MustWait) {
            try {
                wait();
            } catch (InterruptedException e) {
            }}
            if (FirstCall) {
                AColour = C;
                FirstCall = false;
                while (!FirstCall) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
                MustWait = false;
                result = BColour;
                notifyAll();
            } else {
                BColour = C;
            
            result = AColour;
            FirstCall = true;
            MustWait = true;
            notifyAll();
        
            }
        return result;
    }
}
