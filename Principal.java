import java.net.*;
import java.io.*;

public class Principal {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(6969);
            int porta = servidor.getLocalPort();
            System.out.println("Porta atribuída pelo sistema operacional: " + porta);
            System.out.println("Aguardando cliente!");
            Socket socket = servidor.accept(); // espera
            System.out.println("Chegou o cliente :"
                    + socket.getInetAddress().getHostAddress());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String mensagem = "";
            while ((mensagem = in.readLine()) != null) {
                System.out.println(mensagem);
            }
            System.out.println("Fim da conexão");
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}
