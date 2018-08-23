
package clientagora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pascalfares
 */
public class ServiceInOut implements Runnable {

    private final String _arret;
    private final PrintWriter _out;
    private final BufferedReader _in;
    private  String Couleur ;

    public ServiceInOut(BufferedReader in, PrintWriter out,String arret,String Couleur) {
        _in = in;
        _out = out;
        _arret=arret;
        this.Couleur=Couleur;
    }


    /**
     * Lire indiniment l'entrée et la restrasmettre à la sortie (tel quel)
     * Terminer lorque une ligen corrspondant à la commande d'arret est recu
     */
    @Override
    public void run() {
        while(true){
        try {
            System.out.println("I am Eating Honey suckle and Training");
              try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("I am going to the mail");
              try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("I am going to mute and my color is : "+Couleur);
              try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
            }
            String line;
            _out.printf("%s\n", Couleur);
            _out.flush();
            //System.out.println(_sens);
            if ((line = _in.readLine()) != null) {               
                this.Couleur=line;
                System.out.println("Mutation Complete my new color is : "+Couleur);
              
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        }
    }

}
