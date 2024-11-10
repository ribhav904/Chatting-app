import java.io.*;
import java.net.*;

public class Server {
    private Socket socketA = null;
    private Socket socketB = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    Server (int port) {

        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for client A");
            socketA = server.accept();
            System.out.println("Client A accepted");

            System.out.println("Waiting for client B");
            socketB = server.accept();
            System.out.println("Client A accepted");

            in = new DataInputStream(socketA.getInputStream());
            out = new DataOutputStream(socketB.getOutputStream());

            String line = "";

            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    out.writeUTF(line);
                    System.out.println(line);
                } catch (IOException i) {
                    System.out.println(i);
                }
             
            }
            System.out.println("Closing connection");
        
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Server server = new Server (5050);
    }
}