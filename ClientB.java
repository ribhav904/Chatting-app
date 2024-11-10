import java.net.*;
import java.io.*;


public class ClientB {
    private Socket socket = null;
    private DataInputStream in = null;

    public ClientB (String address, int port) {

        try {
            socket = new Socket (address, port);
            System.out.println("Connection established to server");

            in = new DataInputStream(socket.getInputStream());

            String line = "";
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
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
        ClientB client = new ClientB("10.163.57.152", 5050);
    }
}
