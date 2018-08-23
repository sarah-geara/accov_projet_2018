
package agora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Classe de la socket Cliente avec la preparation de reader et writer
 * Cette classe est pour aider la gestion des stream (on pourrait s'en passer)
 * @author pascalfares
 */
public class InfoClients {
    /**
     * La socket de service du client
     */
    private Socket serviceClientSocket;
    private String couleur;
    /**
     * La reader de la socket dún client
     */
    private final BufferedReader reader;

    /**
     * La writer de la socket d'un client
     */
    private final PrintWriter writer;
    
    public InfoClients(Socket s) throws IOException {
        serviceClientSocket=s;
        reader = getInput(s);
        writer = getoutput(s);
        couleur=null;
    }

    final BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    final PrintWriter getoutput(Socket p) throws IOException {
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()),true);
    }
    /**
     * @return the serviceClientSocket
     */
    public Socket getServiceClientSocket() {
        return serviceClientSocket;
    }

    /**
     * @param serviceClientSocket the serviceClientSocket to set
     */
    public void setServiceClientSocket(Socket serviceClientSocket) {
        this.serviceClientSocket = serviceClientSocket;
    }
public String getCouleur() {
        return couleur;
    }
  public void setCouleur(String Couleur) {
        this.couleur = Couleur;
    }
    /**
     * @return the reader
     */
    public BufferedReader getReader() {
        return reader;
    }

    /**
     * @return the writer
     */
    public PrintWriter getWriter() {
        return writer;
    }

}
