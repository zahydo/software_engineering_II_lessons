package co.edu.unicauca.openmarket.infra;


import co.unicauca.openmarket.commons.infra.Utilities;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa el Socket de la aplicación producto. Su función es enviar una
 * solicitud/respuesta entre el producto y el servidor.
 *
 * @author Libardo, Julio
 */
public class OpenMarketSockets {

    /**
     * Socket de la aplicación cliente
     */
    private java.net.Socket socket = null;
    /**
     * Permite leer la recibir la respuesta del socket
     */
    private Scanner input;
    /**
     * Permite enviar una solicitud por el socket
     */
    private PrintStream output;
    /**
     * Ip del Server Socket
     */
    private final String IP_SERVER = Utilities.loadProperty("server.ip");
    /**
     * Puerto del server socket
     */
    private final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));

    /**
     * Envia una solicitud desde la aplicación cliente al servidor mediate el
     * socket
     *
     * @param requestJson solicitud en formato json
     * @return respuesta del scoket
     * @throws IOException error de entrada y salida
     */
    public String sendRequest(String requestJson) throws IOException {
        String response = "";
        input = new Scanner(socket.getInputStream());
        output = new PrintStream(socket.getOutputStream());
        output.flush();
        input.reset();

        Logger.getLogger(OpenMarketSockets.class.getName()).log(Level.INFO, "Lo que se le envia al: ("+requestJson+")");
           
        // Enviar la solicitud
        output.println(requestJson);

        // Procesa la respuesta
        if (input.hasNextLine()) {
            response = input.nextLine();
        }
        Logger.getLogger(OpenMarketSockets.class.getName()).log(Level.INFO, "Lo que se lee del servidor: ("+response+")");
                
        return response;
    }

    /**
     * Cierra los flujos input y output
     */
    public void closeStream() {
        output.close();
        input.close();
    }

    /**
     * Desconectar el socket
     */
    public void disconnect() {
        closeStream();
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(OpenMarketSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Conectar o abrir un socket
     *
     * @throws IOException error de entrada y salida
     */
    public void connect() throws IOException {
        socket = new java.net.Socket(IP_SERVER, PORT);
        Logger.getLogger("SocketClient").log(Level.INFO, "Socket establecido");
    }

}
