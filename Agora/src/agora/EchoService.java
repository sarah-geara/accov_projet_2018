/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agora;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class EchoService implements Runnable {

    private final InfoClients ic;
    private final GestionListeClients listeClients;
        private  int index;
    
    public EchoService(Socket s, GestionListeClients listeClients) throws IOException {
        ic=new InfoClients(s);
        this.listeClients=listeClients;
    listeClients.add(ic);
    }

    @Override
    public void run() {
        
        try {
            System.out.println(ic.getServiceClientSocket().getRemoteSocketAddress());
            String line;
            while (!(line = ic.getReader().readLine()).equals(".")) {
                System.out.printf("[TRACE] recus %s\n", line);
                
                if( listeClients.getwaiting()==0){
                    ic.setCouleur(line);
                listeClients.addwaiting();}
                else {
                     listeClients.mutate(ic,line);
                }
               
            }
            ic.getWriter().printf(".\n");
        } catch (IOException ex) {
            Logger.getLogger(EchoService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                listeClients.remove(ic);
            } catch (IOException ex) {
                Logger.getLogger(EchoService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
